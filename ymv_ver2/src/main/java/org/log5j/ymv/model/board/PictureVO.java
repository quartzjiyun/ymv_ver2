package org.log5j.ymv.model.board;

public class PictureVO {
	private int pictureNo;
	private String pictureName;
	private int boardNo;
	public PictureVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PictureVO(int pictureNo, String pictureName, int boardNo) {
		super();
		this.pictureNo = pictureNo;
		this.pictureName = pictureName;
		this.boardNo = boardNo;
	}
	public int getPictureNo() {
		return pictureNo;
	}
	public void setPictureNo(int pictureNo) {
		this.pictureNo = pictureNo;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	@Override
	public String toString() {
		return "PictureVO [pictureNo=" + pictureNo + ", pictureName="
				+ pictureName + ", boardNo=" + boardNo + "]";
	}

}
