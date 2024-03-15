package meteoproject;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

class Comarca {
    public void problemaLlegir() throws FileNotFoundException {
        RandomAccessFile v = new RandomAccessFile("comarca.bin", "r");
        v.id = readInt();
        v.nom = readLong();
        
    }
}
