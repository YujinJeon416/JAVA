package abst;

import linux.LinuxGuiFac;

public interface GuiFactory {

    Button createButton();

    TextArea createTextArea();

    //default or static?
//    default buildGui(GuiFactory guiFactory) {
//        guiFactory.createButton();
//                Button linuxButton =  linuxGuiFac.createButton();
//        TextArea linuxTextArea = linuxGuiFac.createTextArea();
//
//    }

}
