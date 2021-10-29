package desafiofundecc.model;

import desafiofundecc.controller.csvstorage.CsvStringable;

public final class Cargo implements CsvStringable<Cargo>{
    private String name;
    
    public Cargo (String name) {
        this.name = name;
    } 

    public String getName() {
        return name;
    }

    @Override
    public String toCsvString() {
        return name;
    }

    public static Cargo fromCSVToCargo(String[] csvRecord) {
        return new Cargo(csvRecord[0]);
    }
}