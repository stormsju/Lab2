package Lab2;

class Node{
	int value;
	Node left, right;
	public Node(int value){
		this.value = value;
		left = null;
		right = null;
	}
}

class BinarySearchTree{
	Node root;
	/*
	recursive insert method
	*/
	public void insert(int value){
		//if tree is empty
		if(root == null){
			root = new Node(value);
			return;
		} else {
			Node current = root;
			Node parent = null;
			
			//loop until finished
			//compare to left path (value < current.value), then right (value > current.value)
			while(true) {
				parent = current;
				if(value < current.value) {
					//traverse left
					current = current.left;
					if(current == null) {
						parent.left = new Node(value);
						return;
					}
				} else {
					//traverse right
					current = current.right;
					if(current == null) {
						parent.right = new Node(value);
						return;
					}
				}
			}
		}
	}
	
	/**
	 * Method which performs preOrder node traversal. 
	 * @param root Takes in a Node.
	 */
	public void preOrderTraversal(Node root){
		//base case
	    if(root == null){
	    	return;
	    }
	    
	    //recursively traverse nodes: node > left > right
	    System.out.print(root.value+" ");
	    //traverse to the left
	    preOrderTraversal(root.left);
	    //traverse to the right
	    preOrderTraversal(root.right);
	}
	/**
	 * Method which performs inOrder node traversal. 
	 * @param root Takes in a Node.
	 */
	public void inOrderTraversal(Node root){
		//base case
	    if(root == null){
	    	return;
	    }
	    
	    //recursively traverse nodes: left > node > right
	    //traverse to the left
	    preOrderTraversal(root.left);
	    System.out.print(root.value+" ");
	    //traverse to the right
	    preOrderTraversal(root.right);
	}
	
	/**
	 * Method which performs postOrder node traversal. 
	 * @param root Takes in a Node.
	 */
	public void postOrderTraversal(Node root){
		//base case
	    if(root == null){
	    	return;
	    }
	    
	    //recursively traverse nodes: left > right > node
	    //traverse to the left
	    preOrderTraversal(root.left);
	    //traverse to the right
	    preOrderTraversal(root.right);
	    System.out.print(root.value+" ");
	}
	
	/**
	 * Method which finds a node in the tree given the passed key value.
	 * @param root Takes in a node.
	 * @param key Value to be found in tree.
	 * @return True if node with key is found, otherwise returns false.
	 */
	public boolean find(Node root, int key){
		//base case 1: key not found
		if (root == null) {
			return false;
		}
		
		//base case 2: key found
		if(root.value == key) {
			return true;
		} else if (root.value < key) { //traverse left if key smaller than value
			return find(root.left, key);
		} else { //traverse right if key larger than value
			return find(root.right, key);
		}
	}
	
	/**
	 * Method which finds the minimum node in the tree.
	 * @param root Takes in a Node.
	 * @return The key from the smallest Node in tree.
	 */
	public int getMin(Node root){
		//base case: left-most node found
		if (root.left == null) {
			return root.value;
		}
		
		//continue traversal until found
		return getMin(root.left);
	}
	/*
	a method to find the node in the tree
	with a largest key
	*/
	public int getMax(Node root){
		//implement me
	}
	/*
	this method will not compile until getMax
	is implemented
	*/
	public Node delete(Node root, int key){
		if(root == null){
			return root;
		}else if(key < root.value){
			root.left = delete(root.left, key);
		}else if(key > root.value){
			root.right = delete(root.right, key);
		}else{
			//node has been found
			if(root.left==null && root.right==null){
				//case #1: leaf node
				root = null;
			}else if(root.right == null){
				//case #2 : only left child
				root = root.left;
			}else if(root.left == null){
				//case #2 : only right child
				root = root.right;
			}else{
				//case #3 : 2 children
				root.value = getMax(root.left);
				root.left = delete(root.left, root.value);
			}
		}
		return root;
	}
}

public class TreeDemo{
	public static void main(String[] args){
		BinarySearchTree t1 = new BinarySearchTree();
		t1.insert(24);
		t1.insert(80);
		t1.insert(18);
		t1.insert(9);
		t1.insert(90);
		t1.insert(22);
		System.out.print("in-order : ");
		t1.inOrderTraversal(t1.root);
		System.out.println();
	}
}
