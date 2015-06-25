package org.log5j.ymv.model.board;

import java.util.List;

import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantListVO;

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
	
	public ListVO getNormalBoardList(CompanyVO cpvo);

	public void registerApplicantOK(ApplicantListVO alvo);

	public List<ApplicantListVO> getApplicantOkList(int recruitNo);
	
	public void getPostingByRecruitNoNotHit(int recruitNo);

	public RecruitBoardVO getPostingByRecruitNoUpdateHit(int recruitNo);
	
	public MemberVO getMailAddressByMemberNo(int memberNo);
}
