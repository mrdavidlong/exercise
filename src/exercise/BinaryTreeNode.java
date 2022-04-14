package exercise;

public class BinaryTreeNode<T>{
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;
	public T data;
	
	public BinaryTreeNode(T data) {
		this.data = data;
	}
	
	public int numNodes(BinaryTreeNode<T> t){
		if (t == null)
			return 0;
		return (1 + numNodes(t.left) + numNodes(t.right));

	}

	public int height(BinaryTreeNode<T> t){
		if (t == null)
			return 0;
		
		int heightLeft = height(t.left);
		int heightRight = height(t.right);

		if( heightLeft > heightRight )
			return heightLeft +1;
		else
			return heightRight +1;
	}
}
