public class Main {

    public static void main(String[] args) {
        Adapter adapter = new AdapterImpl();

        float number = 10.0f;
        System.out.println(adapter.twiceOf(number));
        System.out.println(adapter.halfOf(number));
    }
}
