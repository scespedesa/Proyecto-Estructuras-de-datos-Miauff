package dataStructures;

import java.util.Objects;
import java.util.Random;

public class HashTable {
	public MyArrayList<Nodo> hashTable;
	int n = 0;
	public int m; 
	int chain = 0 ; 
	int loadFactor;
	long p;
	int longitudmax=30;
	MyArrayList<Integer> primos= new MyArrayList(11);
	long primo;
	int x;
	int a;
	int b; 
	
	public HashTable(int tamaño){
		this.m=15;
		this.hashTable = new MyArrayList(15);
		creacionArrayPrimos();
		primo = prime();
		int resta = (int) (primo-1);
		int yu = getRandomNumberInRange(0,1);
		x= primos.getObject(yu);
		a = getRandomNumberInRange(2,resta);
		b =  getRandomNumberInRange(0,resta); 
		test();
	}
	private void creacionArrayPrimos() {
		primos.pushBack(31);
		primos.pushBack(53);
		primos.pushBack(786433);
		primos.pushBack(196613);
		primos.pushBack(1572869);
		primos.pushBack(6291469);
		primos.pushBack(50331653);
		primos.pushBack(100663319);
		primos.pushBack(201326611);
		primos.pushBack(402653189);
		primos.pushBack(1610612741);
		
	}
	public long prime() {
		int primo = getRandomNumberInRange(2,10);
		long prime = primos.getObject(primo) ;
		return prime;
	}
	public void rehash() {
		System.out.println("     se hizo rehash ");
		MyArrayList<Nodo> copia =new MyArrayList(hashTable.getCapacity());
		int modulo = 2*m;
		m=modulo;
		primo = prime();
		int resta = (int) (primo-1);
		int yu = getRandomNumberInRange(0,1);
		x= primos.getObject(yu);
		a = getRandomNumberInRange(2,resta);
		b =  getRandomNumberInRange(0,resta); 
		n=0;
		chain = 0 ;
		MyArrayList<Nodo> NewhashTable = new MyArrayList(modulo);
		copia = hashTable;
		this.hashTable =NewhashTable;
		for (int i =0 ; i<copia.getCapacity();i++) {
			Nodo<String> obj= copia.getObject(i);
			if(obj!=null) {
				Nodo<String> runner=obj;
				String key ;
				String value;
				while (runner.next != null){
					key = (String)runner.key;
					value = (String)runner.value;
					put(key,value);
					runner = runner.next;
				}
				key = (String)runner.key;
				value = (String)runner.value;
				put(key,value);
			}
		}
	}
	public boolean find(String key, String value){
		long poly = polyHash(key);
		int location = integerHash(poly);
		Nodo exe = hashTable.getObject(location);
		if(exe==null) {
			return false;
		}else if(exe.key==key && exe.value==value) {
			return true;
		}
		while (exe.next != null){
			exe = exe.next;
			if(exe.getKey().equals(key) && exe.value==value) {
				return true;
			}
		}
		return false;
	}
	
	public Nodo<String> findNode(String key, String value){
		long poly = polyHash(key);
		int location = integerHash(poly);
		Nodo<String> exe = hashTable.getObject(location);
		if(exe==null) {
			return null;
		}
		else if(exe.key==key && exe.value==value) {
			return exe;
		}
		else if(exe!=null) {
			while (exe.next != null){
			exe = exe.next;
			if(exe.getKey().equals(key) && exe.value==value) {
				return exe;
			}
			}
		}
		return null;
	}
	
