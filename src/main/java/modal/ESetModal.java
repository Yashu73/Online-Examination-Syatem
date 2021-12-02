package modal;

public class ESetModal {

	int EID = 0;
	String ETITLE = "Exam Set";
	String DESCRIPTION = "";
	int TID = 0;
	int ClassID = 0;
	

	int DURATION = 0;
	public String getSUBNAME() {
		return SUBNAME;
	}

	public void setSUBNAME(String sUBNAME) {
		SUBNAME = sUBNAME;
	}

	int TOTLEQ = 0;
	int TOTLEMARKS = 0;
	String SDET = "(select to_date(sysdate) from Dual)";
	String STATUS = "A";
	String ISALLOWSTUD="Y";
    int SUBID;
    String SUBNAME="";
	public int getSubid() {
		return SUBID;
	}

	public void setSubid(int subid) {
		this.SUBID = subid;
	}

	public int getEID() {
		return EID;
	}

	public void setEID(int eID) {
		EID = eID;
	}

	public String getETITLE() {
		return ETITLE;
	}

	public void setETITLE(String eTITLE) {
		ETITLE = eTITLE;
	}

	public int getClassID() {
		return ClassID;
	}

	public void setClassID(int classID) {
		ClassID = classID;
	}
	
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public int getTID() {
		return TID;
	}

	public void setTID(int tID) {
		TID = tID;
	}

	public int getDURATION() {
		return DURATION;
	}

	public void setDURATION(int dURATION) {
		DURATION = dURATION;
	}

	public int getTOTLEQ() {
		return TOTLEQ;
	}

	public void setTOTLEQ(int tOTLEQ) {
		TOTLEQ = tOTLEQ;
	}

	public int getTOTLEMARKS() {
		return TOTLEMARKS;
	}

	public void setTOTLEMARKS(int tOTLEMARKS) {
		TOTLEMARKS = tOTLEMARKS;
	}

	public String getSDET() {
		return SDET;
	}

	public void setSDET(String sDET) {
		SDET = sDET;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getISALLOWSTUD() {
		return ISALLOWSTUD;
	}

	public void setISALLOWSTUD(String iSALLOWSTUD) {
		ISALLOWSTUD = iSALLOWSTUD;
	}

}
