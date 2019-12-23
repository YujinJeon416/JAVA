import after.AfterPrintMorseCode;
import after.DefaultMorseCodeFunction;
import after.KoreanMorseCodeFunction;
import before.BeforePrintMorseCode;
import before.BeforePrintMorseCode2;


public class Main {

    public static void main(String[] args) {
        // before, 불필요한 PrintMorseCode 복사와, MorseCode 복사가 필요하다 (파일이 2개씩 늘어남)
        BeforePrintMorseCode beforeCode = new BeforePrintMorseCode();
        beforeCode.m().i().n().w().o().o().k().end();
        // 우리가 사용하는 BeforePrintMorseCode를 BeforePrintMorseCode2로 변경해주었다.
        BeforePrintMorseCode2 beforeCode2 = new BeforePrintMorseCode2();
        beforeCode2.m().i().n().w().o().o().k().end();


        // after, MorseCodeFunction만 만들어 넣어주면 편하게 붙여넣을 수 있다.
        // AfterPrintMorseCode type그대로 사용할 수 있다. (복잡도 낮춤)
        AfterPrintMorseCode afterCode = new AfterPrintMorseCode(new DefaultMorseCodeFunction());
        afterCode.m().i().n().w().o().o().k().end();

        AfterPrintMorseCode afterCode2 = new AfterPrintMorseCode(new KoreanMorseCodeFunction());
        afterCode2.m().i().n().w().o().o().k().end();
    }
}
