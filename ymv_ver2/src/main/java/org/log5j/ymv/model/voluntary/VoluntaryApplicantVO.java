package org.log5j.ymv.model.voluntary;

public class VoluntaryApplicantVO {
	/**
	 * 봉사신청게시판과 봉사활동 신청인원 게시판이 같은거 같아서
	 * 봉사활동신청인원 게시판을 사용하지 않기로함
	 */
	private int recruitNo;
	private int memberNo;
	private String motivate;
	public VoluntaryApplicantVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VoluntaryApplicantVO(int recruitNo, int memberNo, String motivate) {
		super();
		this.recruitNo = recruitNo;
		this.memberNo = memberNo;
		this.motivate = motivate;
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
	public String getMotivate() {
		return motivate;
	}
	public void setMotivate(String motivate) {
		this.motivate = motivate;
	}
	@Override
	public String toString() {
		return "VoluntaryApplicantVO [recruitNo=" + recruitNo + ", memberNo="
				+ memberNo + ", motivate=" + motivate + "]";
	}
	
}
