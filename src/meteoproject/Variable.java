package meteoproject;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

s
import java.io.*;

class Variable {
    int id;
    String nom;
    String unitatDeMesura;

    public Variable(int id, String nom, String unitatDeMesura) {
        this.id = id;
        this.nom = nom;
        this.unitatDeMesura = unitatDeMesura;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", NOM: " + nom + ", UNITAT_DE_MESURA: " + unitatDeMesura;
    }
}

class GestorVariables {
    private String fitxer;

    public GestorVariables(String fitxer) {
        this.fitxer = fitxer;
    }

    Variable llegirTupla() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(fitxer, "r")) {
            int id = raf.readInt();
            byte[] nomBytes = new byte[50];
            raf.readFully(nomBytes);
            String nom = new String(nomBytes).trim();
            byte[] unitatDeMesuraBytes = new byte[5];
            raf.readFully(unitatDeMesuraBytes);
            String unitatDeMesura = new String(unitatDeMesuraBytes).trim();
            return new Variable(id, nom, unitatDeMesura);
        }
    }

    void mostrarTupla(Variable variable) {
        System.out.println(variable);
    }

    void llegirDesDeFitxer() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(fitxer, "r")) {
            long posicio = 0;
            while (posicio < raf.length()) {
                raf.seek(posicio);
                int id = raf.readInt();
                byte[] nomBytes = new byte[50];
                raf.readFully(nomBytes);
                String nom = new String(nomBytes).trim();
                byte[] unitatDeMesuraBytes = new byte[5];
                raf.readFully(unitatDeMesuraBytes);
                String unitatDeMesura = new String(unitatDeMesuraBytes).trim();
                mostrarTupla(new Variable(id, nom, unitatDeMesura));
                posicio += 60; // 4 bytes (int) + 50 bytes (String) + 5 bytes (String) + 1 byte (espai)
            }
        }
    }

    void escriureAFitxer(Variable[] variables) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(fitxer, "rw")) {
            long posicio = 0;
            for (Variable variable : variables) {
                raf.seek(posicio);
                raf.writeInt(variable.id);
                raf.writeBytes(variable.nom);
                raf.writeBytes(variable.unitatDeMesura);
                posicio += 60; // 4 bytes (int) + 50 bytes (String) + 5 bytes (String) + 1 byte (espai)
            }
        }
    }
}