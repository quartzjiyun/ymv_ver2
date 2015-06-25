package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantListVO;
import org.springframework.stereotype.Service;
@Service
public class RecruitBoardServiceImpl implements RecruitBoardService {
	@Resource(name="recruitBoardDAOImpl")
	private RecruitBoardDAO recruitBoardDAO;
	@Override
	public ListVO getBoardList(String pageNo){
		if(pageNo==null||pageNo=="") 
			pageNo="1";
		List<BoardVO> list=recruitBoardDAO.getBoardList(pageNo);
		System.out.println("pageNo가 1인 상태에서 보드 리스트들을 받아오는 거"+list);
		System.out.println("RecruitBoardServiceImpl getBoardList 완료");
		int total=recruitBoardDAO.totalContent();
		System.out.println("RecruitBoardServiceImpl totalContent: "+total);
		PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
		System.out.println("paging 완료 그리고 listvo넣기전"+paging);
		ListVO lvo=new ListVO(list,paging);
		System.out.println("lvo: "+lvo);
		return lvo;
	}
	@Override
	public BoardVO showContent(int no) {
		return recruitBoardDAO.showContent(no);
	}
	@Override
	public void updateBoard(BoardVO bvo) {
		recruitBoardDAO.updateBoard(bvo);
		
	}
	@Override
	public RecruitBoardVO getRecruitBoardByRecruitNo(int recruitNo){
	      return recruitBoardDAO.getRecruitBoardByRecruitNo(recruitNo);
	   }
	@Override
	public List<FieldVO> getFieldList() {
		
		return recruitBoardDAO.getFieldList();
	}
	@Override
	public List<LocationVO> getLocationList() {
		
		return recruitBoardDAO.getLocationList();
	}
	
	@Override
	public void registerVolunteer(RecruitBoardVO rbvo) {
		recruitBoardDAO.registerVolunteer(rbvo);
	}
	
	@Override
	public RecruitBoardVO findRecruitBoardByrecruitNo(int recruitNo) {
		return recruitBoardDAO.findRecruitBoardByrecruitNo(recruitNo);
	}
	@Override
	public void deleteRecruitVolunteer(int recruitNo) {
		recruitBoardDAO.deleteRecruitVolunteer(recruitNo);
	}
	@Override
	public void deleteVoluntaryServiceApplicateNo(int recruitNo) {
		recruitBoardDAO.deleteVoluntaryServiceApplicateNo(recruitNo);
	}
	@Override
	public ListVO getCompanyBoardList(CompanyVO cpvo) {
		// TODO Auto-generated method stub
		
		if(cpvo.getPageNo()==0) {
			cpvo.setPageNo(1);
		}
		List<BoardVO> list=recruitBoardDAO.getCompanyBoardList(cpvo);
		System.out.println("pageNo가 1인 상태에서 보드 리스트들을 받아오는 거"+list);
		System.out.println("RecruitBoardServiceImpl getBoardList 완료");
		int total=recruitBoardDAO.totalCompanyContent(cpvo.getMemberNo());
		System.out.println("RecruitBoardServiceImpl totalContent: "+total);
		PagingBean paging=new PagingBean(total,cpvo.getPageNo());
		System.out.println("paging 완료 그리고 listvo넣기전"+paging);
		ListVO lvo=new ListVO(list,paging);
		System.out.println("lvo: "+lvo);
		return lvo;
	}
	@Override
	public void deletePicture(int pictureNo) {
		// TODO Auto-generated method stub
		recruitBoardDAO.deletePicture(pictureNo);
	}
	@Override
	public ListVO getNormalBoardList(CompanyVO cpvo) {
		if(cpvo.getPageNo()==0) {
			cpvo.setPageNo(1);
		}
		List<BoardVO> list=recruitBoardDAO.getNormalBoardList(cpvo);
		System.out.println("pageNo가 1인 상태에서 보드 리스트들을 받아오는 거"+list);
		System.out.println("RecruitBoardServiceImpl getBoardList 완료");
		int total=recruitBoardDAO.totalNormalContent(cpvo.getMemberNo());
		System.out.println("RecruitBoardServiceImpl totalContent: "+total);
		PagingBean paging=new PagingBean(total,cpvo.getPageNo());
		System.out.println("paging 완료 그리고 listvo넣기전"+paging);
		ListVO lvo=new ListVO(list,paging);
		System.out.println("lvo: "+lvo);
		return lvo;
	}
	@Override
	public void registerApplicantOK(ApplicantListVO alvo) {
		// TODO Auto-generated method stub
		recruitBoardDAO.registerApplicantOK(alvo);
	}
	@Override
	public List<ApplicantListVO> getApplicantOkList(int recruitNo) {
		// TODO Auto-generated method stub
		return recruitBoardDAO.getApplicantOkList(recruitNo);
	}
	@Override
	public void getPostingByRecruitNoNotHit(int recruitNo) {
		recruitBoardDAO.getPostingByRecruitNoNotHit(recruitNo);
	}
	@Override
	public RecruitBoardVO getPostingByRecruitNoUpdateHit(int recruitNo) {
		// TODO Auto-generated method stub
		recruitBoardDAO.updateHit(recruitNo);
		return recruitBoardDAO.findRecruitBoardByrecruitNo(recruitNo);
	}
	@Override
	public MemberVO getMailAddressByMemberNo(int memberNo) {
		// TODO Auto-generated method stub
		return recruitBoardDAO.getMailAddressByMemberNo(memberNo);
	}
}
