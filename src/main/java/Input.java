import dto.Baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    // 유저가 숫자를 입력
    public void userNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Number number = new Number();
        String computerNumber = number.makeComputerNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요. : ");

            String inputText = br.readLine();
            String userNumber = number.makeUserNumber(inputText);
            if (userNumber == null) continue;   // 잘못 입력했을 경우 다시 시작

            Baseball baseball = number.checkNumber(computerNumber, userNumber);

            if (baseball.getStrike() != 3) {   // 스트라이크 3가 아닌경우 얼마나 맞혔는지 보여주기
                System.out.println(number.makeMatchText(baseball));
                continue;
            }

            if (baseball.getStrike() == 3) {   // 전부 맞힌 경우
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            }

            String select = br.readLine();
            if (select.equals("1")) {
                computerNumber = number.makeComputerNumber();
                continue;
            }
            if (select.equals("2")) {
                br.close();
                break;
            }
        }
    }
}
