package mac;

import abst.Button;
import abst.GuiFactory;
import abst.TextArea;

public class MacGuiFac implements GuiFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextArea createTextArea() {
        return new MacTextArea();
    }
}
