package h02_embeddable;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ogrenciler")
public class H1_Ogrenci {
	
	@Id
	private int ogrId;
	
	private String ogrAd;
	
	private int ogrNot;
	

	private H2_Dersler dersler;
	
	@Transient//Javada bulunsun ama tabloda gozukmesin istedigimiz veriler icin kullanilir
	private int ogrYas;

	public H1_Ogrenci() {}

	public H1_Ogrenci(int ogrId, String ogrAd, int ogrNot, H2_Dersler dersler) {
		
		this.ogrId = ogrId;
		this.ogrAd = ogrAd;
		this.ogrNot = ogrNot;
		this.dersler = dersler;
	}

	public int getOgrId() {
		return ogrId;
	}

	public void setOgrId(int ogrId) {
		this.ogrId = ogrId;
	}

	public String getOgrAd() {
		return ogrAd;
	}

	public void setOgrAd(String ogrAd) {
		this.ogrAd = ogrAd;
	}

	public int getOgrNot() {
		return ogrNot;
	}

	public void setOgrNot(int ogrNot) {
		this.ogrNot = ogrNot;
	}

	public H2_Dersler getDersler() {
		return dersler;
	}

	public void setDersler(H2_Dersler dersler) {
		this.dersler = dersler;
	}

	@Override
	public String toString() {
		return "H1_Ogrenci [ogrId=" + ogrId + ", ogrAd=" + ogrAd + ", ogrNot=" + ogrNot + ", dersler=" + dersler + "]";
	}
	
	
	
}
