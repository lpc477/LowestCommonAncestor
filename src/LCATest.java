import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*
 * Unit Tests for LCA Algorithim 
 */
class LCATest {

	//Test the creation of the LCA Datatype
	@Test
	public void testCreation() {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		assertEquals("","","lca Not Created");
	}

	//Test the creation of a head node on the LCA Datatype
	@Test
	public void testHead() {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.createHead('a', 0);
		assertEquals('a',lca.returnKey(lca.head),"Head not Created");
	}
	//Test the LCA AddNode Function
	@Test
	public void testAddNode() {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.createHead('c', 0);
		assertEquals('c',lca.returnKey(lca.head),"Head not Created");
		lca.addNode('a', 1);
		assertEquals('a',lca.returnKey(lca.head.left),"a not Created");
		lca.addNode('d', 2);
		assertEquals('d',lca.returnKey(lca.head.right),"d not Created");
		lca.addNode('b', 3);
		assertEquals('b',lca.returnKey(lca.head.left.right),"b not Created");
		lca.addNode('e', 4);
		assertEquals('e',lca.returnKey(lca.head.right.right),"e not Created");
		
	}
}
