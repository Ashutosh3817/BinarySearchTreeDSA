package BinarySearchTreesDSA450plus;

public class sizesummax {
	
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
	
	public static void display(Node node) {
		if(node == null ) return;
		
		String str = " ";
		
		str += node.left==null?".":node.left.data + " ";
		str += "<-" + node.data + "->";
		str += node.right==null?".":node.right.data + " ";
		System.out.println(str);
		
		display(node.left);
		display(node.right);
		}
	
	public static int sum(Node node) {
		if(node==null) return 0;
		
		int ls = sum(node.left);
		int rs = sum(node.right);
		int ts = ls + rs + node.data;
		
		return ts;
	}
	
	public static int size(Node node) {
		if(node == null) return 0 ;
		
		int ls = size(node.left);
		int rs = size(node.right);
		int ts = ls+rs+1;
		return ts;
	}
	
	public static int max(Node node) {
		if(node.right!=null) return max(node.right);
		else return node.data;
	}
	
	public static int min(Node node) {
		if(node.left!=null) return min(node.left);
		else return node.left.data;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {12,25,37,50,75,87};
		Node root = construct(arr,0,arr.length-1);
		display(root);
		System.out.println(sum(root));
		System.out.println(size(root));

	}
}
