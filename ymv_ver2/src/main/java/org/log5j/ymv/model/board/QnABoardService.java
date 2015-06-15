package org.log5j.ymv.model.board;

public interface QnABoardService {

	public ListVO getQnABoardList(String pageNo);

	public void registerQnABoard(QnABoardVO qvo);

	public QnABoardVO getQnABoardByQnANo(int qnaNo);

	public void updateQnABoard(QnABoardVO qnABoardVO);

	public void deleteQnABoard(int qnaNo);

	public void replyQnABoard(QnABoardVO qvo);

}