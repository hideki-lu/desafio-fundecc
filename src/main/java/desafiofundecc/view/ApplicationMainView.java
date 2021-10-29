package desafiofundecc.view;

import java.util.ArrayList;
import java.util.List;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import desafiofundecc.model.Cargo;
import desafiofundecc.model.Usuario;

public final class ApplicationMainView extends JFrame {
    private List<Usuario> usuariosData;
    private List<Cargo> cargosData;

    private JList<Usuario> usuariosList;
    private JList<Cargo> cargosList;
    private JScrollPane usuariosListPane;
    private JScrollPane cargosListPane;

    // Layout Objects Configuration
    private GridBagLayout layout;
    private GridBagConstraints layoutConstraints;
    public ApplicationMainView() {
        super("Gerenciamento de Usuário");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setResizable(true);

        buildView();
        setVisible(true);
    }

    private void buildView() {
        usuariosList = new JList<Usuario>(usuariosListModel());
        usuariosListPane = new JScrollPane(usuariosList);
        addComponent(usuariosListPane, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, 0, 0, 1, 1);
        
        cargosList = new JList<Cargo>(cargosListModel());
        cargosListPane = new JScrollPane(cargosList);
        addComponent(cargosListPane, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, 0, 2, 1, 1);
    }

    private DefaultListModel<Usuario> usuariosListModel() {
        var usuariosModel = new DefaultListModel<Usuario>();
        for (var usuario : usuariosData)
            usuariosModel.addElement(usuario);
        return usuariosModel;
    }
    private DefaultListModel<Cargo> cargosListModel() {
        var cargosModel = new DefaultListModel<Cargo>();
        for (var cargo : cargosData)
            cargosModel.addElement(cargo);
        return cargosModel;
    }
    public void populateUsuariosData(List<Usuario> usuarios) {
        usuariosData = new ArrayList<Usuario>(usuarios);
    }

    public void populateCargosData(List<Cargo> cargos) {
        cargosData = new ArrayList<Cargo>(cargos);
    }

    private void addComponent(Component component, int anchor, int fill, int row, int column, int width, int height) {
        layoutConstraints.anchor = anchor;
        layoutConstraints.fill = fill;
        layoutConstraints.gridy = row;
        layoutConstraints.gridx = column;
        layoutConstraints.gridwidth = width;
        layoutConstraints.gridheight = height;
        layoutConstraints.insets = new Insets(2, 2, 2, 2);
        layout.setConstraints(component, layoutConstraints);
        this.add(component);
    }
}