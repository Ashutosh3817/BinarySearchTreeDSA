package BinarySearchTreesDSA450plus;

import BinarySearchTreesDSA450plus.PrintInRangeInBST.Node;

public class PopulateInOrderSuccessorOfABST {
	public static class Node{
		int data;
		Node left;
		Node right;
		Node next;
		Node(int data,Node left,Node right,Node next){
			this.data = data;
			this.left = left;
			this.right = right;
			this.next = next;
		}
	}
	static Node construct(int arr[],int low,int high) {
		if(low>high) return null;
		
		int mid = (low+high)/2;
		int data = arr[mid];
		Node lc = construct(arr,low,mid-1);
		Node rc = construct(arr,mid+1,high);
		Node node = new Node(data,lc,rc,null);
		return node;
	}
	static void display(Node node) {
		if(node==null) return ; 
		
        String str = " ";
        str += node.left==null?".":node.left.data + " ";
        str += "<-" + node.data + "->";
        str += node.right==null?".":node.right.data + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);
	}
	
	static Node prev = null;
    public static void populateNext(Node root){
        if(root==null)
            return;
            
        populateNext(root.left);
        if(prev!=null)
            prev.next = root;
        prev = root;
        populateNext(root.right);
        
    }

	
	public static void main(String[] args) {
		int[] arr = {12,25,37,50,62,75,87};
		Node root = construct(arr,0,arr.length-1);
		populateNext(root);	

		display(root);	
	}
}
