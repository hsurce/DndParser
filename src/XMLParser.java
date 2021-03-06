
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLParser {

    public static void main(String[] args) {
        String pathName = "C:\\Users\\Jakob\\Desktop\\DnDAppFiles-master\\DnDAppFiles-master\\Bestiary\\MonsterManualBestiary.xml";
        try {
            File inputFile = new File(pathName);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {

    boolean bName = false;
    boolean bSize = false;
    boolean bType = false;
    boolean bAlignment = false;
    boolean bAc = false;
    boolean bHp = false;
    boolean bSpeed = false;
    boolean bStr = false;
    boolean bDex = false;
    boolean bCon = false;
    boolean bInt = false;
    boolean bWis = false;
    boolean bCha = false;
    boolean bSkill = false;
    boolean bPassive = false;
    boolean bLanguage = false;
    boolean bCr = false;
    boolean bTrait = false;
    boolean bAction = false;
    boolean bSenses = false;
    boolean bLegendary = false;
    boolean bImmune = false;
    boolean bConditionImmune = false;
    boolean bResist = false;
    boolean bText = false;
    boolean bAttack = false;
    boolean bSave = false;
    boolean bSpells = false;
    boolean bSlots = false;
    boolean bVulnerable = false;
    boolean bReaction = false;
    boolean isInnate = false;
    boolean isSpellCasting = false;
    boolean isAttack = false;
    Monster.MonsterBuilder mb;
    Information.InformationBuilder ib;
    Action.ActionBuilder ab;
    AttackAction.AttackActionBuilder atb;
    HitDie.HitDieBuilder hb;
    LegendaryAction.LegendaryActionBuilder lab;
    Stat.StatBuilder sb;
    Trait.TraitBuilder tb;
    HashMap<String, Monster> monsterMap = new HashMap<>();

    public String FindSpellCastingAbility(String s){
        String spellCastingAbility = "";
        if(s.contains("Intelligence")){
            spellCastingAbility = "Intelligence";
        }
        if(s.contains("Wisdom")){
            spellCastingAbility = "Wisdom";
        }
        if(s.contains("Charisma")){
            spellCastingAbility = "Charisma";
        }
        return spellCastingAbility;
    }

    /**
     * Denne metode bliver implicit kaldt af SAX-Parseren.
     * Vi switcher på qName som er navnet på start-tagget.
     * Ud over at initialisere nogle builders gør metoden ikke meget andet
     * end at initialisere nogle booleans som er essensen af dette parser setup.
     * Ved at manipulere med disse booleans kan vi sørge for at parseren kun behandler
     * de nødvendige informationer.
     */
    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)

            throws SAXException {
        switch (qName) {
            case "monster":
                mb = new Monster.MonsterBuilder();
                ib = new Information.InformationBuilder();
                break;
            case "legendary":
            bLegendary = true;
            lab = new LegendaryAction.LegendaryActionBuilder();
            break;
            case "trait":
            bTrait = true;
            tb = new Trait.TraitBuilder();
            break;
            case "action":
            bAction = true;
            ab = new Action.ActionBuilder();
            break;
            case "attack":
                atb = new AttackAction.AttackActionBuilder();
                isAttack = true;
                bAttack = true;
                break;
            case "name":
            bName = true;
            break;
            case "save":
            bSave = true;
            sb = new Stat.StatBuilder();
            break;
            case "text":
            bText = true;
            break;
            case "size":
                bSize = true;
                break;
            case "type":
                bType = true;
                break;
            case "alignment":
                bAlignment = true;
                break;
            case "vulnerable":
                bVulnerable = true;
                break;
            case "ac":
                bAc = true;
                sb = new Stat.StatBuilder();
                break;
            case "hp":
                bHp = true;
                hb = new HitDie.HitDieBuilder();
                break;
            case "speed":
                bSpeed = true;
                sb = new Stat.StatBuilder();
                break;
            case "spells":
                bSpells = true;
                break;
            case "slots":
                bSlots = true;
                break;
            case "str":
                bStr = true;
                break;
            case "dex":
                bDex = true;
                break;
            case "con":
                bCon = true;
                break;
            case "int":
                bInt = true;
                break;
            case "wis":
                bWis = true;
                break;
            case "cha":
                bCha = true;
                break;
            case "skill":
                bSkill = true;
                sb = new Stat.StatBuilder();
                break;
            case "passive":
                bPassive = true;
                break;
            case "languages":
                bLanguage = true;
                break;
            case "cr":
                bCr = true;
                break;
            case "senses":
                bSenses = true;
                 break;
            case "immune":
                bImmune = true;
                break;
            case "conditionImmune":
                bConditionImmune = true;
                break;
            case "reaction":
                bReaction = true;
                break;
            case "resist":
                bResist = true;
                break;
            }

        }
    /**
     * Denne metode bliver implicit kaldt af SAX-parseren så snart cursoren støder på et slut-tag (</x>).
     * Før denne metode bliver kaldt, bliver Character metoden dog kaldt.
     */

    @Override
    public void endElement(String uri,
 String localName, String qName) throws SAXException {
        switch (qName) {
            case "monster":
                mb.info(ib.createInformation());
                Monster m = mb.createMonster();
                monsterMap.put(m.getInfo().getName(), m);

            case "name":
                bName = false;
                break;
            case "text":
                bText = false;
                break;
            case "attack":
                bAttack = false;
                break;
            case "size":
                bSize = false;
                break;
            case "vulnerable":
                bVulnerable = false;
                break;
            case "type":
                bType = false;
                break;
            case "alignment":
                bAlignment = false;
                break;
            case "ac":
               bAc = false;
                break;
            case "hp":
                bHp = false;
                break;
            case "speed":
                bSpeed = false;
                break;
            case "spells":
                bSpells = false;
                break;
            case "slots":
                bSlots = false;
                break;
            case "str":
                bStr = false;
                break;
            case "dex":
                bDex = false;
                break;
            case "con":
                bCon = false;
                break;
            case "int":
                bInt = false;
                break;
            case "wis":
                bWis = false;
                break;
            case "cha":
                bCha = false;
                break;
            case "skill":
                bSkill = false;
                break;
            case "passive":
                bPassive = false;
                break;
            case "languages":
                bLanguage = false;
                break;
            case "cr":
                bCr = false;
                break;
            case "trait":
                mb.traits(tb.BuildTrait());
                isSpellCasting = false;
                isInnate = false;
                bTrait = false;
                break;
            case "action":
                if(isAttack){
                    atb.action(ab.BuildAction());
                    mb.attackActions(atb.BuildAttackAction());
                }
                else {
                    mb.actions(ab.BuildAction());
                }
                isAttack = false;
                bAction = false;
                break;
            case "senses":
                bSenses = false;
                break;
            case "legendary":
                mb.legendaryActions(lab.BuildLegendaryAction());
                bLegendary = false;
                break;
            case "immune":
                bImmune = false;
                break;
            case "conditionImmune":
                bConditionImmune = false;
                break;
            case "resist":
                bResist = false;
                break;
            case "save":
                bSave = false;
                break;
            case "reaction":
                ib.reaction(ab.BuildAction());
                bReaction = false;
                break;
            case "compendium":
                try {
                    FileOutputStream fos = new FileOutputStream("MonstersManual.bin");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(monsterMap);
                    oos.close();
                    fos.close();
                    System.out.println("SERIALIZATION DONE!");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
/**
 * Denne metode indeholder langt det meste af logikken som parseren behandler.
 * Metoden sørger først for at lave et char[] med al den tekst den møder imellem
 * start- og end-tagget. En string (s) bliver oprettet baseret på dette array for at
 * lette læs- og skrivbarheden af koden. Dette er reelt set en switch, opstillet i if-statements.
 * Det kunne have været mere elegant at opstille en enum-klasse og switche på den, men jeg tog den
 * mere simple udvej. Vi sørger for at bruge "if else" statements her, da flere start-tags godt kan være
 * i gang samtidig, og det er kun den relevante logik der skal proccesseres.
 */
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        String s = new String(ch, start, length);
        //YDERSTE TAG SKAL LIGGE LÆNGST NEDE I ELSE-IF RÆKKEN, OSV.



        if (bName) {
            if(bTrait){
                if(s.equals("Innate Spellcasting")){
                    isInnate = true;
                }
                if(s.equals("Spellcasting")){
                    isSpellCasting = true;
                }
                tb.name(s);
            }
            else if(bLegendary){
                lab.name(s);
                Pattern pLeg = Pattern.compile("((.*)\\(Costs )([0-9])( Actions\\))");
                Matcher mLeg = pLeg.matcher(s);
                if(mLeg.matches()){
                    lab.cost(Integer.parseInt(mLeg.group(3)));
                }
                else lab.cost(1);
            }
            else if(bAction || bReaction){
                ab.name(s);
            }
            else{
                ib.name(s);
                System.out.println("Name: " + new String(ch, start, length));
            }
            bName = false;
        }
        else if (bText) {
            if(bTrait){
                if(isSpellCasting || isInnate){
                    if(isSpellCasting) {
                        ib.spellCastingAbility(FindSpellCastingAbility(s));
                        isSpellCasting = false;
                    }
                    else {
                        ib.innateAbility(FindSpellCastingAbility(s));
                        isInnate = false;
                    }
                }
                tb.text(s);
            }
            else if(bLegendary){
                lab.text(s);
            }
            else if(bAction || bReaction){
                ab.text(s);
            }
            bText = false;
        }
        else if (bAttack) {
            atb.ProcessAttackActionString(s, hb);
            bAttack = false;
        }
        else if (bSave) {
            mb.saves(sb.ProcessStatString(s, sb));
        }
        else if(bSkill){
            mb.skills(sb.ProcessStatString(s, sb));
        }
        else if(bSpeed){
            sb.ProcessSpeedString(s, sb, mb);
        }
        else if(bHp){
            /**
             * Parseren tager ikke den explicite con bonus med, da denne blot er (hdAmount * conMod).
             * Hvis denne værdi skal vises, kan det nok bedst betale sig at lave en hurtig fix i logikken der beregner den.
             * Det skal dog huskes at den endelige hp værdi som er i information objektet på det givne monster allerede
             * tager højde for denne værdi.
             */
            String[] word = s.split(" ");
            if(word.length > 1){
                ib.hp(hb.ProcessHDString(word[1].split("\\(")[1]));

            }
            ib.hp(Integer.parseInt(word[0]));
        }
        else if(bAc){
            String[] word = s.split(" ");
            sb.value(Integer.parseInt(word[0]));
            if(word.length > 1) {
                String name = "";
                for(int i = 1; i < word.length; i++) {
                    name += word[i];
                }
                sb.name(name);
            }
            ib.ac(sb.BuildStat());
        }
        else if(bStr){
            ib.str(Integer.parseInt(s));
        }
        else if(bDex){
            ib.dex(Integer.parseInt(s));
        }
        else if(bCon){
            ib.con(Integer.parseInt(s));
        }
        else if(bInt){
            ib.intel(Integer.parseInt(s));
        }
        else if(bWis){
            ib.wis(Integer.parseInt(s));
        }
        else if(bCha){
            ib.cha(Integer.parseInt(s));
        }
        else if(bSize){
            ib.size(s);
        }
        else if(bAlignment){
            ib.alignment(s);
        }
        else if(bCr){
            if(s.contains("/")){
                String[] word = s.split("/");
                int divisor = Integer.parseInt(word[0]);
                double dividend = Integer.parseInt(word[1]);
                double result = divisor/dividend;
                ib.cr(result);
            }
            else ib.cr(Double.parseDouble(s));
        }
        else if(bImmune){
            mb.immunities(mb.ProcessMonsterString(s));

        }
        else if(bSlots){
            String[] word = s.split(",");
            for(int i = 0; i<word.length; i++){
                mb.spellSlots(Integer.parseInt(word[i]));
            }
        }
        else if(bPassive){
            ib.passivePerception(Integer.parseInt(s));
        }
        else if(bLanguage){
            mb.languages(mb.ProcessMonsterString(s));

        }
        else if(bSenses){
            mb.senses(sb.ProcessStatString(s,sb));
        }
        else if(bConditionImmune){
            mb.conditionImmunities(mb.ProcessMonsterString(s));
        }

        else if(bType){
            ib.type(s);
        }
        else if(bVulnerable){
            mb.vulnerable(mb.ProcessMonsterString(s));

        }
        else if(bResist){
            mb.resists(mb.ProcessMonsterString(s));

        }
        else if(bSpells){
            mb.spells(mb.ProcessMonsterString(s));

        }
    }
}