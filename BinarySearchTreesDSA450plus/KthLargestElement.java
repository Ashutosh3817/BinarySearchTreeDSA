package BinarySearchTreesDSA450plus;

import java.util.Stack;

import BinarySearchTreesDSA450plus.KthSmallestElement.Node;

public class KthLargestElement {
	public static class Node {
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
		if(node==null) return;
		
		String str = " ";
		str += node.left==null?".":node.left.data + " ";
		str += "<-" + node.data + "->";
		str += node.right==null?".":node.right.data + " ";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	public static int kthLargest(Node root,int k) {
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		int cnt = 0 ;
		
		while(true) {
			if(node!=null) {
				stack.push(node);
				node =  node.right;
			}
			else {
				if(stack.isEmpty()) {
					break;
				}
				node = stack.pop();
				cnt++;
				if(cnt==k) return node.data;
				node = node.left;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {12,25,37,50,62,75,87};
		Node root = construct(arr1,0,arr1.length-1);	
		kthLargest(root,3);
		display(root);
	}
}
