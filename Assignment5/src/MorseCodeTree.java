
import java.util.ArrayList;

/**
 * This is a MorseCodeTree which is specifically used for the conversion of
 * morse code to english
 * It relies on a root (reference to root of the tree)
 * 
 * The root is set to null when the tree is empty.
 * 
 * The class uses an external generic TreeNode class which consists of a
 * reference to the data and a reference to the left and right child. The
 * TreeNode is parameterized as a String, TreeNode This class uses a private
 * member root (reference to a TreeNode)
 * 
 * The constructor will call the buildTree
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

    private TreeNode<String> root;

    /**
     * This constructor will call the buildTree method
     */
    MorseCodeTree() {
        buildTree();
    }

    /**
     * This is a recursive method that adds element to the correct position in the
     * tree based on the code.
     * 
     * @param root   The root of the tree for this particular recursive instance of
     *               addNode
     * @param code   The code for this particular recursive instance of addNode
     * @param letter The data of the new TreeNode to be added
     */
    @Override
    public void addNode(TreeNode<java.lang.String> root, java.lang.String code, java.lang.String letter) {

        if (code.length() == 1) {
            if (code.equals(".")) {
                root.leftChild = new TreeNode<String>(letter);
            } else {
                root.rightChild = new TreeNode<String>(letter);
            }
        } else {
            if (code.charAt(0) == '.') {
                addNode(root.leftChild, code.substring(1), letter);
            } else {
                addNode(root.rightChild, code.substring(1), letter);
            }
        }

    }

    /**
     * This method builds the MorseCodeTree by inserting the nodes of the tree level
     * by level based on the code.
     */
    @Override
    public void buildTree() {
        root = new TreeNode<String>("");

        // Level 1
        insert(".", "e");
        insert("-", "t");

        // Level 2
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");

        // Level 3
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");

        // Level 4
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    /**
     * This operation is not supported in the MorseCodeTree
     */
    @Override
    public MorseCodeTree delete(java.lang.String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch the data in the tree based on the code This method will call the
     * recursive method fetchNode
     */
    @Override
    public String fetch(java.lang.String code) {
        return fetchNode(root, code);
    }

    /**
     * This is the recursive method that fetches the data of the TreeNode that
     * corresponds with the code A '.' (dot) means traverse to the left.
     */
    @Override
    public String fetchNode(TreeNode<java.lang.String> root, java.lang.String code) {
        if (code.length() == 1) {
            if (code.equals(".")) {
                return root.leftChild.getData();
            } else {
                return root.rightChild.getData();
            }
        } else {
            if (code.charAt(0) == '.') {
                return fetchNode(root.leftChild, code.substring(1));
            } else {
                return fetchNode(root.rightChild, code.substring(1));
            }
        }
    }

    /**
     * Returns a reference to the root
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * Adds element to the correct position in the tree based on the code This
     * method will call the recursive method addNode
     */
    @Override
    public void insert(java.lang.String code, java.lang.String letter) {
        addNode(root, code, letter);
    }

    /**
     * The recursive method to put the contents of the tree in an ArrayList in LNR
     * (Inorder)
     */
    @Override
    public void LNRoutputTraversal(TreeNode<java.lang.String> root, java.util.ArrayList<java.lang.String> list) {
        if (root != null) {
            LNRoutputTraversal(root.leftChild, list);
            list.add(root.getData());
            LNRoutputTraversal(root.rightChild, list);
        }
    }

    /**
     * sets the root of the MorseCodeTree
     */
    @Override
    public void setRoot(TreeNode<java.lang.String> newNode) {
        root = new TreeNode<String>(newNode);
    }

    /**
     * Returns an ArrayList of the items in the linked Tree in LNR (Inorder)
     * Traversal order Used for testing to make sure tree is built correctly
     */
    @Override
    public java.util.ArrayList<java.lang.String> toArrayList() {
        ArrayList list = new ArrayList<String>();
        LNRoutputTraversal(root, list);
        return list;
    }

    /**
     * This operation is not supported in the MorseCodeTree
     */
    @Override
    public MorseCodeTree update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

}
