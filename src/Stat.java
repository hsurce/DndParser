public class Stat {
    String name;
    int value;
    public Stat(String name, int value){
        this.name = name;
        this.value = value;
    }
    public static class StatBuilder{
        String nestedName;
        int nestedValue;

        public void name(String nestedName){
            this.nestedName = nestedName;
        }
        public void value(int nestedValue){
            this.nestedValue = nestedValue;
        }
        public Stat BuildStat(){
            Stat stat = new Stat(nestedName,nestedValue);
            return stat;
        }
        public void ProcessSkillString(String s, StatBuilder sb){
            String[] word = s.split(",");
            String[] word2;
            for(int i = 0; i<word.length;i++){
                word2 = word[i].split(" ");
                for(int j = 0; j<word2.length;j++){
                    if(word2[j].matches("([A-Z])\\w+")){
                        sb.name(word2[j]);
                    }
                    if(word2[j].matches("([0-9])\\w+")){
                        sb.value(Integer.parseInt((word2[j])));
                    }
                    sb.BuildStat();
                }
            }
            //Bearbejd string til at have en liste af skill names og en liste af values
            //Lav Stats fra listen indtil der ikke er flere værdier i listen.
        }
        public void ProcessSpeedString(String s, StatBuilder sb){
            String[] word = s.split(",");
            String[] word2;
            for(int i = 0; i<word.length;i++){
                word2 = word[i].split(" ");
                for(int j = 0; j<word2.length;j++){
                    if(word2[j].matches("([A-Z])\\w+")){
                        if(!word2[j].contains("ft")) {
                            sb.name(word2[j]);
                        }
                    }
                    if(word2[j].matches("([0-9])\\w+")){
                        sb.value(Integer.parseInt((word2[j])));
                    }
                    sb.BuildStat();
                }
            }
            //Bearbejd string til at have en liste af speed names og en liste af speed values i ft.
            //Lav Speeds fra listen indtil der ikke er flere værdier i listen.
        }
    }
}
