package desafiofundecc;

import desafiofundecc.controller.CargoController;
import desafiofundecc.controller.UsuarioController;
import desafiofundecc.view.ApplicationMainView;

public final class Application {
    private UsuarioController usuarioController;
    private CargoController cargoController;
    private ApplicationMainView appMainView;
    public Application() {
        usuarioController = usuarioController.getInstance();
        cargoController = cargoController.getInstance();
        appMainView = new ApplicationMainView();
    }

    public static void main(String[] args) {
        new Application();
    }
}