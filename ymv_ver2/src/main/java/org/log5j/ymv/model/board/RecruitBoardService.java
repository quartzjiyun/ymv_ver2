package org.log5j.ymv.model.board;

import java.util.List;

public interface RecruitBoardService {
	public  ListVO getBoardList(String pageNo);

	public BoardVO showContent(int no);

	public void updateBoard(BoardVO bvo);

	 public RecruitBoardVO getRecruitBoardByRecruitNo(int recruitNo);

	public List<FieldVO> getFieldList();

	public List<LocationVO> getLocationList();
	
	public void registerVolunteer(RecruitBoardVO rbvo);
	
	public RecruitBoardVO findRecruitBoardByrecruitNo(int recruitNo);

	public void deleteRecruitVolunteer(int recruitNo);

	public void deleteVoluntaryServiceApplicateNo(int recruitNo);

	public ListVO getCompanyBoardList(CompanyVO cpvo);

	public void deletePicture(int pictureNo);
}
