package desafiofundecc.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import desafiofundecc.controller.csvstorage.CsvFileStorage;
import desafiofundecc.model.Cargo;

public final class CargoController {
    private List<Cargo> cargos;
    public CargoController() {
        cargos = new CsvFileStorage<Cargo>("./cargos.csv")
                        .loadCSVRecords()
                        .getCsvCollection()
                        .stream()
                        .map((csvRecord) -> 
                            { return Cargo.fromCSVToCargo(csvRecord); })
                        .collect(Collectors.toList());
    }

    public List<Cargo> getAllCargos() { cargos.sort(new Comparator<Cargo>() {
        public int compare(Cargo um, Cargo outr) { return um.getName().compareTo(outr.getName()); };});
        return cargos;
    }
}