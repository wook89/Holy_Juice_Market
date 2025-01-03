package kr.ac.kopo.item.service;

import java.util.List;

import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.item.dao.ItemDAO;
import kr.ac.kopo.item.dao.ItemDAOImpl;
import kr.ac.kopo.item.vo.ItemVO;

public class ItemService {
	private ItemDAO itemDao;

	public ItemService() {
		itemDao = new ItemDAOImpl();
	}
	
	public List<ItemVO> selectAllItem() throws Exception{
		List<ItemVO> itemList = itemDao.selectAllItem();
		return itemList;
	}

	public List<ItemVO> selectAllJuice() throws Exception {
		List<ItemVO> itemList = itemDao.selectAllJuice();
		return itemList;
	}

	public List<ItemVO> selectAllVape() throws Exception {
		List<ItemVO> itemList = itemDao.selectAllVape();
		return itemList;
	}

	public List<ItemVO> selectAllPot() throws Exception {
		List<ItemVO> itemList = itemDao.selectAllPot();
		return itemList;
	}

	public boolean insertItem(ItemVO item) throws Exception{
		int result = itemDao.insertItem(item);
		return result > 0;
	}

	/*
	 * public ItemVO selectOneItem(String item_cd) throws Exception { ItemVO item =
	 * itemDao.selectOne(item_cd); return item; }
	 */

	public void updateItem(ItemVO item) throws Exception {
		itemDao.updateItem(item);
	}

	public void deleteItem(int item_cd) throws Exception{
		itemDao.deleteItem(item_cd);
	}

	public ItemVO selectOneItem(int item_cd) throws Exception {
		ItemVO item = itemDao.selectOne(item_cd);
		return item;
	}

	public List<ItemVO> selectBestList() {
		List<ItemVO> itemList = itemDao.selectBestList();
		return itemList;
	}
	
	// 전체 아이템 수 반환
    public int getTotalItems() {
        return itemDao.countItems();
    }

    // 특정 범위의 아이템 반환
    public List<ItemVO> selectItemsByPage(int startRow, int endRow) {
        return itemDao.selectItemsByPage(startRow, endRow);
    }

}
