package desafiofundecc.controller;

import java.util.ArrayList;
import java.util.List;

import desafiofundecc.model.Usuario;

public final class UsuarioController {
    List<Usuario> usuarios;
    StorageHandler<Usuario> storage;
    private UsuarioController instance;

    private UsuarioController() {
        usuarios = new ArrayList<Usuario>();
        storage = new CsvFileStorage<Usuario>("./usuarios.csv");
    }

    public UsuarioController getInstance() {
        if (instance == null) { 
            instance = new UsuarioController();
            return instance; 
        } else { return instance; }
    }
}
