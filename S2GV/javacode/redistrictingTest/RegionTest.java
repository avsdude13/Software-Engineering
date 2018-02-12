package redistrictingTest;
import static org.junit.Assert.*;
import Districting.*;

public class RegionTest {
	public static void main(String args[]){
	Region testObj = new Region("123");
    assertNotNull(testObj);
    testObj = new Region("testID", 5, 5);
    assertEquals("testID", testObj.getID());
    assertNull(testObj.getRegionDistricts());
    Voter testVoter = new Voter(123);
    testObj.addVoter(testVoter);
    assertNotNull(testObj);
    assertEquals("123", testObj.getID());
    testObj.setID("newID");
    assertEquals("newID", testObj.getID());
    testObj.populateRegion(5,5);
    assertNotNull(testObj);
    testObj.populateRegion();
    assertNotNull(testObj);
    testObj.setPartyManual('a');
    testObj.setPartyAuto();
    Voter newVoter = new Voter (123, 'b');
    testObj.addVoter(newVoter);
    testObj.changePartyByID(123);
    assertEquals('a', newVoter.getParty());
    Region testObject = new Region("123");
    Voter testVoterNew = new Voter (456, 'a');
    testObject.changePartyByCell(0, 0);
    assertEquals('b', testVoterNew.getParty());
	testObject.clearRegion();
	assertNull(testObject);
	testObject.resetSize(5, 5);
	assertEquals(25, testObject.getRegionSize());
	testObject.setFavoredParty('a');
	assertEquals('a',testObject.getFavoredParty());
	System.out.print("Pass");
	}
}
