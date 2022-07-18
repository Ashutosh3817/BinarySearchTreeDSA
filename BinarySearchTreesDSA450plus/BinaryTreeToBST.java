package BinarySearchTreesDSA450plus;

import java.util.ArrayList;
import java.util.Collections;

import BinarySearchTreesDSA450plus.AddNodeInABST.Node;

public class BinaryTreeToBST {
	public static class Node{
		int data;
		Node left;
		Node right;
		Node(int data,Node left,Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	public static Node construct(int[] arr,int low,int high) {
		if(low>high) {
			return null;
		}
		int mid = (low+high)/2;
		int data = arr[mid];
		
		Node lc = construct(arr,low,mid-1);
		Node rc = construct(arr,mid+1,high);
		
		Node node = new Node(data,lc,rc);
		return node;
	}
	public static void display(Node node) {
		if(node==null) return ;
		
		String str  = "";
		
		str += node.left==null?".":node.left.data;
		str += "<-" + node.data + "->";
		str += node.right==null?".":node.right.data;
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	static ArrayList<Integer> al = new ArrayList<>();
	static int i = 0 ; 
	static int binaryTreeToBST(Node root) {
		constructAl(root);
		Collections.sort(al);
		bst(root);
		return root.data;
	}
	
	static void constructAl(Node root) {
		if(root==null) return;
		constructAl(root.left);
		al.add(root.data);
		constructAl(root.right);
	}
	static void bst(Node root) {
		if(root==null) return;
		bst(root.left);
		root.data= al.get(i++);
		bst(root.right);
	}
	
	
	public static void main(String[] args) {
		int[] arr = {12,25,37,50,62,75,87};
		Node root = construct(arr,0,arr.length-1);
		
		System.out.println(binaryTreeToBST(root));
	
		display(root);}
}
