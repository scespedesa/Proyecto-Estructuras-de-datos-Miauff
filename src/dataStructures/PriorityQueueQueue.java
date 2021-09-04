package dataStructures;


public class PriorityQueueQueue<E> {
	private double size;
	public PriorityNode<E> head=null;
	public PriorityNode<E> tail=null;
	public PriorityQueueQueue() {
    }
	
	public void add(E e,double prior) {
		PriorityNode<E> nodo1 = new PriorityNode<E>(e,prior,null,null);
		if(this.head == null) {
			this.head = this.tail = nodo1;
		}else if(this.head.priority < nodo1.priority){
			nodo1.next=this.head;
			this.head.prev=nodo1;
			this.head=nodo1;
		}else {
		PriorityNode<E>current = this.head;
		 while(current!=null && current.priority > nodo1.priority){
		     current=current.next;
		 }
		  if(current==null){
		              nodo1.prev=this.tail;
		              tail.next=nodo1;
		              tail=nodo1;
	      }else {
	    	  nodo1.next= current;
	    	  nodo1.prev=current.prev;
	    	  current.prev.next=nodo1;
	            	current.prev=nodo1;
	                current = nodo1;
	            }
		}
		size++;
	}
	public E topFront(){
        if(this.head==null){
            throw new RuntimeException("No hay elementos en la lista");
        }
        return head.getKey();
    }

	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public boolean Compare(PriorityNode<E> a,PriorityNode<E>b) {
		boolean result = a.priority > b.priority;
		System.out.println(result);
		return result;
	}
    public void printList(){
    	 System.out.print("[");
        if(this.head==null){
            System.out.print("");
        }
        PriorityNode<E>current = this.head;
        
        while(current!=null){
            if(current.next==null){
                System.out.print(current.key);
            }else{
                System.out.println(current.key+" ");
            }
            
            current=current.next;
        }
        System.out.print("]");
    }
  public E peek() {
	  return head.key;
  }
  public PriorityNode<E> pop() {
	  PriorityNode<E>current = this.head;
	  this.head = this.head.next;
	  return current;
  }
}