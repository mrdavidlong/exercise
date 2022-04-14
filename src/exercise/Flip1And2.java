package exercise;

import java.util.*;

public class Flip1And2 {

	/*
	2. function to flip 1,2
	- if
	- () ?
	- array
	- 3 - x
	- x ^ 3
	- (x % 2) + 1
	- 2/x
	*/
	public static int flip1And2Method1(int x) {
		if (x == 1) {
			return 2;
		}
		else {
			return 1;
		}
	}
	
	public static int flip1And2Method2(int x) {
		return (x==1)?2:1;
	}
	
	public static int flip1And2Method3(int x) {
		int[] answer = {0,2,1};
		return answer[x];
	}
	
	public static int flip1And2Method4(int x) {
		return 3-x;
	}
	
	public static int flip1And2Method5(int x) {
		return x^3;
	}
	
	public static int flip1And2Method6(int x) {
		return (x%2)+ 1;
	}
	
	public static int flip1And2Method7(int x) {
		return 2/x;
	}
	
	
	/*
	3. print out the dependencies
	
	        a
	       / \
	      b -> c
	     / \    \
	    d   e    f
	   
	
	output: f,c,d,e,b,a
	*/
	public static List<Package> topSort(Package root) {
		HashSet<Package> packageSet = new HashSet<Package>();
		List<Package> packageList = new ArrayList<Package>();
		topSortCore(root, packageList, packageSet);
		return packageList;
	}
	
	private static void topSortCore(Package root, List<Package> packageList, HashSet<Package> packageSet) {
		for (Package p : root.deps) {
			topSortCore(p, packageList, packageSet);
			if (!packageSet.contains(p)) {
				packageList.add(p);
				packageSet.add(p);
			}
		}
		
		if (!packageSet.contains(root)) {
			packageList.add(root);
			packageSet.add(root);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(flip1And2Method1(1));
		System.out.println(flip1And2Method1(2));
		System.out.println(flip1And2Method2(1));
		System.out.println(flip1And2Method2(2));
		System.out.println(flip1And2Method3(1));
		System.out.println(flip1And2Method3(2));
		System.out.println(flip1And2Method4(1));
		System.out.println(flip1And2Method4(2));
		System.out.println(flip1And2Method5(1));
		System.out.println(flip1And2Method5(2));
		System.out.println(flip1And2Method6(1));
		System.out.println(flip1And2Method6(2));
		System.out.println(flip1And2Method7(1));
		System.out.println(flip1And2Method7(2));
	}
}
