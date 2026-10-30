import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            Dashboard modelo = new Dashboard();
            VistaDashboard vista = new VistaDashboard();

            ControladorDashboard controlador =
                new ControladorDashboard(modelo, vista);

            vista.setVisible(true);
        });
    }
}
