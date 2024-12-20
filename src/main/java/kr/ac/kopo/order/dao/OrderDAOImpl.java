package kr.ac.kopo.order.dao;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.order.vo.OrderVO;

public class OrderDAOImpl implements OrderDAO {
	private SqlSession sqlSession;
	
	
	public OrderDAOImpl() {
		sqlSession = new MyConfig().getInstance();
	}

	@Override
	public void insertFirst(CartVO cartVO) {
		sqlSession.insert("dao.OrderDAO.insertFirst",cartVO);
		sqlSession.commit();
	}
	@Override
	public void insertAfter(CartVO cartVO) {
		sqlSession.insert("dao.OrderDAO.insertAfter",cartVO);
		sqlSession.commit();
	}
	@Override
	public void insertOne(OrderVO orderVO) {
		sqlSession.insert("dao.OrderDAO.insertOne",orderVO);
	}
	
	/*
	 * (usre, item, qty) Sqlsession.insert("nameSpace.firstInsert");
	 * 
	 * firstInsert : seq_ORDER_ID.nextval line_no : 1
	 * 
	 * for(int i = 1; i < itemList.length; i++) {
	 * Sqlsession.insert("nameSpace.nextInsert"); nextInsert : seq_ORDER_ID.currval
	 * line_no : i + 1 }
	 */
}
