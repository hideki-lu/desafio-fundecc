package desafiofundecc.controller;

import java.util.ArrayList;

import desafiofundecc.model.Cargo;

public final class CargoController {
    private ArrayList<Cargo> cargos;
    public CargoController() {
        cargos.stream().distinct()
    }
}