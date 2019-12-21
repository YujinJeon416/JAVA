package Builder1.After;

public class Main {
    public static void main(String[] args) {
        ComputerFactory factory = new ComputerFactory();
        factory.setBluePrint(new LgGramBlueprint());
//        factory.setBluePrint(new LgGramBlueprint());
//        factory.setBluePrint(new LgGramBlueprint());

        Computer computer = factory.makeAndGetComputer("i7", "16g", "256g SSD");
        System.out.println(computer.toString());
    }
}
