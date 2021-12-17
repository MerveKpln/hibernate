package h05_ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import h04_oneToMany.H1_Ogrenci;
import h04_oneToMany.H2_Kitap;

public class H3_Save {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Mirasyediler.class).addAnnotatedClass(H2_Arsalar.class).buildSessionFactory();
		
		Session session= sf.openSession();
				
		Transaction tx =session.beginTransaction();
		
		H2_Arsalar denizli = new H2_Arsalar(11, "Denizli");
		H2_Arsalar istanbul = new H2_Arsalar(22, "Istanbul");
		H2_Arsalar maras = new H2_Arsalar(33, "Kahramanmaras");
		
		H1_Mirasyediler m1 = new H1_Mirasyediler(12345, "yagmur damla", 29);
		H1_Mirasyediler m2 = new H1_Mirasyediler(12346, "huseyin bilir", 45);
		H1_Mirasyediler m3 = new H1_Mirasyediler(12347, "muhittin  topalak", 78);
		
		
		m1.getArsaListesi().add(denizli);
		m1.getArsaListesi().add(istanbul);
		m1.getArsaListesi().add(maras);
		
		m2.getArsaListesi().add(denizli);
		
		m3.getArsaListesi().add(maras);
		m3.getArsaListesi().add(istanbul);
		
		denizli.setMirasyediListesi(denizli.getMirasyediListesi());
		istanbul.setMirasyediListesi(istanbul.getMirasyediListesi());
		maras.setMirasyediListesi(maras.getMirasyediListesi() );
		
		session.save(m1);
		session.save(m2);
		session.save(m3);
		
		session.save(maras);
		session.save(denizli);
		session.save(istanbul);
		tx.commit();
		
		//is id 12345 olan mirasyediyi getir
		System.out.println(session.get(H1_Mirasyediler.class, 12345));
		
		

	}

}
