package org.log5j.ymv.model.voluntary;

public class VoluntaryApplicantVO {

	private int recruitNo;
	private int memberNo;
	public VoluntaryApplicantVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VoluntaryApplicantVO(int recruitNo, int memberNo) {
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
		return "VoluntaryApplicantVO [recruitNo=" + recruitNo + ", memberNo="
				+ memberNo + "]";
	}
	
}
