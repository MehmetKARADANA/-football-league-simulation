import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
      Lig lig = new Lig();
  lig.takim_listele();
  lig.grup();
    // Scanner scanner=new Scanner(System.in);
     // Lig.takim_listele("Trabzonspor",Lig.takimler,Lig.takimler2);//çalıştı
// ev takımın gösterilen gücü ev gücüdür 
//taraftar + etki sağladığı gibi - etkide sağlayabilir
/* 
     String islemler="1. Fikstür Çekimi \n"
     +"2. Takımları Listele \n"
     +"3.  Çıkış \n  "
     ;
    System.out.println("M.K lİG");

    while(true){
        System.out.println(islemler);
        int islem;
       try {
        System.out.println("İşlem seçiniz: ");
        islem = scanner.nextInt();

        if (islem == 1) {
            lig.grup();
        } else if (islem == 2) {
            lig.takim_listele();
        } else if (islem == 3) {
            break;
        } else {
            System.out.println("Geçersiz bir işlem seçtiniz.");
        }
    } catch (InputMismatchException e) {//girdi int değilse
        System.out.println("Geçersiz girdi. Bir tam sayı girmelisiniz...");
        scanner.next(); 
    }
    
    }
    scanner.close();
   System.out.println("Programdan çıkış yapıldı...");
   */
    }

}
