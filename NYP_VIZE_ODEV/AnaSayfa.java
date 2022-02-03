// https://github.com/Enderceliik
// Ender ÇELÝK

package NYP_VIZE_ODEV;
import java.util.Scanner;

public class AnaSayfa {
	public static void main(String[] args)
	{
		int StudentCounter = 10, LessonCounter = 20;
		System.out.println("Oluþturmak istediðiniz bölüm sayýsýný giriniz: ");
		Scanner reader = new Scanner(System.in);
		int variable = Integer.parseInt(reader.nextLine());
		
		Bolum[] Bolum = new Bolum[variable]; // Bolum dizisini oluþturdum
		
		for(int i = 0; i < Bolum.length; i++)
		{
			System.out.println(i + 1 + ". Bölümün numarasýný giriniz: ");
			int BolumNo = Integer.parseInt(reader.nextLine()); //i. Bölümün numarasýný kullanýcýdan alýp bolNo özelliðine iþledim.
			System.out.println(i + 1 + ". Bölümün adýný giriniz: ");
			String BolumAd = reader.nextLine(); //i. Bölümün adýný kullanýcýdan alýp bolAd özelliðine iþledim.
			System.out.println(BolumAd + " bölümünde bulunacak öðrenci sayýsýný giriniz: ");
			int OgrenciSayisi = Integer.parseInt(reader.nextLine());
			Bolum[i] = new Bolum(BolumNo,BolumAd); // i. indiste yeni nesne oluþturdum(her döngüde...)
			Bolum[i].setOgrenciler(OgrenciSayisi,StudentCounter); // Öðrenci sayýsýný kullanýcýdan alýp sonradan deðiþtirmek üzere o kadar sayýda Ogrenci nesnesi doldurdum.
			StudentCounter = OgrenciSayisi + StudentCounter; // ID için öðrenci sayacý. ID'ler 10'dan baþlýyor.
			
			for(int j = 0; j < OgrenciSayisi; j++) // Öðrenci bilgilerini kullanýcýdan aldýðým döngü
			{
				System.out.println(j + 1 + ". Öðrencinin adýný giriniz: ");
				String OgrAD = reader.nextLine();
				System.out.println(OgrAD + " isimli öðrencinin soyadýný giriniz: ");
				String OgrSOYAD = reader.nextLine();
				System.out.println(OgrAD + " isimli öðrencinin sýnýfýný giriniz: ");
				int OgrSINIF = Integer.parseInt(reader.nextLine());
				Bolum[i].ogrenciler[j].setOgrAd(OgrAD); // Set metotlarýný kullanarak en baþta doldurduðum Ogrenci nesnelerini olmasý gereken deðerlerle dolduruyorum.
				Bolum[i].ogrenciler[j].setOgrSoyad(OgrSOYAD);
				Bolum[i].ogrenciler[j].setOgrSinif(OgrSINIF);
				Bolum[i].ogrenciler[j].setBolNo(BolumNo); // Kullancýdan almadan direkt döngü indisinden faydalanýp o indisteki bölümü Ogrenci nesnesine iþliyorum.
				
			}
			System.out.println(BolumAd + " bölümünde açýlacak ders sayýsýný giriniz: ");
			int BolumDersAdet = Integer.parseInt(reader.nextLine());
			Bolum[i].setDersler(BolumDersAdet, LessonCounter); // Ders sayýsýný kullanýcýdan alýp sonradan deðiþtirmek üzere o kadar sayýda Ders nesnesi doldurdum.
			LessonCounter = LessonCounter + BolumDersAdet; // dersID için ders sayacý. ID'ler 30'den baþlýyor.
			for(int j = 0; j < BolumDersAdet; j++) // Ders bilgilerini kullanýcýdan aldýðým döngü
			{
				System.out.println(j + 1 + ". Dersin adýný giriniz: ");
				String DersAD = reader.nextLine(); 
				System.out.println(DersAD + " isimli dersin kredi bilgisini giriniz: ");
				int DersKredi = Integer.parseInt(reader.nextLine());
				Bolum[i].dersler[j].setDersAd(DersAD);
				Bolum[i].dersler[j].setDersKredi(DersKredi);
				Bolum[i].dersler[j].setBolNo(BolumNo);
			}
		
		}
		boolean condition = true; // While döngüsünde kullanmak için boolean deðer tanýmlýyorum.
		while(condition)
		{
			System.out.println(" 1 - Bölümlerin bilgilerini listele ");
			System.out.println(" 2 - Bölüm adýna göre arama yap ");
			System.out.println(" 3 - Öðrenci adýna göre arama yap ");
			System.out.println(" 4 - Ders adýna göre arama yap ");
			System.out.println(" 5 - Sýnýf bilgisine göre öðrencileri bul ");
			System.out.println(" 6 - Ders kredisine göre dersleri bul ");
			System.out.println(" 7 - Çýkýþ ");
			
			String Choice = reader.nextLine();
			switch(Choice)  //Ýþlemleri metotlar içerisine alýp case'lerden çaðýrarak daha anlaþýlabilir bir yapý elde etmeye çalýþtým.
			{
				case "1":
				{	
					TumBolumleriListele(Bolum);
					break;
				}
				case "2":
				{
					System.out.println("Aramak istediðiniz bölümün ismini büyük-küçük harf dikkat ederek giriniz: ");
					String searchBolum = reader.nextLine();
					SearchByDepartmentName(Bolum, searchBolum); //Dizimi ve Aranýlan bölümün ismini metoda gönderdim.
					break;
				}
				case "3":
				{
					System.out.println("Aramak istediðiniz öðrencinin ismini büyük-küçük harf dikkat ederek giriniz: ");
					String searchOgrenci = reader.nextLine();
					SearchByStudentName(Bolum, searchOgrenci); //Dizimi ve Aranýlan öðrenci ismini metoda gönderdim.
					break;
				}
				case "4":
				{
					System.out.println("Aramak istediðiniz dersin ismini büyük-küçük harf dikkat ederek giriniz: ");
					String searchLesson = reader.nextLine();
					SearchByLessonName(Bolum, searchLesson); //Dizimi ve Aranýlan ders ismini metoda gönderdim.
					break;
				}
				case "5":
				{	
					System.out.println("Aramak istediðiniz sýnýfý giriniz: ");
					int ClassNumber = Integer.parseInt(reader.nextLine());
					SearchByClassNumber(Bolum, ClassNumber); //Dizimi ve Aranýlan sýnýf deðerini metoda gönderdim.
					break;
				}
				case "6":
				{
					System.out.println("Taramak istediðiniz kredi bilgisini giriniz: ");
					int searchLessonCredit = Integer.parseInt(reader.nextLine());
					SearchByLessonCredit(Bolum, searchLessonCredit); //Dizimi ve Aranýlan kredi deðerini metoda gönderdim.
					break;
				}
				case "7":
				{
					condition = false; // Çýkýþ case'i
					break;
				}
			}	
		}
	reader.close(); // Daha veri almayacaðým için kapattým.
	}
	public static void TumBolumleriListele(Bolum [] Dizi)
	{
		for(int i = 0; i < Dizi.length; i++)
		{
			System.out.print("------------------------------------\n");
			System.out.println("Bölüm No: "+ Dizi[i].getBolNo() + " Bölüm Ad: " + Dizi[i].getBolAd());
			System.out.println("Öðrenciler: ");
			for(int j = 0; j < Dizi[i].ogrenciler.length; j++)
			{	
				System.out.println("	" + (j + 1) + ". Öðrenci: " + Dizi[i].ogrenciler[j].getOgrID() + " " + Dizi[i].ogrenciler[j].getOgrAd() + " " + Dizi[i].ogrenciler[j].getOgrSoyad() + " " + Dizi[i].ogrenciler[j].getOgrSinif());
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
				System.out.println("Bölüm No: "+ Dizi[i].getBolNo() + " Bölüm Ad: " + Dizi[i].getBolAd());
				System.out.println("Öðrenciler: ");
				for(int j = 0; j < Dizi[i].ogrenciler.length; j++)
				{	
					System.out.println("	" + (j + 1) + ". Öðrenci: " + Dizi[i].ogrenciler[j].getOgrID() + " " + Dizi[i].ogrenciler[j].getOgrAd() + " " + Dizi[i].ogrenciler[j].getOgrSoyad() + " " + Dizi[i].ogrenciler[j].getOgrSinif());
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
		System.out.println(searchDepartmen + " adýnda bir bölüm bulunmadý!");
		System.out.print("------------------------------------\n");
	}
	public static void SearchByStudentName(Bolum [] Dizi, String searchStudent)
	{
		int control = 0; //Herhangi bir eþleþme bulup bulmadýðýný kontrol edeceðimdeðiþkeni tanýmladým.
		for(int i = 0; i < Dizi.length; i++)
		{
			for(int j = 0; j<Dizi[i].ogrenciler.length; j++)
			{
				if(searchStudent.equals(Dizi[i].ogrenciler[j].getOgrAd())) // Hocam burada "isim" 
					//derken neyi kastettiðinizi tam anlayamadým. Pdf'teki "Öðrenci/öðrenciler" deki öðrenciler'den yola çýkýp 
					//ayný isim ve soyisme sahpi öðrenci çýkma ihtimali az olduðundan sadece "ad" kýyasý yaptým. Olasý bir yanlýþ
					//anlaþýlma ihtimaline karþýn isim+soyisim kýyasý yapan if'i de yorum satýrý olarak ekliyorum:
					//if(searchStudent.equals(Dizi[i].ogrenciler[j].getOgrAd()+ " "+ Dizi[i].ogrenciler[j].getOgrSoyad()))
				{
					System.out.print("------------------------------------\n");
					System.out.println(Dizi[i].ogrenciler[j].getOgrAd() + " adlý öðrencinin bilgileri:");
					System.out.println("Tam ismi: " + Dizi[i].ogrenciler[j].getOgrAd() +" "+ Dizi[i].ogrenciler[j].getOgrSoyad());
					System.out.println("ID: " + Dizi[i].ogrenciler[j].getOgrID());
					System.out.println("Sýnýf: " + Dizi[i].ogrenciler[j].getOgrSinif() + "\n");
					System.out.println("Bölüm: " + Dizi[i].getBolAd());
					System.out.println("Bölümünün numarasý: " + Dizi[i].ogrenciler[j].getBolNo());
					control = 1;
				}
			}
		}
		if(control ==  0)
		{
			System.out.print("\n------------------------------------\n");
			System.out.println(searchStudent + " adýnda bir öðreci bulunmadý!");
			System.out.print("------------------------------------\n");
			return;
		}
		System.out.print("------------------------------------\n");
	}
	public static void SearchByLessonName(Bolum [] Dizi, String searchLesson)
	{
		int control = 0; //Herhangi bir eþleþme bulup bulmadýðýný kontrol edeceðimdeðiþkeni tanýmladým.
		for(int i = 0; i < Dizi.length; i++)
		{
			for(int j = 0; j<Dizi[i].dersler.length; j++)
			{
				if(searchLesson.equals(Dizi[i].dersler[j].getDersAd()))
				{
					System.out.print("------------------------------------\n");
					System.out.println(Dizi[i].dersler[j].getDersAd() + " adlý dersin bilgileri:\n");
					System.out.println("ID: " + Dizi[i].dersler[j].getDersID());
					System.out.println("Kredi: " + Dizi[i].dersler[j].getDersKredi() + "\n");
					System.out.println("Bölüm: " + Dizi[i].getBolAd());
					System.out.println("Bölümünün numarasý: " + Dizi[i].dersler[j].getBolNo());
					control = 1;
				}
			}
		}
		if(control ==  0)
		{
			System.out.print("\n------------------------------------\n");
			System.out.println(searchLesson + " adýnda bir öðreci bulunmadý!");
			System.out.print("------------------------------------\n");
			return;
		}
		System.out.print("------------------------------------\n");
	}
	public static void SearchByClassNumber(Bolum [] Dizi, int ClassNumber)
	{
		int control = 0; //Herhangi bir eþleþme bulup bulmadýðýný kontrol edeceðimdeðiþkeni tanýmladým.
		for(int i = 0; i < Dizi.length; i++)
		{
			for(int j = 0; j<Dizi[i].ogrenciler.length; j++)
			{
				if(ClassNumber ==  Dizi[i].ogrenciler[j].getOgrSinif())
				{
					System.out.print("------------------------------------\n");
					System.out.println("Ýsim: " + Dizi[i].ogrenciler[j].getOgrAd()+" "+Dizi[i].ogrenciler[j].getOgrSoyad());
					System.out.println("ID: " + Dizi[i].ogrenciler[j].getOgrID());
					System.out.println("Bölümü: " + Dizi[i].getBolAd());
					control = 1;
				}
			}
		}
		if(control ==  0)
		{
			System.out.print("\n------------------------------------\n");
			System.out.println(ClassNumber + ". sýnýfta öðrenim gören herhangi bir öðreci bulunmadý!");
			System.out.print("------------------------------------\n");
			return;
		}
		System.out.print("------------------------------------\n");
	}
	public static void SearchByLessonCredit(Bolum [] Dizi, int searchLessonCredit)
	{
		int control = 0; //Herhangi bir eþleþme bulup bulmadýðýný kontrol edeceðimdeðiþkeni tanýmladým.
		for(int i = 0; i < Dizi.length; i++)
		{
			for(int j = 0; j<Dizi[i].dersler.length; j++)
			{
				if(searchLessonCredit == Dizi[i].dersler[j].getDersKredi())
				{
					System.out.print("------------------------------------\n");
					System.out.println(Dizi[i].dersler[j].getDersAd() + " adlý dersin bilgileri:");
					System.out.println("   ID: " + Dizi[i].dersler[j].getDersID());
					System.out.println("Kredi: " + Dizi[i].dersler[j].getDersKredi() + "\n");
					System.out.println("Bölüm: " + Dizi[i].getBolAd());
					System.out.println("Bölümünün numarasý: " + Dizi[i].dersler[j].getBolNo());
					control = 1;
				}
			}
		}
		if(control ==  0)
		{
			System.out.print("\n------------------------------------\n");
			System.out.println(searchLessonCredit + " kredide ders bulunmadý!");
			System.out.print("------------------------------------\n");
			return;
		}
		System.out.print("------------------------------------\n");
	}

}