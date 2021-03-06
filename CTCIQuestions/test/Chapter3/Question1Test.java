package Chapter3;

import org.junit.*;
import static org.junit.Assert.*;

public class Question1Test{
	Question1<Integer> q1;
	int n;

	@Before
	public void setUp(){
		n = 20;
		q1 = new Question1<Integer>(Integer.class, n);
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testInitialize(){
		assertNotNull(q1);
		
		assertTrue(q1.empty(1));
		assertTrue(q1.empty(2));
		assertTrue(q1.empty(3));
		
		assertNull(q1.peek(1));
		assertNull(q1.peek(2));
		assertNull(q1.peek(3));
		
		assertNull(q1.pop(1));
		assertNull(q1.pop(2));
		assertNull(q1.pop(3));
	}

	@Test
	public void testPushAndPopFromNull(){
		
		for(int i=1; i <= 3; i++){
			assertTrue(q1.empty(i));
			Integer expected = new Integer(5);
			q1.push(expected, i);
			
			assertFalse(q1.empty(i));
			assertEquals(1, q1.size(i));
			assertEquals(expected,q1.peek(i));
			assertEquals(expected,q1.pop(i));
			
			assertTrue(q1.empty(i));
		}
	}
	

	@Test
	public void testPushAndPopAfterOneElement(){
		for(int i=1; i <= 3; i++){
			Integer five = new Integer(5);
			Integer eight = new Integer(8);
			
			q1.push(five, i);
			q1.push(eight, i);
			
			assertFalse(q1.empty(i));
			assertEquals(2, q1.size(i));
			assertEquals(eight,q1.peek(i));
			assertEquals(eight,q1.pop(i));
			
			assertEquals(1, q1.size(i));
			assertEquals(five,q1.peek(i));
			assertEquals(five,q1.pop(i));
	
			assertEquals(0, q1.size(i));
			assertTrue(q1.empty(i));
		}
	}
	
	@Test
	public void testPushNElements(){
		for(int i=0; i < this.n ; i++){
			Integer number = new Integer(i);
			int stackId = (i % 3) + 1;
			q1.push(number, stackId);
			
			assertEquals(i + 1, q1.size());
			assertEquals(number,q1.peek(stackId));

		}
		
		for(int i=this.n; i <= 0; i++){
			Integer number = new Integer(i);
			int stackId = (i % 3) + 1;
			assertEquals(number,q1.peek(stackId));
			assertEquals(number,q1.pop(stackId));
			assertEquals(i + 1, q1.size());
			

		}
	}
	
	@Test
	public void testPushStack3OverTheEdge(){
		for(int i=0; i < this.n ; i++){
			Integer number = new Integer(i);
			q1.push(number, 3);
			
			assertEquals(i + 1, q1.size());
			assertEquals(number,q1.peek(3));
		}
		
		for(int i=this.n; i <= 0; i++){
			Integer number = new Integer(i);
			assertEquals(number,q1.peek(3));
			assertEquals(number,q1.pop(3));
			assertEquals(i + 1, q1.size());
		}
	}

}
