import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AttackAction implements Serializable {
    int toHit;
    HitDie hitDie;
    int damageBonus;
    Action action;

    public AttackAction(Action action, int toHit, HitDie hitDie, int damageBonus){
        this.action = action;
        this.toHit = toHit;
        this.hitDie = hitDie;
        this.damageBonus = damageBonus;
    }
    public static class AttackActionBuilder{
        Action nestedAction;
        int nestedToHit;
        HitDie nestedHitDie;
        int nestedDamageBonus;


        public void toHit(int nestedToHit){
            this.nestedToHit = nestedToHit;
        }
        public void hitDie(HitDie nestedHitDie){
            this.nestedHitDie = nestedHitDie;
        }
        public void damageBonus(int nestedDamageBonus){
            this.nestedDamageBonus = nestedDamageBonus;
        }
        public void action(Action nestedAction){
            this.nestedAction = nestedAction;
        }
        public AttackAction BuildAttackAction(){
            AttackAction attackAction = new AttackAction(nestedAction,nestedToHit,nestedHitDie,nestedDamageBonus);
            return attackAction;
        }

        /**
         * Metode som finder hitDie og attack bonus samt damage bonus for det enkelte angreb.
         * @param s
         * @param hdb
         */
        public void ProcessAttackActionString(String s, HitDie.HitDieBuilder hdb){
            String[] word = s.split("\\|");
            if(!word[1].isBlank()){
                toHit(Integer.parseInt(word[1]));
            }
            for(int i = 0; i < word.length; i++){
                HitDie hd = hdb.ProcessHDString(word[i]);
                if(hd != null) {
                    this.hitDie(hd);
                }
                Pattern p = Pattern.compile("(.*)(\\++)([0-9]+)");
                Matcher m = p.matcher(word[i]);
                if(m.matches()){
                    if(m.group(2).equals("-")) {
                        damageBonus(Integer.parseInt(m.group(3))*-1);
                    }
                    else damageBonus(Integer.parseInt(m.group(3)));
                }

            }
            //Få extractet de vigtige fra strengen og sæt det ind i et AttackAction objekt.
        }
    }
}
