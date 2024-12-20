package kr.ac.kopo.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.delivery.vo.DeliveryVO;
import kr.ac.kopo.mybatis.MyConfig;

public class DeliverDAOImpl implements DeliverDAO {
	private SqlSession sqlSession;
	
	
	public DeliverDAOImpl() {
		sqlSession = new MyConfig().getInstance();
	}
	@Override
	public void insertADDR(DeliveryVO deliverVO) {
		sqlSession.clearCache();
		sqlSession.insert("dao.DeliverDAO.insertADDR",deliverVO);
	}
	@Override
	public List<DeliveryVO> selectToUserNo(int user_no) {
		sqlSession.clearCache();
		List<DeliveryVO> deliveryList = sqlSession.selectList("dao.DeliverDAO.selectToUserNo",user_no);
		return deliveryList;
	}
	@Override
	public void deleteADDR(int d_no) {
		sqlSession.delete("dao.DeliverDAO.deleteADDR",d_no);
		sqlSession.commit();
	}
	@Override
	public void updateType(int d_no) {
		sqlSession.update("dao.DeliverDAO.updateType",d_no);
		sqlSession.commit();
	}
	@Override
	public void updateAllFalse(int user_no) {
		sqlSession.update("dao.DeliverDAO.updateAllFalse",user_no);
		sqlSession.commit();
	}
}
