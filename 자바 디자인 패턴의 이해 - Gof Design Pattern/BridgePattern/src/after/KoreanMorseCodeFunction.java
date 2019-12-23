package after;

public class KoreanMorseCodeFunction implements MorseCodeFunction{

    @Override
    public void dot() {
        System.out.print("��");
    }

    @Override
    public void dash() {
        System.out.print("�뽬");
    }

    @Override
    public void space() {
        System.out.print(" ");
    }
}
