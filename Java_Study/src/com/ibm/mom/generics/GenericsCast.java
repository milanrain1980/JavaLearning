package com.ibm.mom.generics;

class Node<L, R> {
	private L leftNode;
	private R rightNode;

	public Node(L left, R right) {
		this.leftNode = left;
		this.rightNode = right;
	}

	public L getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(L leftNode) {
		this.leftNode = leftNode;
	}

	public R getRightNode() {
		return rightNode;
	}

	public void setRightNode(R rightNode) {
		this.rightNode = rightNode;
	}

}

public class GenericsCast {
	public static void main(String[] args) {
		Node<String, Integer> node = new Node<String, Integer>("Russel", new Integer(10));
		String name = node.getLeftNode();
		Integer rank = node.getRightNode();

		Object nameAsObj = node.getLeftNode();

		System.out.println(name + " " + rank + " " + nameAsObj);
	}
}
