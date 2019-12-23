import abst.*;
import concrete.FactoryInstance;
import linux.LinuxGuiFac;
import mac.MacGuiFac;

public class Main {

    public static void main(String[] args) {
        GuiFactory fac = FactoryInstance.getGuiFac(2);
        Button button =  fac.createButton();
        TextArea textArea = fac.createTextArea();

        button.click();
        System.out.println(textArea.getText());

    }
}
