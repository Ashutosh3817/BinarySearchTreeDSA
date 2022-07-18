package BinarySearchTreesDSA450plus;

public class LCAInBST {
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
	
	public static int lca(Node node,int d1,int d2) {
		if(d1<node.data && d2<node.data) {
			return lca(node.left ,d1,d2);
		}
		else if(d1>node.data && d2>node.data) {
			return lca(node.right,d1,d2);
		}
		else {
			return node.data;
		}
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
	int[] arr = {12,25,37,50,62,75,87};
	Node root = construct(arr,0,arr.length-1);
	System.out.println(lca(root,12,62));
	display(root);
}
}
