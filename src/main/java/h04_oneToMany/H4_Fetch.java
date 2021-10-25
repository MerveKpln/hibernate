package h04_oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import h03_oneToOne.H1_Kisi;
import h03_oneToOne.H2_Gunluk;

public class H4_Fetch {

	public static void main(String[] args) {
SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Ogrenci.class).addAnnotatedClass(H2_Kitap.class).buildSessionFactory();
		
		Session session= sf.openSession();
				
		Transaction tx =session.beginTransaction();

		//id=1 olan öğrencinin tüm kitaplarını listeleyin
		
//		for (H2_Kitap w : session.get(H1_Ogrenci.class, 1).getKitapListesi()) {
//			System.out.println("kitaplar  :"+w );
//		}
//		  System.out.println();
//	  
//	  //id= 12 olan kitabın sahibinin bilgilerini listeleyin
//		  
//		 
//		  System.out.println("ilkCevap"  + session.get(H2_Kitap.class, 12).getOgrenci());
//		
//		
//		  System.out.println();
		  
		  //------------------------------------------------------
		  //SILME ISLEMI  tx.commit(); `i delete islemlerinde unutmamaliyiz
		  //-------------------------------------------------------
		  
		  //HQL ile tumkitaplai silelim
		  //once child silinir
		  
//		  session.createQuery("DELETE FROM H2_Kitap").executeUpdate();
//		  
//		  System.out.println("Kitaplar silindi");
//		  
		  //simdi parent `i silelim
		   
		  session.delete(session.get(H1_Ogrenci.class, 4));
		  
		  System.out.println("2 nolu id`li ogrenci silindi");// onceki kodlari yoruma al yoksa kitaplar silinmis olur hata verir
		  
		
		//direk Parent tablodan Exception olmaksizin silebilmek için
			//------------------------------------------
			// 
			//  A)ya Once Child sonra parent silinir.YA DA
			//  B) SQL deki gibi Cascade ozelligi aktif hale getirilir. 
			// (@OneToMany(mappedBy = "ogrenci", orphanRemoval = true, cascade = CascadeType.ALL) 

			//tekrar tabloları oluştur.(sql den sil tekrar kaydet verileri) 
		  
// session.delete(session.get(H1_Ogrenci.class, 4));
		  
		//  System.out.println("2 nolu id`li ogrenci bilgileri tekarr silindi");
		  
		//--------------------------------------------------------------------------
//			//  LAZY FETCH VS EAGER FETCH  
//			//------------------------------------------------------------------------
		//	
//			/* 
//			 *  Hibernate veritabanından verileri cekerken AC GOZLU(EAGER) veya TEMBEL(LAZY) olabilmektedir. 
//			 *  EAGER Fetch isleminde bir tablodan veri cekilmesi istendiginde Hibernate o tablo ile iliskili
//			 *  Tum tablolari da getirir. 
//			 *  
//			 *  Eger LAZY fetch islemi kullanilirsa sadece istenilen tablonun verileri getirilir. 
//			 * 
//			 *  2 yontemin de avantajlari ve dezavatanjlari vardir. Tercih, uygulanin gereksinimlerine gore belirlenir.  
//			 * 
//			 *  LAZY fetch gereksiz verilerin cekilmemesini saglamak icin ve daha dusuk bellek kullanimi icin daha elvereslidir. 
//			 *  Ancak, zamana duyarlı uygulamalarda problem olusturuabilir. iliskili verilerin tek tek veritabnindan getirilmesi
//			 *  zaman kayıolarina yol acabilir. 
//			 * 
//			 *  EAGER fetch ise bazen kullanimayacak veriler bastan pesin pesin getirilmesine yol acabilir.
//			 *   
//			 *   */öğrenci class ına git( önce LAZY yap sonra )EAGER kısmını ekle, sonra alttaki satırları yaz
		////	
		  
		// System.out.println( session.get(H1_Ogrenci.class, 7));
		  
		  // fetch kısmında EAGER yazılıyken konsolda alttaki sonuçlar çıkar
		// select
		// h1_ogrenci0_.ogrId as ogrid1_1_0_,
		// h1_ogrenci0_.ogrAd as ograd2_1_0_,
		// h1_ogrenci0_.ogrNot as ogrnot3_1_0_,
		// kitapliste1_.ogrId as ogrid3_0_1_,
		// kitapliste1_.id as id1_0_1_,
		// kitapliste1_.id as id1_0_2_,
		// kitapliste1_.isim as isim2_0_2_,
		// kitapliste1_.ogrId as ogrid3_0_2_ 
		  
		  
		  //fetch kısmında LAZY  açıkken konsolda alttaki sonuçlar çıkar
		  
		// select
		// kitapliste0_.ogrId as ogrid3_0_0_,
		// kitapliste0_.id as id1_0_0_,
		// kitapliste0_.id as id1_0_1_,
		// kitapliste0_.isim as isim2_0_1_,
		// kitapliste0_.ogrId as ogrid3_0_1_ 
		  
		  
		  
		  
		tx.commit();
		sf.close();
		session.close();
	}

}
