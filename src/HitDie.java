import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HitDie implements Serializable {
    int dieAmount;
    int dieSize;
    public HitDie(int dieAmount, int dieSize){
        this.dieAmount = dieAmount;
        this.dieSize = dieSize;
    }
    public static class HitDieBuilder{
        int nestedDieAmount;
        int nestedDieSize;
        public void dieAmount(int nestedDieAmount){
            this.nestedDieAmount = nestedDieAmount;
        }
        public void dieSize(int nestedDieSize){
            this.nestedDieSize = nestedDieSize;
        }
        public HitDie BuildHitDie(){
            HitDie hitDie = new HitDie(nestedDieAmount,nestedDieSize);
            return hitDie;
        }

        /**
         * En hurtig metode til at finde værdien før og efter et "d". Bliver brugt
         * til at finde dice mængde og dice størrelse for en arbitrær dice.
         * Konventionen i XML'en er "XdY" hvor X er mængde og Y størrelse.
         * @param s
         * @return
         */
        public HitDie ProcessHDString(String s){


                Pattern p = Pattern.compile("([0-9]+)d([0-9]+)(.*)");
                Matcher m = p.matcher(s);
                if(m.matches()){
                    this.dieAmount(Integer.parseInt(m.group(1)));
                    this.dieSize(Integer.parseInt(m.group(2)));
                    return BuildHitDie();
                }

            return null;
        }
    }
}
