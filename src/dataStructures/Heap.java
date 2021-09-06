package dataStructures;
import java.util.ArrayList;
import datosMascotas.MascotasAdopcion;

public class Heap {
	
    public static ArrayList<MascotasAdopcion> glob = new ArrayList<MascotasAdopcion>();
    public static ArrayList<Integer> globarr = new ArrayList<Integer>(); 
    void heapify(ArrayList<Integer> hT, int i) {
    int size = hT.size();
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    
    if (l < size && hT.get(l) > hT.get(largest))
      largest = l;
    if (r < size && hT.get(r) > hT.get(largest))
      largest = r;

    if (largest != i) {
      int temp = hT.get(largest);
      MascotasAdopcion temp2= glob.get(largest);
      hT.set(largest, hT.get(i));
      hT.set(i, temp);
      glob.set(largest, glob.get(i));
      glob.set(i, temp2);

      heapify(hT, largest);
    }
  }

  public void insert(ArrayList<Integer> hT, int newNum, MascotasAdopcion arr2) {
    int size = hT.size();
    if (size == 0) {
      hT.add(newNum);
      glob.add(arr2);

    } else {
      hT.add(newNum);
      glob.add(arr2);
      for (int i = size / 2 - 1; i >= 0; i--) {
        heapify(hT, i);
      }
    }
  }

 public void deleteNode(ArrayList<Integer> hT, int num, MascotasAdopcion arr2)
  {
    int size = hT.size();
    int i;
    for (i = 0; i < size; i++)
    {
      if (num == hT.get(i))
        break;
    }

    int temp = hT.get(i);
    MascotasAdopcion temp2= glob.get(i);
    hT.set(i, hT.get(size-1));
    hT.set(size-1, temp);
    glob.set(i, glob.get(size-1));
    glob.set(size-1, temp2);

    hT.remove(size-1);
    glob.remove(size-1);
    for (int j = size / 2 - 1; j >= 0; j--)
    {
      heapify(hT, j);
    }
  }

  void printArray(ArrayList<Integer> array, int size, ArrayList<ArrayList> arr2) {
    for (Integer i : array) {
      System.out.print(i + " ");
    }
    
    System.out.println();
    
    for (Object i : arr2) {
      System.out.print(i + " ");
    }
  }
}