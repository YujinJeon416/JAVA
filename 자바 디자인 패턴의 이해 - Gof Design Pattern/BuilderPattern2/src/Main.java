public class Main {

    public static void main(String[] args) {

        /*
        * �������
        * Computer computer = new Computer("�߸��� ����1", ...);
        * ���� ���� �߸��� ���� �Ǵ� �߸��� ������ ������ �� �ֱ⿡ builder ������ ���� ��������� �����ֵ��� ��.
        * */

        Computer computer = ComputerBuilder
                .start()
                .setCpu("i7")
                .setRam("8g")
                .setStorage("ssd 256mb")
                .build();

        System.out.println(computer.toString());
    }
}
