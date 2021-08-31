package dataStructures;

public class ArbolBinario<K extends Comparable, V> implements BinaryTree<K, V> {

    private Node<K, V> root;
    private int size;

    public ArbolBinario() {
        this.root = null;
        this.size = 0;
    }

    public Node<K, V> makeNode(K key, V value) {
        return new Node<>(key, value);
    }

    public Node<K, V> getRoot() {
        return root;
    }

    public V getRootValue() {
        return root.value;
    }

    public void setRoot(Node<K, V> root) {
        if (this.root == null)
            size = 1;
        this.root = root;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> aux = root;
        if (aux == null) {
            root = new Node<>(key, value, null);
            size = 1;
            return;
        }
        int cmp;
        Node<K, V> parent;
        if (key != null) {
            do {
                parent = aux;
                cmp = key.compareTo(aux.key);
                if (cmp < 0)
                    aux = aux.left;
                else if (cmp > 0)
                    aux = aux.right;
                else {
                    aux.value = value;
                    break;
                }
            } while (aux != null);
        } else {
            if (key == null)
                throw new NullPointerException();
            do {
                parent = aux;
                cmp = key.compareTo(aux.key);
                if (cmp < 0)
                    aux = aux.left;
                else if (cmp > 0)
                    aux = aux.right;
                else {
                    aux.value = value;
                    break;
                }
            } while (aux != null);
        }
        Node<K, V> e = new Node<>(key, value, parent);
        if (cmp == 0) ;
        else if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
        size++;
    }

    @Override
    public boolean containsKey(K key) {
        Node<K, V> aux = root;
        while (aux != null) {
            int cmp = key.compareTo(aux.key);
            if (cmp < 0)
                aux = aux.left;
            else if (cmp > 0)
                aux = aux.right;
            else
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return containsValue(value, root);
    }

    private boolean containsValue(V value, Node<K, V> root) {
        //TODO
        return false;
    }

    @Override
    public void remove(K key) {
        if (!isEmpty()) {
            root = remove(key, root);
            size--;
        }
    }

    public Node<K, V> remove(K key, Node<K, V> root) {
        if (root == null)
            return root;
        int compareResult = key.compareTo(root.key);
        if (compareResult < 0)
            root.left = remove(key, root.left);
        else if (compareResult > 0)
            root.right = remove(key, root.right);
        else if (root.left != null && root.right != null) {
            root.value = findMin(root.right);
            root.right = remove(root.key, root.right);
        } else
            root = (root.left != null) ? root.left : root.right;
        return root;
    }

    @Override
    public V get(K key) {
        Node<K, V> aux = root;
        while (aux != null) {
            int cmp = key.compareTo(aux.key);
            if (cmp < 0)
                aux = aux.left;
            else if (cmp > 0)
                aux = aux.right;
            else
                return aux.value;
        }
        return null;
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> aux = root;
        while (aux != null) {
            int cmp = key.compareTo(aux.key);
            if (cmp < 0)
                aux = aux.left;
            else if (cmp > 0)
                aux = aux.right;
            else
                return aux;
        }
        return null;
    }

    @Override
    public V findMin() {
        Node<K, V> aux = root;
        while (aux.left != null) {
            aux = aux.left;
        }
        return aux.value;
    }

    public V findMin(Node<K, V> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.value;
    }

    @Override
    public V findMax() {
        Node<K, V> aux = root;
        while (aux.right != null) {
            aux = aux.right;
        }
        return aux.value;
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node<K, V> node) {
        if (node == null)
            return -1;
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<K, V> root) {
        if (root != null) {
            System.out.print("[" + root.value + "] ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<K, V> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print("[" + root.value + "] ");
            inOrder(root.right);
        }
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<K, V> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print("[" + root.value + "] ");
        }
    }

    @Override
    public void levelOrder() {
        Queue<Node<K, V>> queue = new QueueDoubleLinkedList<>();
        Node<K, V> aux = root;
        queue.enqueue(aux);
        while (!queue.isEmpty()) {
            aux = queue.dequeue();
            System.out.print("[" + aux.value + "] ");
            if (aux.left != null) {
                queue.enqueue(aux.left);
            }
            if (aux.right != null) {
                queue.enqueue(aux.right);
            }
        }
    }

    public ListaSimplementeEnlazada  toList() {
        ListaSimplementeEnlazada listToFill = new ListaSimplementeEnlazada(null);
        Queue<Node<K, V>> queue = new QueueDoubleLinkedList<>();
        Node<K, V> aux = root;
        queue.enqueue(aux);
        while (!queue.isEmpty()) {
            aux = queue.dequeue();
            listToFill.pushFront(aux.value);
            if (aux.left != null) {
                queue.enqueue(aux.left);
            }
            if (aux.right != null) {
                queue.enqueue(aux.right);
            }
        }
        return listToFill;
    }

    @Override
    public int size() {
        return this.size;
    }

    public void makeEmpty() {
        root = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public class Node<K, V> {
        private V value;
        private K key;
        private Node<K, V> parent;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.value = value;
            this.key = key;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        public Node(K key, V value, Node<K, V> parent) {
            this.value = value;
            this.key = key;
            this.parent = parent;
            this.left = null;
            this.right = null;
        }

        public Node<K, V> getParent() {
            return parent;
        }

        public void setParent(Node<K, V> parent) {
            this.parent = parent;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getLeft() {
            return left;
        }

        public void setLeft(Node<K, V> left) {
            this.left = left;
        }

        public Node<K, V> getRight() {
            return right;
        }

        public void setRight(Node<K, V> right) {
            this.right = right;
        }

    }
}

