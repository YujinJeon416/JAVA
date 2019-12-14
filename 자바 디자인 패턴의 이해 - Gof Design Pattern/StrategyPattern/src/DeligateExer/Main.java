package DeligateExer;

public class Main {
    public static void main(String[] args) {
        Ainterface ainterface = new AinterfaceImpl();
        AObj aObj = new AObj(ainterface);

        aObj.funcAA();

    }
}
