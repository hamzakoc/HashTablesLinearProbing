
package hashtableslinearprobing;

public class QuadHashTable {
    private String[] table;
    private int tableSize;
    private double loadFactor; //0.80
    int numItems;
    
    public QuadHashTable(int max,double lf){
        table = new String[max];
        tableSize= max;        
        loadFactor=lf;
        numItems=0;
    }
    public QuadHashTable(int max){
        table = new String[max];
        tableSize= max;
        loadFactor=0.75;
        numItems=0;
    }
    
    public QuadHashTable(){
        table = new String[20];
        tableSize= 20;
        loadFactor=0.75;
        numItems=0;
    }
    
    private int hashFunction(String word){
        int value=0,weight=1;
        for (int x =0; x<word.length();x++){
            value += (word.charAt(x)-'a'+1)*weight;
            weight++;
        }
        return value%tableSize;
    }
    // insert search delete (update)
    public void insert (String word){
        if (numItems/tableSize < loadFactor){
            int count=1;
            int startLoc =hashFunction(word);  
            int loc = startLoc;
            while (table[loc]!=null && table[loc].compareTo("DELETED")!=0){
                loc = (startLoc + count*count)%tableSize;
                count++;
            }    
            table[loc]=word;
            numItems++;
        }
    }
    
    public int search(String word){
        int count=1;
        int startLoc =hashFunction(word);  
        int loc = startLoc; 
        while (table[loc]!=null && table[loc].compareTo(word)!=0){
            loc = (startLoc + count*count)%tableSize;
                count++;
        }
        if (table[loc]==null)
            return -1;
        return loc;
    }
    
    public void delete(String word){
        int count=1;
        int startLoc =hashFunction(word);  
        int loc = startLoc; 
        while (table[loc]!=null && table[loc].compareTo(word)!=0){
            loc = (startLoc + count*count)%tableSize;
                count++;
        }
        if (table[loc]!=null){
            table[loc]="DELETED"; 
            numItems--;
        }
    } 
    
    public void printTable(){
        System.out.println("Hash Table Contents");
        for (int x=0;x<tableSize;x++){
            if(table[x]!=null)
                System.out.println(table[x]);
            else
                System.out.println("EMPTY");
        }
        System.out.println("");
    }
    
}
