package redistricting;

/**
 * District class is modified by the Districting class.
 * Districts divide regions into groups of voters
 * and there are a set number of districts per region.
 * All districts contain as close as equal as possible
 * number of voters, and the size of any one district
 * can never be greater than 1.
 * Districts are non-overlapping and contiguous.
 * @author S2GV Josh McKinstry, Matt Kline, Dong (Bob) Lee
 */
public class District {

    /** Array of the voters contained in district. */
    private Voter[] votersInDistrict;
    /** String identifier to distinguish districts. */
    private String districtID;
    /** Party with most voters in district is favored. */
    private char districtFavoredParty;
    /** For method addVoter and removeVoter. - Bob **/
    private int counterForVotersInDistrict;

    /** An empty constructor. */
    public District() {

    }

    /**
     * Constructor builds new, empty district.
     * @param districtID String to differentiate districts
     */
    public District(final String districtID) {
        this.districtID = districtID;
        this.votersInDistrict = new Voter[0];
    }

    /**
     * Constructor builds, new empty district with specific size.
     * @param districtID String to differentiate districts
     * @param numVoters Number of voters in district/district size
     */
    public District(final String districtID, final int numVoters) {
        this.districtID = districtID;
        this.votersInDistrict = new Voter[numVoters];
    }

    /**
     * Add voter to votersInDistrict.
     * @param voter Voter object to be added
     * Last modified by Bob at 12:30PM, 04/28/17
     */
    public void addVoter(final Voter voter) {
        if (counterForVotersInDistrict == 0) {
            votersInDistrict[0] = voter;
            counterForVotersInDistrict++;
            return;
        } else if (counterForVotersInDistrict == votersInDistrict.length) {
            System.out.println("Size of the region is already at capacity.");
            return;
        }
        votersInDistrict[counterForVotersInDistrict] = voter;
        counterForVotersInDistrict++;
    }

    /**
     * Remove voter from votersInDistrict.
     * @param voter Voter object to be removed
     */
    public void removeVoter(final Voter voter) {
        if (votersInDistrict.length == 0) {
            return;
        }
        --counterForVotersInDistrict;
        for (int i = 0; i > counterForVotersInDistrict; i++) {
            if (votersInDistrict[i] == voter) {
                votersInDistrict[counterForVotersInDistrict] = null;
                return;
            }
        }
    }

    /**
     * Retrieve the voters in this district.
     * @return votersInDistrict
     */
    public Voter[] getVoters() {
        return votersInDistrict;
    }

    /**
     * Reset district, size of district remains constant.
     */
    public void clearDistrict() {
        for (int i = 0; i < votersInDistrict.length; i++) {
            votersInDistrict[i] = null;
        }
    }

    /**
     * Retrieve unique district identifier.
     * @return districtID Unique String distinguishing districts
     */
    public String getDistrictID() {
        return this.districtID;
    }

    /**
     * Set String identification for district.
     * @param districtID Unique String distinguishing districts
     */
    public void setDistrictID(final String districtID) {
        this.districtID = districtID;
    }

    /**
     * Retrieve favored party for district.
     * @return districtFavoredParty
     */
    public char getFavoredParty() {
        return this.districtFavoredParty;
    }

    /**
     * Set the favored party of the district.
     * @param party Party that is favored
     */
    private void setFavoredParty(final char party) {
        this.districtFavoredParty = party;
    }
}
