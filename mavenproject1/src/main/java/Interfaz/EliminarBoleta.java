package Interfaz;

import com.mycompany.mavenproject1.GestorRifas;
import javax.swing.*;

public class EliminarBoleta extends javax.swing.JFrame {

    public EliminarBoleta(GestorRifas gestorRifas) {
        setTitle("Eliminar Boleta");
        setSize(400, 200);

        JTextField numeroField = new JTextField();

        Object[] inputs = {
            "Número de boleta a eliminar:", numeroField
        };

        int option = JOptionPane.showConfirmDialog(this, inputs, "Eliminar Boleta", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int numero = Integer.parseInt(numeroField.getText());
                gestorRifas.eliminarBoleta(numero);
                JOptionPane.showMessageDialog(this, "Boleta eliminada correctamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Entrada inválida. Verifique los datos.");
            }
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

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
