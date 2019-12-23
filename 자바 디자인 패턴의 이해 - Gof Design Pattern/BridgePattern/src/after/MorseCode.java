package after;

public class MorseCode {
    private MorseCodeFunction function;

    public MorseCode(MorseCodeFunction function) {
        this.function = function;
    }

    public MorseCodeFunction getFunction() {
        return function;
    }

    public void setFunction(MorseCodeFunction function) {
        this.function = function;
    }

    // deligate
    public void dot() {
        function.dot();
    }

    public void dash() {
        function.dash();
    }

    public void space() {
        function.space();
    }

}
