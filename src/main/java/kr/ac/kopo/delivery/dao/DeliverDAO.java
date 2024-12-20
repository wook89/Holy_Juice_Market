package kr.ac.kopo.delivery.dao;

import java.util.List;

import kr.ac.kopo.delivery.vo.DeliveryVO;

public interface DeliverDAO {

	void insertADDR(DeliveryVO deliverVO);

	List<DeliveryVO> selectToUserNo(int user_no);

	void deleteADDR(int d_no);

	void updateType(int d_no);

	void updateAllFalse(int user_no);
	
}
