package org.log5j.ymv.model.voluntary;
//?�도 ?�시?�각
public class VoluntaryServiceApplicateVO {
	private int recruitNo;
	private int memberNo;
	public VoluntaryServiceApplicateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VoluntaryServiceApplicateVO(int recruitNo, int memberNo) {
		super();
		this.recruitNo = recruitNo;
		this.memberNo = memberNo;
	}
	public int getRecruitNo() {
		return recruitNo;
	}
	public void setRecruitNo(int recruitNo) {
		this.recruitNo = recruitNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "VoluntaryServiceApplicateVO [recruitNo=" + recruitNo
				+ ", memberNo=" + memberNo + "]";
	}

}
