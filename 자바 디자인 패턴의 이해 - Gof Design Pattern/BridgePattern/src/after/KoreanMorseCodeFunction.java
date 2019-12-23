package after;

public class KoreanMorseCodeFunction implements MorseCodeFunction{

    @Override
    public void dot() {
        System.out.print("Á¡");
    }

    @Override
    public void dash() {
        System.out.print("´ë½¬");
    }

    @Override
    public void space() {
        System.out.print(" ");
    }
}
