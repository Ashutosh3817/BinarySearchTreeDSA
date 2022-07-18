package BinarySearchTreesDSA450plus;

public class LargestBSTInABinaryTree {
	public static class Node{
		Node left;
		Node right;
		int data;
		Node(int data,Node left,Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public static class NodeValue{
		int maxNode;
		int minNode;
		int maxSize;
		NodeValue(int maxNode,int minNode,int maxSize){
			this.maxNode=maxNode;
			this.minNode=minNode;
			this.maxSize = maxSize;
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
		if(node==null) return;
		String str = " ";
		str += node.left==null?".":node.left.data + " ";
		str += "<-" + node.data + "->";
		str += node.right==null?".":node.right.data + " ";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	public static NodeValue largrestBSTSubtreeHelper(Node root) {
		if(root==null)
			return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
		
		NodeValue left = largrestBSTSubtreeHelper(root.left);
		NodeValue right = largrestBSTSubtreeHelper(root.right);
		if(left.maxNode<root.data && root.data<right.minNode) {
			return new NodeValue(Math.min(root.data,left.minNode),Math.max(root.data,right.maxNode)
					,left.maxSize+right.maxSize+1);
		}
		else
		return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize, right.maxSize));
		
	}
	
	public static int largestBSTSubtree(Node root) {
		return largrestBSTSubtreeHelper(root).maxSize;
	}
	
	public static void main(String[] args) {
		int[] arr = {12,25,37,50,62,75,87};
		Node root = construct(arr,0,arr.length-1);
		//display(root);
		System.out.println(largestBSTSubtree(root));
	}
}
