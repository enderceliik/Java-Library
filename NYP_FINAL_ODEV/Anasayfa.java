// https://github.com/Enderceliik
// Ender ÇELÝK

package NYP_FINAL_ODEV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Anasayfa {
	public static void main(String[] args) {
		boolean wCondition = true;
		ArrayList <Kursiyer> Kursiyerler = new ArrayList<Kursiyer>();
		ArrayList<Kurs> Kurslar = new ArrayList<Kurs>();
		ArrayList <Kurs> KursListe = new ArrayList<Kurs>();
		
		IOProcces(Kurslar, KursListe, Kursiyerler); //Dosyadan okuma yaptýðým metodu çaðýrdýðým kýsým.
		
		while(wCondition) //Menü döngüsü
		{
			System.out.println("1 – Kurs Ekle\r\n"
					+ "2 – Kurs Listele\r\n"
					+ "3 – Kursiyer Ekle\r\n"
					+ "4 – Kursiyer Ara\r\n"
					+ "5 – Kursiyer Sil\r\n"
					+ "6 – Kursiyerleri Listele\r\n"
					+ "7 – Kursiyerleri Ayrýntýlý Listele\r\n"
					+ "8 - Kursiyerin Ödeyeceði Tutarý Hesapla\r\n"
					+ "9 - Çýkýþ");
			String sChoice;
			Scanner reader = new Scanner(System.in);
			sChoice = reader.nextLine();
			switch(sChoice)
			{
				case "1":
				{
					AddCourse(Kurslar); //Kurs Ekle metodu.
					break;
				}
				case "2":
				{
					ListOfKurslar(Kurslar); //Kurslarý listeleyen metot.
					break;
				}
				case "3":
				{
					AddTrainee(Kurslar, KursListe, Kursiyerler); //Kursiyer ekleme iþlemlerini içeren metot.
					break;
				}
				case "4":
				{
					SearchTrainee(Kursiyerler); //Kursiyer aramasý yaptýran metot.
					break;
				}
				case "5":
				{
					DeleteTrainee(Kursiyerler); //Kursiyer silme iþlemlerini içeren metot.
					break;
				}
				case "6":
				{
					ListOfKursiyer1(Kursiyerler); //Kursiyerleri listeleyen metot.
					break;
				}
				case "7":
				{
					ListOfKursiyer2(Kursiyerler); //Kursiyerleri ayrýntýlý listeleyen metot.
					break;
				}
				case "8":
				{
					CalculateFeeOfMonth(Kursiyerler); //Kursiyerlerin aylýk ücretlerini gösteren metot.
					break;
				}
				
				case "9":
				{
					ExitFunction(Kursiyerler,Kurslar); //ArrayListlerim'deki verileri dosyaya yazdýðým metot
					System.out.println("-- Çýkýþ yapýlýyor --");
					reader.close(); //Scanner nesnesini kapattým
					wCondition = false; //Menü koþulumu "false" yapýp case'den çýkýyorum
					break;
				}
						
			}
		}
	}
	public static void IOProcces(ArrayList<Kurs> Kurslar,ArrayList<Kurs> KursListe, ArrayList<Kursiyer> Kursiyerler) // Dosyadan okuma iþlemleri
	{
		try
		{	
			String line;
			File myfile = new File("kursiyer.txt");
			if(!myfile.exists())
			{
				myfile.createNewFile();
				return;
			}
			FileReader fr = new FileReader(myfile);
			BufferedReader br = new BufferedReader(fr);
			boolean fileNullControl = false;
			int Klistkontrol = 0;
			int kursiyerID = 0;
			String kursiyerAdSoyad = "";
			int kursiyerYas = 0;
			while((line = br.readLine()) != null)
			{
				String [] okunanlar = line.split("-"); // Split metodu ile "-" 'e göre parçalýyoruz
				if(okunanlar[0].startsWith("*")) //Okuduðum satýr kullanýcý bilgisi mi yoksa kurs bilgisi mi içeriyor onun kontrolü
				{
					if(Klistkontrol == 1) //Önce bir satýr kullanýcý verisi daha sonra belirsiz kurs bilgisi okuduðumdan x kursiyerinin verisini bir sonraki kursiyerin verisini okumaya baþlamadan önce arraylist'e ekliyorum.
					{
						Kursiyerler.add(new Kursiyer(kursiyerID, kursiyerAdSoyad, kursiyerYas, KursListe));
						KursListe.clear(); //Okurken geçici olarak kurslarý tuttuðum arraylist'i temizliyorum bir sonraki kursiyer için.
					}
						
					okunanlar[0] = okunanlar[0].substring(1, okunanlar[0].length());
					kursiyerID = Integer.parseInt(okunanlar[0]);
					kursiyerAdSoyad = okunanlar[1];
					kursiyerYas = Integer.parseInt(okunanlar[2]);
					Klistkontrol = 0;
				}
				else
				{
					okunanlar[0] = okunanlar[0].substring(1, okunanlar[0].length());
					int kursID = Integer.parseInt(okunanlar[0]);
					KursListe.add(new Kurs(kursID,okunanlar[1]));
					Klistkontrol = 1;
				}
				fileNullControl = true;
			}
			if(fileNullControl == true)
			{		
				Kursiyerler.add(new Kursiyer(kursiyerID, kursiyerAdSoyad, kursiyerYas, KursListe));//Son kursiyeri burada ekliyorum arraylist'e.
			}
			else
			{
				Kursiyerler.clear();
			}
			fr.close();
			br.close();
			
			File myfile1 = new File("kurs.txt");
			if(!myfile1.exists())		
				myfile1.createNewFile();
			FileReader FR = new FileReader(myfile1);
			BufferedReader BR = new BufferedReader(FR);
			
			while((line = BR.readLine()) != null)
			{
				String [] okunanlar = line.split("-"); // Split metodu ile "-" 'e göre parçalýyoruz	
				okunanlar[0] = okunanlar[0].substring(0, okunanlar[0].length());	
				int kursID = Integer.parseInt(okunanlar[0]);;
				String kursAd = okunanlar[1];
				Kurslar.add(new Kurs(kursID, kursAd)); //Kurslarý satýr satýr okuyup Kurslar ArrayList'ime ekliyorum.
			}
			FR.close();
			BR.close();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void AddCourse(ArrayList<Kurs> Kurslar) //1 Kurs ekleme metodu
	{
		Scanner reader = new Scanner(System.in);
		while(true)
		{
			boolean c = false;
			try
			{
				System.out.println("Oluþturmak istediðiniz kursun ID bilgisini giriniz: ");
				int ID = Integer.parseInt(reader.next());
				for(Kurs obj : Kurslar)
				{
					if(obj.getKursID() == ID)
					{
						System.out.println(obj.getKursID());
						System.out.println("Girmiþ olduðunuz ID'de mevcut bir kurs bulunmaktadýr. Lütfen baþka bir deðer girmeyi deneyin!");
						c = true;
						break;
					}
				}
				if(c == true)
				{
					continue;
				}
				System.out.println("Oluþturmak istediðiniz kursun Ad bilgisini giriniz");
				String KursAd = StringAlma();
				Kurslar.add(new Kurs(ID, KursAd));					
			}
			catch(NumberFormatException e)
			{
				System.out.println("Lütfen Integer bir deðer giriniz");
				continue;
			}
			break;
		}
	}
	public static void ListOfKurslar(ArrayList <Kurs> Liste) //2 Kurslarý listeleyen metot.
	{
		if(Liste.size() != 0)
		{
			System.out.println("\n----------------------");
			System.out.println("Kurs ID - Kurs Ad");
			for(int i=0; i<Liste.size(); i++)
			{
				System.out.println(" " + Liste.get(i).getKursID() + "      " + Liste.get(i).getKursAd());
			}
			System.out.println("----------------------");
		}
		else
		{
			System.out.println("Listelenebilecek herhangi bir kurs kaydý yoktur\n-- Ana Menüye Yönlendiriliyorsunuz --\n-------------------------------------");
		}
	}
	public static void AddTrainee(ArrayList<Kurs> Kurslar, ArrayList<Kurs> KursListe, ArrayList<Kursiyer> Kursiyerler)//3 Kursiyer kaydý yapýlan metot.
	{
		if(Kurslar.size() != 0)
		{
			Scanner reader = new Scanner(System.in);
			while(true)
			{
				boolean c = false;
				System.out.println("Oluþturmak istediðiniz kursiyerin ID bilgisini giriniz: ");
				int kursiyerID = Integer.parseInt(reader.next());
				for(Kursiyer obj : Kursiyerler)
				{
					if(obj.getKursiyerID() == kursiyerID) //Girilen ID zaten mevcut mu?
					{
						System.out.println("Girmiþ olduðunuz ID'de mevcut bir kursiyer bulunmaktadýr. Lütfen baþka bir deðer girmeyi deneyin!");
						c = true;
						break;
					}
				}
				if(c == true)
				{
					continue;
				}
				System.out.println("Yeni kursiyerin adýný ve soyadýný giriniz: ");
				String kursiyerAdSoyad = StringAlma();
				System.out.println("Yeni kursiyerin yaþýný giriniz: ");
				int kursiyerYas = Integer.parseInt(reader.next());
				int kursAdet = 0;
				while(true)
				{
					System.out.println("Yeni kursiyeri kaydetmek istediðiniz kurs adedini giriniz: ");
					kursAdet = reader.nextInt();
					if(kursAdet < 1)
					{
						System.out.println("Lütfen mantýklý deðerler girmeye dikkat ediniz!\n----------------------");
						continue;
					}
					else if(kursAdet > Kurslar.size()) //Kursiyeri mevcuttaki kurs sayýsýndan fazla kursa kaydedebilmek mümkün deðil kontrolü.
					{
						System.out.println("Lütfen mantýklý deðerler girmeye dikkat ediniz!\nKursiyeri kayýt etmek istediðiniz kadar kurs bünyemizde bulunmamaktadýr. Mevcut kurs sayýmýz: " + Kurslar.size() + "\n----------------------------------------------------------" );
						continue;
					}
					else
					{
						break;
					}
				}
				KursListe.clear();
				for(int i = 0; i<kursAdet; i++)
				{
					boolean control = false;
					boolean control2 = false;
					System.out.println("Eklemek istediðiniz " + (i + 1) +". kursun ID'sini girin: ");
					int kursID = reader.nextInt();
					for(Kurs obj : Kurslar) //Kurslar'ýn bulunduðu list'in içinde böyle bir ID var mý döngüsü
						{
							if(obj.getKursID() == kursID) //O ID'de bir kurs var
							{
								for(Kurs obj2 : KursListe) //Ayný ID'yi iki kez mi ekliyor kontrolü için KursListesi içinde döngü
								{
									if(obj2.getKursID() == kursID) //Ayný ID zaten eklenmiþ geçici listeme
									{
										control2 = true;
										break;
									}
								}
								if(control2 == true)
								{
									control = true;
									control2 = false;
									break;
								}
								KursListe.add(new Kurs(kursID, obj.getKursAd()));
								control = true;
								control2 = true;
							}
						}
					if(control == false)
					{
						System.out.println("Girmiþ olduðunuz ID'de herhangi bir kurs bulunmamaktadýr!");
						i--;
						continue;
					}
					if(control2 == false)
					{
						System.out.println("Ayný ID'de ikinci bir kurs eklemeyi denediniz! Lütfen tekrar kurs ID'si giriniz! ");
						i--;
						continue;
					}	
				}
				Kursiyerler.add(new Kursiyer(kursiyerID, kursiyerAdSoyad, kursiyerYas, KursListe));
				break;
			}
		}
		else
		{
			System.out.println("Kursiyer kaydedebileceðiniz herhangi bir kursumuz yoktur. Öncelikle kurs ekleyiniz!\n-- Ana Menüye Yönlendiriliyorsunuz --\n-------------------------------------");
		}
	}
	public static void SearchTrainee(ArrayList<Kursiyer> Kursiyerler) //4
	{
		if(Kursiyerler.size() != 0)
		{
			System.out.println("Aratmak istediðiniz kursiyerin adýný ve soyadýný giriniz:\n(Ad ve soyadý listeleme seçeceneðindeki gibi yazmaya özen gösteriniz) ");
			String TraineeName = StringAlma();
			boolean control = false;
			for(Kursiyer obj : Kursiyerler)
			{
				if(TraineeName.equals(obj.getKursiyerAdSoyad()))
				{
					System.out.println("Aratmýþ olduðunuz kursiyerin ID, yaþ ve aldýðý kurslarýn bilgileri:\n----------------------");	
					System.out.println("Kursiyer ID: " + obj.getKursiyerID());
					System.out.println("Kursiyer Ad Soyad: " + obj.getKursiyerAdSoyad());
					System.out.println("Kursiyer Yaþ: " + obj.getKursiyerYas());
					System.out.println("Kayýtlý olduðu kurslar: ");
					for(int j = 0; j<obj.getAlinankurslar().size(); j++)
					{	
						System.out.println(obj.getAlinankurslar().get(j).getKursID() + " " + obj.getAlinankurslar().get(j).getKursAd());
					}
					System.out.println("--------------------------");
					control = true;
				}
			}
			if(control == false)
			{
				System.out.println("Aradýðýnýz isimde bir kursiyer kaydý yoktur\n-- Ana Menüye Yönlendiriliyorsunuz --\n-------------------------------------");
			}
		}
		else
		{
			System.out.println("Aranabilecek herhangi bir kursiyer kaydý yoktur\n-- Ana Menüye Yönlendiriliyorsunuz --\n-------------------------------------");
		}
	}
	public static void DeleteTrainee(ArrayList<Kursiyer> Kursiyerler)//5
	{
		if(Kursiyerler.size() != 0)
		{
			Scanner reader = new Scanner(System.in);
			boolean control = false;
			System.out.println("Silmek istediðiniz kursiyerin ID'sini giriniz: ");
			int kursiyerID = reader.nextInt();
			for(Kursiyer obj : Kursiyerler)
			{
				if(obj.getKursiyerID() == kursiyerID)
				{
					Kursiyerler.remove(Kursiyerler.indexOf(obj));
					System.out.println("Silme iþlemi baþarýlya gerçekleþtirilmiþtir\n-- Ana Menüye Yönlendiriliyorsunuz --\n-------------------------------------");
					control = true;
					break;
				}							
			}
			if(control == false)
			{
				System.out.println("Girdiðiniz ID'de herhangi bir kursiyer bulunmamaktadýr!\n-- Ana Menüye Yönlendiriliyorsunuz --\n-------------------------------------");
			}
		}
		else
		{
			System.out.println("Silinebilecek herhangi bir kursiyer kaydý yoktur\n-- Ana Menüye Yönlendiriliyorsunuz --\n-------------------------------------");
		}
	}
	public static void ListOfKursiyer1(ArrayList <Kursiyer> Liste) //6
	{
		if(Liste.size() != 0)
		{
			for(int i = 0; i<Liste.size(); i++)
			{
				{
					System.out.println("Kursiyer ID: " + Liste.get(i).getKursiyerID());
					System.out.println("Kursiyer Ad Soyad: " + Liste.get(i).getKursiyerAdSoyad());
					System.out.println("Kursiyer Yaþ: " + Liste.get(i).getKursiyerYas());
					System.out.println("--------------------------");
				}
			}
		}
		else
		{
			System.out.println("Listelenebilecek herhangi bir kursiyer kaydý yoktur\n-- Ana Menüye Yönlendiriliyorsunuz --\n-------------------------------------");
		}
	}
	public static void ListOfKursiyer2(ArrayList <Kursiyer> Liste) //7
	{
		if(Liste.size() != 0)
		{
			for(int i = 0; i<Liste.size(); i++)
			{
				System.out.println("Kursiyer ID: " + Liste.get(i).getKursiyerID());
				System.out.println("Kursiyer Ad Soyad: " + Liste.get(i).getKursiyerAdSoyad());
				System.out.println("Kursiyer Yaþ: " + Liste.get(i).getKursiyerYas());
				for(int j = 0; j<Liste.get(i).getAlinankurslar().size(); j++)
				{	
					System.out.println("   " + Liste.get(i).getAlinankurslar().get(j).getKursID() + " " + Liste.get(i).getAlinankurslar().get(j).getKursAd());
				}
				System.out.println("--------------------------");
			}
		}
		else
		{
			System.out.println("Listelenebilecek herhangi bir kursiyer kaydý yoktur\n-- Ana Menüye Yönlendiriliyorsunuz --\n-------------------------------------");
		}
	}
	public static void CalculateFeeOfMonth(ArrayList <Kursiyer> Liste) //8
	{
		Scanner reader = new Scanner(System.in);
		if(Liste.size() != 0)
		{
			System.out.println("Aylýk ücretini hesaplatmak istediðiniz kursiyerin ID'sini giriniz: ");
			int ID = reader.nextInt();
			boolean control = false;
			int ucret;
			for(Kursiyer obj : Liste)
			{
				if(obj.getKursiyerID() == ID)
				{
					if(obj.getAlinankurslar().size() == 1)
					{
						ucret = 400; // Haftalýk 100 * 4 = 400
						System.out.println(ID + " ID'li kursiyer tek bir kursa kayýtlý olduðundan herhangi bir kampanyadan faydalanamamaktadýr\nAylýk ücreti: " + ucret + " TL'dir");
					}
					else if(obj.getAlinankurslar().size() == 2)
					{
						ucret = 740; //[1. kurs:] 400 + [ikinci kurs:] 400 - (400*15/100) = 740
						System.out.println(ID + " ID'li kursiyer iki kursa kayýtlý olduðundan Kampanya 1'den faydalanmaktadýr\nAylýk ücreti: " + ucret + " TL'dir");
					}
					else if(obj.getAlinankurslar().size() == 3)
					{
						ucret = 1100; //[1. kurs:] 400 + [ikinci kurs:] 400  + [üçüncü kurs:] 400 - (400*25/100) = 1100
						System.out.println(ID + " ID'li kursiyer üç kursa kayýtlý olduðundan Kampanya 2'den faydalanmaktadýr\nAylýk ücreti: " + ucret + " TL'dir");
					}
					else if(obj.getAlinankurslar().size() > 3) 
					{
						ucret = obj.getAlinankurslar().size() * 360; // [Her kurs:] 400 - (400*10/100) = 360 : kurs sayisi * 360 = ...
						System.out.println(ID + " ID'li kursiyer üçten fazla kursa kayýtlý olduðundan Kampanya 3'ten faydalanmaktadýr\nAylýk ücreti: " + ucret + " TL'dir");
					}
					control = true;
					break;
				}							
			}
			if(control == false)
			{
				System.out.println("Girdiðiniz ID'de herhangi bir kursiyer bulunmamaktadýr!\n-- Ana Menüye Yönlendiriliyorsunuz --\n-------------------------------------");
			}
		}
		else
		{
			System.out.println("Ücreti hesaplanabilecek herhangi bir kursiyer kaydý yoktur\n-- Ana Menüye Yönlendiriliyorsunuz --\n-------------------------------------");
		}	
	}
	public static void ExitFunction(ArrayList<Kursiyer> Liste, ArrayList<Kurs> Liste2) //9
	{
		try
		{
			File my_file = new File("kursiyer.txt");
			if(!my_file.exists())
				my_file.createNewFile();
			FileWriter fw = new FileWriter(my_file);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Kursiyer obj : Liste)
			{
				bw.write("*"+obj.getKursiyerID()+"-"+obj.getKursiyerAdSoyad()+"-"+obj.getKursiyerYas()+"\n");
				for(int i=0; i<obj.getAlinankurslar().size(); i++)
				{
					bw.write("%"+obj.getAlinankurslar().get(i).getKursID()+"-"+obj.getAlinankurslar().get(i).getKursAd()+"\n");
				}
			}
			bw.close();	
			
			File my_file1 = new File("kurs.txt");
			if(!my_file.exists())
				my_file.createNewFile();
			FileWriter FW = new FileWriter(my_file1);
			BufferedWriter BW = new BufferedWriter(FW);
			for(Kurs obj : Liste2)
			{
				BW.write(obj.getKursID()+"-"+obj.getKursAd()+"\n");
			}
			BW.close();	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}	
	public static String StringAlma()
	{
		Scanner reader = new Scanner(System.in);
		String variable = reader.nextLine();
		return variable;
	}
}
