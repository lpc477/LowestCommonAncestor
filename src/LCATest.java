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
}
