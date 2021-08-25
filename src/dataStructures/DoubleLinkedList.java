package dataStructures;

public interface DoubleLinkedList <E> {
    E popFront();
    E topFront();
    E popBack();
    void pushBack(E Object);
    boolean isEmpty();
    void printList();
	void pushFront(E Object);
    
}