// https://github.com/Enderceliik
// Ender �EL�K

package NYP_VIZE_ODEV;
import java.util.Scanner;

public class AnaSayfa {
	public static void main(String[] args)
	{
		int StudentCounter = 10, LessonCounter = 20;
		System.out.println("Olu�turmak istedi�iniz b�l�m say�s�n� giriniz: ");
		Scanner reader = new Scanner(System.in);
		int variable = Integer.parseInt(reader.nextLine());
		
		Bolum[] Bolum = new Bolum[variable]; // Bolum dizisini olu�turdum
		
		for(int i = 0; i < Bolum.length; i++)
		{
			System.out.println(i + 1 + ". B�l�m�n numaras�n� giriniz: ");
			int BolumNo = Integer.parseInt(reader.nextLine()); //i. B�l�m�n numaras�n� kullan�c�dan al�p bolNo �zelli�ine i�ledim.
			System.out.println(i + 1 + ". B�l�m�n ad�n� giriniz: ");
			String BolumAd = reader.nextLine(); //i. B�l�m�n ad�n� kullan�c�dan al�p bolAd �zelli�ine i�ledim.
			System.out.println(BolumAd + " b�l�m�nde bulunacak ��renci say�s�n� giriniz: ");
			int OgrenciSayisi = Integer.parseInt(reader.nextLine());
			Bolum[i] = new Bolum(BolumNo,BolumAd); // i. indiste yeni nesne olu�turdum(her d�ng�de...)
			Bolum[i].setOgrenciler(OgrenciSayisi,StudentCounter); // ��renci say�s�n� kullan�c�dan al�p sonradan de�i�tirmek �zere o kadar say�da Ogrenci nesnesi doldurdum.
			StudentCounter = OgrenciSayisi + StudentCounter; // ID i�in ��renci sayac�. ID'ler 10'dan ba�l�yor.
			
			for(int j = 0; j < OgrenciSayisi; j++) // ��renci bilgilerini kullan�c�dan ald���m d�ng�
			{
				System.out.println(j + 1 + ". ��rencinin ad�n� giriniz: ");
				String OgrAD = reader.nextLine();
				System.out.println(OgrAD + " isimli ��rencinin soyad�n� giriniz: ");
				String OgrSOYAD = reader.nextLine();
				System.out.println(OgrAD + " isimli ��rencinin s�n�f�n� giriniz: ");
				int OgrSINIF = Integer.parseInt(reader.nextLine());
				Bolum[i].ogrenciler[j].setOgrAd(OgrAD); // Set metotlar�n� kullanarak en ba�ta doldurdu�um Ogrenci nesnelerini olmas� gereken de�erlerle dolduruyorum.
				Bolum[i].ogrenciler[j].setOgrSoyad(OgrSOYAD);
				Bolum[i].ogrenciler[j].setOgrSinif(OgrSINIF);
				Bolum[i].ogrenciler[j].setBolNo(BolumNo); // Kullanc�dan almadan direkt d�ng� indisinden faydalan�p o indisteki b�l�m� Ogrenci nesnesine i�liyorum.
				
			}
			System.out.println(BolumAd + " b�l�m�nde a��lacak ders say�s�n� giriniz: ");
			int BolumDersAdet = Integer.parseInt(reader.nextLine());
			Bolum[i].setDersler(BolumDersAdet, LessonCounter); // Ders say�s�n� kullan�c�dan al�p sonradan de�i�tirmek �zere o kadar say�da Ders nesnesi doldurdum.
			LessonCounter = LessonCounter + BolumDersAdet; // dersID i�in ders sayac�. ID'ler 30'den ba�l�yor.
			for(int j = 0; j < BolumDersAdet; j++) // Ders bilgilerini kullan�c�dan ald���m d�ng�
			{
				System.out.println(j + 1 + ". Dersin ad�n� giriniz: ");
				String DersAD = reader.nextLine(); 
				System.out.println(DersAD + " isimli dersin kredi bilgisini giriniz: ");
				int DersKredi = Integer.parseInt(reader.nextLine());
				Bolum[i].dersler[j].setDersAd(DersAD);
				Bolum[i].dersler[j].setDersKredi(DersKredi);
				Bolum[i].dersler[j].setBolNo(BolumNo);
			}
		
		}
		boolean condition = true; // While d�ng�s�nde kullanmak i�in boolean de�er tan�ml�yorum.
		while(condition)
		{
			System.out.println(" 1 - B�l�mlerin bilgilerini listele ");
			System.out.println(" 2 - B�l�m ad�na g�re arama yap ");
			System.out.println(" 3 - ��renci ad�na g�re arama yap ");
			System.out.println(" 4 - Ders ad�na g�re arama yap ");
			System.out.println(" 5 - S�n�f bilgisine g�re ��rencileri bul ");
			System.out.println(" 6 - Ders kredisine g�re dersleri bul ");
			System.out.println(" 7 - ��k�� ");
			
			String Choice = reader.nextLine();
			switch(Choice)  //��lemleri metotlar i�erisine al�p case'lerden �a��rarak daha anla��labilir bir yap� elde etmeye �al��t�m.
			{
				case "1":
				{	
					TumBolumleriListele(Bolum);
					break;
				}
				case "2":
				{
					System.out.println("Aramak istedi�iniz b�l�m�n ismini b�y�k-k���k harf dikkat ederek giriniz: ");
					String searchBolum = reader.nextLine();
					SearchByDepartmentName(Bolum, searchBolum); //Dizimi ve Aran�lan b�l�m�n ismini metoda g�nderdim.
					break;
				}
				case "3":
				{
					System.out.println("Aramak istedi�iniz ��rencinin ismini b�y�k-k���k harf dikkat ederek giriniz: ");
					String searchOgrenci = reader.nextLine();
					SearchByStudentName(Bolum, searchOgrenci); //Dizimi ve Aran�lan ��renci ismini metoda g�nderdim.
					break;
				}
				case "4":
				{
					System.out.println("Aramak istedi�iniz dersin ismini b�y�k-k���k harf dikkat ederek giriniz: ");
					String searchLesson = reader.nextLine();
					SearchByLessonName(Bolum, searchLesson); //Dizimi ve Aran�lan ders ismini metoda g�nderdim.
					break;
				}
				case "5":
				{	
					System.out.println("Aramak istedi�iniz s�n�f� giriniz: ");
					int ClassNumber = Integer.parseInt(reader.nextLine());
					SearchByClassNumber(Bolum, ClassNumber); //Dizimi ve Aran�lan s�n�f de�erini metoda g�nderdim.
					break;
				}
				case "6":
				{
					System.out.println("Taramak istedi�iniz kredi bilgisini giriniz: ");
					int searchLessonCredit = Integer.parseInt(reader.nextLine());
					SearchByLessonCredit(Bolum, searchLessonCredit); //Dizimi ve Aran�lan kredi de�erini metoda g�nderdim.
					break;
				}
				case "7":
				{
					condition = false; // ��k�� case'i
					break;
				}
			}	
		}
	reader.close(); // Daha veri almayaca��m i�in kapatt�m.
	}
	public static void TumBolumleriListele(Bolum [] Dizi)
	{
		for(int i = 0; i < Dizi.length; i++)
		{
			System.out.print("------------------------------------\n");
			System.out.println("B�l�m No: "+ Dizi[i].getBolNo() + " B�l�m Ad: " + Dizi[i].getBolAd());
			System.out.println("��renciler: ");
			for(int j = 0; j < Dizi[i].ogrenciler.length; j++)
			{	
				System.out.println("	" + (j + 1) + ". ��renci: " + Dizi[i].ogrenciler[j].getOgrID() + " " + Dizi[i].ogrenciler[j].getOgrAd() + " " + Dizi[i].ogrenciler[j].getOgrSoyad() + " " + Dizi[i].ogrenciler[j].getOgrSinif());
			}
			System.out.println("Dersler: ");
			for(int j = 0; j < Dizi[i].dersler.length; j++)
			{	
				System.out.println("	"+ (j + 1) + ". Ders: " + Dizi[i].dersler[j].getDersID() + " " + Dizi[i].dersler[j].getDersAd() + " " + Dizi[i].dersler[j].getDersKredi());
			}
			
		}
		System.out.print("------------------------------------\n");
	}
	public static void SearchByDepartmentName(Bolum [] Dizi, String searchDepartmen)
	{
		for(int i = 0; i < Dizi.length; i++)
		{
			if(searchDepartmen.equals(Dizi[i].getBolAd())) 
			{	
				System.out.print("\n------------------------------------\n");
				System.out.println("B�l�m No: "+ Dizi[i].getBolNo() + " B�l�m Ad: " + Dizi[i].getBolAd());
				System.out.println("��renciler: ");
				for(int j = 0; j < Dizi[i].ogrenciler.length; j++)
				{	
					System.out.println("	" + (j + 1) + ". ��renci: " + Dizi[i].ogrenciler[j].getOgrID() + " " + Dizi[i].ogrenciler[j].getOgrAd() + " " + Dizi[i].ogrenciler[j].getOgrSoyad() + " " + Dizi[i].ogrenciler[j].getOgrSinif());
				}
				System.out.println("Dersler: ");
				for(int j = 0; j < Dizi[i].dersler.length; j++)
				{	
					System.out.println("	" + (j + 1) + ". Ders: " + Dizi[i].dersler[j].getDersID() + " " + Dizi[i].dersler[j].getDersAd() + " " + Dizi[i].dersler[j].getDersKredi());
				}
				System.out.print("------------------------------------\n");
				return;
			}	
		}
		System.out.print("\n------------------------------------\n");
		System.out.println(searchDepartmen + " ad�nda bir b�l�m bulunmad�!");
		System.out.print("------------------------------------\n");
	}
	public static void SearchByStudentName(Bolum [] Dizi, String searchStudent)
	{
		int control = 0; //Herhangi bir e�le�me bulup bulmad���n� kontrol edece�imde�i�keni tan�mlad�m.
		for(int i = 0; i < Dizi.length; i++)
		{
			for(int j = 0; j<Dizi[i].ogrenciler.length; j++)
			{
				if(searchStudent.equals(Dizi[i].ogrenciler[j].getOgrAd())) // Hocam burada "isim" 
					//derken neyi kastetti�inizi tam anlayamad�m. Pdf'teki "��renci/��renciler" deki ��renciler'den yola ��k�p 
					//ayn� isim ve soyisme sahpi ��renci ��kma ihtimali az oldu�undan sadece "ad" k�yas� yapt�m. Olas� bir yanl��
					//anla��lma ihtimaline kar��n isim+soyisim k�yas� yapan if'i de yorum sat�r� olarak ekliyorum:
					//if(searchStudent.equals(Dizi[i].ogrenciler[j].getOgrAd()+ " "+ Dizi[i].ogrenciler[j].getOgrSoyad()))
				{
					System.out.print("------------------------------------\n");
					System.out.println(Dizi[i].ogrenciler[j].getOgrAd() + " adl� ��rencinin bilgileri:");
					System.out.println("Tam ismi: " + Dizi[i].ogrenciler[j].getOgrAd() +" "+ Dizi[i].ogrenciler[j].getOgrSoyad());
					System.out.println("ID: " + Dizi[i].ogrenciler[j].getOgrID());
					System.out.println("S�n�f: " + Dizi[i].ogrenciler[j].getOgrSinif() + "\n");
					System.out.println("B�l�m: " + Dizi[i].getBolAd());
					System.out.println("B�l�m�n�n numaras�: " + Dizi[i].ogrenciler[j].getBolNo());
					control = 1;
				}
			}
		}
		if(control ==  0)
		{
			System.out.print("\n------------------------------------\n");
			System.out.println(searchStudent + " ad�nda bir ��reci bulunmad�!");
			System.out.print("------------------------------------\n");
			return;
		}
		System.out.print("------------------------------------\n");
	}
	public static void SearchByLessonName(Bolum [] Dizi, String searchLesson)
	{
		int control = 0; //Herhangi bir e�le�me bulup bulmad���n� kontrol edece�imde�i�keni tan�mlad�m.
		for(int i = 0; i < Dizi.length; i++)
		{
			for(int j = 0; j<Dizi[i].dersler.length; j++)
			{
				if(searchLesson.equals(Dizi[i].dersler[j].getDersAd()))
				{
					System.out.print("------------------------------------\n");
					System.out.println(Dizi[i].dersler[j].getDersAd() + " adl� dersin bilgileri:\n");
					System.out.println("ID: " + Dizi[i].dersler[j].getDersID());
					System.out.println("Kredi: " + Dizi[i].dersler[j].getDersKredi() + "\n");
					System.out.println("B�l�m: " + Dizi[i].getBolAd());
					System.out.println("B�l�m�n�n numaras�: " + Dizi[i].dersler[j].getBolNo());
					control = 1;
				}
			}
		}
		if(control ==  0)
		{
			System.out.print("\n------------------------------------\n");
			System.out.println(searchLesson + " ad�nda bir ��reci bulunmad�!");
			System.out.print("------------------------------------\n");
			return;
		}
		System.out.print("------------------------------------\n");
	}
	public static void SearchByClassNumber(Bolum [] Dizi, int ClassNumber)
	{
		int control = 0; //Herhangi bir e�le�me bulup bulmad���n� kontrol edece�imde�i�keni tan�mlad�m.
		for(int i = 0; i < Dizi.length; i++)
		{
			for(int j = 0; j<Dizi[i].ogrenciler.length; j++)
			{
				if(ClassNumber ==  Dizi[i].ogrenciler[j].getOgrSinif())
				{
					System.out.print("------------------------------------\n");
					System.out.println("�sim: " + Dizi[i].ogrenciler[j].getOgrAd()+" "+Dizi[i].ogrenciler[j].getOgrSoyad());
					System.out.println("ID: " + Dizi[i].ogrenciler[j].getOgrID());
					System.out.println("B�l�m�: " + Dizi[i].getBolAd());
					control = 1;
				}
			}
		}
		if(control ==  0)
		{
			System.out.print("\n------------------------------------\n");
			System.out.println(ClassNumber + ". s�n�fta ��renim g�ren herhangi bir ��reci bulunmad�!");
			System.out.print("------------------------------------\n");
			return;
		}
		System.out.print("------------------------------------\n");
	}
	public static void SearchByLessonCredit(Bolum [] Dizi, int searchLessonCredit)
	{
		int control = 0; //Herhangi bir e�le�me bulup bulmad���n� kontrol edece�imde�i�keni tan�mlad�m.
		for(int i = 0; i < Dizi.length; i++)
		{
			for(int j = 0; j<Dizi[i].dersler.length; j++)
			{
				if(searchLessonCredit == Dizi[i].dersler[j].getDersKredi())
				{
					System.out.print("------------------------------------\n");
					System.out.println(Dizi[i].dersler[j].getDersAd() + " adl� dersin bilgileri:");
					System.out.println("   ID: " + Dizi[i].dersler[j].getDersID());
					System.out.println("Kredi: " + Dizi[i].dersler[j].getDersKredi() + "\n");
					System.out.println("B�l�m: " + Dizi[i].getBolAd());
					System.out.println("B�l�m�n�n numaras�: " + Dizi[i].dersler[j].getBolNo());
					control = 1;
				}
			}
		}
		if(control ==  0)
		{
			System.out.print("\n------------------------------------\n");
			System.out.println(searchLessonCredit + " kredide ders bulunmad�!");
			System.out.print("------------------------------------\n");
			return;
		}
		System.out.print("------------------------------------\n");
	}

}