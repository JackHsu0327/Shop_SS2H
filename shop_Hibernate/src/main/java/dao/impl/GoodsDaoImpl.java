package dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DbConnection;
import dao.GoodsDao;
import model.Goods;

public class GoodsDaoImpl implements GoodsDao{
	
	@Override
	public void add(Goods g) {
		Session se= DbConnection.getDb();
		Transaction t = se.beginTransaction();
		se.save(g);
		t.commit();
	}

	@Override
	public List<Goods> selectAll() {
		Session se = DbConnection.getDb();
		String SQL="select * from goods";
		NativeQuery q = se.createNativeQuery(SQL, Goods.class);
		
		return q.list();
	}

	@Override
	public List<Goods> selectBy(int id) {
		Session se = DbConnection.getDb();
		String SQL="select * from goods where id = ?";
		NativeQuery q = se.createNativeQuery(SQL, Goods.class);
		q.setParameter(1, id);
		
		return q.list();
	}

	@Override
	public List<Goods> selectName(String name) {
		Session se = DbConnection.getDb();
		String SQL="select * from goods where name like ?";
		NativeQuery q = se.createNativeQuery(SQL, Goods.class);
		q.setParameter(1,"%"+name+"%");
		
		return q.list();
	}

	@Override
	public List<Goods> selectPrice(int minPrice, int maxPrice) {
		Session se = DbConnection.getDb();
		String SQL="select * from goods where price between ? and ?";
		NativeQuery q = se.createNativeQuery(SQL, Goods.class);
		q.setParameter(1, minPrice);
		q.setParameter(2, maxPrice);
		
		return q.list();
	}

	@Override
	public List<Goods> selectNamePrice_1(String name, int minPrice, int maxPrice) {
		Session se = DbConnection.getDb();
	    String SQL = "select * from goods where name like ? and price between ? and ?";
	    NativeQuery q = se.createNativeQuery(SQL, Goods.class);
	    q.setParameter(1, "%" + name + "%");
	    q.setParameter(2, minPrice);
	    q.setParameter(3, maxPrice);

	    return q.list();
	}

	@Override
	public List<Goods> selectNamePrice_2(String name, int minPrice) {
		Session se = DbConnection.getDb();
	    String SQL = "select * from goods where name like ? and price >= ?";
	    NativeQuery q = se.createNativeQuery(SQL, Goods.class);
	    q.setParameter(1, "%" + name + "%");
	    q.setParameter(2, minPrice);

	    return q.list();
	}

	@Override
	public List<Goods> selectNamePrice_3(String name, int maxPrice) {
		Session se = DbConnection.getDb();
	    String SQL = "select * from goods where name like ? and price <= ?";
	    NativeQuery q = se.createNativeQuery(SQL, Goods.class);
	    q.setParameter(1, "%" + name + "%");
	    q.setParameter(2, maxPrice);

	    return q.list();
	}

	@Override
	public List<Goods> selectByPrice_1(int minPrice) {
		Session se = DbConnection.getDb();
		String SQL="select * from goods where price >= ?";
		NativeQuery q = se.createNativeQuery(SQL, Goods.class);
		q.setParameter(1, minPrice);
		
		return q.list();
	}

	@Override
	public List<Goods> selectByPrice_2(int maxPrice) {
		Session se = DbConnection.getDb();
		String SQL="select * from goods where price <= ?";
		NativeQuery q = se.createNativeQuery(SQL, Goods.class);
		q.setParameter(1, maxPrice);
		
		return q.list();
	}

	@Override
	public void update(Goods g) {
		Session se = DbConnection.getDb();
		Transaction t = se.beginTransaction();
		se.update(g);
		t.commit();
	}

	@Override
	public void delete(Integer id) {
		Session se = DbConnection.getDb();
		Transaction t = se.beginTransaction();
		
		Goods goods = se.get(Goods.class, id);
		if (goods != null) {
	        se.delete(goods);
		}    
		t.commit();
	}


}
