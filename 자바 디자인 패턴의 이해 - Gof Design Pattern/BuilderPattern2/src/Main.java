public class Main {

    public static void main(String[] args) {

        /*
        * 사용이유
        * Computer computer = new Computer("잘못된 인자1", ...);
        * 위와 같이 잘못된 인자 또는 잘못된 순서를 제공할 수 있기에 builder 패턴을 통해 명시적으로 보여주도록 함.
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
