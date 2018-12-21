
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

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
            case "language":
                bLanguage = true;
                break;
            case "cr":
                bCr = true;
                break;
            case "senses":
                bAction = true;
                sb = new Stat.StatBuilder();
                break;
            case "immune":
                bImmune = true;
                break;
            case "conditionImmune":
                bConditionImmune = true;
                break;
            case "resist":
                bConditionImmune = true;
                break;
            }
        }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        switch (qName) {
            case "monster":
                mb.info(ib.createInformation());
                mb.createMonster();

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
                ib.ac(sb.BuildStat());
                bAc = false;
                break;
            case "hp":
                ib.hp(hb.BuildHitDie());
                bHp = false;
                break;
            case "speed":
                mb.speeds(sb.BuildStat());
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
                mb.skills(sb.BuildStat());
                bSkill = false;
                break;
            case "passive":
                bPassive = false;
                break;
            case "language":
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
                mb.senses(sb.BuildStat());
                bSenses = false;
                break;
            case "legendary":
                lab.BuildLegendaryAction();
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
                mb.saves(sb.BuildStat());
                bSave = false;
                break;
        }
    }

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
            }
            else if(bAction){
                ab.name(s);
            }
            else{
                ib.name(s);
            }
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        }
        else if (bText) {
            if(bTrait){
                if(isSpellCasting || isInnate){
                    if(isSpellCasting) {
                        ib.spellCastingAbility(FindSpellCastingAbility(s));
                    }
                    else ib.innateAbility(FindSpellCastingAbility(s));
                }
                tb.text(s);
            }
            else if(bLegendary){
                lab.text(s);
            }
            else if(bAction){
                ab.text(s);
            }
            System.out.println("Text: " + new String(ch, start, length));
            bText = false;
        }
        else if (bAttack) {
            /**
             * GØR INTET ENDNU!
             */
            atb.ProcessAttackActionString(s);
            System.out.println("Attack: " + new String(ch, start, length));
            bAttack = false;
        }
        else if (bSave) {
            System.out.println("Saves: " + new String(ch, start, length));
            bSave = false;
        }
        else if(bSkill){

        }
        else if(bSpeed){

        }
        else if(bHp){

        }
        else if(bAc){

        }
        else if(bStr){

        }
        else if(bDex){

        }
        else if(bCon){

        }
        else if(bInt){

        }
        else if(bWis){

        }
        else if(bCha){

        }
        else if(bSize){

        }
        else if(bAlignment){

        }
        else if(bStr){

        }
        else if(bImmune){

        }
        else if(bSlots){

        }
        else if(bSpells){

        }



    }
}