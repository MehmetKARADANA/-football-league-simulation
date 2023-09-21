import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Lig {

  public ArrayList<Takim> takimler = new ArrayList<Takim>();
  public ArrayList<Takim> takimler2 = new ArrayList<Takim>();

  public String[] tffTakimlari = {
      "null",
      "Beşiktaş",
      "Fenerbahçe",
      "Galatasaray",
      "Trabzonspor",
      "Başakşehir",
      "Antalyaspor",
      "Gaziantep FK",
      "Alanyaspor",
      "Konyaspor",
      "Rizespor",
      "Hatayspor",
      "Göztepe",
      "Adana DS",
      "Gençlerbirliği",
      "Malatyaspor",
      "Kayserispor",
      "Ankaragücü",
      "Erzurumspor"
  };

  public Lig() {

    for (int i = 0; i < 9; i++) {
      takimler.add(new Takim());
      takimler2.add(new Takim());

    }

    for (int i = 0; i < 9; i++) {
      takimler.get(i).setAd(tffTakimlari[2 * i + 1]);
      takimler2.get(i).setAd(tffTakimlari[2 * i + 2]);
    }
  }

  public void grup() {
    for (int j = 0; j < 17; j++) {
      System.out.println(j + 1 + ".Hafta Karşılaşmaları");
      System.out.println("Ev T  -  Misafir T");
      for (int i = 0; i < 9; i++) {
        System.out.println(takimler.get(i).getAd() + "-" + takimler2.get(i).getAd());
      }
      System.out.println("     ********");
      System.out.println(j + 1 + ".Hafta Karşılaşma sonuçları");
      System.out.println(" Ev Takımı                 Misafir Takım");
      for (int i = 0; i < 9; i++) {
        this.macYap(takimler.get(i), takimler2.get(i));
      }
      System.out.println();
      System.out.println(j + 1 + ".Hafta Puan Sıralaması:");
      System.out.println("Güç          İsim       Maç İstatistikleri");
      istatistikler(takimler2, takimler);
      System.out.println("     ********");
      System.out.println("");

      // Emre bey algoritmasına göre dizilere yaptığımız işlem
      takimler.add(1, takimler2.get(0));
      takimler2.remove(0);
      takimler2.add(8, takimler.get(9));
      takimler.remove(9);
      System.out.println("        ********");
      System.out.println("             ");
      try {
        Thread.sleep(3000); // 3 saniye beklet
      } catch (InterruptedException e) {

        e.printStackTrace();
      }

    }
    // ev tarafını değiştirmek için son hale getiriyoruz
    // bir kere daha çalıştı arraylistler başa döndü
    takimler.add(1, takimler2.get(0));
    takimler2.remove(0);
    takimler2.add(8, takimler.get(9));
    takimler.remove(9);

    for (int j = 17; j < 34; j++) {
      System.out.println(j + 1 + ".Hafta Karşılaşmaları");
      System.out.println("Ev T  -  Misafir T");
      for (int i = 0; i < 9; i++) {
        System.out.println(takimler2.get(i).getAd() + "-" + takimler.get(i).getAd());
      }
      System.out.println("     ********");
      System.out.println(j + 1 + ".Hafta Karşılaşma sonuçları");
      System.out.println(" Ev Takımı                 Misafir Takım");
      for (int i = 0; i < 9; i++) {
        this.macYap(takimler2.get(i), takimler.get(i));
      }
      System.out.println();
      System.out.println(j + 1 + ".Hafta Puan Sıralaması:");
      System.out.println("Güç          İsim       Maç İstatistikleri");
      istatistikler(takimler, takimler2);
      System.out.println("     ********");
      System.out.println("");
      takimler2.add(1, takimler.get(0));
      takimler.remove(0);
      takimler.add(8, takimler2.get(9));
      takimler2.remove(9);
      try {
        Thread.sleep(3000); // 3 saniye beklet
      } catch (InterruptedException e) {

        e.printStackTrace();
      }
    }
  }

  // kazanan takıma 3 berabere kalana 1 kaybedene puan verilmez
  public void macYap(Takim t_ev, Takim t_deplasman) {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    String fv_ev = decimalFormat.format(t_ev.getEvGuc() * 10);
    String fd_ort = decimalFormat.format(t_deplasman.getOrtalamaGuc() * 10);

    t_ev.oynanan_mac++;
    t_deplasman.oynanan_mac++;
    if (t_ev.getEvGuc() >= t_deplasman.getOrtalamaGuc()) {
      int takim_ev_gol = 0, takim_dep_gol = 0;
      if (t_ev.getHucumGuc() > t_deplasman.getHucumGuc()) {
        takim_ev_gol++;
      } else {
        takim_dep_gol++;
      }
      if (t_ev.getOrtasahaGuc() > t_deplasman.getOrtasahaGuc()) {
        takim_ev_gol++;
      } else {
        takim_dep_gol++;
      }
      if (t_ev.getKaleciGuc() > t_deplasman.getKaleciGuc()) {
        takim_ev_gol++;
      } else {
        takim_dep_gol++;
      }
      if (t_ev.getSavunmaGuc() > t_deplasman.getSavunmaGuc()) {
        takim_ev_gol++;
      } else {
        takim_dep_gol++;
      }

      if (takim_ev_gol > takim_dep_gol) {// güclü tarafın gol sayısı fazla ise okey değilse berabere random gol
                                         // attıralım
        System.out.println(" (" + fv_ev + ") " + t_ev.getAd() + " " + takim_ev_gol + "-" + takim_dep_gol + " "
            + t_deplasman.getAd() + " (" + fd_ort + ") ");
        t_ev.galibiyet_sayisi++;
        t_deplasman.maglubiyet_sayisi++;
        t_ev.toplam_gol += takim_ev_gol;
        t_deplasman.toplam_gol += takim_dep_gol;
        t_ev.sezon_puan += 3;
        t_ev.yenilen_gol += takim_dep_gol;
        t_deplasman.yenilen_gol += takim_ev_gol;

      } else {
        Random random = new Random();
        int a = random.nextInt(3);
        takim_dep_gol = a;
        takim_dep_gol = a;
        System.out.println(" (" + fv_ev + ") " + t_ev.getAd() + " " + takim_ev_gol + "-" + takim_dep_gol + " "
            + t_deplasman.getAd() + " (" + fd_ort + ") ");
        t_deplasman.toplam_gol += a;
        t_ev.toplam_gol += a;
        t_deplasman.beraberlik++;
        t_ev.beraberlik++;
        t_deplasman.sezon_puan += 1;
        t_ev.sezon_puan += 1;
        t_deplasman.yenilen_gol += a;
        t_ev.yenilen_gol += a;

      }
    } else {
      int takim_ev_gol = 0, takim_dep_gol = 0;
      if (t_ev.getHucumGuc() > t_deplasman.getHucumGuc()) {
        takim_ev_gol++;
      } else {
        takim_dep_gol++;
      }
      if (t_ev.getOrtasahaGuc() > t_deplasman.getOrtasahaGuc()) {
        takim_ev_gol++;
      } else {
        takim_dep_gol++;
      }
      if (t_ev.getKaleciGuc() > t_deplasman.getKaleciGuc()) {
        takim_ev_gol++;
      } else {
        takim_dep_gol++;
      }
      if (t_ev.getSavunmaGuc() > t_deplasman.getSavunmaGuc()) {
        takim_ev_gol++;
      } else {
        takim_dep_gol++;
      }

      if (takim_ev_gol < takim_dep_gol) {// güclü tarafın gol sayısı fazla ise okey değilse berabere random gol
                                         // attıralım
        System.out.println(" (" + fv_ev + ") " + t_ev.getAd() + " " + takim_ev_gol + "-" + takim_dep_gol + " "
            + t_deplasman.getAd() + " (" + fd_ort + ") ");
        t_deplasman.galibiyet_sayisi++;
        t_ev.maglubiyet_sayisi++;
        t_ev.toplam_gol += takim_ev_gol;
        t_deplasman.toplam_gol += takim_dep_gol;
        t_deplasman.sezon_puan += 3;
        t_ev.yenilen_gol += takim_dep_gol;
        t_deplasman.yenilen_gol += takim_ev_gol;

      } else {
        Random random = new Random();
        int a = random.nextInt(3);
        takim_dep_gol = a;
        takim_dep_gol = a;
        System.out.println(" (" + fv_ev + ") " + t_ev.getAd() + " " + takim_ev_gol + "-" + takim_dep_gol + " "
            + t_deplasman.getAd() + " (" + fd_ort + ") ");
        t_deplasman.toplam_gol += a;
        t_ev.toplam_gol += a;
        t_deplasman.beraberlik++;
        t_ev.beraberlik++;
        t_deplasman.sezon_puan += 1;
        t_ev.sezon_puan += 1;
        t_deplasman.yenilen_gol += a;
        t_ev.yenilen_gol += a;
      }

    }
  }

  public void istatistikler(ArrayList<Takim> t1, ArrayList<Takim> t2) {

    // listi birleştirince hata oluşuyor
    // yerel bir liste atıcam
    ArrayList<Takim> kopya1 = new ArrayList<Takim>();

    kopya1.addAll(t1);
    kopya1.addAll(t2);

    DecimalFormat decimalFormat = new DecimalFormat("#.###");
    Collections.sort(kopya1,
        Comparator.comparingInt(Takim::getSezon_puan).reversed()
            .thenComparing(Takim::getAveraj, Comparator.reverseOrder())
            .thenComparing(Takim::getToplam_gol, Comparator.reverseOrder()));
    for (int i = 0; i < 18; i++) {
      String formattedValue = decimalFormat.format(kopya1.get(i).getOrtalamaGuc() * 10);

      kopya1.get(i).averaj = kopya1.get(i).toplam_gol - kopya1.get(i).yenilen_gol;
      System.out.println(i + 1 + ". " + formattedValue + "  " + kopya1.get(i).getAd() + " O:"
          + kopya1.get(i).oynanan_mac + " G:" + kopya1.get(i).galibiyet_sayisi + " B:" + kopya1.get(i).beraberlik
          + " M:" + kopya1.get(i).maglubiyet_sayisi + " A:" + kopya1.get(i).toplam_gol + " Y:"
          + kopya1.get(i).yenilen_gol + " AVG:" + kopya1.get(i).averaj + " P:" + kopya1.get(i).getSezon_puan());
    }

  }

  public void takim_listele() {
    ArrayList<Takim> t1 = takimler;
    ArrayList<Takim> t2 = takimler2;
    ArrayList<Takim> kopya2 = new ArrayList<Takim>();
    kopya2.addAll(t1);
    kopya2.addAll(t2);

    for (int i = 0; i < kopya2.size(); i++) {

      kopya2.get(i).takim_guc_listele();

    }

  }

}
