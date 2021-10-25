package h03_oneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="kisiler")
public class H1_Kisi {
	
	@Id
	private int kisiId;
	
	
	private String kisiAd;
	
	private int kisiYAs;
	
	@OneToOne(mappedBy="kisi")
	private H2_Gunluk gunluk;

	public H1_Kisi(int kisiId, String kisiAd, int kisiYAs) {
		super();
		this.kisiId = kisiId;
		this.kisiAd = kisiAd;
		this.kisiYAs = kisiYAs;
	}
	
	public H1_Kisi() {}

	public int getKisiId() {
		return kisiId;
	}

	public void setKisiId(int kisiId) {
		this.kisiId = kisiId;
	}

	public String getKisiAd() {
		return kisiAd;
	}

	public void setKisiAd(String kisiAd) {
		this.kisiAd = kisiAd;
	}

	public int getKisiYAs() {
		return kisiYAs;
	}

	public void setKisiYAs(int kisiYAs) {
		this.kisiYAs = kisiYAs;
	}

	@Override
	public String toString() {
		return "H1_Kisi [kisiId=" + kisiId + ", kisiAd=" + kisiAd + ", kisiYAs=" + kisiYAs + "]";
	};
	
	
	

}
