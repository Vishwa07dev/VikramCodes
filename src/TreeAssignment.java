import java.util.*;

public class TreeAssignment {

  public static Tree copy(Tree root){

    // Make the copy of each root
    Map<Tree, Tree> map = new HashMap<>();
    addCloneOfEachNodeInMap(map, root);

    // Clone the relationships between the nodes
    cloneTheRelationships(root, map);

    return map.get(root) ;
  }

  private static void cloneTheRelationships(Tree root, Map<Tree,Tree> map) {
    if(root == null){
      return ;
    }

    Tree rootClone = map.get(root);

    for(Tree node  : root.getChildren()){
      rootClone.getChildren().add(map.get(node));
    }

    for(Tree node : root.getChildren()){
      cloneTheRelationships(node, map);
    }

  }

  /**
   * 1 --> 1
   * 2--> 2
   *
   * 3--> 3
   * ...
   * ...
   *
   *
   * @param map
   * @param root
   */
  private static void addCloneOfEachNodeInMap(Map<Tree,Tree> map, Tree root) {
    if(root==null){
      return ;
    }

    Tree newNode = new Tree(root.getValue());

    map.put(root, newNode);

    for(Tree node : root.getChildren()){
      addCloneOfEachNodeInMap(map, node);
    }
  }
}




class Tree {

  private int value;

  private List<Tree> children;

  /**
   * Creates a tree with the given value, and no children.
   * @param value The value for this tree.
   */
  public Tree(int value) {
    this.children = new LinkedList<>();
    this.value = value;
  }

  /**
   * Creates a tree with the given value and list of children.
   * @param value The value for this tree.
   * @param children The subtrees for this tree.
   */
  public Tree(int value, List<Tree> children) {
    this.children = new LinkedList<>(children);
    this.value = value;
  }

  /**
   * Returns the value of this tree.
   * @return The value of this tree.
   */
  public int getValue() {
    return value;
  }


  /**
   * Sets the value of this tree.
   * @param The new value of this tree.
   */
  public int setValue(int value) {
    return this.value = value;
  }

  /**
   * Returns the subtrees of this tree.
   * @return The subtrees of this tree.
   */
  public List<Tree> getChildren() {
    return this.children;
  }

  /**
   * Checks equality of two trees.
   * @param other The object to compare with.
   * @return True if the trees are equal, false otherwise.
   */
  public boolean equals(Object other) {
    if (other instanceof Tree) {
      Tree that = (Tree) other;
      return that.getValue() == this.getValue() && this.getChildren().equals(that.getChildren());
    }
    return false;
  }

  /**
   * Returns a human readable format of this tree.
   * @return A string representation of this tree.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    this.toString(sb, 0);
    return sb.toString();
  }

  /**
   * Returns a human readable format of this tree.
   * @param sb StringBuilder to append to.
   * @param depth Identation depth of this part.
   */
  private void toString(StringBuilder sb, int depth) {
    for (int i = 0; i < depth; i++) sb.append("  ");
    sb.append("<Tree ").append(this.value).append(" [");

    if (this.children.isEmpty()) {
      sb.append("]>");
      return;
    }
    // Recursively add children
    for (Tree t : this.children) {
      sb.append("\n");
      for (int i = 0; i < depth; i++) sb.append("  ");
      t.toString(sb, depth + 1);
    }
    sb.append("\n");
    for (int i = 0; i < depth; i++) sb.append("  ");
    sb.append("]>");
  }
}
