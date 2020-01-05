package abst;

/**
 *  <h2><b>Role : </b>Decorator</h2>
 *  <p>
 *  ������Ʈ�� ����� ���Ͻ� ���ִ� �����մϴ�.
 *  </p>
 * @author garam park
 */
abstract  public class AbstAdding implements IBeverage {

    private IBeverage base;

    public AbstAdding(IBeverage base) {
        this.base = base;
    }

    public IBeverage getBase() {
        return base;
    }

    @Override
    public int getTotalPrice() {
        return base.getTotalPrice();
    }

}
