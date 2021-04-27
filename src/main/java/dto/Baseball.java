package dto;

public class Baseball {
    private Integer strike;
    private Integer ball;
    private Integer out;

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public Integer getOut() {
        return out;
    }
}
