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
    }
}
