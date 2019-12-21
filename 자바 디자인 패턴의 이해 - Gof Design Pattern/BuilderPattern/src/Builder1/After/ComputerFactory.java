package Builder1.After;
// 1.���赵 ���� 2. ����� 3. return �Ѵ�.
public class ComputerFactory {
    private BluePrint blueprint;

    public void setBluePrint(BluePrint blueprint) {
        this.blueprint = blueprint;
    }

    // make�� get�� ������ ������ �� �ִ�.
    public Computer makeAndGetComputer(String cpu,String ram, String storage) {
        blueprint.setCpu(cpu);
        blueprint.setRam(ram);
        blueprint.setStorage(storage);

        return blueprint.getComputer();
    }

}

