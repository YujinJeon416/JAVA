package DeligateExer;

public class AObj  {

    Ainterface ainterface;

    public AObj(Ainterface ainterface) {
        this.ainterface = ainterface;
    }

    // deligate �� ���
    public void funcAA(){
        ainterface.funcA();
        ainterface.funcA();
    }

}
