package h04_oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class H3_Save {
public static void main(String[] args) {
	SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Ogrenci.class).addAnnotatedClass(H2_Kitap.class).buildSessionFactory();
	
	Session session= sf.openSession();
			
	Transaction tx =session.beginTransaction();

	//kitaplari bilgisi 
	H2_Kitap k1 =new H2_Kitap(12,"mat kitabi");
	H2_Kitap k2 =new H2_Kitap(21,"edeb kitabi");
	H2_Kitap k3 =new H2_Kitap(45,"trkce kitabi");
	H2_Kitap k4 =new H2_Kitap(33,"cogrf kitabi");
	
	//ogrenc bilgsi
	H1_Ogrenci o1= new H1_Ogrenci(1,"Sedef",98);
	H1_Ogrenci o2= new H1_Ogrenci(4,"Sabah",95);
	H1_Ogrenci o3= new H1_Ogrenci(7,"Kenan",97);
	
	//kitap il ogr eslestir
	k1.setOgrenci(o1);
	k2.setOgrenci(o1);
	k3.setOgrenci(o2);
	k4.setOgrenci(o2);
	
	session.save(k1);
	session.save(k2);
	session.save(k3);
	session.save(k4);
	session.save(o1);
	session.save(o2);
	session.save(o3);
	
	
	tx.commit();
	sf.close();
	session.close();
}
}
