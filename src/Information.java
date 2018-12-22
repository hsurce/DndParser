public class Information {
    String name;
    String size;
    String type;
    String alignment;
    int hp;
    int str;
    int dex;
    int con;
    int intel;
    int wis;
    int cha;
    double cr;
    int passivePerception;
    HitDie hitDie;
    Stat ac;
    Action reaction;
    String innateAbility;
    String spellCastingAbility;
    public Information(String name, String size, String type, String alignment, Stat ac, int hp, HitDie hitDie,
                       int str, int dex, int con, int intel, int wis, int cha, double cr, int passivePerception, Action reaction, String innateAbility, String spellCastingAbility){
        this.name = name;
        this.size = size;
        this.type = type;
        this.alignment = alignment;
        this.hp = hp;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.intel = intel;
        this.wis = wis;
        this.cha = cha;
        this.cr = cr;
        this.passivePerception = passivePerception;
        this.hitDie = hitDie;
        this.ac = ac;
        this.reaction = reaction;
        this.innateAbility = innateAbility;
        this.spellCastingAbility = spellCastingAbility;
    }

public static class InformationBuilder {
    private String nestedName;
    private String nestedSize;
    private String nestedType;
    private String nestedAlignment;
    private String nestedInnateAbility;
    private String nestedSpellCastingAbility;
    private int nestedHp;
    private int nestedStr;
    private int nestedDex;
    private int nestedCon;
    private int nestedIntel;
    private int nestedWis;
    private int nestedCha;
    private double nestedCr;
    private int nestedPassivePerception;
    private HitDie nestedHitDie;
    private Stat nestedAc;
    private Action nestedReaction;

    public void name(final String newName){
        this.nestedName = newName;
    }
    public void size(final String newSize){
        this.nestedSize = newSize;
    }
    public void type(final String newType){
        this.nestedType = newType;
    }

    public void alignment(final String newAlignment){
        this.nestedAlignment = newAlignment;
    }

    public void innateAbility(final String newInnateAbility){
        this.nestedInnateAbility = newInnateAbility;
    }
    public void spellCastingAbility(final String newSpellCastingAbility){
        this.nestedSpellCastingAbility = newSpellCastingAbility;
    }

    public void hp(final int newHp){
        this.nestedHp = newHp;
    }

    public void str(final int newStr){
        this.nestedStr = newStr;
    }

    public void dex(final int newDex){
        this.nestedDex = newDex;
    }

    public void con(final int newCon){
        this.nestedCon = newCon;
    }

    public void intel(final int newIntel){
        this.nestedIntel = newIntel;
    }

    public void wis(final int newWis){
        this.nestedWis = newWis;
    }

    public void cha(final int newCha){
        this.nestedCha = newCha;
    }

    public void cr(final double newCr){
        this.nestedCr = newCr;
    }

    public void passivePerception(final int newPassivePerception){
        this.nestedPassivePerception = newPassivePerception;
    }

    public void hp(final HitDie newHitDie){
        this.nestedHitDie = newHitDie;
    }

    public void ac(final Stat newAc){
        this.nestedAc = newAc;
    }

    public void reaction(final Action newReaction) { this.nestedReaction = newReaction;
    }
    public Information createInformation(){
        Information information = new Information(nestedName,nestedSize,nestedType,nestedAlignment,nestedAc,nestedHp,
                nestedHitDie, nestedStr, nestedDex, nestedCon, nestedIntel, nestedWis, nestedCha, nestedCr, nestedPassivePerception, nestedReaction,nestedInnateAbility,nestedSpellCastingAbility);
        return information;
    }
}
}
