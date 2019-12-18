package framework;

public abstract class ItemCreator {

    // 템플릿 메서드
    public Item create(){
        Item item;

        requestItemsInfo();
        item = createItem();

        createItemLog();

        return item;
    }

    protected abstract void requestItemsInfo();
    protected abstract void createItemLog();
    protected abstract Item createItem();

}

