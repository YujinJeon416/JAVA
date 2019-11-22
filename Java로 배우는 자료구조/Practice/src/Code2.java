import java.util.Scanner;

/*
 1.Scanner
 2. NextInt()
 3. == 연산자
 */


public class Code2 {
    public static void main(String[] args) {
        int number = 123;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter an integer:");

        int input = keyboard.nextInt();

        if (input == number) {
            System.out.println("Number match!");
        } else {
            System.out.println("Numbers do not match!");
        }
    }
}
