package redistrictingTest;
import static org.junit.Assert.*;
import Districting.*;

public class VoterTest {

   public static void main(String args[]){
      
      Voter testObj = new Voter(123);
      //assertEquals('a', testObj.getParty()); Should fail.
      testObj.setParty('a');
      assertEquals('a', testObj.getParty()); //Should pass.
      //testObj.setParty('b');
      testObj.setParty('b');
      assertEquals('b', testObj.getParty());
      //assertEquals(1, testObj.getID()); Should fail.
      testObj = new Voter(5, 'b');
      assertEquals(5, testObj.getID());
      assertEquals(false, testObj.getIsInDistrict());
      testObj.setIsInDistrict(true);
      assertEquals(true, testObj.getIsInDistrict());
      System.out.println("Pass");
   }
}
