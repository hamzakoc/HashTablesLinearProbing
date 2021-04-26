
package hashtableslinearprobing;


public class DoubleHashTable {
    
    private String[] table;
    private int tableSize;
    private double loadFactor; //0.80
    int numItems;
    
    public DoubleHashTable(int max,double lf){
        table = new String[max];
        tableSize= max;        
        loadFactor=lf;
        numItems=0;
    }
    public DoubleHashTable(int max){
        table = new String[max];
        tableSize= max;
        loadFactor=0.75;
        numItems=0;
    }
    
    public DoubleHashTable(){
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
    
       private int hashFunction2 (String word){
        int value=0,weight=1;
        for (int x =0; x<word.length();x++){
            value += word.charAt(x);
            weight++;
        }
        return value%tableSize;
    }
    
    // insert search delete (update)
    public void insert (String word){
        if (numItems/tableSize < loadFactor){
            int loc =hashFunction(word);  
            int inc = hashFunction2(word);
            while (table[loc]!=null && table[loc].compareTo("DELETED")!=0){
                loc = (loc+inc)%tableSize;
            }    
            table[loc]=word;
            numItems++;
        }
    }
    
    public int search(String word){
        int loc = hashFunction(word);
        int inc = hashFunction2(word);
        while (table[loc]!=null && table[loc].compareTo(word)!=0){
            loc = (loc+inc)%tableSize;
        }
        if (table[loc]==null)
            return -1;
        return loc;
    }
    
    public void delete(String word){
        int loc = hashFunction(word); 
        int inc = hashFunction2(word);
        while (table[loc]!=null  && table[loc].compareTo(word)!=0){
            loc = (loc+inc)%tableSize;
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
