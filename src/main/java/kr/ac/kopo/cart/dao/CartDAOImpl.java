package kr.ac.kopo.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.mybatis.MyConfig;

public class CartDAOImpl implements CartDAO {
	private SqlSession sqlSession;
	
	
	public CartDAOImpl() {
		sqlSession = new MyConfig().getInstance();
	}


	@Override
	public void insertCart(CartVO cart) {
		sqlSession.insert("dao.CartDAO.insertCart",cart);
		sqlSession.commit();

	}


	@Override
	public List<CartVO> selectCart(int user_no) {
		sqlSession.clearCache();
		List<CartVO> cartList = sqlSession.selectList("dao.CartDAO.selectCart", user_no);
		return cartList;
	}


	@Override
	public CartVO selectOneCartInItem(CartVO cartVO) {
		sqlSession.clearCache();
		CartVO cart = sqlSession.selectOne("dao.CartDAO.selectOneCartInItem",cartVO);
		return cart;
	}


	@Override
	public void updateToItemQTY(CartVO cart) {
		sqlSession.update("dao.CartDAO.updateToItemQTY",cart);
		sqlSession.commit();
	}


	@Override
	public int selectQTY(CartVO cart) {
		sqlSession.clearCache();
		int qty = sqlSession.selectOne("dao.CartDAO.selectQTY",cart);
		return qty;
	}


	@Override
	public boolean updateQuantity(CartVO cart) {
		if(sqlSession.update("dao.CartDAO.updateQuantity",cart) == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
		
		//return sqlSession.update("dao.CartDAO.updateQuantity",cart) == 1 ? true : false;
	}


	@Override
	public CartVO selectCartItem(CartVO cart) {
		sqlSession.clearCache();
		CartVO cartvo = sqlSession.selectOne("dao.CartDAO.selectOneCart",cart);
		return cartvo;
	}


	@Override
	public void deleteCartInItem(CartVO cart) {
		sqlSession.delete("dao.CartDAO.deleteCartInItem",cart);
		sqlSession.commit();
	}


	@Override
	public void deleteAllCart(int user_no) {
		sqlSession.delete("dao.CartDAO.deleteAllCart",user_no);
		sqlSession.commit();
	}
	
}
