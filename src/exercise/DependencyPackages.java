package exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class Package {
	public List<Package> deps;
	public String data;
	
	public Package(String data) {
		this.data = data;
		deps = new ArrayList<Package>();
	}
}

public class DependencyPackages {
	/*
	print out the dependencies
	
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
		}
		
		if (!packageSet.contains(root)) {
			packageList.add(root);
			packageSet.add(root);
		}
	}
	
	public static void main(String[] args) {
		Package a = new Package("a");
		Package b = new Package("b");
		Package c = new Package("c");
		Package d = new Package("d");
		Package e = new Package("e");
		Package f = new Package("f");
		a.deps.add(b);
		a.deps.add(c);
		b.deps.add(c);
		b.deps.add(d);
		b.deps.add(e);
		c.deps.add(f);
		List<Package> result = topSort(a);
		Iterator<Package> iter = result.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().data);
		}
	}
}
