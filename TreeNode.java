package trees;

import java.util.*;

class TreeNode {
	private String name;
	private TreeNode parent;
	private ArrayList<TreeNode> children;

	TreeNode(String name) {
		this.name = name;
		children = new ArrayList<>();
	}

	String getName() {
		return name;
	}

	void addChild(TreeNode childNode) {
		// Add childNode to this node's children list. Also
		// set childNode's parent to this node.

		this.children.add(childNode);
		childNode.parent = this;

	}

	// Searches subtree at this node for a node
	// with the given name. Returns the node, or null if not found.
	TreeNode getNodeWithName(String targetName) {

		// Does this node have the target name?
		if (this.getName().equals(targetName))
			return this;

		// No, recurse. Check all children of this node.
		for (TreeNode child : children) {
			// If child.getNodeWithName(targetName) returns a non-null node,
			// then that's the node we're looking for. Return it.

			if (child.getName() != null)
				return child;
		}

		// Not found anywhere.
		return null;
	}

	// Returns a list of ancestors of this TreeNode, starting with this node's
	// parent and ending with the root. Order is from recent to ancient.
	ArrayList<TreeNode> collectAncestorsToList() {

		ArrayList<TreeNode> ancestors = new ArrayList<>();

		// ????? Collect ancestors of this TreeNode into the array list. HINT:
		// going up the nodes of a tree is like traversing a linked list. If
		// that isn't clear, draw a tree, mark any leaf node, and then mark its
		// ancestors in order from recent to ancient. Expect a question about
		// this on the final exam.
		
		TreeNode pop = this.parent; //assign this variable to the parent
		
		while (pop != null){ //while there exists a parent
			ancestors.add(pop); //Add it to the arraylist of ancestors
			pop = pop.parent;
			
		}
		
		return ancestors;
	}

	public String toString() {
		return toStringWithIndent("");
	}

	private String toStringWithIndent(String indent) {
		String s = indent + name + "\n";
		indent += "  ";
		for (TreeNode childNode : children)
			s += childNode.toStringWithIndent(indent);
		return s;
	}
}
