package org.log5j.ymv.model.board;

import java.sql.Date;

public class AuctionBoardVO implements BoardVO{
	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private int memberNo;
	private Date timePosted;
	private int hit;
	public AuctionBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuctionBoardVO(int boardNo, String title, String writer,
			String content, int memberNo, Date timePosted, int hit) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.memberNo = memberNo;
		this.timePosted = timePosted;
		this.hit = hit;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public Date getTimePosted() {
		return timePosted;
	}
	public void setTimePosted(Date timePosted) {
		this.timePosted = timePosted;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "AuctionBoardVO [boardNo=" + boardNo + ", title=" + title
				+ ", writer=" + writer + ", content=" + content + ", memberNo="
				+ memberNo + ", timePosted=" + timePosted + ", hit=" + hit
				+ "]";
	}
	
}
