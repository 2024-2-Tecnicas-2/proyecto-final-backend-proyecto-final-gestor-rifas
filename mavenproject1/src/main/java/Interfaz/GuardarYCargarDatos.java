package Interfaz;

import com.mycompany.mavenproject1.GestorRifas;
import javax.swing.*;

public class GuardarYCargarDatos extends javax.swing.JFrame {

    public GuardarYCargarDatos(GestorRifas gestorRifas) {
        setTitle("Guardar y Cargar Datos");
        setSize(300, 200);

        int option = JOptionPane.showConfirmDialog(this,
                "¿Desea guardar y cargar los datos?",
                "Guardar y Cargar Datos",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            gestorRifas.guardarDatosRifas();
            gestorRifas.cargarDatosRifas();
            JOptionPane.showMessageDialog(this, "Datos guardados y cargados exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se realizaron cambios.");
        }
    }
    public void CerrarVentana() {
        dispose(); 
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
