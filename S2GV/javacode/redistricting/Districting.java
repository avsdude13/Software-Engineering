package redistricting;
import java.util.ArrayList;

/**
 * Performs districting functions/operations on regions.
 * @author  S2GV Josh McKinstry, Matt Kline, Dong (Bob) Lee
 */
public class Districting {

    /** A region for this specific districting instance. */
    private Region region;

    /** A list of potential districts to separate the region.
     *  One list per region. Contains all possible districts that could
     *  be within the region.
     */
    private ArrayList<District> potentials = new ArrayList<District>();

    /**
     * New districting project on a new region.
     * @param row gets num rows for region
     * @param column gets num rows for region
     */
    public Districting(final int row, final int column) {
        this.region = new Region("R1", row, column);
    }

    /** Used to interface with the user. */
    private UserInterface user = new UserInterface();

    /**
     * Creates and stores properly sized districts for the given region.
     */
    public void numDistricts() {
        int numDist = region.getRegionSize()
            / user.userNumDistricts(region.getRegionSize());
    }

    /**
     * Adds the desired number of districts to regionDistricts.
     * @param numDist Number of districts to add
     */
    public void addDistricts(final int numDist) {
    	int[] distSizes = sizeDistricts(numDist, region.getRegionSize());
    	for (int i = 0; i < numDist; i++) {
    		region.getRegionDistricts().add(new District("00" + 
    	                 i, distSizes[i]));
    	}
    }

    /**
     * Properly sizes each district with a set limit of voters.
     * @param numDist Number of districts being added
     * @param rSize Number of voters in the region
     * @return districtSizes an array of the sizes for each district
     */
    public int[] sizeDistricts(final int numDist, final int rSize) {
    	int[] districtSizes = new int[numDist];
    	int rem = rSize % numDist;
    	for (int i = 0; i < numDist; i++) {
    		districtSizes[i] = rSize / numDist;
    	}
    	if (rem != 0) {
    		for (int i = 0; i < rem; i++) {
    			++districtSizes[i];
    		}
    	}
    	return districtSizes;
    }

    /**
     * Sets parties randomly or asks user for manual party input.
     */
    public void partySet() {
   	    String regionParties = "";
        if (user.userAssign()) {
            for (int i = 0; i < region.getRegionSize(); i++) {
                regionParties = regionParties + user.askParty();
            }
        region.setPartyManual(regionParties);
        } else {
            region.setPartyAuto();
        }
    }

    /**
     * Runs a new districting project. Sizes a new region,
     * populates that region with voters,
     * @param args takes any input in class calls
     */
    public static void main(final String[] args) {

    	UserInterface user = new UserInterface();
    	int[] dimensions = user.welcome();
        Districting newDis1 = new Districting(dimensions[0], dimensions[1]);
        newDis1.numDistricts();
        newDis1.region.populateRegion();
        newDis1.partySet();
        newDis1.region.drawRegionGrid();
    }

}
