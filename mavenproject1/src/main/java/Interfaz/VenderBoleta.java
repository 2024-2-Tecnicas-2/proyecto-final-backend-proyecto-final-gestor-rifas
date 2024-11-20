package Interfaz;

import com.mycompany.mavenproject1.GestorRifas;
import javax.swing.*;

public class VenderBoleta extends javax.swing.JFrame {

    public VenderBoleta(GestorRifas gestorRifas) {

        setTitle("Vender Boleta");
        setSize(400, 300);

        JTextField numeroField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField telefonoField = new JTextField();
        JTextField correoField = new JTextField();
        JTextField direccionField = new JTextField();
        JComboBox<String> estadoPagoField = new JComboBox<>(new String[]{"Pago", "Pendiente"});

        Object[] inputs = {
            "Número de boleta:", numeroField,
            "Nombre del comprador:", nombreField,
            "Teléfono del comprador:", telefonoField,
            "Correo del comprador:", correoField,
            "Dirección del comprador:", direccionField,
            "Estado de pago:", estadoPagoField
        };

        int option = JOptionPane.showConfirmDialog(this, inputs, "Vender Boleta", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int numero = Integer.parseInt(numeroField.getText());
                String nombre = nombreField.getText();
                String telefono = telefonoField.getText();
                String correo = correoField.getText();
                String direccion = direccionField.getText();
                String estadoPago = (String) estadoPagoField.getSelectedItem();

                if (!Validador.isPositiveNumber(numero)) {
                    JOptionPane.showMessageDialog(this, "El número de boleta debe ser positivo.");
                } else if (!Validador.isNotEmpty(nombre)) {
                    JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
                } else if (!Validador.isValidPhone(telefono)) {
                    JOptionPane.showMessageDialog(this, "Teléfono inválido. Debe tener 10 dígitos.");
                } else if (!Validador.isValidEmail(correo)) {
                    JOptionPane.showMessageDialog(this, "Correo inválido.");
                } else {
                    gestorRifas.venderBoleta(numero, nombre, telefono, correo, direccion, estadoPago);
                    JOptionPane.showMessageDialog(this, "Boleta vendida exitosamente.");
                     this.dispose(); 
                     
                    
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El número de boleta debe ser un valor numérico.");
                
            }
            } else {
            this.dispose(); 
             
        }
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
