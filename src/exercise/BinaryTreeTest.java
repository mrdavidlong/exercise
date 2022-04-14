package exercise;

public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree<Character> bt = new BinaryTree<Character>();
		BinaryTreeNode<Character> root = new BinaryTreeNode<Character>('s');
		bt.rootNode = root;
		BinaryTreeNode<Character> sm = new BinaryTreeNode<Character>('m');
		BinaryTreeNode<Character> sma = new BinaryTreeNode<Character>('a');
		root.right = sm;
		root.left = sma;
		BinaryTreeNode<Character> smar = new BinaryTreeNode<Character>('r');
		BinaryTreeNode<Character> smart = new BinaryTreeNode<Character>('t');
		sma.left = smar;
		sma.right = smart;
		BinaryTreeNode<Character> smarts = new BinaryTreeNode<Character>('s');
		BinaryTreeNode<Character> smartsh = new BinaryTreeNode<Character>('h');
		sm.left = smarts;
		sm.right = smartsh;
		BinaryTreeNode<Character> smartshe = new BinaryTreeNode<Character>('e');
		BinaryTreeNode<Character> smartshee = new BinaryTreeNode<Character>('e');
		smartsh.right = smartshe;
		smartsh.left = smartshee;
		BinaryTreeNode<Character> smartsheet = new BinaryTreeNode<Character>('t');
		smarts.right = smartsheet;
		//bt.printSnake();
		//bt.printSnake();
		
	}
}
