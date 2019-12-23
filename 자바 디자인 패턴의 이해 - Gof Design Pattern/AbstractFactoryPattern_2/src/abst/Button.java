package abst;

public interface Button {
    default void click() {
        System.out.println(this.getClass().getName()+ " is Clicked!");
    }
}
