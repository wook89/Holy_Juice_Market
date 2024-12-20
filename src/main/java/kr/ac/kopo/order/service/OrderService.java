package kr.ac.kopo.order.service;

import java.util.List;

import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.order.dao.OrderDAO;
import kr.ac.kopo.order.dao.OrderDAOImpl;
import kr.ac.kopo.order.vo.OrderVO;

public class OrderService {
	private OrderDAO orderDao;
	
	public OrderService() {
		orderDao = new OrderDAOImpl();
	}
	public void insertFirst(CartVO cartVO) {
		orderDao.insertFirst(cartVO);
	}
	public void insertAfter(CartVO cartVO) {
		orderDao.insertAfter(cartVO);
	}
	public void insertOne(OrderVO orderVO ) {
		orderDao.insertOne(orderVO);
	}
}
