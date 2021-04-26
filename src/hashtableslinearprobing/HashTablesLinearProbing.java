
package hashtableslinearprobing;


public class HashTablesLinearProbing {

  
 public static void main(String[] args) {
        LinearHashTablePrev lht = new LinearHashTablePrev();
        lht.printTable();
        lht.insert("andrew");
        lht.insert("farah");
        lht.insert("jeremy");
        lht.insert("micheal");
        lht.printTable();
        lht.delete("andrew");
        lht.printTable();
        lht.insert("andrew");
        lht.printTable();
        
        
        
        
        System.out.println("*****************");
        QuadHashTable qht = new QuadHashTable();
        qht.printTable();
        qht.insert("andrew");
        qht.insert("farah");
        qht.insert("jeremy");
        qht.insert("micheal");
        qht.printTable();
        qht.delete("andrew");
        qht.printTable();
        qht.insert("andrew");
        qht.printTable();
        
        
        
        
    }
    
}
