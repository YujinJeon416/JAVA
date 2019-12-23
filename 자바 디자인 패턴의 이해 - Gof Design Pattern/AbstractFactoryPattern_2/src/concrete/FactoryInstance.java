package concrete;

import abst.GuiFactory;
import linux.LinuxGuiFac;
import mac.MacGuiFac;

public class FactoryInstance {
    public static GuiFactory getGuiFac() {
        return getGuiFac(getOsCode());
    }

    public static GuiFactory getGuiFac(int osCode) {
        switch (osCode) {
            case 0:
                return new LinuxGuiFac();
            case 1:
                return new MacGuiFac();
            default:
                throw new Error("There's no os name such like that!");
        }
    }

    private static int getOsCode() {
        String os = System.getProperty("os.name");
        if (os.equals("Linux")) { return 0; }
        else if (os.equals("Mac OS X")) { return 1; }
        else if (os.equals("Window")) { return 2; }
        return -1;
    }

}
