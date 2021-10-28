package desafiofundecc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private UsuarioController() {
        usuarios = new ArrayList<Usuario>();
        storageKind = StorageKind.CSV_FILE_STORAGE;
    }
    public void storeUsuarios() {
        switch (storageKind) {
            case CSV_FILE_STORAGE: { csvStorageBehaviour(); break; }
            default: defaultBehavior();
        }
    }
    private void defaultBehavior() {
        csvStorageBehaviour();
    }

    private void csvStorageBehaviour() {
        try { new CsvFileStorage<Usuario>("./usuarios.csv").addCollection(usuarios).save();}
        catch (IOException exception) { System.err.println("Error while saving usuarios.");}
    }
}
