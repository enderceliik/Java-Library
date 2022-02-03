// https://github.com/Enderceliik
// Ender ÇELÝK

package NYP_VIZE_ODEV;

public class Bolum {
	private int bolNo;
	private String bolAd;
	public Ders[] dersler;
	public Ogrenci[] ogrenciler;
	public Bolum(int bolNo, String bolAd) 
	{
		this.bolNo = bolNo;
		this.bolAd = bolAd;		
	}
	
	public void setOgrenciler(int OgrenciSayisi, int StudentCounter) { // Öðrenci sayýsýný kullanýcýdan alýp sonradan deðiþtirmek üzere o kadar sayýda Ogrenci nesnesi doldurdum.
		this.ogrenciler = new Ogrenci[OgrenciSayisi];
		for(int i = 0; i < OgrenciSayisi; i++)
		{
			this.ogrenciler[i] = new Ogrenci(StudentCounter+i,"","",0,0);
		}
	}

	public void setDersler(int DersAdet, int LessonCounter) { // Ders sayýsýný kullanýcýdan alýp sonradan deðiþtirmek üzere o kadar sayýda Ders nesnesi doldurdum.
		this.dersler = new Ders[DersAdet];
		for(int i = 0; i < DersAdet; i++)
		{
			this.dersler[i] = new Ders(LessonCounter+i, 0, 0, "");
		}
	}
	public int getBolNo() {
		return bolNo;
	}
	public void setBolNo(int bolNo) {
		this.bolNo = bolNo;
	}
	public String getBolAd() {
		return bolAd;
	}
	public void setBolAd(String bolAd) {
		this.bolAd = bolAd;
	}
}
