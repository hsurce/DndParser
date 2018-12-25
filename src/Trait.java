import java.io.Serializable;
import java.util.ArrayList;

public class Trait implements Serializable {
    String name;
    ArrayList<String> texts;

    public Trait(String name, ArrayList<String> texts){
        this.name = name;
        this.texts = texts;
    }
    public static class TraitBuilder{
        String nestedName;
        ArrayList<String> nestedTexts;
        public TraitBuilder(){
            nestedTexts = new ArrayList<>();
        }
        public void name(String nestedName){
            this.nestedName = nestedName;
        }
        public void text(String nestedText){
            nestedTexts.add(nestedText);
        }
        public Trait BuildTrait(){
            Trait trait = new Trait(nestedName,nestedTexts);
            return trait;
        }
    }
}
