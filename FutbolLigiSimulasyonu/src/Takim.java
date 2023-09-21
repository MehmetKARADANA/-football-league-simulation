import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Takim {

    public static int takimsayi;// takım isimlendirmede yardım
    private String ad;
    private ArrayList<oyuncu> Oyuncular = new ArrayList<oyuncu>();

    private double OrtalamaGuc;// deplasman gücü
    private double SavunmaGuc;
    private double HucumGuc;
    private double OrtasahaGuc;
    private double KaleciGuc;
    private double Taraftar_Guc;
    private double EvGuc;// evdeki tarftqr+ gücü
    public int toplam_gol;
    public int galibiyet_sayisi;
    public int oynanan_mac;
    public int yenilen_gol;

    public int sezon_puan;
    public int maglubiyet_sayisi;
    public int beraberlik;
    public int averaj;

    private KaleciOyuncu[] kaleciOyuncusu;

    private OrtaSahaOyuncusu[] ortaSahaOyuncusu;
    private SavunmaOyuncusu[] savunmaOyuncusu;
    private HucumOyuncusu[] hucumOyuncusu;
    private static List<Takim> instances = new ArrayList<Takim>();// takım özelliklerini listelerken kulancam

    public Takim() {

        instances.add(this);
        averaj = 0;
        oynanan_mac = 0;
        galibiyet_sayisi = 0;
        maglubiyet_sayisi = 0;
        beraberlik = 0;
        toplam_gol = 0;
        sezon_puan = 0;
        Random random = new Random();
        takimsayi++;
        ad = "takım" + takimsayi;
        kaleciOyuncusu = new KaleciOyuncu[3];// başlatmadan yapamaya çalıştım hata aldım saatlerce
        ortaSahaOyuncusu = new OrtaSahaOyuncusu[6];
        savunmaOyuncusu = new SavunmaOyuncusu[10];
        hucumOyuncusu = new HucumOyuncusu[6];

        for (int i = 0; i < 3; i++) {
            kaleciOyuncusu[i] = new KaleciOyuncu();
            Oyuncular.add(kaleciOyuncusu[i]);
        }

        for (int i = 0; i < 6; i++) {
            ortaSahaOyuncusu[i] = new OrtaSahaOyuncusu();
            Oyuncular.add(ortaSahaOyuncusu[i]);
        }
        for (int i = 0; i < 10; i++) {
            savunmaOyuncusu[i] = new SavunmaOyuncusu();
            Oyuncular.add(savunmaOyuncusu[i]);
        }

        for (int i = 0; i < 6; i++) {
            hucumOyuncusu[i] = new HucumOyuncusu();
            Oyuncular.add(hucumOyuncusu[i]);
        }
        ///////////////////////////////////
        for (int i = 0; i < 3; i++) {
            // System.out.println(o.getName());
            KaleciGuc += kaleciOyuncusu[i].getOyuncuGucu();
        }
        KaleciGuc = KaleciGuc / 3;

        for (int i = 0; i < 6; i++) {
            OrtasahaGuc += ortaSahaOyuncusu[i].getOyuncuGucu();
        }
        OrtasahaGuc = OrtasahaGuc / 6;

        for (int i = 0; i < 10; i++) {
            SavunmaGuc += savunmaOyuncusu[i].getOyuncuGucu();
        }
        SavunmaGuc = SavunmaGuc / 10;

        for (int i = 0; i < 6; i++) {
            HucumGuc += hucumOyuncusu[i].getOyuncuGucu();
        }
        HucumGuc = HucumGuc / 6;

        OrtalamaGuc = (HucumGuc + SavunmaGuc + OrtasahaGuc + KaleciGuc) / 4;

        Taraftar_Guc = random.nextInt(20);
        EvGuc = (HucumGuc + SavunmaGuc + OrtasahaGuc + KaleciGuc + Taraftar_Guc) / 5;

        // OrtalamaGuc = (HucumGuc + SavunmaGuc + OrtasahaGuc + KaleciGuc) / 4;

    }

    public void takim_guc_listele() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String fv_kaleciGuc = decimalFormat.format(KaleciGuc * 10);
        String fv_ortasahaGuc = decimalFormat.format(OrtasahaGuc * 10);
        String fv_savunmaGuc = decimalFormat.format(SavunmaGuc * 10);
        String fv_hucumGuc = decimalFormat.format(HucumGuc * 10);
        String fv_OrtalamaGuc = decimalFormat.format(OrtalamaGuc * 10);
        String fv_evGuc = decimalFormat.format(EvGuc * 10);

        System.out.println("             *************");
        System.out.println(this.getAd() + " Takımı Gücü:");
        System.out.println("Hücum gücü: " + fv_hucumGuc);
        System.out.println("Savunma gücü: " + fv_savunmaGuc);
        System.out.println("Ortasaha gücü: " + fv_ortasahaGuc);
        System.out.println("Kaleci gücü: " + fv_kaleciGuc);
        System.out.println("Genel (Ortalama) güç: " + fv_OrtalamaGuc);
        System.out.println("Ev Gücü: " + fv_evGuc);
        System.out.println("             *************");
    }

    public void takım_oyuncular_listele() {// bunuda hallaettik takım oyuncular özellikleri bastırma
        for (oyuncu o : Oyuncular) {
            // System.out.println(o.getName());
            System.out.println(this.getAd() + "takımı oyuncuları:");
            System.out.println("-----------------");
            o.ozellikler();
            System.out.println("-----------------");
        }

    }

    public static List<Takim> getAllInstances() {
        return instances;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public ArrayList<oyuncu> getOyuncular() {
        return Oyuncular;
    }

    public void setOyuncular(ArrayList<oyuncu> oyuncular) {
        Oyuncular = oyuncular;
    }

    public double getOrtalamaGuc() {
        return OrtalamaGuc;
    }

    public void setOrtalamaGuc(double ortalamaGuc) {
        OrtalamaGuc = ortalamaGuc;
    }

    public double getSavunmaGuc() {
        return SavunmaGuc;
    }

    public void setSavunmaGuc(double savunmaGuc) {
        SavunmaGuc = savunmaGuc;
    }

    public double getHucumGuc() {
        return HucumGuc;
    }

    public void setHucumGuc(double hucumGuc) {
        HucumGuc = hucumGuc;
    }

    public double getOrtasahaGuc() {
        return OrtasahaGuc;
    }

    public void setOrtasahaGuc(double ortasahaGuc) {
        OrtasahaGuc = ortasahaGuc;
    }

    public double getKaleciGuc() {
        return KaleciGuc;
    }

    public void setKaleciGuc(double kaleciGuc) {
        KaleciGuc = kaleciGuc;
    }

    public KaleciOyuncu[] getKaleciOyuncusu() {
        return kaleciOyuncusu;
    }

    public void setKaleciOyuncusu(KaleciOyuncu[] kaleciOyuncusu) {
        this.kaleciOyuncusu = kaleciOyuncusu;
    }

    public OrtaSahaOyuncusu[] getOrtaSahaOyuncusu() {
        return ortaSahaOyuncusu;
    }

    public void setOrtaSahaOyuncusu(OrtaSahaOyuncusu[] ortaSahaOyuncusu) {
        this.ortaSahaOyuncusu = ortaSahaOyuncusu;
    }

    public SavunmaOyuncusu[] getSavunmaOyuncusu() {
        return savunmaOyuncusu;
    }

    public void setSavunmaOyuncusu(SavunmaOyuncusu[] savunmaOyuncusu) {
        this.savunmaOyuncusu = savunmaOyuncusu;
    }

    public HucumOyuncusu[] getHucumOyuncusu() {
        return hucumOyuncusu;
    }

    public void setHucumOyuncusu(HucumOyuncusu[] hucumOyuncusu) {
        this.hucumOyuncusu = hucumOyuncusu;
    }

    public double getTaraftar_Guc() {
        return Taraftar_Guc;
    }

    public void setTaraftar_Guc(double taraftar_Guc) {
        Taraftar_Guc = taraftar_Guc;
    }

    public double getEvGuc() {
        return EvGuc;
    }

    public void setEvGuc(double evGuc) {
        EvGuc = evGuc;
    }

    public int getSezon_puan() {
        return sezon_puan;
    }

    public int getAveraj() {
        return averaj;
    }

    public int getToplam_gol() {
        return toplam_gol;
    }

}
