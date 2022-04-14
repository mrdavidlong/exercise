package exercise;

public class BinaryTree<T> {
	public BinaryTreeNode<T> rootNode = null;

//	public void printBreadthFrist() {
//		LinkedList<BinaryTreeNode<T>> ll = new LinkedList<BinaryTreeNode<T>>();
//		ll.addLast(rootNode);
//		while (!ll.isEmpty()) {
//			BinaryTreeNode<T> currentNode = ll.removeFirst();
//			System.out.println(currentNode.data);
//			ll.addLast(currentNode.left);
//			ll.addLast(currentNode.right);
//		}
//	}
//
//	void printSnake() {
//		LinkedList<BinaryTreeNode<T>> currentList = new LinkedList<BinaryTreeNode<T>>();
//		LinkedList<BinaryTreeNode<T>> nextList = new LinkedList<BinaryTreeNode<T>>();
//		boolean leftToRight = true;
//		currentList.push(rootNode);
//
//		while (!currentList.isEmpty()) {
//			BinaryTreeNode currentNode = currentList.pop();
//			System.out.print(currentNode.data);
//			if (leftToRight) {
//				if (currentNode.left != null) {
//					nextList.push(currentNode.left);
//				}
//				if (currentNode.right != null) {
//					nextList.push(currentNode.right);
//				}
//			}
//			else {
//				if (currentNode.right != null) {
//					nextList.push(currentNode.right);
//				}
//				if (currentNode.left != null) {
//					nextList.push(currentNode.left);
//				}
//			}
//
//			if (currentList.isEmpty()) {
//				leftToRight = !leftToRight;
//				currentList = nextList;
//				nextList = new LinkedList<BinaryTreeNode<T>>();
//			}
//		}
//	}
//	
//	public void printSnake2() {
//		LinkedList<BinaryTreeNode<T>> ll = new LinkedList<BinaryTreeNode<T>>();
//		ll.addLast(rootNode);
//		int i = 0;
//		BinaryTreeNode<T> currentNode;
//		
//		while (i < ll.size()) {
//			currentNode = ll.get(i);
//			if (currentNode.left != null) {
//				ll.addLast(currentNode.left);
//			}
//			if (currentNode.right != null) {
//				ll.addLast(currentNode.right);
//			}
//			i++;
//		}
//		
//		i = 0;
//		int level = 0;
//		while (i < ll.size()) {
//			if (level % 2 != 0) { // even: right to left
//				boolean isEnd = false;
//				int endIndex = (int)Math.pow(2, level+1) - 2;
//				if (endIndex >= ll.size() - 1) {
//					endIndex = ll.size() - 1;
//					isEnd = true;
//				}
//				int currentIndex = endIndex;
//				int startIndex = i;
//				while (currentIndex >= startIndex) {
//					currentNode = ll.get(currentIndex);
//					System.out.println(currentNode.data);
//					currentIndex--;
//				}
//				i = endIndex;
//				if (isEnd) {
//					return;
//				}
//			}
//			else {
//				currentNode = ll.get(i);
//				System.out.println(currentNode.data);
//			}
//			
//			// bump up the level
//			if (i == Math.pow(2, level + 1) - 2) {
//				level++;
//			}
//			i++;
//			
//		}
//		
//		ll.clear();
//		
//	}
//	
//	public void printSnake3() {
//		LinkedList<BinaryTreeNode<T>> ll = new LinkedList<BinaryTreeNode<T>>();
//		ll.addLast(rootNode);
//		int i = 0;
//		int level = 0;
//		BinaryTreeNode<T> startNode;
//		BinaryTreeNode<T> endNode;
//		while (!ll.isEmpty()) {
//			BinaryTreeNode<T> currentNode;
//			if (level % 2 == 0) { // even: right to left
//				currentNode = ll.removeLast();
//				System.out.println(currentNode.data);
//				ll.addLast(currentNode.right);
//				ll.addLast(currentNode.left);
//			}
//			else {
//				// odd: left to right
//				currentNode = ll.removeFirst();
//				System.out.println(currentNode.data);
//				ll.addLast(currentNode.left);
//				ll.addLast(currentNode.right);
//			}
//			
//			// bump up the level
//			if (i == Math.pow(2, level) - 1) {
//				level++;
//			}
//			i++;
//		}
		
//		
//		
//		boolean leftToRight = true;
//		int i = 0;
//		while (!ll.isEmpty()) {
//			BinaryTreeNode<T> currentNode = ll.removeLast();
//			System.out.println(currentNode.data);
//			i++;
//			if (i > Math.pow(2, ) && i > Math.pow(2, ))
//			if (leftToRight) {
//				leftToRight = false;
//				ll.addLast(currentNode.right);
//				ll.addLast(currentNode.left);
//			}
//			else {
//				leftToRight = true;
//				ll.addLast(currentNode.left);
//				ll.addLast(currentNode.right);
//			}
//		
//			LinkedList<BinaryTreeNode<T>> ll = new LinkedList<BinaryTreeNode<T>>();
//			ll.addLast(rootNode);
//			boolean leftToRight = true;
//			while (!ll.isEmpty()) {
//				BinaryTreeNode<T> currentNode = ll.removeLast();
//				System.out.println(currentNode.data);
//				if (leftToRight) {
//					leftToRight = false;
//					ll.addLast(currentNode.right);
//					ll.addLast(currentNode.left);
//				}
//				else {
//					leftToRight = true;
//					ll.addLast(currentNode.left);
//					ll.addLast(currentNode.right);
//				}
			
//		}
//	}
}
