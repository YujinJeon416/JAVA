package concrete;

import abst.AbstAdding;
import abst.IBeverage;

/**
 * <h2><b>Role : </b>ConcreteDecorator</h2>
 *  <p>
 *  �������� ��� �ν��Ͻ� �� �����̸�, å���� �߰��Ǵ� �κ��Դϴ�.
 *  </p>
 * @author garam park
 *
 */
public class Milk extends AbstAdding {


    public Milk(IBeverage beverage) {
        super(beverage);
    }

    @Override
    public int getTotalPrice() {
        return super.getTotalPrice()+50;
    }
}
