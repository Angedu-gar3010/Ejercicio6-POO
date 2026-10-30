public class ControladorDashboard {

    private Dashboard modelo;
    private VistaDashboard vista;

    public ControladorDashboard(Dashboard modelo, VistaDashboard vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.mostrarWidgets(modelo.getWidgets());

        vista.getBotonOrdenar().addActionListener(e -> {
            modelo.ordenarPorMemoria();
            vista.mostrarWidgets(modelo.getWidgets());
        });

        vista.getBotonActualizar().addActionListener(e -> {
            vista.mostrarWidgets(modelo.getWidgets());
        });
    }
}