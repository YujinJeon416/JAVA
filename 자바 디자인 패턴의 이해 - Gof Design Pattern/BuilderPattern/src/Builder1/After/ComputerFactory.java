package Builder1.After;
// 1.설계도 설정 2. 만들고 3. return 한다.
public class ComputerFactory {
    private BluePrint blueprint;

    public void setBluePrint(BluePrint blueprint) {
        this.blueprint = blueprint;
    }

    // make와 get의 순서를 강제할 수 있다.
    public Computer makeAndGetComputer(String cpu,String ram, String storage) {
        blueprint.setCpu(cpu);
        blueprint.setRam(ram);
        blueprint.setStorage(storage);

        return blueprint.getComputer();
    }

}

