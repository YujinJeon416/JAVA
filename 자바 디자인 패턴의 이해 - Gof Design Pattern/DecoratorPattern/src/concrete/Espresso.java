package concrete;

import abst.AbstAdding;
import abst.IBeverage;

/**
 * <h2><b>Role : </b>ConcreteDecorator</h2>
 *  <p>
 *  �������� ��� �ν��Ͻ� �� �����̸�, å���� �߰��Ǵ� �κ��Դϴ�.
 *  </p>
 */
public class Espresso extends AbstAdding {

    static protected int espressoCount = 0;

    public Espresso(IBeverage beverage) {
        super(beverage);
    }

    @Override
    public int getTotalPrice() {
        return super.getTotalPrice()+getAddPrice();
    }

    private static int getAddPrice() {
        espressoCount++;
        int addPrice = espressoCount > 1 ? 70 : 100;

        return addPrice;
    }
}
