package modal;

public class SubjectModal {
	
	private int SUBID;
	public int getSUBID() {
		return SUBID;
	}
	public void setSUBID(int sUBID) {
		SUBID = sUBID;
	}
	public String getSUBNAME() {
		return SUBNAME;
	}
	public void setSUBNAME(String sUBNAME) {
		SUBNAME = sUBNAME;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public int getCLASSID() {
		return CLASSID;
	}
	public void setCLASSID(int cLASSID) {
		CLASSID = cLASSID;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	private String SUBNAME;
	private String STATUS;
	private int CLASSID;
	private String DESCRIPTION;
	
}

