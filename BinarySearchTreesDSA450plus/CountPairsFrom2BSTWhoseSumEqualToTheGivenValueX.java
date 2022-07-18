package BinarySearchTreesDSA450plus;

import java.util.Stack;

import BinarySearchTreesDSA450plus.MergeTwoBST.Node;

public class CountPairsFrom2BSTWhoseSumEqualToTheGivenValueX {
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
		str += "<-" + node.data + "->" ; 
		str += node.right==null?".":node.right.data + " ";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	static int countPairs(Node root1,Node root2,int x) {
		if(root1==null || root2==null) return 0 ; 
		
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		Node top1 , top2;
		int count =1;
		while(true) {
			while(root1!=null) {
				st1.push(root1);
				root1 = root1.left;
			}
			while(root2!=null) {
				st2.push(root2);
				root2 = root2.right;
			}
			if(st1.isEmpty() || st2.isEmpty()) break;
			
			top1 = st1.peek();
			top2 = st2.peek();
			if((top1.data+top2.data)==x) {
				count++;
				st1.pop();
				st2.pop();
				root1 = top1.right;
				root2 = top2.left;
			}
			else if((top1.data + top2.data)<x) {
				st1.pop();
				root1 = top1.right;
			}
			else {
				st2.pop();
				root2 = top2.left;
			}
		}
		return count/2;
		
	}
	public static void main(String[] args) {
		int[] arr1 = {12,25,37,50,62,75,87};
		int x = 27;
		Node root1 = construct(arr1,0,arr1.length-1);
		//System.out.println("First Tree");
		//display(root1);
		int[] arr2 = {1,2,3,4,5,6,7};
		Node root2 = construct(arr2,0,arr2.length-1);
		//System.out.println();
		//System.out.println("Second tree");

		//display(root2);
		System.out.println(countPairs(root1,root2, x));
	}
}
