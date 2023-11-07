
/**
 * The external Tree Node for Linked Trees
 */
public class TreeNode<T> {

    protected T data;
    protected TreeNode<T> leftChild;
    protected TreeNode<T> rightChild;

    /**
     * Create a new TreeNode with left and right child set to null and data set to
     * the dataNode
     * 
     * @param dataNode the data to be stored in the TreeNode
     */
    public TreeNode(T dataNode) {
        data = dataNode;
        leftChild = null;
        rightChild = null;
    }

    /**
     * used for making deep copies
     * 
     * @param node the TreeNode to be copied
     */
    public TreeNode(TreeNode<T> node) {
        data = node.data;
        leftChild = node.leftChild;
        rightChild = node.rightChild;
    }

    /**
     * Return the data within this TreeNode
     * 
     * @return the data within the TreeNode
     */
    public T getData() {
        return data;
    }

}
