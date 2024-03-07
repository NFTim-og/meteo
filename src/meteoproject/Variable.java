package meteoproject;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

class Variable {
    public void problemaLlegir() throws FileNotFoundException {
        RandomAccessFile v = new RandomAccessFile("variable.bin", "r");
        v.id = readInt();
        v.nom = readLong();
        v.unitat_de_mesura = readLong();
        
        
    }
}
