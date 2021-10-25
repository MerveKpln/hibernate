package h06_caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {
	public static void main(String[] args) {
		

		// ==================== HIBERNATE CACHING MEKANİZMASI =============================
		/* 	Hibernate'te default olarak L1-cache sistemi kullanılmaktadir.
		 * 
		 *  Eğer kullanıcı bir veriyi tekrar tekrar talep eder ise 
		 *  hibernate bu veriyi veritabından getirip hem L1 cache'e saklar. 
		 *  Hem de kullanıma sunar. Dolayısıyla, kullanıcı aynı veriye tekrar
		 *  ihtiyaç duyarsa bu veri veritabanından değil cache'den getirilmektedir.  
		 *  
		 *  L1-Cache'i session tabanlı bir cache'dir.
		 *  Bir uygulamada birden fazla session olabilir. Ancak her session'ın 
		 *  verileri o sesion'a özeldir. Dolayısıyla her oturumun ayrı bir L1
		 *  cache'i olduğu düşünülebilir. Session kapatıldığında L1'deki  verilere
		 *  erişilemez. 
		 *  
		 *  Session.evict(): Cache'deki belirtilen veriyi kaldırmak için 
			refresh(): belleği günceller.
			clear(): cache'deki tüm nesne ve entity'leri siler.
		 * 
		 * ------------------------------ L2 CACHE ---------------------------------------
		 * Hibernate L2-cache mekanizmasını da barındırmaktadır.
		 * L2-Cache, default kapalıdır. Kullanmak için aktif hale getirilmelidir.
		 * 
		 * L2, tüm session'lar (SessionFactory) için ortak bir cache alanı sunar.
		 * Yani L2 cache'deki verilere bir uygulamadaki tüm session'lar erişebilir.
		 * 
		 * Bir session, veritabanından bir veri çekince bu veri hem L2,hem L1 hem de 
		 * session' a sunulur. Aynı veri tekrar lazım olursa L1'den çekilir. Ancak,
		 * session kapatılırsa L1'deki veri silinir lakin aynı veriye başka bir session
		 * ihtiyac duyarsa bu veri L2'den çekilmiş olur. Yani veritabanına gitmeye gerek kalmaz.
		 *  
		 * */
		
		
			SessionFactory sf=new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(H1_Developer.class)
			.addAnnotatedClass(H2_Hesap.class).buildSessionFactory();
	
	Session session1= sf.openSession();
			
	Transaction tx1 =session1.beginTransaction();
	
	//id=1 olan dev in bilgilerini çekelim
	
	System.out.println(session1.get(H1_Developer.class, 1));
	
	
	
	tx1.commit();
	
	}

	
}
