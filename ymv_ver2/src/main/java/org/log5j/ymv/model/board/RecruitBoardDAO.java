package org.log5j.ymv.model.board;

import java.util.List;

public interface RecruitBoardDAO {
	public  List<BoardVO> getBoardList(String pageNo);
	public  int totalContent();
	public BoardVO showContent(int recruitNo);
	public RecruitBoardVO getRecruitBoardByRecruitNo(int recruitNo);
	public List<FieldVO> getFieldList();
	public List<LocationVO> getLocationList();
	public void registerVolunteer(RecruitBoardVO rbvo);
	public RecruitBoardVO findRecruitBoardByrecruitNo(int recruitNo);
	public void updateBoard(BoardVO bvo);
	public void deleteRecruitVolunteer(int recruitNo);
	public void deleteVoluntaryServiceApplicateNo(int recruitNo);
	public List<BoardVO> getCompanyBoardList(CompanyVO cpvo);
	public int totalCompanyContent(int memberNo);
}
