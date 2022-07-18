package BinarySearchTreesDSA450plus;

import BinarySearchTreesDSA450plus.ConstructorOfBST.Node;

public class ConstructABSTFromPreOrderTraversal {
	public static class Node{
		Node left;
		Node right;
		int data =0;
		Node(int data){
			this.data= data;
			
		}
	}

	/*public static Node construct(int[] arr,int low,int high) {
		if(low>high) return null;
		int mid = (low+high)/2;
		
		int data =arr[mid];
		Node lc = construct(arr,low,mid-1);
		Node rc = construct(arr,mid+1,high);
		
		Node node = new Node(data,lc,rc);
		return node;
	}*/
	public static Node bstPre(int[] A) {
		return bstFromPreOrder(A,Integer.MAX_VALUE,new int[] {0});
	}
	
	public static Node bstFromPreOrder(int[]A,int bound,int[] i ) {
		if(i[0]==A.length || A[i[0]]>bound) return null;
		Node root = new Node(A[i[0]++]);
		root.left = bstFromPreOrder(A,root.data,i);
		root.right = bstFromPreOrder(A,bound,i);
		return root;
	}
	
	public static void display(Node root) {
		if(root==null) return;
		
		String str = "";
		
		str += root.left==null?".":root.left.data;
		str += "<-" + root.data + "->";
		str += root.right==null? ".":root.right.data;
		System.out.println(str);
		display(root.left);
		display(root.right);
	}
	public static void main(String[] args) {
		int[] arr = {10, 5, 1, 7, 40, 50};
		Node root = bstPre(arr);
		display(root);
	}
}

