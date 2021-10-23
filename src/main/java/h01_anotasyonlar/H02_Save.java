
package h01_anotasyonlar;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H02_Save {

	public static void main(String[] args) {
		
		//IMPORTLAR HIBERNATE OLANDAN YAPILACAK
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H01_Sehir.class);
		//sql verilerinin olduğu cfg.xml clasına bağlandık, bu sayede sql e bağlandık 
		//ve H01_Sehir classından işlem yapacağımızı belirttik
		
		
		//islem yapacagimiz alanlar (session) icin paretn alan olusturduk
		SessionFactory sf= con.buildSessionFactory();
		
		//paretn alandan kendime kucuk alanlar actim
		Session s= sf.openSession();
		
		Transaction tx =s.beginTransaction();
		
		
	H01_Sehir sehir1 = new H01_Sehir(34,"istanbul",40000);
	
	
	s.save(sehir1);
	s.save(new H01_Sehir(35,"izmir",30000));//kaydetmek icin 2. yol
	tx.commit();
	// Oturumlarin kapatilmasi
			sf.close(); //bunu kapatınca parent kapamış olur, session açılamaz
			s.close();//kapattıktan sonra işlem yapılmaz, yapmak istersek tekrar session lar açmalıyız
	}

}
