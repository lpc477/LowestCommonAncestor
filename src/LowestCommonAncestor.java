
public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Sourced LCA Algorithim and Binary Tree code from @awarde96
	 */
	
	public Node head;
	
	//Node class to represent Nodes of the binary tree with left, right and parent nodes as well as a key represented by a character
	public class Node{  
		private char key;
		public Node left, right, parent;
		private int value;
	}
	
	//Creates a new binary tree with a head
	public void createHead(char key,int value){
		Node head = new Node();
		head.key = key;
		head.left = null;
		head.right = null;
		head.value = value;
		this.head = head;
	}
	
	public char returnKey(Node node){
		return node.key;
	}
	
	public int returnValue(Node node){
		return node.value;
	}
	
	/*An add node function thats adds a node to the tree based on its 
	key by recursively calling a private function */
	public void addNode(char key, int value){
		Node newNode = new Node();
		newNode.key = key;
		newNode.left = null;
		newNode.right = null;	
		newNode.value = value;
		addNode(newNode, head);
	}
	
	private void addNode(Node newNode, Node head){
		if(newNode.key < head.key){
			if(head.left == null){
				head.left = newNode;
				newNode.parent = head;
			}
			else{
				addNode(newNode, head.left);
			}
		}
		else{
			if(head.right == null){
				head.right = newNode;
				newNode.parent = head;
			}
			else{
				addNode(newNode, head.right);
			}
		}
	}
	
	//A function to return a node given a key
	public Node findNode(char key){
		if(key == head.key){
			return head;
		}
		else {
			return findNode(key, head);
		}
	}
	
	private Node findNode(char key, Node head){
		Node ret = null;
		if(head.left != null){
			if (head.left.key == key){
				return head.left;
			}
			else{
				ret = findNode(key, head.left);
				if(ret != null){
					return ret;
				}
			}
		}
		if(head.right != null){
			if(head.right.key == key){
				return head.right;
			}
			else{
				ret = findNode(key, head.right);
				if(ret != null){
					return ret;
				}
			}
		}
		return null;
	}
	
	public int depth(char key){
		int depth = 0;
		Node node = findNode(key);
		while(node.parent != null){
			depth++;
			node = node.parent;
		}
		return depth;
	}
	
	
	//Implementation of the LCA Algorithim 
	public Node lowestCommonAncestor(Node root, Node p, Node q) {
	    if(root==null)
	        return null;
	 
	    if(root==p || root==q)
	        return root;
	 
	    Node l = lowestCommonAncestor(root.left, p, q);
	    Node r = lowestCommonAncestor(root.right, p, q);
	 
	    if(l!=null&&r!=null){
	        return root;
	    }else if(l==null&&r==null){
	        return null;
	    }else{
	        return l==null?r:l;
	    }
	}

}
