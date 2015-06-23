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
}
