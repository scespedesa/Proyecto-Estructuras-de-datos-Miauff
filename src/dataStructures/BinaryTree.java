package dataStructures;

public interface BinaryTree<K, V> {
    void put(K key, V value);

    void remove(K key);

    V get(K key);

    V getRootValue();

    ListaSimplementeEnlazada<? super V> toList();

    V findMin();

    V findMax();

    int height();

    boolean containsKey(K key);

    boolean containsValue(V value);

    boolean isEmpty();

    int size();

    void makeEmpty();

    void preOrder();

    void inOrder();

    void postOrder();

    void levelOrder();

    String toString();
}