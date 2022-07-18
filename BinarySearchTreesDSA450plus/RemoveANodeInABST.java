package BinarySearchTreesDSA450plus;


public class RemoveANodeInABST {
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
	public static int max(Node node) {
		if(node.right!=null) return max(node.right);
		else return node.data;
		
	}
	
	public static Node remove(Node node,int data) {
		if(node==null) return null;
		if(data>node.data) remove(node.right,data);
		if(data<node.data) remove(node.left,data);
		else {
			if(node.left!=null && node.right!=null) {
				int lmax=max(node.left);
				node.data = lmax;
				node.left = remove(node.left,lmax);
			}
			else if(node.left!=null) {
				return node.left;
			}
			else if(node.right!=null) return node.right;
			else return null;
		}
		return node;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {12,25,37,50,62,75,87};
		Node root = construct(arr,0,arr.length-1);
		remove(root,50);
		display(root);
	}
}
