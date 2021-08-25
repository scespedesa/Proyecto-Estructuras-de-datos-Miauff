package dataStructures;


public class HashTable {
	
	public MyArrayList<Nodo> hashTable = new MyArrayList(20);
	
	int n_keys = 0;
	int m_size = 0 ; 
	
	
	public HashTable(){
		
		String prueba = "cba" ;
		// el p es el primo que dependiendo del exponencial entrega un hash de ciertos digitos, tamaño del arreglo
		int p = (int)(1e9 + 9);
		System.out.println("el hash es de geek 1 : " + polyHash(prueba,p,53));
		test();
	}
	public void contrasenia(String contra) {
		//estructura de datos. add (polyhash(contrasenia)-contraseña)
		
	}
	public void esta(){
		
	}
	public void put(String key, String value) {
		double tamaño = hashTable.getCapacity();
		int expo= (int) Math.pow(1, tamaño);
		int p =(int)(expo + 9);
		int location = Math.abs(polyHash(key,p,53));
		System.out.println("locacion de : " + key + "= " + location);
		//int location = Math.abs(key.hashCode())%10;
		//every key string would give me its unique array index
		Nodo newNode= new Nodo(key,value,null,null);      
		if (hashTable.getObject(location) == null){//the linked list is still empty and this is the first entry
			hashTable.pushIndex(newNode, location);
		}
		else {
			Nodo runner= hashTable.getObject(location);; // the runner will go throught the linked list wothout loosing the head 
			while (runner.next != null){
				runner = runner.next;
			}
			runner.setNext(newNode);
		}    
	}
	//end of put() method
	public Object get(String key){
		double tamaño = hashTable.getCapacity();
		int expo= (int) Math.pow(1, tamaño);
		int p =(int)(expo + 9);
		int location = polyHash(key,p,53); 
		System.out.println("locacion de : " + key + "= " + location);
		Nodo runner= hashTable.getObject(location);       
		while (runner!=null){                
			if (runner.key.equals(key)) {
				return runner.value;
			}	
			runner = runner.next;                            
		}       
		return null;
	}
	public void test(){
        System.out.println("");
        put("sammy", "Kassoum");
        put("maria", "secreto");
        put("say", "Ksoum");
        put("ma", "cecreto");
        put("gu", "oum");
        put("poi", "so");
        put("lo", "mepepe");
        put("nestor", "guille");
        put("adri", "poisson");
        put("niñp", "juguete");
        System.out.println(get("sammy"));
        System.out.println(get("maria"));
       System.out.println(get("nestor"));
        System.out.println(get("adri") + "clave de adri");
        System.out.println(get("paquito") + "este es paquito");
         
    }
	public int polyHash(String prueba,int p,int x) {
		int i = prueba.length();
		int hash =0 ;
		for(i = i -1; i>=0; i--){
			hash = ((hash * x)  + (prueba.charAt(i) - 'a' + 1 )) % p;
			int j = prueba.charAt(i)- 'a' + 1;
			//System.out.println("valor de " +prueba.charAt(i)+ " = "+ j );
		}
		return hash;
	}
}
