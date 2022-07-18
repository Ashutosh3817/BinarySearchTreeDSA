package BinarySearchTreesDSA450plus;

public class MergeTwoBST {
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
		if(low>high) return null;
		int mid = (low+high)/2;
		int data = arr[mid];
		Node lc = construct(arr,low,mid-1);
		Node rc = construct(arr,mid+1,high);
		Node node = new Node(data,lc,rc);
		return node;		
	}
	
	static void inorderUtil(Node node) {
		if(node==null) return;
		inorderUtil(node.left);
		System.out.print(node.data + " ");
		inorderUtil(node.right);
	}
	
	public static void display(Node node) {
		if(node==null) return ;
		
		String str = " ";
		str += node.left==null ? ".": node.left.data + " ";
		str += "<-" + node.data + "->";
		str += node.right==null ? ".":node.right.data + " ";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	public static void main(String[] args) {
		int[] arr1 = {12,25,37,50,62,75,87};
		Node root1 = construct(arr1,0,arr1.length-1);
		System.out.println("First Tree");
		display(root1);
		inorderUtil(root1);
		int[] arr2 = {1,2,3,4,5,6,7};
		Node root2 = construct(arr2,0,arr2.length-1);
		System.out.println();
		System.out.println("Second tree");

		display(root2);
		inorderUtil(root2);

	}
}
