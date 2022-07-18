package BinarySearchTreesDSA450plus;

import BinarySearchTreesDSA450plus.LCAInBST.Node;

public class ValidateABSTORNot {
	public static class Node{
		int data;
		Node left;
		Node right;
		Node(int data,Node left,Node right){
			this.data = data ;
			this.left = left;
			this.right = right;
		}
	}
	public static Node construct(int[] arr,int low,int high) {
		if(low>high) return null;
		
		int mid = (low+high)/2;
		int data = arr[mid];
		Node lc = construct(arr,low,mid-1);
		Node rc = construct(arr,mid+1,high);
		
		Node node = new Node(data,lc,rc);
		return node;
	}
	
	public static boolean validate(Node node,long min,long max) {
		
		if(node==null) return true;
		
		if(node.data<=min || node.data>=max) return false;
		
		if(validate(node.left,min,node.data) && validate(node.right,node.data,max)) return true;
		return false;
	}
	
	public static boolean validBST(Node node) {
		return validate(node,Long.MIN_VALUE,Long.MAX_VALUE);
	}
	
	public static void display(Node node) {
		if(node==null) return;
		
		String str = " ";
		str += node.left==null?".":node.left.data + " ";
		str += "<-" + node.data + "->";
		str += node.right==null ? "." : node.right.data + " ";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
public static void main(String[] args) {
	int[] arr = {12,25,37,50,62,75,87,99};
	Node root = construct(arr,0,arr.length-1);
	System.out.println(validBST(root));
	//display(root);
}
}
