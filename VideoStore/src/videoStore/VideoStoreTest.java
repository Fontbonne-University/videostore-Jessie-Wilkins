package videoStore;
import junit.framework.*;

import org.junit.*;
import org.junit.Assert;
import org.junit.Test;
public class VideoStoreTest 
{
	private static final Movie regular3 = new RegularMovie ("Regular 3");
	private static final Movie regular2 = new RegularMovie ("Regular 2");
	private static final Movie regular1 = new RegularMovie ("Regular 1");
	private static final Movie childrenMovie = new ChildrensMovie ("Childrens");
	private static final Movie newReleaseMovie2 = new NewReleaseMovie ("New Release 2");
	private static final Movie newReleaseMovie1 = new NewReleaseMovie ("New Release 1");
	private static final double DELTA = .001;
	private Statement statement;
	
	@Before
	public void setUp ()  {
		statement = new Statement ("Customer");
	}
	
	@Test
	public void testSingleNewReleaseStatementTotals () {
		statement.addRental (new Rental (newReleaseMovie1, 3));		
		statement.generate();
		Assert.assertEquals(9.0, statement.getTotal(), DELTA);
		Assert.assertEquals(2, statement.getFrequentRenterPoints());
	}
	@Test
	public void testDualNewReleaseStatementTotals () {
		statement.addRental (new Rental (newReleaseMovie1, 3));
		statement.addRental (new Rental (newReleaseMovie2, 3));
		statement.generate ();
		Assert.assertEquals(18.0, statement.getTotal(), .001);
		Assert.assertEquals(4, statement.getFrequentRenterPoints());
	}
	@Test
	public void testSingleChildrensStatementTotals () {
		statement.addRental (new Rental (childrenMovie, 3));
		statement.generate ();
		Assert.assertEquals(1.5, statement.getTotal(), .001);
		Assert.assertEquals(1, statement.getFrequentRenterPoints());
	}
	@Test
	public void testMultipleRegularStatementTotals () {
		statement.addRental (new Rental (regular1, 1));
		statement.addRental (new Rental (regular2, 2));
		statement.addRental (new Rental (regular3, 3));
		
		statement.generate ();
		Assert.assertEquals(7.5, statement.getTotal(), .001);
		Assert.assertEquals(3, statement.getFrequentRenterPoints());
	}
	@Test
	public void testMultipleRegularStatementFormat () {
		statement.addRental (new Rental (regular1, 1));
		statement.addRental (new Rental (regular2, 2));
		statement.addRental (new Rental (regular3, 3));
		
		Assert.assertEquals ("Rental Record for Customer\n"
				+ "\tRegular 1\t2.0\n"
				+ "\tRegular 2\t2.0\n"
				+ "\tRegular 3\t3.5\n"
				+ "You owed 7.5\n"
				+ "You earned 3 frequent renter points\n", statement.generate ());
	}


	
}