package desafiofundecc.model;

import desafiofundecc.controller.csvstorage.CsvStringable;

public final class Cargo implements CsvStringable<Cargo>{
    private String nome;
    
    public Cargo (String nome) {
        this.nome = nome;
    } 

    public String getNome() {
        return nome;
    }

    @Override
    public String toCsvString() {
        return nome;
    }

    public static Cargo fromCSVToCargo(String[] csvRecord) {
        return new Cargo(csvRecord[0]);
    }

    @Override
    public String toString() {
        return getNome();
    }
}