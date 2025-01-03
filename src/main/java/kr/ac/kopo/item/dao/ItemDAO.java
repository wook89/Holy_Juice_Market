package kr.ac.kopo.item.dao;

import java.util.List;

import kr.ac.kopo.item.vo.ItemVO;

public interface ItemDAO {
	List<ItemVO> selectAllItem() throws Exception;

	List<ItemVO> selectAllJuice() throws Exception;

	List<ItemVO> selectAllVape() throws Exception;

	List<ItemVO> selectAllPot() throws Exception;

	int insertItem(ItemVO item) throws Exception;

	/* ItemVO selectOne(String item_cd) throws Exception; */
	ItemVO selectOne(int item_cd) throws Exception;

	void updateItem(ItemVO item) throws Exception;

	void deleteItem(int item_cd) throws Exception;

	List<ItemVO> selectBestList();
	
	// 전체 아이템 수 조회
    int countItems();

    // 페이징 처리된 아이템 조회
    List<ItemVO> selectItemsByPage(int offset, int limit);
}
