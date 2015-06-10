package org.log5j.ymv.model.member;

public class MemberVO {
	private int memberNo;
	private String id;
	private String password;
	private String name;
	private String address;
	private String identityNo;
	private String mailAddress;
	private String memberType;
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public MemberVO(int memberNo, String id, String password, String name,
			String address, String identityNo, String mailAddress,
			String memberType) {
		super();
		this.memberNo = memberNo;
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.identityNo = identityNo;
		this.mailAddress = mailAddress;
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return "MemberVO [memberNo=" + memberNo + ", id=" + id + ", password="
				+ password + ", name=" + name + ", address=" + address
				+ ", identityNo=" + identityNo + ", mailAddress=" + mailAddress
				+ ", memberType=" + memberType + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}