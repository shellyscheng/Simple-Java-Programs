public class BinarySearchTree
{
	private Node root;

	//Construct an empty tree

	public BinarySearchTree()
	{
		root = null;
	}

	/**
	 * Insert a new node into the tree
	 * @param obj the object to insert
	 */

	public void add(Comparable obj)
	{
		Node newNode = new Node();
		newNode.data = obj;
		newNode.left = null;
		newNode.right = null;

		if (root == null) { root = newNode; }
		else { root.addNode(newNode); }
	}

	/**
	 * find an object in the tree
	 * @param obj the object to find
	 * @return true if the object is found
	 */

	public boolean find (Comparable obj)
	{
		Node current = root;

		while (current != null)
		{
			int d = current.data.compareTo(obj); // Compare the value of obj with the current node

			if (d == 0) { return true; } //when the current node equals the obj

			else if (d > 0) { current = current.left; } //when the current node is larger than obj, search left

			else { current = current.right; } // when the current node is smaller than the obj, search right
		}

		return false; //if obj is not found in the tree
	}

	/**
	 * remove an obj from the tree
	 * nothing happens if the obj was not found in the tree
	 */

	public void remove(Comparable obj)
	{
		//find the node to be removed

		Node toBeRemoved = root;
		Node parent = null;
		boolean found = false;

		while (!found && toBeRemoved != null)
		{
			int d = toBeRemoved.data.compareTo(obj);

			if (d == 0) { found = true; }
			else
			{
				parent = toBeRemoved;

				if (d > 0) { toBeRemoved = toBeRemoved.left; }
				else { toBeRemoved = toBeRemoved.right; }
			}
		}

		if (!found) { return; }

		/**
		 * if toBeRemoved contains obj
		 */

		// if one of the children is emtpy, use the other

		if (toBeRemoved.left == null || toBeRemoved.right == null)
		{
			Node newChild;

			if (toBeRemoved.left == null)
			{
				newChild = toBeRemoved.right;
			}
			else
			{
				newChild = toBeRemoved.left;
			}

			if (parent == null) //found in root
			{
				root = newChild;
			}
			else if (parent.left == toBeRemoved)
			{
				parent.left = newChild;
			}
			else
			{
				parent.right = newChild;
			}
			return;
		}

		// Neither subtree is empty

		// Find the smallest element of the right subtree

		Node smallestParent = toBeRemoved;
		Node smallest = smallest.left;

		while (smallest.left != null)
		{
			smallestParent = smallest;
			smallest = smallest.left;
		}

		// Smallest contains the smallest child in the right subtree

		// Move contents, unlink child;

		toBeRemoved.data = smallest.data;

		if (smallestParent == toBeRemoved)
		{
			smallestParent.right = smallest.right;
		}
		else
		{
			smallestParent.left = smallest.right;
		}
	}


	//print the contents of the tree in sorted order

	public void print()
	{
		print(root);
		System.out.println();
	}

	/**
	 * prints a node and all of its descendants in sorted order
	 * @param parent the root of the subtree to print
	 */

	private static void print(Node parent)
	{
		if (parent == null) { return; }

		print(parent.left);
		System.out.print(parent.data + " ");
		print(parent.right);
	}

	// a node of a tree stores a data item and references to the left and right childe nodes

	class Node
	{
		public Comparable data;
		public Node left;
		public Node right;


		/** Insert a new node as descendant of this node
		 *  @param newNode  the node to insert
		 */

		public void addNode(Node newNode)
		{
			//compare the value of data and comp
			int comp = newNode.data.compareTo(data); 

			if(comp < 0)
			{
				if (left == null) { left = newNode; }
				else {left.addNode(newNode); }
			}

			else if (comp > 0)
			{
				if (right -- null) { right = newNode; }
				else { right.addNode(newNode); }
			}
		}
	}
}