import java.util.Scanner;

/*
1. Next(): 하나의 문자열 읽어들임
2. String간 비교는 ==이 아닌 equal()사용

 */
public class Code3 {

    public static void main(String[] args) {
        String str = "java";
        String input = null;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the word: ");

        input = keyboard.next();

        if (str.equals(input)) {
            System.out.println("Matched!");
        } else {
            System.out.println("Unmatched!");
        }
    }
}
