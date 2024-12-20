package kr.ac.kopo.cart.service;

import java.util.List;

import kr.ac.kopo.cart.dao.CartDAO;
import kr.ac.kopo.cart.dao.CartDAOImpl;
import kr.ac.kopo.cart.vo.CartVO;

public class CartService {
	private CartDAO cartDao;

	public CartService() {
		 cartDao = new CartDAOImpl();
	}

	public void addToCart(CartVO cart) {
		cartDao.insertCart(cart);
	}

	public List<CartVO> selectCart(int user_no) {
		List<CartVO> cartList = cartDao.selectCart(user_no);
		return cartList;
	}
	public CartVO selectCart(CartVO cart) {
		CartVO cartvo = cartDao.selectCartItem(cart);
		return cartvo;
	}

	public CartVO selectOneCartInItem(CartVO cartVO) {
		CartVO cart = cartDao.selectOneCartInItem(cartVO);
		return cart;
	}

	public void updateToItemQTY(CartVO cart) {
		cartDao.updateToItemQTY(cart);
	}

	public int selectQTY(CartVO cart) {
		int qty = cartDao.selectQTY(cart);
		return qty;
	}

	public boolean updateQuantity(CartVO cart) {
		
		return cartDao.updateQuantity(cart);
	}

	public void deleteCartInItem(CartVO cart) {
		cartDao.deleteCartInItem(cart);
	}

	public void deleteAllCart(int user_no) {
		cartDao.deleteAllCart(user_no);
	}


}
