package org.log5j.ymv.model.board;
//area => location
// timeHr,date ??�� ?�시 ?�각
public class RecruitBoardVO implements BoardVO{
	private int recruitNo;
	private String title;
	private String field;
	private String location;
	private int age;
	private String startDate;
	private String endDate;
	private String content;
	public RecruitBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RecruitBoardVO(int recruitNo, String title, String field,
			String location, int age, String startDate, String endDate,
			String content) {
		super();
		this.recruitNo = recruitNo;
		this.title = title;
		this.field = field;
		this.location = location;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRecruitNo() {
		return recruitNo;
	}
	public void setRecruitNo(int recruitNo) {
		this.recruitNo = recruitNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "RecruitBoardVO [recruitNo=" + recruitNo + ", title=" + title
				+ ", field=" + field + ", location=" + location + ", age="
				+ age + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", content=" + content + "]";
	}
	
}
