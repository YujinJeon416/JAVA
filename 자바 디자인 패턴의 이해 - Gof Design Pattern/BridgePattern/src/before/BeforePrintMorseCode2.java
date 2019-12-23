package before;

public class BeforePrintMorseCode2 extends MorseCode2 {
    //minwook
    public BeforePrintMorseCode2 m() {
        dash();
        dash();
        space();
        return this;
    }
    public BeforePrintMorseCode2 i(){
        dot();
        dot();
        space();
        return this;
    }
    public BeforePrintMorseCode2 n(){
        dash();
        dot();
        space();
        return this;
    }
    public BeforePrintMorseCode2 w(){
        dot();
        dash();
        dash();
        space();
        return this;
    }
    public BeforePrintMorseCode2 o(){
        dash();
        dash();
        dash();
        space();
        return this;
    }
    public BeforePrintMorseCode2 k(){
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
