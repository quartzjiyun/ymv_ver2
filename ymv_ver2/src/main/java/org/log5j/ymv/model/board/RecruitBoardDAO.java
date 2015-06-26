package org.log5j.ymv.model.board;

import java.util.List;

import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantListVO;
import org.log5j.ymv.model.voluntary.ConfirmBoardVO;
import org.log5j.ymv.model.voluntary.ConfirmPageVO;
import org.log5j.ymv.model.voluntary.ConfirmVO;

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
	public void deletePicture(int pictureNo);
	public List<BoardVO> getNormalBoardList(CompanyVO cpvo);
	public int totalNormalContent(int memberNo);
	public void registerApplicantOK(ApplicantListVO alvo);
	public List<ApplicantListVO> getApplicantOkList(int recruitNo);
	public void getPostingByRecruitNoNotHit(int recruitNo);
	public void updateHit(int recruitNo);
	public MemberVO getMailAddressByMemberNo(int memberNo);
	public void registerConfirm(ConfirmVO confirmvo);
	public void registerConfirmBoard(ConfirmBoardVO confirmbvo);
	public void deleteVoluntaryApplicantOK(int recruitNo);
	public void deleteVoluntaryServiceApplicateByRecruitNo(int recruitNo);
	public List<ConfirmVO> getConfirmByMemberNo(int memberNo);
	public List<BoardVO> getConfirmBoardListByMemberNo(ConfirmPageVO confirmPageVO);
	public int totalContentConfirm(int memberNo);
}
