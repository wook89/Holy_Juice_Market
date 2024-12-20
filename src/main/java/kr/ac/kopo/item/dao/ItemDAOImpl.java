package kr.ac.kopo.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.item.vo.ItemVO;
import kr.ac.kopo.mybatis.MyConfig;

public class ItemDAOImpl implements ItemDAO{
	
	private SqlSession sqlSession;
	
	public ItemDAOImpl() {
		sqlSession = new MyConfig().getInstance();
		System.out.println("세션객체 : "+sqlSession);
	}

	@Override
	public List<ItemVO> selectAllItem() throws Exception {
		sqlSession.clearCache();
		List<ItemVO> itemList = sqlSession.selectList("dao.ItemDAO.selectAllItem");
		return itemList;
	}

	@Override
	public List<ItemVO> selectAllJuice() throws Exception {
		sqlSession.clearCache();
		List<ItemVO> itemList = sqlSession.selectList("dao.ItemDAO.selectAllJuice");
		return itemList;
	}

	@Override
	public List<ItemVO> selectAllVape() throws Exception {
		sqlSession.clearCache();
		List<ItemVO> itemList = sqlSession.selectList("dao.ItemDAO.selectAllVape");
		return itemList;
	}

	@Override
	public List<ItemVO> selectAllPot() throws Exception {
		sqlSession.clearCache();
		List<ItemVO> itemList = sqlSession.selectList("dao.ItemDAO.selectAllPot");
		return itemList;
	}

	@Override
	public int insertItem(ItemVO item) throws Exception {
		 int result = sqlSession.insert("dao.ItemDAO.insertItem",item);
		 sqlSession.commit();
		 return result;
	}

	/*
	 * @Override public ItemVO selectOne(String item_cd) { ItemVO item =
	 * sqlSession.selectOne("dao.ItemDAO.selectOneItem",item_cd); return item; }
	 */

	@Override
	public void updateItem(ItemVO item) throws Exception {
		
		sqlSession.update("dao.ItemDAO.updateItem",item);
		sqlSession.commit();
	}

	@Override
	public void deleteItem(int item_cd) throws Exception {
		sqlSession.delete("dao.ItemDAO.deleteItem",item_cd);
		sqlSession.commit();
	}

	@Override
	public ItemVO selectOne(int item_cd) throws Exception {
		ItemVO item = sqlSession.selectOne("selectOneItem",item_cd);
		return item;
	}

}
