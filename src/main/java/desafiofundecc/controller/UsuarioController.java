package desafiofundecc.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import desafiofundecc.controller.csvstorage.CsvFileStorage;
import desafiofundecc.controller.storageinterfaces.StorageKind;
import desafiofundecc.model.Usuario;

public final class UsuarioController {
    private List<Usuario> usuarios;
    private StorageKind storageKind;
    private UsuarioController instance;
    public UsuarioController getInstance() {
        if (instance == null) { 
            instance = new UsuarioController();
            return instance; 
        } else { return instance; }
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarios;
    }
    private UsuarioController() {
        usuarios = loadUsuariosList();
        storageKind = StorageKind.CSV_FILE_STORAGE;
    }
    public void storeUsuarios() {
        switch (storageKind) {
            case CSV_FILE_STORAGE: { csvStorageBehaviour(); break; }
            default: defaultBehavior();
        }
    }

    private List<Usuario> loadUsuariosList() {
        return new CsvFileStorage<Usuario>("./usuarios.csv")
                    .loadCSVRecords()
                    .getCsvCollection()
                    .stream()
                    .map((csvRecord) -> { return Usuario.fromCVSToUsuario(csvRecord); })
                    .collect(Collectors.toList());
    }
    private void defaultBehavior() {
        csvStorageBehaviour();
    }

    private void csvStorageBehaviour() {
        try { new CsvFileStorage<Usuario>("./usuarios.csv").addCollection(usuarios).save();}
        catch (IOException exception) { System.err.println("Error while saving usuarios.");}
    }
}
