package abst;

public interface TextArea {
    default String getText() {
        return this.getClass().getName();
    }
}
