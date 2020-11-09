package test;

import main.Tree;
import org.junit.Test;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void createTree() {
        Tree tree = new Tree(100);
        assertEquals(tree.getHealth(), 100);
    }
}
