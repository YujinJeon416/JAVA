import abst.IBeverage;
import concrete.Base;
import concrete.Espresso;
import concrete.Milk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            //base
            IBeverage beverage = new Base();
            boolean done = false;
            while (!done) {
                System.out.println("���� ���� ���� : " + beverage.getTotalPrice());
                System.out.println("���� :\n1) �� �߰�\n2)���� �߰�");
                System.out.print(">> ");
                switch (sc.nextInt()) {
                    case 0:
                        done = true;
                        break;
                    case 1:
                        beverage = new Espresso(beverage);
                        break;
                    case 2:
                        beverage = new Milk(beverage);
                        break;
                }
            }

            System.out.println("���� ���� : " + beverage.getTotalPrice());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
