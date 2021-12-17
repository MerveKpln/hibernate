package h05_ManyToMany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Mirasyediler.class).addAnnotatedClass(H2_Arsalar.class).buildSessionFactory();
		
		Session session= sf.openSession();
				
		Transaction tx =session.beginTransaction();
		
		//nosu=22 olan arsayi getir
		
		System.out.println(session.get(H2_Arsalar.class,22));
		
		//adi=muhittin olan mirasyediyi getir(arsalarinida gorelim HQl ile)
		
		Object mrs1=session.createQuery("FROM H1_Mirasyediler m WHERE m.isim='muhittin  topalak'").getSingleResult();
		//HQL de her seyi isiyorsan select* yazmana gerek yok
		System.out.println(mrs1);
		
		
	//ARSA YERLERINI GETIR
		List<Object[]> liste= session.createQuery("SELECT a.sehir FROM H2_Arsalar a").getResultList();
		
		System.out.println(liste);
		
		
		
		//mirasyedi isimlerini getir
		
		
		System.out.println(session.createQuery("SELECT isim FROM H1_Mirasyediler").getResultList());
		
		
		tx.commit();
	}
}
