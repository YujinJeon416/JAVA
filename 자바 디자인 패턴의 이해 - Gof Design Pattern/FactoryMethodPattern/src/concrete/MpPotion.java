package concrete;

import framework.Item;

public class MpPotion implements Item {
    @Override
    public void use() {
        System.out.println("마력이 회복되었습니다.");
    }
}
