package concrete;

import framework.Item;

public class HpPotion implements Item {
    @Override
    public void use() {
        System.out.println("체력이 회복되었습니다.");
    }
}
