package concrete;

import abst.AbstAdding;
import abst.IBeverage;

/**
 * <h2><b>Role : </b>ConcreteDecorator</h2>
 *  <p>
 *  실질적인 장식 인스턴스 및 정의이며, 책임이 추가되는 부분입니다.
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
