package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
	@Resource
	private NoticeBoardDAO noticeBoardDAO;
	
	@Override
	public ListVO getNoticeBoardList(String pageNo) {
		if (pageNo == null || pageNo == "")
			pageNo = "1";
		List<BoardVO> list = noticeBoardDAO.getNoticeBoardList(pageNo);
		System.out.println("ServiceImpl list: "+list);
		int total = noticeBoardDAO.totalContent();
		System.out.println("ServiceImpl total: "+total);
		PagingBean paging = new PagingBean(total, Integer.parseInt(pageNo));
		System.out.println("ServiceImpl paging: "+paging);
		ListVO lvo = new ListVO(list, paging);
		System.out.println("ServiceImpl lvo: "+lvo);
		
		return lvo;
	}

	@Override
	public void registerNoticeBoard(NoticeBoardVO vo) {
		// TODO Auto-generated method stub
		noticeBoardDAO.registerNoticeBoard(vo);
	}

	@Override
	public BoardVO getNoticeBoardByBoardNo(int boardNo) {
		// TODO Auto-generated method stub
		return noticeBoardDAO.getReviewBoardByBoardNo(boardNo);
	}

	@Override
	public void noticeBoardUpdate(NoticeBoardVO vo) {
		// TODO Auto-generated method stub
		noticeBoardDAO.noticeBoardUpdate(vo);
	}

	@Override
	public void noticeBoardDelete(String boardNo) {
		// TODO Auto-generated method stub
		noticeBoardDAO.noticeBoardDelete(boardNo);
	}

}
