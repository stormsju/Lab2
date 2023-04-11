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

/**
 * @author jstor and CS380 book materials
 * Class which constructs a Binary Search Tree data structure which stores int key values.
 */
class BinarySearchTree{
	Node root;
	
	/**
	 * Method which inserts a given key as a Node into the BST.
	 * @param value Key which is to be inserted.
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
	 * Method which finds the minimum key in the tree.
	 * @param root Takes in a Node.
	 * @return The key from the smallest key in tree.
	 */
	public int getMin(Node root){
		//base case: left-most node found
		if (root.left == null) {
			return root.value;
		}
		
		//continue traversal until found
		return getMin(root.left);
	}
	/**
	 * Method which finds the maximum key in the tree.
	 * @param root Takes in a Node.
	 * @return The key from the largest key in tree.
	 */
	public int getMax(Node root){
		//base case: right-most node found
		if (root.right == null) {
			return root.value;
		}
		
		//continue traversal until found
		return getMin(root.right);
	}
	
	/**
	 * Method which deletes a key from the BST by removing the Node it is stored in.
	 * @param root Node to begin search.
	 * @param key Key to be removed.
	 * @return the node which was deleted.
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

/**
 * @author jstor and CS380 book materials
 * Class Which runs a demonstration of the BST class.
 */
public class TreeDemo{
	/**
	 * Test/Driver code for the class. Builds a BST and inserts Nodes into it, then performs in-order traversal.
	 * @param args Test demonstrations of this BST class.
	 */
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
