import java.util.Random;

public class oyuncu {

    public static int sayi;// oyunucy öZGÜ İSİM VERİRKEN KULLANIYORUM

    private String name;
    private int age;
    protected String Pozisyon;
    // private Position position;
    private boolean footh;// sağ 1 sol 0
    private int length;
    private int weight;

    // atributtes
    // burada "technical değişkeninini alt özellikler üzerinden fonksiyonla
    // hesaplıycaz"

    public oyuncu() {
        sayi++;
        Random random = new Random();
        this.name = "oyuncu" + sayi; // 8 karakter uzunluğunda rastgele isim oluşturur//takım kurunca takım isminden//eski fikirler
                                     // bir parça eklemeyi düşün
        this.age = 18 + random.nextInt(20);// her oyuncuya 18 38 yaş arası yaş random etti
        this.footh = random.nextBoolean();
        this.length = 165 + random.nextInt(20);
        this.weight = 65 + random.nextInt(15);
    }

    public void ozellikler() {
    };// alt classlarda eziyoruz
      //

    // private int random(int i) {
    // return 0;
    // }

    /*
     * public class attributes{
     * public String ad;//özelliklere hızlı değer atamak için
     * public int deger;
     * }
     */
    // bu özelliklere burada sadece 0-20 puan sınırlaması getireceğim pozisyona özel
    // sınırlamayı ezm eile yapıcam
    Random random = new Random();

    private int Corner = random.nextInt(20);
    private int Crossing = random.nextInt(20);
    private int Dribbling = random.nextInt(20);
    private int Finishing = random.nextInt(20);
    private int FirstTouch = random.nextInt(20);
    private int FreeKick = random.nextInt(20);
    private int Heading = random.nextInt(20);
    private int LongShots = random.nextInt(20);
    private int LongThrows = random.nextInt(20);
    private int Marking = random.nextInt(20);
    private int Passing = random.nextInt(20);
    private int PenaltyTaking = random.nextInt(20);
    private int Tackling = random.nextInt(20);
    private int Technique = random.nextInt(20);
    private double TECHNICAL = (double) (Corner + Crossing + Dribbling + Finishing + FirstTouch + FreeKick + Heading
            + LongShots + Marking + Passing + PenaltyTaking + Tackling + Technique) / 14;// üstteki
    // değerler
    // bunun
    // için

    ////////////

    private int Aggression = random.nextInt(20);
    private int Anticipation = random.nextInt(20);
    private int Bravery = random.nextInt(20);
    private int Composure = random.nextInt(20);
    private int Concentration = random.nextInt(20);
    private int Decisions = random.nextInt(20);
    private int Determination = random.nextInt(20);
    private int Flair = random.nextInt(20);
    private int Leadership = random.nextInt(20);
    private int OfftheBall = random.nextInt(20);
    private int Positioning = random.nextInt(20);
    private int Teamwork = random.nextInt(20);
    private int Vision = random.nextInt(20);
    private int WorkRate = random.nextInt(20);
    private double MENTAL = (double) (Aggression + Anticipation + Bravery + Composure + Concentration + Decisions
            + Determination
            + Flair + Leadership + OfftheBall + Positioning + Teamwork + Vision + WorkRate) / 14;/// **bunun için */

    //////////////

    private int Acceleration = random.nextInt(20);
    private int Agility = random.nextInt(20);
    private int Balance = random.nextInt(20);
    private int JumpingReach = random.nextInt(20);
    private int NaturalFitness = random.nextInt(20);
    private int Pace = random.nextInt(20);
    private int Stamina = random.nextInt(20);
    private int Strength = random.nextInt(20);
    private double PHYSICAL = (double) (Acceleration + Agility + Balance + JumpingReach + NaturalFitness + Pace
            + Stamina
            + Strength) / 8;

    public String getPozisyon() {
        return Pozisyon;
    }

