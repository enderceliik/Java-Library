// https://github.com/Enderceliik
// Ender ÇELÝK

package NYP_FINAL_ODEV;

import java.util.ArrayList;
import java.util.List;

public class Kursiyer {
	private int kursiyerID;
	private String kursiyerAdSoyad;
	private int kursiyerYas;
	List <Kurs> alinankurslar;
	public Kursiyer(int kursiyerID, String kursiyerAdSoyad, int kursiyerYas, List<Kurs> alinankurslar) {
		super();
		this.kursiyerID = kursiyerID;
		this.kursiyerAdSoyad = kursiyerAdSoyad;
		this.kursiyerYas = kursiyerYas;
		setAlinankurslar(alinankurslar);
	}
	public int getKursiyerID() {
		return kursiyerID;
	}
	public void setKursiyerID(int kursiyerID) {
		this.kursiyerID = kursiyerID;
	}
	public String getKursiyerAdSoyad() {
		return kursiyerAdSoyad;
	}
	public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
		this.kursiyerAdSoyad = kursiyerAdSoyad;
	}
	public int getKursiyerYas() {
		return kursiyerYas;
	}
	public void setKursiyerYas(int kursiyerYas) {
		this.kursiyerYas = kursiyerYas;
	}
	public List<Kurs> getAlinankurslar() {
		return alinankurslar;
	}
	public void setAlinankurslar(List<Kurs> alinankurslar) {
		this.alinankurslar = new ArrayList<Kurs>();
		for(int i = 0; i<alinankurslar.size(); i++)
		{
			this.alinankurslar.add(new Kurs(alinankurslar.get(i).getKursID(),alinankurslar.get(i).getKursAd()));
		}
	}
}

