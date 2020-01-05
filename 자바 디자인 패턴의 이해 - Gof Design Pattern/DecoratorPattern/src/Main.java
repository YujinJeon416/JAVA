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
                System.out.println("음료 현재 가격 : " + beverage.getTotalPrice());
                System.out.println("선택 :\n1) 샷 추가\n2)우유 추가");
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

            System.out.println("음료 가격 : " + beverage.getTotalPrice());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
