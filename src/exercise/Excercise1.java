package exercise;

import java.util.*;

public class Excercise1 {
	
	public static void DoFizzBuzz(int n) {
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				System.out.println(i + " Fizz Buzz");
			}
			else if (i % 3 == 0) {
				System.out.println(i + " Fizz");
			}
			else if (i % 5 == 0) {
				System.out.println(i + " Buzz");
			}
		}
	}
	
	public static Boolean isPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j++) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * int result = ComputeNumbers(new int[] {5, 100, 20, 7, 1000000, 3, 100, 19, 1000, 7, 100, 60, 5 });
	 * (5*100+20+7)*1000000 + (3*100+19) * 1000 + 7*100+60+5
	 * result == 527319765
	 */
	public static int ComputeNumbers(int[] numbers) {
		int temp = 0;
		int total = 0;
		for (int i = 0; i < numbers.length; i++)
		{
			if (numbers[i] == 100) {
				temp *= numbers[i];
			}
			else if (numbers[i] == 1000 || numbers[i] == 1000000 || numbers[i] == 1000000000) {
				total += temp * numbers[i];
				temp = 0;
			}
			else {
				temp += numbers[i];
			}
		}
		
		if (temp > 0) {
			total += temp;
		}
		
		return total;
	}
	
	public static boolean HasTwoAddToX(int[] a, int x) {
		Hashtable<Integer, Boolean> ht = new Hashtable<Integer, Boolean>();
		for (int num : a) {
			if (ht.containsKey(x-num)) {
				return true;
			}
			else {
				ht.put(num, true);
			}
		}
		return false;
	}
	
	public static int getMaxSum(int a[]) {
		int maxSum = 0;
		int tempSum = 0;
		for (int i = 0; i < a.length; i++) {
			tempSum += a[i];
			if (tempSum > maxSum) {
				maxSum = tempSum;
			}
			else if (tempSum < 0) {
				tempSum = 0;
			}
		}
		return maxSum;
	}
	
	/*
	An Armstrong is an integer such that the sum 
	of the cubes of its digits is equal to the number itself. For example, 
	371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371.

	Write a program to find all Armstrong number in the range of 0 and 999.
	Print each Armstrong number to the command console.
	*/
	public static void PrintArmstrongNumbers(int n) {
		int asNum;
		int curNum;
		int curDigit;
		int i;

		for (i = 0; i <= n; i++) { 
			asNum = 0;
			curNum = i;
			curDigit = 0;
			while (curNum > 0) {
				curDigit = curNum % 10;
				
				asNum += curDigit * curDigit * curDigit;
				
				curNum /= 10;
			}
			if (asNum == i) {
				System.out.println("Armstrong number: " + asNum);
			}	
		}	
	}
	
	public static void PrintLinkedList(LinkedList<UrlCount> list) {
		for (UrlCount urlCount : list) {
			System.out.println(urlCount.url + " " + urlCount.count);
		}
	}
	
	public static LinkedList<UrlCount> insertInOrder(LinkedList<UrlCount> urlCounts, UrlCount newUrlCount) {
		int i = 0;
		for (UrlCount urlCount: urlCounts) {
			if (newUrlCount.count > urlCount.count) {
				break;
			}
			i++;
		}
		urlCounts.add(i, newUrlCount);
		return urlCounts;
	}
	
	public static LinkedList<UrlCount> getTopTenUrls(ArrayList<String> urls) {
		Hashtable<String, Integer> urlCountHT = new Hashtable<String, Integer>();
		for (String url : urls) {
			if (!urlCountHT.containsKey(url)) {
				urlCountHT.put(url, 1);
			}
			else {
				urlCountHT.put(url, urlCountHT.get(url) + 1);
			}
		}
		
		LinkedList<UrlCount> topTenUrls = new LinkedList<UrlCount>();
		for (String url: urlCountHT.keySet()) {
			if (topTenUrls.size() < 10) {
				//add url to the linked list in sorted order
				insertInOrder(topTenUrls, new UrlCount(url, urlCountHT.get(url)));
			}
			else {
				//compare the count to the lowest count
				//if larger then lowest count, insert in order
				if (topTenUrls.peekLast().count < urlCountHT.get(url)) {
					topTenUrls.removeLast();
					insertInOrder(topTenUrls, new UrlCount(url, urlCountHT.get(url)));
				}
			}
		}
		
		return topTenUrls;
	}
	
	/*
	 * abc => bcd
	 * abcd, abxcd => ab or cd
	 */
	public static String getLargestSubstring(String s1, String s2) {
		String maxString = null;
		int maxLength = 0;
		for (int i = 0; i < s2.length() - 1; i++) {
			for (int j = i+1; j < s2.length(); j++) {
				String sub = s2.substring(i, j);
				if (s1.indexOf(sub) >=0 && sub.length() > maxLength)  {
					maxString = sub;
					maxLength = sub.length();
				}
			}
		}
		return maxString;
	}

	public static String getLargestSubstring2(String s1, String s2) {
		HashSet<String> hs1 = new HashSet<String>();		
		for (int i = 0; i < s1.length(); i++) {
			for (int j = i; j < s1.length(); j++) {
				String sub = s1.substring(i, j + 1);
				if (!hs1.contains(sub)) {
					hs1.add(sub);
				}
			}
		}
		
		HashSet<String> hs2 = new HashSet<String>();
		for (int i = 0; i < s2.length(); i++) {
			for (int j = i; j < s2.length(); j++) {
				String sub = s2.substring(i, j + 1);
				if (!hs2.contains(sub)) {
					hs2.add(sub);
				}
			}
		}
		
		// find overlapping strings, and look for the max length
		String maxString = null;
		int maxLength = 0;
		for (String s : hs1) {
			if (hs2.contains(s) && s.length() > maxLength) {
				maxLength = s.length();
				maxString = s;
			}
		}
		
		return maxString;
	}
	
	/* company: Porch */
	public static int getMaxOccurrance(int a[]) {
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		int maxNumOfOccurance = 0;
		int maxInt = 0;
		for (int i = 0; i < a.length; i++) {
			if (!ht.containsKey(a[i])) {
				ht.put(a[i], 0);
			}
			ht.put(a[i], ht.get(a[i]) + 1);
			if (ht.get(a[i]) > maxNumOfOccurance) {
				maxNumOfOccurance = ht.get(a[i]); 
				maxInt = a[i]; 
			}
		}
		return maxInt;
	}
	
	public static void getTwoAddToX(int[] a, int[] b, int x) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
		for (int aInt : a) {
//			if (!hm.containsKey(aInt)) {
//				hm.put(aInt, 0);
//			}
			hm.put(aInt, hm.getOrDefault(aInt, 0) + 1);
		}
		
		for (int bInt : b) {
			if (hm.containsKey(x-bInt)) {
				System.out.println(x-bInt + " " + bInt + " times " + hm.get(x-bInt));
			}
		}
	}
	
	public static void getTwoAddToXWithIndices(int[] a, int[] b, int x) {
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>(); 
		for (int i = 0; i < a.length; i++) {
			if (!hm.containsKey(a[i])) {
				hm.put(a[i], new ArrayList<Integer>());
			}
			hm.get(a[i]).add(i);
		}
		
		for (int j = 0; j < b.length; j++) {
			if (hm.containsKey(x-b[j])) {
				ArrayList<Integer> aIndices = hm.get(x-b[j]);
				for (int aIndex : aIndices) {
					System.out.println("a[" + aIndex + "] " + (x-b[j]) + " b["+j+"] " + b[j]);
				}
			}
		}
	}
	
    static int fibRecursion(int  n) {
        if ((n == 1) || (n == 0)) {
            return n;
        }
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }
	
	public static int fibIteration(int n)
	{
		if (n==0) return 0;
		if (n==1) return 1;
		
		int f1 = 0;
		int f2 = 1;
		int fib = 1;
		for ( int i = 2; i <= n; i++ ) {
			fib = f1 + f2;
			f1 = f2;
			f2 = fib;
		}
		return fib;
	}  
	
	public static void main(String[] args) {

		int[] arr = new int[] {3,2,5,1,7,0};

		//Arrays.sort(arr, Collections.reverseOrder());
		//DoFizzBuzz(100);
		
//		String panString = "abcdedcba";
//		Boolean isPalindromeResult = isPalindrome(panString);
		
		//int result = ComputeNumbers(new int[] {5, 100, 20, 7, 1000000, 3, 100, 19, 1000, 7, 100, 60, 5 });
		
		//boolean resultHasTwoAddToX = HasTwoAddToX(new int[] {0, 2, 4, 3}, 5);
		
//		int maxSum = getMaxSum(new int[] {3, 4, -1, 4, 5, -10, 2});
		
//		ArrayList<PolyTerm> poly1 = new ArrayList<PolyTerm>();
//		PolyTerm polyTerm1 = new PolyTerm(1,1);
//		poly1.add(new PolyTerm(1,1));
//		poly1.add(new PolyTerm(2,2));
//		poly1.add(new PolyTerm(3,3));
//		ArrayList<PolyTerm> poly2 = new ArrayList<PolyTerm>();
//		poly2.add(new PolyTerm(1,1));
//		poly2.add(new PolyTerm(2,2));
//		poly2.add(new PolyTerm(4,4));
//		ArrayList<PolyTerm> polyResult = PolyTerm.polySum(poly1, poly2);
		
		//PrintArmstrongNumbers(999);
		
//		ArrayList<String> urlList = new ArrayList<String>();
//		urlList.add("a");
//		urlList.add("b");
//		urlList.add("c");
//		urlList.add("d");
//		urlList.add("e");
//		urlList.add("f");
//		urlList.add("g");
//		urlList.add("h");
//		urlList.add("i");
//		urlList.add("j");
//		urlList.add("k");
//		urlList.add("l");
//		urlList.add("a");
//		urlList.add("b");
//		urlList.add("c");
//		LinkedList<UrlCount> topTenUrls = getTopTenUrls(urlList);
//		PrintLinkedList(topTenUrls);
		
		int retFib = fibRecursion(0);
		retFib = fibRecursion(1);
		retFib = fibRecursion(2);
		retFib = fibRecursion(3);
		retFib = fibRecursion(4);
		retFib = fibRecursion(5);
		
		retFib = fibIteration(0);
		retFib = fibIteration(1);
		retFib = fibIteration(2);
		retFib = fibIteration(3);
		retFib = fibIteration(4);
		retFib = fibIteration(5);
		
		int maxInt = getMaxOccurrance(new int[] {1,1,2,2,2,3,4});
		System.out.println(maxInt);
		String s1 = "abc";
		String s2 = "bcd";
		String maxString = getLargestSubstring2(s1, s2);
		System.out.println(maxString);
	}
}
