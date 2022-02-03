// https://github.com/Enderceliik
// Ender ÇELÝK

package NYP_VIZE_ODEV;

public class Ogrenci
{
	private int bolNo;
	private int ogrID;
	private String ogrAd;
	private String ogrSoyad;
	private int ogrSinif;
	public Ogrenci(int OgrID, String ogrAd, String ogrSoyad, int ogrSinif, int bolNo) {
		super();
		this.ogrAd = ogrAd;
		this.ogrSoyad = ogrSoyad;
		this.ogrSinif = ogrSinif;
		this.bolNo = bolNo;
		this.ogrID = OgrID;
	}
	public int getBolNo() {
		return bolNo;
	}
	public void setBolNo(int bolNo) {
		this.bolNo = bolNo;
	}
	public int getOgrID() {
		return ogrID;
	}
	public void setOgrID(int ogrID) {
		this.ogrID = ogrID;
	}
	public String getOgrAd() {
		return ogrAd;
	}
	public void setOgrAd(String ogrAd) {
		this.ogrAd = ogrAd;
	}
	public String getOgrSoyad() {
		return ogrSoyad;
	}
	public void setOgrSoyad(String ogrSoyad) {
		this.ogrSoyad = ogrSoyad;
	}
	public int getOgrSinif() {
		return ogrSinif;
	}
	public void setOgrSinif(int ogrSinif) {
		this.ogrSinif = ogrSinif;
	}
}
