package kr.ac.kopo.delivery.service;

import java.util.List;

import kr.ac.kopo.delivery.dao.DeliverDAO;
import kr.ac.kopo.delivery.dao.DeliverDAOImpl;
import kr.ac.kopo.delivery.vo.DeliveryVO;
import kr.ac.kopo.user.vo.UserVO;

public class DeliverService {
	private DeliverDAO deliverDao;
	
	public DeliverService() {
		deliverDao = new DeliverDAOImpl();
	}

	public void insertADDR(DeliveryVO deliverVO) {
		deliverDao.insertADDR(deliverVO);
	}

	public List<DeliveryVO> selectToUserNo(int user_no) {
		return deliverDao.selectToUserNo(user_no);
	}

	public void deleteADDR(int d_no) {
		deliverDao.deleteADDR(d_no);
	}

	public void updateType(int d_no) {
		deliverDao.updateType(d_no);
	}

	public void updateAllFalse(int user_no) {
		deliverDao.updateAllFalse(user_no);
	}

	public DeliveryVO selectBase(int user_no) {
		return deliverDao.selectBase(user_no);
	}
}
