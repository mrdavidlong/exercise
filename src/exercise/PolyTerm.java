package exercise;

import java.util.ArrayList;
import java.util.Collections;

public class PolyTerm implements Comparable {
	double coefficient;
	double exponent;
	
	public PolyTerm(double a, double b) {
		coefficient = a;
		exponent = b;
	}
	
	@Override
	public int compareTo(Object polyTerm) {
		return (int) (this.exponent - ((PolyTerm)polyTerm).exponent);
	}
	
	public static ArrayList<PolyTerm> polySum(ArrayList<PolyTerm> poly1, ArrayList<PolyTerm> poly2) {
		Collections.sort(poly1);
		Collections.sort(poly2);
		ArrayList<PolyTerm> result = new ArrayList<PolyTerm>();
		int i = 0;
		int j = 0;
		while (i < poly1.size() && j < poly2.size()) {
			if (poly1.get(i).exponent == poly2.get(j).exponent) {
				result.add(new PolyTerm(poly1.get(i).coefficient + poly2.get(j).coefficient, poly1.get(i).exponent));
				i++;
				j++;
			}
			else if (poly1.get(i).exponent < poly2.get(i).exponent) {
				result.add(new PolyTerm(poly1.get(i).coefficient, poly1.get(i).exponent));
				i++;
			}
			else if (poly1.get(i).exponent > poly2.get(j).exponent) {
				result.add(new PolyTerm(poly2.get(j).coefficient, poly2.get(j).exponent));
				j++;
			}
		}
		
		while (i < poly1.size()) {
			result.add(poly1.get(i));
			i++;
		}
		
		while (j < poly2.size()) {
			result.add(poly2.get(j));
			j++;
		}
		
		return result;
	}
}
