package exercise;

public class TrinaryTree implements Comparable{
	public TrinaryTree left;
	public TrinaryTree middle;
	public TrinaryTree right;
	public int data;
	
	public TrinaryTree(int d) {
		data = d;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public TrinaryTree getLeft() {
		return left;
	}
	
	public void setLeft(TrinaryTree left) {
		this.left = left;
	}
	
	public TrinaryTree getRight() {
		return right;
	}
	
	public void setRight(TrinaryTree right) {
		this.right = right;
	}
	
	@Override
	public int compareTo(Object tree2) {
		return data - ((TrinaryTree)tree2).data;
	}
	
	public void insert(int data) {
	    TrinaryTree curNode = this;
	    if (data == curNode.data) {
	    	if (curNode.middle == null) {
	            curNode.middle = new TrinaryTree(data);
	        }
	        else {
	            curNode.middle.insert(data);
	        }
	    }
	    else if (data < curNode.data) {
	        if (curNode.left == null) {
	            curNode.left = new TrinaryTree(data);
	        }
	        else {
	            curNode.left.insert(data);
	        }
	    }
	    else if (data > curNode.data) {
	    	if (curNode.right == null) {
	            curNode.right = new TrinaryTree(data);
	        }
	        else {
	            curNode.right.insert(data);
	        }
	    }
	}
	
	public void insertIterative(int d) {
		TrinaryTree curNode = this;
		while (curNode != null) {
			if (d < data) {
				if (curNode.right == null) {
					curNode.right = new TrinaryTree(d);
					return;
				}
				else {
					curNode = curNode.right;
				}
			}
			else if (d > data) {
				if (curNode.left == null) {
					curNode.left = new TrinaryTree(d);
					return;
				}
				else {
					curNode = curNode.left;
				}
			}
			else if (d == data) {
				if (curNode.middle == null) {
					curNode.middle = new TrinaryTree(d);
					return;
				}
				else {
					curNode = curNode.middle;
				}
			}
		}
	}
	
	public TrinaryTree findMin() {
		TrinaryTree curNode = this;
		while(curNode.left != null) {
			curNode = curNode.left;
		}
	    return curNode;
	}

	public TrinaryTree findParentOfLastMiddle() {
		TrinaryTree curNode = this;
		while(curNode.middle != null && curNode.middle.middle != null) {
			curNode = curNode.middle;
		}
	    return curNode;
	}
	
	public TrinaryTree delete(int data) {
		TrinaryTree curNode = this;
	    if (data < curNode.data && curNode.left != null) {
	    	curNode.left = curNode.left.delete(data);
	    }
	    else if (data > curNode.data && curNode.right != null) {
	    	curNode.right = curNode.right.delete(data);
	    }
	    // found the node that we need to delete
	    else if (data == curNode.data) {
	        // Scenario 1:  delete last child from the middle subtree
	    	if (curNode.middle != null) {
	    		TrinaryTree parentOfLastMiddle = curNode.findParentOfLastMiddle();
	    		parentOfLastMiddle.middle = null;
	    	}
	    	// Scenario 2: there is no left, no middle, and no right children
	    	else if (curNode.left == null && curNode.right == null) { 
	        	curNode = null;
	        }
	        // Scenario 3 a: there is only one right child, skip over the node that we need to delete
	        else if(curNode.left == null) {
	        	curNode = curNode.right;
	        }
	        // Scenario 3 b: there is only one left child, skip over the node that we need to delete
	        else if(curNode.right == null) {
	        	curNode = curNode.left;
	        }
	        // Scenario 4: there are left and right children
	        else { 
	            TrinaryTree temp = curNode.right.findMin();
	            curNode.data = temp.data;
	            curNode.right = curNode.right.delete(temp.data);
	        }
	    }
	    return curNode;
	}

	public void inOrderPrint() {
		inOrderPrintCore();
//		this.inOrderPrintLevel(0, false);
		System.out.println();
		System.out.println();
	}
	
	public void inOrderPrintCore() {
		TrinaryTree curNode = this;
		if (curNode.left != null) {
			curNode.left.inOrderPrintCore();
		}
		System.out.print(this.data + " ");
		if (curNode.middle != null) {
			curNode.middle.inOrderPrintCore();
		}
		if (curNode.right != null) {
			curNode.right.inOrderPrintCore();
		}
	}
	
	/*
	 * The tree is print in the format that is 90 degrees counterclockwise
	 */
	public void inOrderPrintLevel(int level, boolean isMiddle) {
		TrinaryTree curNode = this;
		if (curNode.right != null) {
			curNode.right.inOrderPrintLevel(level + 1, false);
		}

		if (isMiddle == false) {
			StringBuilder spaces = new StringBuilder();
			for (int i = 0; i < level; i++) {
				spaces.append("  ");
			}
			System.out.print(spaces.toString() + curNode.data);
		}
		else {
			System.out.print(" " + curNode.data);
		}
		
		if (curNode.middle != null) {
			curNode.middle.inOrderPrintLevel(level + 1, true);
		}
		else {
			System.out.println();
		}
		
		if (curNode.left != null) {
			curNode.left.inOrderPrintLevel(level + 1, false);
		}
	}
}