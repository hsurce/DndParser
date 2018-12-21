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

        public void skills(Stat newSkills){
            this.nestedSkills.add(newSkills);
        }

        public void speeds(Stat newSpeeds){
            this.nestedSpeeds.add(newSpeeds);
        }

        public void saves(Stat newSaves){
            this.nestedSaves.add(newSaves);
        }

        public void senses(Stat newSenses){
            this.nestedSenses.add(newSenses);
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

        public void languages(String newLanguages){
            this.nestedLanguages.add(newLanguages);
        }

        public void vulnerable(String newVulnerable){this.nestedVulnerable.add(newVulnerable);}

        public void resists(String newResists){
            this.nestedResists.add(newResists);
        }

        public void immunities(String newImmunities){
            this.nestedImmunities.add(newImmunities);
        }

        public void conditionImmunities(String newConditionImmunities){
            this.nestedConditionImmunities.add(newConditionImmunities);
        }
        public void spellSlots(Integer newSlots){
            this.nestedSpellSlots.add(newSlots);
        }
        public void spells(String newSpells){
            this.nestedSpells.add(newSpells);
        }

        public Monster createMonster(){
            Monster monster = new Monster(nestedInfo,nestedSkills,nestedSpeeds,nestedSaves,nestedSenses,nestedTraits,nestedActions,
                    nestedLegendaryActions,nestedAttackActions,nestedLanguages,nestedResists,nestedImmunities,nestedConditionImmunities, nestedSpells,nestedSpellSlots,nestedVulnerable);
            return monster;
        }



    }
}
