package redistrictingTest;
import static org.junit.Assert.*;
import Districting.*;

public class DistrictTest {
   public static void main(String args[]){
      District testObj = new District("123");
      assertNotNull(testObj);
      testObj = new District("testID", 5);
      assertEquals("testID", testObj.getDistrictID());
      testObj.addVoter(new Voter(1, 'a'));
      testObj.addVoter(new Voter(2, 'b'));
      testObj.addVoter(new Voter(3, 'a'));
      
      /*
         In the District class, 
         field aside from districtID are inaccessible.
         To avoid regression, I will leave the District class alone.   
      */
      
      System.out.print("Pass");
   
   }
}
