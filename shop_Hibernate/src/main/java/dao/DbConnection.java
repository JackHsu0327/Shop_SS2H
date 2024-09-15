package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConnection {

	public static Session getDb()
	{
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session se = sf.openSession();
		return se;
	}
	
	

}	
		
	