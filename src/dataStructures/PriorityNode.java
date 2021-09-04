package dataStructures;

public class PriorityNode<E> {
	public E key;
	public double priority;
    public E getKey() {
		return key;
	}
	public void setKey(E key) {
		this.key = key;
	}
	public double getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	protected PriorityNode<E> next;
    protected PriorityNode<E> prev;
    
    public PriorityNode(E key,double priority,PriorityNode<E> next,PriorityNode<E> prev){
        this.key = key;
        this.next = next;
        this.prev = prev;
        this.priority = priority;
    }
    public PriorityNode(E key,PriorityNode<E> next,PriorityNode<E> prev) {
    	this.key = key;
        this.next = next;
        this.prev = prev;
    }

}
