package Interfaz;
import com.mycompany.mavenproject1.GestorRifas;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Menu extends javax.swing.JFrame {

    private final GestorRifas gestorRifas;

    public Menu() {
        gestorRifas = new GestorRifas();
        gestorRifas.cargarDatosRifas(); 
        setupMenu();
    }

    private void setupMenu() {
        setTitle("Sistema de Gestión de Rifas");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 1)); 

        
        add(createMenuButton("Menú Rifas existentes", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new RifaMenu(gestorRifas).setVisible(true);
            }
        }));

        add(createMenuButton("Vender boleta", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new VenderBoleta(gestorRifas).setVisible(true);
            }
        }));

        add(createMenuButton("Actualizar estado de pago", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new ActualizarPago(gestorRifas).setVisible(true);
            }
        }));

        add(createMenuButton("Mostrar información de la rifa", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                gestorRifas.mostrarInformacionRifa();
            }
        }));

        add(createMenuButton("Mostrar estado de boletas", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new MostrarBoletas(gestorRifas).setVisible(true);
            }
        }));

        add(createMenuButton("Buscar boleta", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new BuscarBoleta(gestorRifas).setVisible(true);
            }
        }));

        add(createMenuButton("Eliminar boleta", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new EliminarBoleta(gestorRifas).setVisible(true);
            }
        }));

        add(createMenuButton("Guardar y cargar datos", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                gestorRifas.guardarDatosRifas();
                JOptionPane.showMessageDialog(Menu.this, "Datos guardados exitosamente.");
            }
        }));

        add(createMenuButton("Salir", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.exit(0);
            }
        }));
    }

    private JButton createMenuButton(String text, AbstractAction action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        return button;
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
