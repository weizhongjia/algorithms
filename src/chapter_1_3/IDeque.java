package chapter_1_3;

public interface IDeque<Item> {

    boolean isEmpty();

    int size();

    void pushLeft(Item item);

    void pushRight(Item item);

    Item popLeft();

    Item popRight();
}
