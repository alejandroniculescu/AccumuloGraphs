public class DijkstraAccumuloGraphFeed{
    
    String className = this.getClass().getSimpleName();
    //get accumulo property connector
    //get local properties
    private static String tableName = "myTable";
    
    
    
    public void setup(String[] args) throws Exception {
        Options options = new Options();
        options.addOption(args[0], "name of config file to use");
        options.addOption(arges[1], "names of table to use");
        
        
        
    }
    
    
    

ArrayList<String> list = new ArrayList<String>();
ArrayList<String> subList = new ArrayList<String>();
Integer hopCounter = 0;

public void Dijkstra(String tableName, String UID1, int maxHops) throws Exception{
    subList.add(UID1);
    
    while(hopCounter <= maxHops){
        subList = scanList(subList);
        hopCounter++;
        System.out.println("result at" +hopCounter+ "hops: " +subList);
    }
    
}

public ArrayList scanList(ArrayList<String> seed) throws Exception{
    ArrayList newStuff = new ArrayList();
    
    for (String person : seed) {
        Scanner scanner = //create scanner from data, auths() create scanner
        
        for(Entry<Key, Value> entry : scanner) {
            
            Key key = entry.getKey();
            String newPerson = key.getColumnQualifier().toString();
            
            if ((entry.getKey().getRow().toString().equals(person) && (!list.contains(newPeron))){
                
                newStuff.add(newPerson);
                
                scanner.setRange(new Range(newPerson));
                
            }
            
        }
        
        list.addAll(seed);
        
        return newStuff;
    }
    
}

public static void main(String [] args) throws Exception {
    
    DijkstraAccumuloGraphFeed util = new DijkstraAccumuloGraphFeed();
    
    try {
        util.setup(args)
        util.Dijkstra(tripleData, "A", 2);
        
        
        
    }
    
    catch(Exception ex){ex.printStackTrace();}
    
    
}

}
