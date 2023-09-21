import java.util.Random;

public class KaleciOyuncu extends oyuncu implements IKaleciTechnic {

    public void ozellikler() {
        System.out.println("Adı: " + getName());
        System.out.println("Kaleci Teknik Puan: " + this.KaleciTechnical());
        System.out.println("Mental Puan:  " + getMENTAL());
        System.out.println("Fizik Puanı: " + getPHYSICAL());
        System.out.println("Pozisyon: " + this.Pozisyon);
        System.out.println("Kaleci genel puanı: " + this.OyuncuGucu);
    }

    public KaleciOyuncu() {
        super();
        Pozisyon = "Kaleci";
    }

    @Override
    public double KaleciTechnical() {
        Random random = new Random();
        int AerialReach = random.nextInt(20);
        int CommandofArea = random.nextInt(20);
        int Communication = random.nextInt(20);
        int Eccentricity = random.nextInt(20);
        int FirstTouch = random.nextInt(20);
        int Handling = random.nextInt(20);
        int Kicking = random.nextInt(20);
        int OneonOnes = random.nextInt(20);
        int Passing = random.nextInt(20);
        int Punching = random.nextInt(20);
        int ReflexeS = random.nextInt(20);
        int RushingOut = random.nextInt(20);
        int Throwing = random.nextInt(20);

        double deger = (double) (AerialReach + CommandofArea + Communication + Eccentricity + FirstTouch + Handling
                + Kicking + OneonOnes + Passing + Punching + ReflexeS + RushingOut + Throwing) / 13;
        return deger;
    }

    private double TECHNICAL = KaleciTechnical();

    private double OyuncuGucu = (this.KaleciTechnical() + this.getPHYSICAL() + this.getMENTAL()) / 3;

    public double getTECHNICAL() {
        return TECHNICAL;
    }

    public void setTECHNICAL(double tECHNICAL) {
        TECHNICAL = tECHNICAL;
    }

}
