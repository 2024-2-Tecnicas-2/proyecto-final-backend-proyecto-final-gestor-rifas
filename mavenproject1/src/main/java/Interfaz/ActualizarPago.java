package Interfaz;

import com.mycompany.mavenproject1.GestorRifas;
import javax.swing.*;

public class ActualizarPago extends javax.swing.JFrame {

    public ActualizarPago(GestorRifas gestorRifas) {
        setTitle("Actualizar Estado de Pago");
        setSize(400, 300);

        JTextField numeroField = new JTextField();
        JComboBox<String> nuevoEstadoField = new JComboBox<>(new String[]{"Pago", "Pendiente"});

        Object[] inputs = {
            "Número de boleta:", numeroField,
            "Nuevo estado de pago:", nuevoEstadoField
        };

        int option = JOptionPane.showConfirmDialog(this, inputs, "Actualizar Estado de Pago", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int numero = Integer.parseInt(numeroField.getText());
                String nuevoEstado = (String) nuevoEstadoField.getSelectedItem();
                gestorRifas.actualizarEstadoPago(numero, nuevoEstado);
                JOptionPane.showMessageDialog(this, "Estado de pago actualizado correctamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Entrada inválida. Verifique los datos.");
            }
        }
        
    }
    public void closeWindow() {
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
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ActualizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
        //</editor-fold>

        /* Create and display the form */

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
}
