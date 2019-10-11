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
	
	//Test the find node method
	@Test
	public void testFindNode() {
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
		assertEquals('e',lca.returnKey(lca.findNode('e')),"e not found");
		assertEquals('d',lca.returnKey(lca.findNode('d')),"d not found");
		assertEquals('b',lca.returnKey(lca.findNode('b')),"b not found");
		assertNull(lca.findNode('z'),"z found, but not in tree");
	}
	
	//Test the depth finding method
	//Potential issue in finding and depth-ing repeated elements
	@Test
	public void testDepth() {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.createHead('c', 0);
		assertEquals(0,lca.depth('c'),"Wrong Depth for c");
		lca.addNode('a', 1);
		assertEquals(1,lca.depth('a'),"Wrong Depth for a");
		lca.addNode('b', 2);
		assertEquals(2,lca.depth('b'),"Wrong Depth for b");
		lca.addNode('d', 3);
		assertEquals(1,lca.depth('d'),"Wrong Depth for d");
		lca.addNode('e', 4);
		assertEquals(2,lca.depth('e'),"Wrong Depth for e");
		lca.addNode('f', 5);
		assertEquals(3,lca.depth('f'),"Wrong Depth for f");
	}
	
	//Test the LCA Algorithim
	@Test
	public void testLCA() {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.createHead('c', 0);
		assertEquals(lca.findNode('c'),lca.lowestCommonAncestor(lca.findNode('c'), 
				lca.findNode('c'), null),"Root Failure");
		lca.addNode('b', 1);
		lca.addNode('f', 2);
		assertEquals(lca.findNode('c'),lca.lowestCommonAncestor(lca.findNode('c'),
				lca.findNode('b'), lca.findNode('f')),"Depth 1 failure");
		lca.addNode('a', 3);
		assertEquals(lca.findNode('c'),lca.lowestCommonAncestor(lca.findNode('c'), 
				lca.findNode('a'), lca.findNode('f')),"Failure at a and f");
		lca.addNode('d', 4);
		lca.addNode('h', 5);
		assertEquals(lca.findNode('f'),lca.lowestCommonAncestor(lca.findNode('c'), 
				lca.findNode('d'), lca.findNode('h')),"Failure at d and h");
	}
	
	//Test the DAG structure constructor and Vertices finder
	@Test
	public void testDAGVertices() {
		DAG dag = new DAG(5);
		assertEquals(' ',' ',"DAG not created");
		int vertices = dag.V();
		assertEquals(5,vertices,"Did not count the correct vertices");
	}
	
	//Testing adding edges
	@Test
	public void testAddEdges() {
		DAG dag = new DAG(10);
		assertEquals(dag.addEdge(0, 0),false,"Loop created 0-0");
		assertEquals(dag.addEdge(0, 1),true,"Failed at adding valid edge(0,1)");
		assertEquals(dag.addEdge(1, 0),false,"Loop created 1-0-1");
		assertEquals(dag.addEdge(0, 2),true,"Failed at adding valid edge(0,2)");
		assertEquals(dag.addEdge(0, 11),false,"Added to a non-existent node 0-11");
		assertEquals(dag.addEdge(11, 12),false,"Added 2 non-existent nodes 11-12");
		assertEquals(dag.addEdge(1, 3),true,"Failed at adding valid edge(1,3)");
		assertEquals(dag.addEdge(2, 4),true,"Failed at adding valid edge(2,3)"); //NOTE: not a loop, directed
		assertEquals(dag.addEdge(4, 0),false,"Created loop 0-2-4-0");

	}
	
	//
	@Test
	public void test3() {
		
	}
	
	//
	@Test
	public void test4() {
		
	}
	
	
	
	
	
}
