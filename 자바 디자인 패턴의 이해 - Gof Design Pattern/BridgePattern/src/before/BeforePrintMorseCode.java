package before;

public class BeforePrintMorseCode extends MorseCode {
    //minwook
    public BeforePrintMorseCode m() {
        dash();
        dash();
        space();
        return this;
    }
    public BeforePrintMorseCode i(){
        dot();
        dot();
        space();
        return this;
    }
    public BeforePrintMorseCode n(){
        dash();
        dot();
        space();
        return this;
    }
    public BeforePrintMorseCode w(){
        dot();
        dash();
        dash();
        space();
        return this;
    }
    public BeforePrintMorseCode o(){
        dash();
        dash();
        dash();
        space();
        return this;
    }
    public BeforePrintMorseCode k(){
        dash();
        dot();
        dash();
        space();
        return this;
    }

    public void end(){
        System.out.println();
    }
}
