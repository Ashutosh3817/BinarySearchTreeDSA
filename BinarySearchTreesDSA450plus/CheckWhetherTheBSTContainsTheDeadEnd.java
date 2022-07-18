
package BinarySearchTreesDSA450plus;


public class CheckWhetherTheBSTContainsTheDeadEnd {
	public static class Node{
		Node left;
		Node right;
		int data;
		Node(int data,Node left,Node right){
			this.data= data;
			this.left = left;
			this.right = right;
		}
	}

	public static Node construct(int[] arr,int low,int high) {
		if(low>high) return null;
		int mid = (low+high)/2;
		
		int data =arr[mid];
		Node lc = construct(arr,low,mid-1);
		Node rc = construct(arr,mid+1,high);
		
		Node node = new Node(data,lc,rc);
		return node;
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
	public static boolean solve(Node root,int min,int max) {
		if(root==null) return false;
		if(min==max) return true;
		return (solve(root.left,min,root.data-1) || solve(root.right,root.data+1,max));
	}
	public static boolean containsDeadEnd(Node root) {
		return solve(root,1,Integer.MAX_VALUE);
	}
	public static void main(String[] args) {
		int[] arr = {8 ,7 ,10 ,9 ,13 ,2};
		Node root = construct(arr,0,arr.length-1);
	//	display(root);
		System.out.println(containsDeadEnd(root));
	}
}
