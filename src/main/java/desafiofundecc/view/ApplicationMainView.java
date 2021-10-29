package desafiofundecc.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class ApplicationMainView extends JFrame {
    
    private JTable usuariosTable;
    private DefaultTableModel usuarioTableModel;
    private JScrollPane usuariosTablePane;
    public ApplicationMainView() {
        super("Gerenciamento de Usuário");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
    }
}