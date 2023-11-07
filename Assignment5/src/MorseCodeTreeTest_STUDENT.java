import static org.junit.Assert.*;

import org.junit.Test;

public class MorseCodeTreeTest_STUDENT {

    MorseCodeTree tree = new MorseCodeTree();

    @Test
    public void testAddNode() {
        tree.addNode(tree.getRoot(), "..", "i");
        assertEquals("i", tree.fetch(".."));
    }

    @Test
    public void testFetchNode() {
        assertEquals("a", tree.fetchNode(tree.getRoot(), ".-"));
    }

    @Test
    public void testGetRoot() {
        assertEquals("", tree.getRoot().getData());
    }

    @Test
    public void testInsert() {
        tree.insert("--..", "z");
        assertEquals("z", tree.fetch("--.."));
    }

}
