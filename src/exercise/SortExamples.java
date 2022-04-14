package exercise;
import java.util.*;

class Fruit implements Comparable<Fruit>{
	 
	private String fruitName;
	private String fruitDesc;
	private int quantity;
 
	public Fruit(String fruitName, String fruitDesc, int quantity) {
		super();
		this.fruitName = fruitName;
		this.fruitDesc = fruitDesc;
		this.quantity = quantity;
	}
 
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public String getFruitDesc() {
		return fruitDesc;
	}
	public void setFruitDesc(String fruitDesc) {
		this.fruitDesc = fruitDesc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
 
	public int compareTo(Fruit compareFruit) {
 
		int compareQuantity = ((Fruit) compareFruit).getQuantity(); 
 
		//ascending order
		return this.quantity - compareQuantity;
 
		//descending order
		//return compareQuantity - this.quantity;
 
	}
 
	public static Comparator<Fruit> FruitNameComparator 
                          = new Comparator<Fruit>() {
 
	    public int compare(Fruit fruit1, Fruit fruit2) {
 
	      String fruitName1 = fruit1.getFruitName().toUpperCase();
	      String fruitName2 = fruit2.getFruitName().toUpperCase();
 
	      //ascending order
	      return fruitName1.compareTo(fruitName2);
 
	      //descending order
	      //return fruitName2.compareTo(fruitName1);
	    }
 
	};
}

public class SortExamples {
	
	public static void main(String[] args) {
		////////////////////  Array /////////////////////
		String[] fruits = new String[] {"Pineapple","Apple", "Orange", "Banana"}; 
		 
		Arrays.sort(fruits);
	 
		int i=0;
		for(String temp: fruits){
			System.out.println("fruits " + ++i + " : " + temp);
		}
		
		////////////////////  ArrayList /////////////////////
		List<String> fruitsList = new ArrayList<String>();
		 
		fruitsList.add("Pineapple");
		fruitsList.add("Apple");
		fruitsList.add("Orange");
		fruitsList.add("Banana");
	 
		Collections.sort(fruitsList);
	 
		int j=0;
		for(String temp: fruits){
			System.out.println("fruits " + ++j + " : " + temp);
		}
		
		//////////////////  Comparator  //////////////
		Fruit[] fruitObjects = new Fruit[4];
		 
		Fruit pineappale = new Fruit("Pineapple", "Pineapple description",70); 
		Fruit apple = new Fruit("Apple", "Apple description",100); 
		Fruit orange = new Fruit("Orange", "Orange description",80); 
		Fruit banana = new Fruit("Banana", "Banana description",90); 
 
		fruitObjects[0]=pineappale;
		fruitObjects[1]=apple;
		fruitObjects[2]=orange;
		fruitObjects[3]=banana;
 
		Arrays.sort(fruitObjects);
 
		int k=0;
		for(Fruit temp: fruitObjects){
		   System.out.println("fruits " + ++k + " : " + temp.getFruitName() + 
			", Quantity : " + temp.getQuantity());
		}
		
		Arrays.sort(fruitObjects, Fruit.FruitNameComparator);
		int l=0;
		for(Fruit temp: fruitObjects){
		   System.out.println("fruits " + ++l + " : " + temp.getFruitName() + 
			", Quantity : " + temp.getQuantity());
		}
	}
}
