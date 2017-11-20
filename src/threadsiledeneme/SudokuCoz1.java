package threadsiledeneme;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SudokuCoz1 {
    
 static int N = 9;
 

 static int dizimiz1[][] = Pencere.dizi1;
 
 
 static class Hucre {

  int satir, sutun;

  public Hucre(int satir, int sutun) 
  {
   super();
   this.satir = satir;
   this.sutun = sutun;
  }

  @Override
  public String toString() {
   return "Hucre [satir=" + satir + ", sutun=" + sutun + "]";
  }
 };
 
 private static void DosyayaEkle(String metin){
     try{
           File dosya = new File("C:\\USERS\\EMIL MAMMADOV\\DESKTOP\\yeni1.txt");
           FileWriter yazici = new FileWriter(dosya,true);
           BufferedWriter yaz = new BufferedWriter(yazici);
           yaz.write(metin);
           yaz.close();
           //System.out.println("Ekleme İşlemi Başarılı");
     }
     catch (Exception hata){
           hata.printStackTrace();
     }
}


 static boolean uygunMu(Hucre hucre, int deger) {

  if (dizimiz1[hucre.satir][hucre.sutun] != 0) {
   throw new RuntimeException(
     "Degeri zaten olan bir hucreyi cagiramazsiniz");
  }

  // Eger satir boyunca deger varsa false dondur
  for (int c = 0; c < 9; c++) {
   if (dizimiz1[hucre.satir][c] == deger)
    return false;
  }

  // Eger sutun boyunca deger varsa false dondur
  for (int r = 0; r < 9; r++) {
   if (dizimiz1[r][hucre.sutun] == deger)
    return false;
  }

  //Eger deger oldugu kutunun icinde varsa false dondur

  int x1 = 3 * (hucre.satir / 3);
  int y1 = 3 * (hucre.sutun / 3);
  int x2 = x1 + 2;
  int y2 = y1 + 2;

  for (int x = x1; x <= x2; x++)
   for (int y = y1; y <= y2; y++)
    if (dizimiz1[x][y] == deger)
     return false;

  // Eger deger hicbir yerde yoksa true dondur
  return true;
 }

 static Hucre sonrakiHucre(Hucre h) {

  int satir = h.satir;
  int sutun = h.sutun;

  sutun++;

  if (sutun > 8) {
   sutun = 0;
   satir++;
  }
     
  String a= "\r\nsatir:"+satir+" "+"sutun:"+sutun + "\n\r";
  DosyayaEkle(stringeata1());
      if (satir > 8)
      { 
          return null; 
      }
  
   

  Hucre siradaki = new Hucre(satir, sutun);
  return siradaki;
 }

 
 static boolean coz(Hucre h) {

  
  if (h == null)
   return true;

  
  if (dizimiz1[h.satir][h.sutun] != 0) {
   
   return coz(sonrakiHucre(h));
  }

  
  for (int i = 1; i <= 9; i++) {
   
   boolean uygun = uygunMu(h, i);

   if (!uygun) 
    continue;

   dizimiz1[h.satir][h.sutun] = i;

   boolean cozuldu = coz(sonrakiHucre(h));
   
   if (cozuldu)
    return true;
   else
    dizimiz1[h.satir][h.sutun] = 0;
  }

  return false;
 }
 
 static void diziYazdir(int dizimiz1[][]) {
	 for (int i = 0; i < 9; ++i) {
		    if (i % 3 == 0)
			System.out.println(" -----------------------");
		    for (int j = 0; j < 9; ++j) {
			if (j % 3 == 0) System.out.print("| ");
			System.out.print(dizimiz1[i][j] == 0 ? " " : Integer.toString(dizimiz1[i][j]));
			
			System.out.print(' ');
		    }
		    System.out.println("|");
		}
		System.out.println(" -----------------------");
 }
		
		
		static String stringeata1() {
			 String sudoku = "";
			 int i, j;
			 for(i = 0; i < 9; i++) {
				 for(j = 0; j < 9; j++) {
					 sudoku += dizimiz1[i][j];
				 }
				 sudoku+="\r\n";
			 }
			 sudoku+="\r\n";
			 sudoku+="\r\n";
			 return sudoku;
 }
}
