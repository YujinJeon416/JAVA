package concrete;

import framework.Item;
import framework.ItemCreator;

import java.util.Date;

public class HpCreator extends ItemCreator {
    String name = "체력회복";
    @Override
    protected void requestItemsInfo() {
        System.out.println("데이터베이스에서 "+name+" 정보를 가져옵니다.");
    }

    @Override
    protected void createItemLog() {
        System.out.println(name + " 물약을 새로 생성 했습니다." + new Date());
    }

    @Override
    protected Item createItem() {
        return new HpPotion();
    }
}
