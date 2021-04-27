import dto.Baseball;

import java.util.HashSet;
import java.util.Random;

public class Number {
    // 컴퓨터가 랜덤으로 3자리 수 생성
    public String makeComputerNumber() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();//랜덤 함수
        int randomNum;//랜덤으로 생성된 숫자
        boolean[] duplicationCheck = new boolean[10];//랜덤으로 생성된 숫자가 중복되지 않도록 체크하는 배열

        for (int i = 0; i < 3; i++) {
            do {
                randomNum = random.nextInt(9) + 1;//1~9 랜덤 숫자 생성
            } while (duplicationCheck[randomNum] == true);

            duplicationCheck[randomNum] = true;//랜덤으로 생성된 숫자 배열에 이미 값이 들어가 있다고 처리
            builder.append(randomNum);  //중복이 아닌 랜덤숫자로 String 만들기
        }

        return builder.toString();
    }

    // 사용자가 입력한 값이 숫자 인지 여부 확인
    public String makeUserNumber(String number) {
        if (number.length() != 3) {
            System.out.println("숫자는 3자리로 입력해 주시기 바랍니다.");
            return null;
        }

        String userNumber = checkNumber(number);

        return userNumber;
    }

    // 사용자가 입력한 값이 중복 인지 여부 확인
    public String checkNumber(String number) {
        StringBuilder builder = new StringBuilder();

        if (checkDuplicationNumber(number)) {
            return null;
        }

        for (int i=0; i<number.length(); i++) {
            int value = number.charAt(i) - '0';

            if (value > 9 || value == 0) {  // 1 ~ 9 사이 숫자 확인
                System.out.println("숫자는 1~9 사이로 입력해 주시기 바랍니다.");
                return null;
            }

            builder.append(value);
        }

        return builder.toString();
    }

    // 사용자가 입력한 값 중복여부 확인
    public boolean checkDuplicationNumber(String number){
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<number.length(); i++) {
            set.add(number.charAt(i) - '0');
        }

        if (set.size() != 3) {
            System.out.println("중복되지 않은 숫자를 다시 입력해 주시기 바랍니다.");
            return true;
        }

        return false;
    }

    // 컴퓨터가 생성한 숫자와 사용자가 입력한 숫자 strike, ball, out 체크
    public Baseball checkNumber(String computerNumberText, String userNumberText) {
        Baseball baseball = new Baseball();
        int strike = 0, ball = 0, out = 0;

        for (int i = 0; i < computerNumberText.length(); i++) {
            int computerNumber = computerNumberText.charAt(i) - '0';
            int userNumber = userNumberText.charAt(i) - '0';
            if (computerNumber == userNumber) strike++;
            if (computerNumber != userNumber && userNumberText.contains(String.valueOf(computerNumber))) ball++;
            if (computerNumber != userNumber && !userNumberText.contains(String.valueOf(computerNumber))) out++;
        }

        baseball.setStrike(strike);
        baseball.setBall(ball);
        baseball.setOut(out);

        return baseball;
    }

    // strike, ball, out 값으로 텍스트 만들기
    public String makeMatchText(Baseball baseball) {
        StringBuilder builder = new StringBuilder();

        if (baseball.getStrike() > 0) builder.append(baseball.getStrike()).append(" 스트라이크 ");
        if (baseball.getBall() > 0) builder.append(baseball.getBall()).append(" 볼 ");
        if (baseball.getOut() == 3) builder.append("낫싱");

        return builder.toString();
    }

}
