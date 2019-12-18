package concrete;

import framework.Item;
import framework.ItemCreator;

import java.util.Date;

public class HpCreator extends ItemCreator {
    String name = "ü��ȸ��";
    @Override
    protected void requestItemsInfo() {
        System.out.println("�����ͺ��̽����� "+name+" ������ �����ɴϴ�.");
    }

    @Override
    protected void createItemLog() {
        System.out.println(name + " ������ ���� ���� �߽��ϴ�." + new Date());
    }

    @Override
    protected Item createItem() {
        return new HpPotion();
    }
}
