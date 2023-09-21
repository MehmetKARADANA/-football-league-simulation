public class HucumOyuncusu extends oyuncu {

    public void ozellikler() {
        System.out.println("Adı: " + getName());
        System.out.println("Teknik Puan: " + getTECHNICAL());
        System.out.println("Mental Puan:  " + getMENTAL());
        System.out.println("Fizik Puanı: " + getPHYSICAL());
        System.out.println("Pozisyon: " + this.Pozisyon);
        System.out.println("Oyuncu genel puanı: " + this.getOyuncuGucu());
    }

    public HucumOyuncusu() {
        super();
        Pozisyon = "Hucum";
    }

}
