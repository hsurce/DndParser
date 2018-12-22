import java.util.ArrayList;


public class Monster {
    Information info;
    ArrayList<Stat> skills;
    ArrayList<Stat> speeds;
    ArrayList<Stat> saves;
    ArrayList<Stat> senses;
    ArrayList<Trait> traits;
    ArrayList<Action> actions;
    ArrayList<Action> legendaryActions;
    ArrayList<AttackAction> attackActions;
    ArrayList<String> languages;
    ArrayList<String> resists;
    ArrayList<String> immunities;
    ArrayList<String> conditionImmunities;
    ArrayList<String> spells;
    ArrayList<Integer> spellSlots;
    ArrayList<String> vulnerable;
    public Monster(
            Information info, ArrayList<Stat> skills, ArrayList<Stat> speeds, ArrayList<Stat> saves, ArrayList<Stat> senses, ArrayList<Trait> traits,
            ArrayList<Action> actions, ArrayList<Action> legendaryActions, ArrayList<AttackAction> attackActions, ArrayList<String> languages,
            ArrayList<String> resists, ArrayList<String> immunities, ArrayList<String> conditionImmunities, ArrayList<String> spells, ArrayList<Integer> spellSlots, ArrayList<String> vulnerable){

        this.info = info;
        this.skills = skills;
        this.speeds = speeds;
        this.saves = saves;
        this.senses = senses;
        this.traits = traits;
        this.actions = actions;
        this.legendaryActions = legendaryActions;
        this.attackActions = attackActions;
        this.languages = languages;
        this.resists = resists;
        this.immunities = immunities;
        this.conditionImmunities = conditionImmunities;
        this.spells = spells;
        this.spellSlots = spellSlots;
        this.vulnerable = vulnerable;
    }
    public static class MonsterBuilder{
        Information nestedInfo;
        ArrayList<Stat> nestedSkills;
        ArrayList<Stat> nestedSpeeds;
        ArrayList<Stat> nestedSaves;
        ArrayList<Stat> nestedSenses;
        ArrayList<Trait> nestedTraits;
        ArrayList<Action> nestedActions;
        ArrayList<Action> nestedLegendaryActions;
        ArrayList<AttackAction> nestedAttackActions;
        ArrayList<String> nestedLanguages;
        ArrayList<String> nestedResists;
        ArrayList<String> nestedImmunities;
        ArrayList<String> nestedConditionImmunities;
        ArrayList<String> nestedSpells;
        ArrayList<String> nestedVulnerable;
        ArrayList<Integer> nestedSpellSlots;

        public MonsterBuilder(){
            nestedSkills = new ArrayList<>();
            nestedSpeeds = new ArrayList<>();
            nestedSaves = new ArrayList<>();
            nestedSenses = new ArrayList<>();
            nestedTraits = new ArrayList<>();
            nestedActions = new ArrayList<>();
            nestedLegendaryActions = new ArrayList<>();
            nestedAttackActions = new ArrayList<>();
            nestedLanguages = new ArrayList<>();
            nestedResists = new ArrayList<>();
            nestedImmunities = new ArrayList<>();
            nestedConditionImmunities = new ArrayList<>();
            nestedSpells = new ArrayList<>();
            nestedSpellSlots = new ArrayList<>();
            nestedVulnerable = new ArrayList<>();
        }

        public void info(final Information newInfo){
            this.nestedInfo = newInfo;
        }

        public void speeds(Stat newSpeeds){
            this.nestedSpeeds.add(newSpeeds);
        }

        public void skills(ArrayList<Stat> newSkills){
            this.nestedSkills = newSkills;
        }

        public void saves(ArrayList<Stat> newSaves){
            this.nestedSaves = newSaves;
        }

        public void senses(ArrayList<Stat> newSenses){
            this.nestedSenses = newSenses;
        }

        public void traits(Trait newTraits){
            this.nestedTraits.add(newTraits);
        }

        public void actions(Action newActions){
            this.nestedActions.add(newActions);
        }

        public void legendaryActions(Action newLegendaryActions){
            this.nestedLegendaryActions.add(newLegendaryActions);
        }

        public void attackActions(AttackAction newAttackActions){
            this.nestedAttackActions.add(newAttackActions);
        }

        public ArrayList<String> ProcessMonsterString(String s, MonsterBuilder mb){
            ArrayList<String> al = new ArrayList<>();
            String[] word = s.split(",");
            for(int i = 0; i<word.length; i++){
                al.add(word[i]);
            }
            return al;
        }

        public void languages(ArrayList<String> newLanguages){
            this.nestedLanguages = newLanguages;
        }

        public void vulnerable(ArrayList<String> newVulnerable){this.nestedVulnerable = newVulnerable;}

        public void resists(ArrayList<String> newResists){
            this.nestedResists = newResists;
        }

        public void immunities(ArrayList<String> newImmunities){
            this.nestedImmunities = newImmunities;
        }

        public void conditionImmunities(ArrayList<String> newConditionImmunities){
            this.nestedConditionImmunities = newConditionImmunities;
        }
        public void spells(ArrayList<String> newSpells){
            this.nestedSpells = newSpells;
        }

        public void spellSlots(Integer newSlots){
            this.nestedSpellSlots.add(newSlots);
        }

        public Monster createMonster(){
            Monster monster = new Monster(nestedInfo,nestedSkills,nestedSpeeds,nestedSaves,nestedSenses,nestedTraits,nestedActions,
                    nestedLegendaryActions,nestedAttackActions,nestedLanguages,nestedResists,nestedImmunities,nestedConditionImmunities, nestedSpells,nestedSpellSlots,nestedVulnerable);
            return monster;
        }



    }
}
