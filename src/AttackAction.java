import java.util.ArrayList;

public class AttackAction{
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
        public void ProcessAttackActionString(String s){
            //Få extractet de vigtige fra strengen og sæt det ind i et AttackAction objekt.
        }
    }
}
