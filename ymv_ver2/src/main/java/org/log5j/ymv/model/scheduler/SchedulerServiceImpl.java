package org.log5j.ymv.model.scheduler;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.PagingBean;
import org.springframework.stereotype.Service;
@Service
public class SchedulerServiceImpl implements SchedulerService {
	@Resource
	private SchedulerDAO schedulerDAO;
	@Override
	public List<BoardVO> getSchedulerList(SchedulerVO sdvo){
		List<BoardVO> list=schedulerDAO.getSchedulerList(sdvo);
		return list;
	}
	@Override
	public ListVO getSearchList(SearchVO scvo){
		if(scvo.getPageNo()==null||scvo.getPageNo()=="") 
			scvo.setPageNo("1");
		List<BoardVO> list=schedulerDAO.getSearchList(scvo);
		int total=schedulerDAO.totalContent(scvo);
		System.out.println("RecruitBoardServiceImpl totalContent: "+total);
		PagingBean paging=new PagingBean(total,Integer.parseInt(scvo.getPageNo()));
		System.out.println("paging 완료 그리고 listvo넣기전"+paging);
		ListVO lvo=new ListVO(list,paging);
		System.out.println("lvo: "+lvo);
		return lvo;
	}
	@Override
	public List<HashMap> getDateList(SchedulerVO sdvo) {
		return schedulerDAO.getDateList(sdvo);
	}
	@Override
	public SchedulerVO schedulerCheck(String memberNo) {
		return schedulerDAO.schedulerCheck(memberNo);
	}
	@Override
	public void registerScheduler(SchedulerVO sdvo) {
		schedulerDAO.registerScheduler(sdvo);
	}
	@Override
	public void updateScheduler(SchedulerVO sdvo) {
		schedulerDAO.updateScheduler(sdvo);
	}
	
	@Override
	public ListVO getRecruitBoardList(SearchBoardVO sebvo) {
		if (sebvo.getPageNo() == null || sebvo.getPageNo() == ""){
			sebvo.setPageNo("1");
		}
		List<BoardVO> list = schedulerDAO.getRecruitBoardList(sebvo);
		int total=schedulerDAO.getRecruitTotalContent(sebvo.getSearch());
		PagingBean paging=new PagingBean(total, Integer.parseInt(sebvo.getPageNo()));
		ListVO rvo = new ListVO(list, paging);
		System.out.println("rvo: "+rvo);
		return rvo;
	}
	@Override
	public ListVO getNoticeBoardList(SearchBoardVO sebvo) {
		if (sebvo.getPageNo() == null || sebvo.getPageNo() == ""){
			sebvo.setPageNo("1");
		}
		List<BoardVO> list = schedulerDAO.getNoticeBoardList(sebvo);
		int total=schedulerDAO.getNoticeBoardTotalContent(sebvo.getSearch());
		PagingBean paging=new PagingBean(total, Integer.parseInt(sebvo.getPageNo()));
		ListVO nvo = new ListVO(list, paging);
		System.out.println("nvo: "+nvo);
		return nvo;
	}
	@Override
	public ListVO getReviewBoardList(SearchBoardVO sebvo) {
		if (sebvo.getPageNo() == null || sebvo.getPageNo() == ""){
			sebvo.setPageNo("1");
		}
		List<BoardVO> list = schedulerDAO.getReviewBoardList(sebvo);
		int total=schedulerDAO.getReviewBoardTotalContent(sebvo.getSearch());
		PagingBean paging=new PagingBean(total, Integer.parseInt(sebvo.getPageNo()));
		ListVO revo = new ListVO(list, paging);
		System.out.println("revo: "+revo);
		return revo;
	}
	@Override
	public ListVO getQnABoardList(SearchBoardVO sebvo) {
		if (sebvo.getPageNo() == null || sebvo.getPageNo() == ""){
			sebvo.setPageNo("1");
		}
		List<BoardVO> list = schedulerDAO.getQnABoardList(sebvo);
		int total=schedulerDAO.getQnABoardTotalContent(sebvo.getSearch());
		PagingBean paging=new PagingBean(total, Integer.parseInt(sebvo.getPageNo()));
		ListVO qvo = new ListVO(list, paging);
		System.out.println("qvo: "+qvo);
		return qvo;
	}
	
	@Override
	public List<BoardVO> getThRecruitBoardList(String search) {
		List<BoardVO> list = schedulerDAO.getThRecruitBoardList(search);
		return list;
	}
	@Override
	public List<BoardVO> getThNoticeBoardList(String search) {
		List<BoardVO> list = schedulerDAO.getThNoticeBoardList(search);
		return list;
	}
	@Override
	public List<BoardVO> getThReviewBoardList(String search) {
		List<BoardVO> list = schedulerDAO.getThReviewBoardList(search);
		return list;
	}
	@Override
	public List<BoardVO> getThQnABoardList(String search) {
		List<BoardVO> list = schedulerDAO.getThQnABoardList(search);
		return list;
	}
}
