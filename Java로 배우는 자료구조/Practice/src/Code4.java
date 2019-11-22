import java.util.Scanner;

public class Code4 {
    public static void main(String[] args) {
        String name;
        int age;
        String gender;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter [name, age, gender]");

        name = keyboard.next();
        age = keyboard.nextInt();
        gender = keyboard.next();

        if (gender.equals("male")) {
            System.out.println('"' + name + '"' + age + " man");
        } else {
            System.out.println('"' + name + '"' + age + " woman");
        }
    }
}
