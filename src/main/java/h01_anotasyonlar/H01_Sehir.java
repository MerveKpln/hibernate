package h01_anotasyonlar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//================================================================
//HIBERNATE ICIN TABLO TANIMLAMASININ YAPILMASI 
//tablo oluşturabilmek için içerik hazırlama )alttakiler)
//POJO: Plain Old Java Object									
//1) Private degiskenler tanimlanir.
//2) constructor olusturulur.
//3) Getter ve Setter metotlar tanimlanir.
//4) toString() metodu ile nesne yazdirilabilir hale getirilir.
//================================================================
/*
	Bir Class Hibernate ile tablo olusturmada kullanilacaksa degiskenlerin
	“final” veya “static” tanimlanMAMAsi gerekir. 
*/
//- @Entity anotasyonu bu class’ın bir tabloya donusturulmesi
//gerektigini Hibernate’e gosterir.(sql ortamına mapping yapıo uyarlıo,translate) Her bir degisken bir sutun olacaktir.
//- @Table annotasyonu tablo adinin degistirlmesini saglar.javada ve sql deki isimler aynı olmak zorunda değiliz
//- @Id anotasyonu tablo icerisinde primary key olusturur.
//- @Transient anotasyonu bir degiskenin (sutun) tabloda yer almayacagini gosterir.

@Entity //Entity import edilmeli fakat, private bilgileri girmeden entity import edilmiyor
@Table(name="sehir_tablosu")//bu ismi vermek zorunda degiliz ama verirsek sqldeki ismi sehir_tablosu olsun
public class H01_Sehir {

	@Id  //bu sütun primary key demek oluyor (not null ve unique)
	@Column(name="cityPlaka")
	private int sehirPlaka;
	
	private int sehirNufus;
	public int getSehirPlaka() {
		return sehirPlaka;
	}
	
	
	public H01_Sehir(int sehirPlaka, String sehirAd,int sehirNufus) {
		super();
		this.sehirPlaka = sehirPlaka;
		this.sehirAd = sehirAd;
		this.sehirNufus = sehirNufus;
	}


	public H01_Sehir() {
		
	}
	


	public void setSehirPlaka(int sehirPlaka) {
		this.sehirPlaka = sehirPlaka;
	}
	public String getSehirAd() {
		return sehirAd;
	}
	public void setSehirAd(String sehirAd) {
		this.sehirAd = sehirAd;
	}
	private String sehirAd;
	

	public int getSehirNufus() {
		return sehirNufus;
	}


	public void setSehirNufus(int sehirNufus) {
		this.sehirNufus = sehirNufus;
	}


	@Override
	public String toString() {
		return "H01_Sehir [sehirPlaka=" + sehirPlaka + ", sehirNufus=" + sehirNufus + ", sehirAd=" + sehirAd + "]";
	}
	
}
