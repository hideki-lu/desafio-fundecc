package desafiofundecc.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import desafiofundecc.controller.csvstorage.CsvFileStorage;
import desafiofundecc.controller.storageinterfaces.StorageKind;
import desafiofundecc.model.Cargo;

public final class CargoController {
    private List<Cargo> cargos;
    private StorageKind storageKind;
    private static CargoController instance = null;

    private CargoController() {
        instance = null;
        storageKind = StorageKind.CSV_FILE_STORAGE;
        cargos = new CsvFileStorage<Cargo>("./cargos.csv")
                        .loadCSVRecords()
                        .getCsvCollection()
                        .stream()
                        .map((csvRecord) -> 
                            { return Cargo.fromCSVToCargo(csvRecord); })
                        .collect(Collectors.toList());
    }

    public CargoController getInstance() {
        if (instance == null) { 
            instance = new CargoController();
            return instance; 
        } else { return instance; }
    }
    public List<Cargo> getAllCargos() { cargos.sort(new Comparator<Cargo>() {
        public int compare(Cargo um, Cargo outr) { return um.getNome().compareTo(outr.getNome()); };});
        return cargos;
    }

    public void storeCargos() {
        switch (storageKind) {
            case CSV_FILE_STORAGE: { csvStorageBehaviour(); break; }
            default: defaultBehavior();
        }
    }

    private void defaultBehavior() {
        csvStorageBehaviour();
    }

    private void csvStorageBehaviour() {
        try { new CsvFileStorage<Cargo>("./cargos.csv").addCollection(cargos).save();}
        catch (IOException exception) { System.err.println("Error while saving usuarios.");}
    }

    public void addCargo(Cargo cargo) {
        cargos.add(cargo);
    }
}