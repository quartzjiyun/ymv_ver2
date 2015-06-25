package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantListVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class RecruitBoardDAOImpl implements RecruitBoardDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardVO> getBoardList(String pageNo){
		System.out.println(pageNo+"   RecruitBoardDAOImpl  getBoardList pageno");
		
		List<BoardVO> list = sqlSessionTemplate.selectList("board.getBoardList", pageNo);
		System.out.println("RecruitBoardDAOImpl db 들어가서 list 넣은거"+list);
		return list;
	}

	@Override
	public int totalContent(){
		return sqlSessionTemplate.selectOne("board.totalContent");
	}

	@Override
	public BoardVO showContent(int recruitNo) {
		return (BoardVO)sqlSessionTemplate.selectOne("board.showContent",recruitNo);
	}

	@Override
	public RecruitBoardVO getRecruitBoardByRecruitNo(int recruitNo){
	      return sqlSessionTemplate.selectOne("board.getRecruitBoardByRecruitNo",recruitNo);
	   }

	@Override
	public List<FieldVO> getFieldList() {
		List<FieldVO> list = sqlSessionTemplate.selectList("board.getFieldList");
		return list;
	}

	@Override
	public List<LocationVO> getLocationList() {
		List<LocationVO> list = sqlSessionTemplate.selectList("board.getLocationList");
		return list;
	}

	@Override
	public RecruitBoardVO findRecruitBoardByrecruitNo(int recruitNo) {
		return sqlSessionTemplate.selectOne("board.findRecruitBoardByrecruitNo", recruitNo);
	}
	
	@Override
	public void registerVolunteer(RecruitBoardVO rbvo) {
		System.out.println("dao register volunterr"+rbvo);
		sqlSessionTemplate.insert("board.registerVolunteer",rbvo);
		
	}

	@Override
	public void updateBoard(BoardVO bvo) {
		sqlSessionTemplate.update("board.updateBoard",bvo);
		
	}

	@Override
	public void deleteRecruitVolunteer(int recruitNo) {
		sqlSessionTemplate.delete("board.deleteRecruitVolunteer",recruitNo);
	}

	@Override
	public void deleteVoluntaryServiceApplicateNo(int recruitNo) {
		sqlSessionTemplate.delete("member.deleteVoluntaryServiceApplicateNo",recruitNo);		
	}

	@Override
	public List<BoardVO> getCompanyBoardList(CompanyVO cpvo) {
		// TODO Auto-generated method stub
		System.out.println("DAOImpl : "+cpvo);
		List<BoardVO> list = sqlSessionTemplate.selectList("board.getCompanyBoardList",cpvo);
		System.out.println("RecruitBoardDAOImpl db 들어가서 list 넣은거"+list);
		return list;
	}

	@Override
	public int totalCompanyContent(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("board.totalCompanyContent",memberNo);
	}

	@Override
	public void deletePicture(int pictureNo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("board.deletePicture",pictureNo);
	}
	
	@Override
	public List<BoardVO> getNormalBoardList(CompanyVO cpvo) {
		System.out.println("DAOImpl : "+cpvo);
		List<BoardVO> list = sqlSessionTemplate.selectList("board.getNormalBoardList",cpvo);
		System.out.println("RecruitBoardDAOImpl db 들어가서 list 넣은거"+list);
		return list;
	}

	@Override
	public int totalNormalContent(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("board.totalNormalContent",memberNo);
	}

	@Override
	public void registerApplicantOK(ApplicantListVO alvo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("applicant.registerApplicantOK",alvo);
	}

	@Override
	public List<ApplicantListVO> getApplicantOkList(int recruitNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("applicant.getApplicantOkList",recruitNo);
	}
	
	@Override
	public void getPostingByRecruitNoNotHit(int recruitNo) {
		sqlSessionTemplate.selectOne("board.findRecruitBoardByrecruitNo",recruitNo);
	}

	@Override
	public void updateHit(int recruitNo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("board.updateHit", recruitNo);
	}

	@Override
	public MemberVO getMailAddressByMemberNo(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("applicant.getMailAddressByMemberNo", memberNo);
	}

}
