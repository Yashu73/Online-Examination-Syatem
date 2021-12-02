package modal;

public class ExamModal {

	int SID;
	int SUBID;
	int QID;
	String QTYPE = "";
	String ANS = "";
	int EID;
	int ANSID;
	int TID;
	int CLASSID;
	int SN;
	String CURANS;
	int EAID;
		
	String QUESTION;
	String A;
	String B;
	String C;
	String D;

	String examDate;
	String StartTime;
	String EndTime;
	String SubName;
	String SubjectName;
	
	
	public String getSub_Name() {
		return SubjectName;
	}
	public void setSub_Name(String sub_Name) {
		this.SubjectName = sub_Name;
	}
	public String getSubName() {
		return SubjectName;
	}
	public void setSubName(String subName) {
		SubName = subName;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}	/**
	 * @return the sID
	 */
	public int getSID() {
		return SID;
	}
	/**
	 * @param sID the sID to set
	 */
	public void setSID(int sID) {
		SID = sID;
	}
	  
	public int getSUBID() {
		return SUBID;
	}
	 
	public void setSUBID(int sUBID) {
		SUBID = sUBID;
	} 
	public int getQID() {
		return QID;
	} 
	public void setQID(int qID) {
		QID = qID;
	} 
	public String getQTYPE() {
		return QTYPE;
	} 
	public void setQTYPE(String qTYPE) {
		QTYPE = qTYPE;
	}
	/**
	 * @return the aNS
	 */
	public String getANS() {
		return ANS;
	}
	/**
	 * @param aNS the aNS to set
	 */
	public void setANS(String aNS) {
		ANS = aNS;
	}
	/**
	 * @return the eID
	 */
	public int getEID() {
		return EID;
	}
	/**
	 * @param eID the eID to set
	 */
	public void setEID(int eID) {
		EID = eID;
	}
	/**
	 * @return the aNSID
	 */
	public int getANSID() {
		return ANSID;
	}
	/**
	 * @param aNSID the aNSID to set
	 */
	public void setANSID(int aNSID) {
		ANSID = aNSID;
	}
	/**
	 * @return the tID
	 */
	public int getTID() {
		return TID;
	}
	/**
	 * @param tID the tID to set
	 */
	public void setTID(int tID) {
		TID = tID;
	}
	/**
	 * @return the cLASSID
	 */
	public int getCLASSID() {
		return CLASSID;
	}
	/**
	 * @param cLASSID the cLASSID to set
	 */
	public void setCLASSID(int cLASSID) {
		CLASSID = cLASSID;
	}
	/**
	 * @return the sN
	 */
	public int getSN() {
		return SN;
	}
	/**
	 * @param sN the sN to set
	 */
	public void setSN(int sN) {
		SN = sN;
	}
	/**
	 * @return the cURANS
	 */
	public String getCURANS() {
		return CURANS;
	}
	/**
	 * @param cURANS the cURANS to set
	 */
	public void setCURANS(String cURANS) {
		CURANS = cURANS;
	}
	/**
	 * @return the eAID
	 */
	public int getEAID() {
		return EAID;
	}
	/**
	 * @param eAID the eAID to set
	 */
	public void setEAID(int eAID) {
		EAID = eAID;
	}
	/**
	 * @return the qUESTION
	 */
	public String getQUESTION() {
		return QUESTION;
	}
	/**
	 * @param qUESTION the qUESTION to set
	 */
	public void setQUESTION(String qUESTION) {
		QUESTION = qUESTION;
	}
	/**
	 * @return the a
	 */
	public String getA() {
		return A;
	}
	/**
	 * @param a the a to set
	 */
	public void setA(String a) {
		A = a;
	}
	/**
	 * @return the b
	 */
	public String getB() {
		return B;
	}
	/**
	 * @param b the b to set
	 */
	public void setB(String b) {
		B = b;
	}
	/**
	 * @return the c
	 */
	public String getC() {
		return C;
	}
	/**
	 * @param c the c to set
	 */
	public void setC(String c) {
		C = c;
	}
	/**
	 * @return the d
	 */
	public String getD() {
		return D;
	}
	/**
	 * @param d the d to set
	 */
	public void setD(String d) {
		D = d;
	}
		
}
