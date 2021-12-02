package modal;

public class CurrentActiveModal {
	
	int EID = 0;
	String ETITLE = "Exam Set";
	String DESCRIPTION = "";
	int TID = 0;
	int DURATION = 0;
	int TOTLEQ = 0;
	int TOTLEMARKS = 0;
	String SDET = "(select to_date(sysdate) from Dual)";
	String STATUS = "A";
	String ISALLOWSTUD="Y";
	String Subname;
	int SUBID;
	
	
	public int getSUBID() {
		return SUBID;
	}
	public void setSUBID(int sUBID) {
		SUBID = sUBID;
	}
	public String getSubname() {
		return Subname;
	}
	public void setSubname(String subname) {
		Subname = subname;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	String Subject;
	
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
