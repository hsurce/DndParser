import java.util.ArrayList;

public class LegendaryAction extends Action{
    public LegendaryAction(String name, ArrayList<String> texts){
        super(name, texts);
        this.name = name;
        this.texts = texts;
    }
    public static class LegendaryActionBuilder{
        String nestedName;
        ArrayList<String> nestedTexts;
        public LegendaryActionBuilder(){
            nestedTexts = new ArrayList<>();
        }
        public void name(String nestedName){
            this.nestedName = nestedName;
        }
        public void text(String nestedText){
            this.nestedTexts.add(nestedText);
        }
        public LegendaryAction BuildLegendaryAction(){
            LegendaryAction legendaryAction = new LegendaryAction(nestedName,nestedTexts);
            return legendaryAction;
        }

    }
}
