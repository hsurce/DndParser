import java.io.Serializable;
import java.util.ArrayList;

public class Action implements Serializable {
    String name;
    ArrayList<String> texts;
    public Action(String name, ArrayList<String> texts) {
        this.name = name;
        this.texts = texts;
    }
    public static class ActionBuilder{
        String nestedName;
        ArrayList<String> nestedTexts;
        public ActionBuilder(){
            nestedTexts = new ArrayList<>();
        }
        public void name(String nestedName){
            this.nestedName = nestedName;
        }
        public void text(String nestedText){
            this.nestedTexts.add(nestedText);
        }
        public Action BuildAction(){
            Action action = new Action(nestedName,nestedTexts);
            return action;
        }
    }
}
