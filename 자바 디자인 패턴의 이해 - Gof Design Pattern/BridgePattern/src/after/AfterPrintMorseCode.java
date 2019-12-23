package after;

public class AfterPrintMorseCode extends MorseCode {


    public AfterPrintMorseCode(MorseCodeFunction function) {
        super(function);
    }

    public AfterPrintMorseCode m() {
        dash();
        dash();
        space();
        return this;
    }
    public AfterPrintMorseCode i(){
        dot();
        dot();
        space();
        return this;
    }
    public AfterPrintMorseCode n(){
        dash();
        dot();
        space();
        return this;
    }
    public AfterPrintMorseCode w(){
        dot();
        dash();
        dash();
        space();
        return this;
    }
    public AfterPrintMorseCode o(){
        dash();
        dash();
        dash();
        space();
        return this;
    }
    public AfterPrintMorseCode k(){
        dash();
        dot();
        dash();
        space();
        return this;
    }

    public void end() {
        System.out.println();
    }
}
