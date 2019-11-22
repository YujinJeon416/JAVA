
public class Code1 {

    protected static int num;

    public static void main(String[] args) {
        int anotherNum = 5;
        num = 2;

        System.out.println(num + anotherNum);
        System.out.println("num:" + num);
        System.out.println("anotherNum: "+anotherNum);
    }
}
