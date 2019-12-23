import after.AfterPrintMorseCode;
import after.DefaultMorseCodeFunction;
import after.KoreanMorseCodeFunction;
import before.BeforePrintMorseCode;
import before.BeforePrintMorseCode2;


public class Main {

    public static void main(String[] args) {
        // before, ���ʿ��� PrintMorseCode �����, MorseCode ���簡 �ʿ��ϴ� (������ 2���� �þ)
        BeforePrintMorseCode beforeCode = new BeforePrintMorseCode();
        beforeCode.m().i().n().w().o().o().k().end();
        // �츮�� ����ϴ� BeforePrintMorseCode�� BeforePrintMorseCode2�� �������־���.
        BeforePrintMorseCode2 beforeCode2 = new BeforePrintMorseCode2();
        beforeCode2.m().i().n().w().o().o().k().end();


        // after, MorseCodeFunction�� ����� �־��ָ� ���ϰ� �ٿ����� �� �ִ�.
        // AfterPrintMorseCode type�״�� ����� �� �ִ�. (���⵵ ����)
        AfterPrintMorseCode afterCode = new AfterPrintMorseCode(new DefaultMorseCodeFunction());
        afterCode.m().i().n().w().o().o().k().end();

        AfterPrintMorseCode afterCode2 = new AfterPrintMorseCode(new KoreanMorseCodeFunction());
        afterCode2.m().i().n().w().o().o().k().end();
    }
}
