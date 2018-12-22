public class HitDie {
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
        public void ProcessHPString(String s){

        }
    }
}