	public boolean findLlave(String key){
		long poly = polyHash(key);
		int location = integerHash(poly);
		Nodo exe = hashTable.getObject(location);
		if(exe==null) {
			return false;
		}else if(exe.key==key) {
			return true;
		}
		while (exe.next != null){
			exe = exe.next;
			if(exe.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean remove(String key, String value) {
		long poly = polyHash(key);
		int location = integerHash(poly);
		Nodo exe = hashTable.getObject(location);
		Nodo prev;
		if (exe.key==null && exe.value==null){
            return false;
        }
		if(exe.key==key && exe.value==value) {
			if (exe.next==null) {
				hashTable.popIndexHash(location);
				System.out.println("se elimino el primero y unico");
			}else {
				exe= exe.next;
				hashTable.pushIndex(exe, location);
				System.out.println("se elimino el primero");
			}
			return true;
		}
		while (exe.next != null){
			prev= exe;
			if(exe.next.getKey().equals(key) && exe.next.value==value) {
				prev.next = exe.next.next ;
				System.out.println(" se elimino como nodo de la mitad");
				return true;
			}
			exe = exe.next;
		}
		return false;
	}public boolean changeClave(String key, String value, String newValue) {
		Nodo<String> nod = findNode(key,value);
		if (nod!=null) {
			nod.setValue(newValue);
			return true;
		}
		return false;
		
	}
	public void put(String key, String value) {
		n+=1;
		hashTable.setSize(n);
		long poly = polyHash(key);
		int location = integerHash(poly);
		Nodo<String> newNode= new Nodo(key,value,null,null);      
		if (hashTable.getObject(location) == null){
			hashTable.pushIndex(newNode, location);
			System.out.println( "se puso a : " + key + "en la posicion : " + location + "del arreglo tam: " + hashTable.getCapacity());
		}
		else {
			Nodo<String> runner= hashTable.getObject(location);
			int cont = 1 ;
			while (runner.next != null){
				runner = runner.next;
				cont +=1;
			}
			cont+=1;
			if(cont>chain) {
				chain=cont;
			}
			System.out.println( "se puso a : " + key + "en la posicion : " + location + "del arreglo tam: " + hashTable.getCapacity());
			runner.setNext(newNode);
		} 
		loadFactor= n/m ;
		if(loadFactor>0.75) {
			System.out.println(hashTable.toString());
			System.out.println("   estabamos con  " + key);
			rehash();
		}
	}
	public Object get(String key){
		long poly = polyHash(key);
		int location = integerHash(poly);
		Nodo<String> runner= hashTable.getObject(location);       
		while (runner!=null){                
			if (runner.key.equals(key)) {
				return runner.value;
			}	
			runner = runner.next;                            
		}       
		return null;
	}
	public void test(){
        System.out.println(" ");
        
        put("sammy", "Kassoum");
        put("maria", "secreto");
        put("say", "Ksoum");
        put("ma", "cecreto");
        put("gu", "oum");
        put("poi", "so");
        put("geeksforgeeks", "Katttssoum");
        put("mariajuliana198883", "mepepe");
        put("nestor", "guille");
        put("adri", "poisson");
        put("niñp", "juguete");
        System.out.println(get("sammy")+ "clave sammy");
        System.out.println(get("maria") + "clave maria");
       System.out.println(get("nestor")+ "clave nestor");
        System.out.println(get("adri") + "clave de adri");
        System.out.println(get("paquito") + "este es paquito");
        System.out.println(get("mariajuliana198883") + " clave de mariajuliana198883");
        System.out.println(chain + "mas colisones");
        System.out.println(primo + " el primo que se escogio y objetos" + n + "ell " +  loadFactor);
        System.out.println(remove("adri","poisson"));
        System.out.println(get("adri"));
        System.out.println(changeClave("gu", "oum","newclavesita"));
        System.out.println(get("gu"));
        System.out.println(hashTable.toString());
    }public int integerHash(long num){
    	int in = (int) (((a*num)+b)%primo)%m ;
    	in= Math.abs(in);
    	return in;
    }
    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    public long polyHash(String prueba) {
    	int i = prueba.length();
    	long hash =0 ;
    	for(i = i -1; i>=0; i--){
    		hash =  ((hash*x) + (prueba.charAt(i) - 'a' + 1 )) % primo;
    		hash= Math.abs(hash);
    	}
    	return hash;
    	
	}
    
}