    public void setPozisyon(String pozisyon) {
        Pozisyon = pozisyon;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void setMENTAL(double mENTAL) {
        MENTAL = mENTAL;
    }

    public double getOyuncuGucu() {
        return OyuncuGucu;
    }

    public void setOyuncuGucu(double oyuncuGucu) {
        OyuncuGucu = oyuncuGucu;
    }

    private double OyuncuGucu = (this.MENTAL + this.PHYSICAL + this.TECHNICAL) / 3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFooth() {
        return footh;
    }

    public void setFooth(boolean footh) {
        this.footh = footh;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getTECHNICAL() {
        return TECHNICAL;
    }

    public void setTECHNICAL(double tECHNICAL) {
        TECHNICAL = tECHNICAL;
    }

    public int getCorner() {
        return Corner;
    }

    public void setCorner(int corner) {
        Corner = corner;
    }

    public int getCrossing() {
        return Crossing;
    }

    public void setCrossing(int crossing) {
        Crossing = crossing;
    }

    public int getDribbling() {
        return Dribbling;
    }

    public void setDribbling(int dribbling) {
        Dribbling = dribbling;
    }

    public int getFinishing() {
        return Finishing;
    }

    public void setFinishing(int finishing) {
        Finishing = finishing;
    }

    public int getFirstTouch() {
        return FirstTouch;
    }

    public void setFirstTouch(int firstTouch) {
        FirstTouch = firstTouch;
    }

    public int getFreeKick() {
        return FreeKick;
    }

    public void setFreeKick(int freeKick) {
        FreeKick = freeKick;
    }

    public int getHeading() {
        return Heading;
    }

    public void setHeading(int heading) {
        Heading = heading;
    }

    public int getLongShots() {
        return LongShots;
    }

    public void setLongShots(int longShots) {
        LongShots = longShots;
    }

    public int getLongThrows() {
        return LongThrows;
    }

    public void setLongThrows(int longThrows) {
        LongThrows = longThrows;
    }

    public int getMarking() {
        return Marking;
    }

    public void setMarking(int marking) {
        Marking = marking;
    }

    public int getPassing() {
        return Passing;
    }

    public void setPassing(int passing) {
        Passing = passing;
    }

    public int getPenaltyTaking() {
        return PenaltyTaking;
    }

    public void setPenaltyTaking(int penaltyTaking) {
        PenaltyTaking = penaltyTaking;
    }

    public int getTackling() {
        return Tackling;
    }

    public void setTackling(int tackling) {
        Tackling = tackling;
    }

    public int getTechnique() {
        return Technique;
    }

    public void setTechnique(int technique) {
        Technique = technique;
    }

    public double getMENTAL() {
        return MENTAL;
    }

    public void setMENTAL(Double mENTAL) {
        MENTAL = mENTAL;
    }

    public int getAggression() {
        return Aggression;
    }

    public void setAggression(int aggression) {
        Aggression = aggression;
    }

    public int getAnticipation() {
        return Anticipation;
    }

    public void setAnticipation(int anticipation) {
        Anticipation = anticipation;
    }

    public int getBravery() {
        return Bravery;
    }

    public void setBravery(int bravery) {
        Bravery = bravery;
    }

    public int getComposure() {
        return Composure;
    }

    public void setComposure(int composure) {
        Composure = composure;
    }

    public int getConcentration() {
        return Concentration;
    }

    public void setConcentration(int concentration) {
        Concentration = concentration;
    }

    public int getDecisions() {
        return Decisions;
    }

    public void setDecisions(int decisions) {
        Decisions = decisions;
    }

    public int getDetermination() {
        return Determination;
    }

    public void setDetermination(int determination) {
        Determination = determination;
    }

    public int getFlair() {
        return Flair;
    }

    public void setFlair(int flair) {
        Flair = flair;
    }

    public int getLeadership() {
        return Leadership;
    }

    public void setLeadership(int leadership) {
        Leadership = leadership;
    }

    public int getOfftheBall() {
        return OfftheBall;
    }

    public void setOfftheBall(int offtheBall) {
        OfftheBall = offtheBall;
    }

    public int getPositioning() {
        return Positioning;
    }

    public void setPositioning(int positioning) {
        Positioning = positioning;
    }

    public int getTeamwork() {
        return Teamwork;
    }

    public void setTeamwork(int teamwork) {
        Teamwork = teamwork;
    }

    public int getVision() {
        return Vision;
    }

    public void setVision(int vision) {
        Vision = vision;
    }

    public int getWorkRate() {
        return WorkRate;
    }

    public void setWorkRate(int workRate) {
        WorkRate = workRate;
    }

    public double getPHYSICAL() {
        return PHYSICAL;
    }

    public void setPHYSICAL(double pHYSICAL) {
        PHYSICAL = pHYSICAL;
    }

    public int getAcceleration() {
        return Acceleration;
    }

    public void setAcceleration(int acceleration) {
        Acceleration = acceleration;
    }

    public int getAgility() {
        return Agility;
    }

    public void setAgility(int agility) {
        Agility = agility;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public int getJumpingReach() {
        return JumpingReach;
    }

    public void setJumpingReach(int jumpingReach) {
        JumpingReach = jumpingReach;
    }

    public int getNaturalFitness() {
        return NaturalFitness;
    }

    public void setNaturalFitness(int naturalFitness) {
        NaturalFitness = naturalFitness;
    }

    public int getPace() {
        return Pace;
    }

    public void setPace(int pace) {
        Pace = pace;
    }

    public int getStamina() {
        return Stamina;
    }

    public void setStamina(int stamina) {
        Stamina = stamina;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }
}
