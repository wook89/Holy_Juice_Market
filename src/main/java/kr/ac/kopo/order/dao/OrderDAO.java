package kr.ac.kopo.order.dao;

import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.order.vo.OrderVO;

public interface OrderDAO {

	void insertFirst(CartVO cartVO);

	void insertAfter(CartVO cartVO);

	void insertOne(OrderVO orderVO);

}
