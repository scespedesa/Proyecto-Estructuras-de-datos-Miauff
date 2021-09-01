package dataStructures;

import java.util.Arrays;
//Clase implementacion de un arreglo dinamico
public class MyArrayList<O>  { 

	@SuppressWarnings("unchecked")
	public O[] array ;
	public int size;
	public int capacity ;

	public MyArrayList() {
		this.array = (O[]) new Object[1];
		this.capacity = 1 ;
		this.size = 0 ; 
	}
	public MyArrayList(int i) {
		this.array = (O[]) new Object[i];
		this.capacity = i ;
		this.size = 0 ; 
	}
	//Retorna true o false si el arreglo esta vacio
	public boolean isEmpty(){
		return size == 0;
	}
	//redimensiona el arreglo
	public void resize(O Object) {
		O[] newArray = (O[]) new Object[2*capacity];
			newArray[0]= Object ;
			for(int i = 0 ; i<capacity ; i++ ) {
				newArray[i+1]= array[i];
		this.array = newArray;
		capacity= capacity * 2 ;
			}
	}public void resize() {
		O[] newArray = (O[]) new Object[2*capacity];
		for(int i = 0 ; i<capacity ; i++ ) {
			newArray[i]= array[i];
		}
		this.array = newArray;
		capacity= capacity * 2 ;
	}
	
	//agrega un elemento al inicio del arreglo - complejidad O(n) - por ser arreglo
	public void pushFront(O Object) {
		if(capacity==size) {
			resize(Object);
		}else {
			for(int i = size-1 ; i>=0; i--) {
				array[i+1]=array[i];
			}
			array[0]= Object;
		}
		size++;
	}
	//agrega un elemento al final del arreglo - complejidad O(1) - por ser arreglo
	public void pushBack(O Object){
		if (capacity == size){
			resize();
		}
		array[size] = Object;
		size ++ ;
	} 
	//agrega un elemento en la posicion del index solicitado - complejidad O(n) - por ser arreglo
	public void pushIndex(O Object, int index) {
		array[index]=Object;
	}
	public void agregarIndex(O Object, int index) {
		array[index-1]=Object;	
	}
	//devuelve el elemento en la primera posicion - complejidad O(1) - por ser arreglo
	public O topFront(){    
		if(isEmpty()){     
			throw new RuntimeException("Array vacío");
		}
		return array[0];      
	}
	//elimina el primer elemento - complejidad O(n) - por ser arreglo
	public O popFront(){  
		O eliminado= this.array[0];
		popIndex(1);
		return eliminado;

	}
	// imprime el arreglo
	public void printArray(){
		int cont=1;
		for(int i = 0; i<size;i++ ){
			String im = String.valueOf(cont);
			String array = this.array[i].toString().replace("#", "");
			System.out.println( im + ")"+ array);
			cont+=1;         
		}
	} 
	// retorna si un elementos esta - busqueda O(n) - optimizar
	public boolean esta(O Object){
		boolean is = false;
		for(int i = 0; i<size;i++ ){
			if(array[i]==Object){
				is=true;
			} 
		}
		return is;
	} 
	@Override
	public String toString() {
		return  Arrays.toString(array).replace("[", "").replace("]", "").trim();
		//elimina el ultimo elemento - o(n)
	}public void popBack(){ 
		popIndex(size);	
	}
	// elimina el elemento segun el index - O(n)
	public void popIndex(int num){  
		if(isEmpty()){   
			throw new RuntimeException("Array vacío");
		}       
		this.array[num-1]=null;
		if(num == size) {
			array[size-1]=null;
		}else {
			for(int posicion = num-1; posicion<size; posicion++) {
				array[posicion]=array[posicion+1];
			}
		}
		size -- ;       
	}
	public void popIndexHash(int num){  
		if(isEmpty()){   
			throw new RuntimeException("Array vacío");
		}       
		this.array[num]=null;
		size -- ;       
	}
	public O getObject(int index) {
		if(index>capacity) {
			throw new IndexOutOfBoundsException("El indice excede el tamanio ");
		}
		return array[index];
	}
	public O get(int index) {
		if(index>capacity) {
			throw new IndexOutOfBoundsException("El indice excede el tamanio ");
		}
		return array[index-1];
	}
	

	public O[] getArray() {
		return array;
	}
	public void setArray(O[] array) {
		this.array = array;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}


