package h04_oneToMany;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="ogrenciler")
 public class H1_Ogrenci {
    
    @Id
    private int ogrId;
    
    private String ogrAd;
    
    private int ogrNot;
    
    // Child'ı silmeden Parent silmek icin ==>> orphanRemoval=true, cascade = CascadeType.ALL
    // Getirme islemleri icin ===> fetch = FetchType.EAGER veya fetch = FetchType.LAZY 
    
    @OneToMany(mappedBy="ogrenci", orphanRemoval=true, cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    
    private List <H2_Kitap> kitapListesi = new ArrayList<>();
    //Arraylist in içine class ismi yazmayınca hata veriyorsa:
    //hibernate sağ tıkla,properties=>java compiler=>use tikini kaldır 1.8 
    //işaretle Apply
//burada private H2_Kitap kitap yazamam, bu bir tane kitap olur, çok olacağı için list yaptık,her öğrencinin listesi olacak
    public H1_Ogrenci() {
    
    }
    
    public H1_Ogrenci(int ogrId, String ogrAd, int ogrNot) {
        this.ogrId = ogrId;
        this.ogrAd = ogrAd;
        this.ogrNot = ogrNot;
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
    public List<H2_Kitap> getKitapListesi() {
        return kitapListesi;
    }
    public void setKitapListesi(List<H2_Kitap> kitapListesi) {
        this.kitapListesi = kitapListesi;
    }
//  @Override  burayı lazy eager muhabbetinde aç, alttaki tostring i kapat
//  public String toString() {
//      return "Ogrenci ogrId=" + ogrId + ", ogrAd=" + ogrAd + ", ogrNot=" + ogrNot;
//  }
    @Override
    public String toString() {
        return "Ogrenci ogrId=" + ogrId + ", ogrAd=" + ogrAd + ", ogrNot=" + ogrNot + ", kitapListesi="
                + kitapListesi + "]";
    }
    
}