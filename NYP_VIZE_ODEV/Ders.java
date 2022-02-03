// https://github.com/Enderceliik
// Ender ÇELÝK

package NYP_VIZE_ODEV;

public class Ders
{
	private int bolNo;
	private int dersID;
	private String dersAd;
	private int dersKredi;
	public Ders(int dersID, int dersKredi, int bolNo, String dersAd) {
		super();
		this.bolNo = bolNo;
		this.dersID = dersID;
		this.dersAd = dersAd;
		this.dersKredi = dersKredi;
	}
	public int getBolNo() {
		return bolNo;
	}
	public void setBolNo(int bolNo) {
		this.bolNo = bolNo;
	}
	public int getDersID() {
		return dersID;
	}
	public void setDersID(int dersID) {
		this.dersID = dersID;
	}
	public String getDersAd() {
		return dersAd;
	}
	public void setDersAd(String dersAd) {
		this.dersAd = dersAd;
	}
	public int getDersKredi() {
		return dersKredi;
	}
	public void setDersKredi(int dersKredi) {
		this.dersKredi = dersKredi;
	}
}
