package kr.ac.kopo.cart.dao;

import java.util.List;

import kr.ac.kopo.cart.vo.CartVO;

public interface CartDAO {

	void insertCart(CartVO cart);

	List<CartVO> selectCart(int user_no);

	CartVO selectOneCartInItem(CartVO cart);

	void updateToItemQTY(CartVO cart);

	int selectQTY(CartVO cart);

	boolean updateQuantity(CartVO cart);

	CartVO selectCartItem(CartVO cart);

	void deleteCartInItem(CartVO cart);

	void deleteAllCart(int user_no);

}
