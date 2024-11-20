package Interfaz;

import com.mycompany.mavenproject1.GestorRifas;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class RifaMenu extends javax.swing.JFrame {

    public RifaMenu(GestorRifas gestorRifas) {
        setTitle("Menú Rifas");
        setSize(400, 300);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton crearRifaButton = new JButton("Crear nueva rifa");
        crearRifaButton.addActionListener(e -> crearRifa(gestorRifas));

        JButton eliminarRifaButton = new JButton("Eliminar rifa existente");
        eliminarRifaButton.addActionListener(e -> eliminarRifa(gestorRifas));

        add(crearRifaButton);
        add(eliminarRifaButton);

        setVisible(true);
    }

    private void crearRifa(GestorRifas gestorRifas) {
        JTextField sizeField = new JTextField();
        JTextField loteriaField = new JTextField();
        JTextField fechaField = new JTextField();

        Object[] inputs = {
            "Tamaño de la rifa:", sizeField,
            "Lotería:", loteriaField,
            "Fecha (DD/MM/AAAA):", fechaField
        };

        int option = JOptionPane.showConfirmDialog(this, inputs, "Crear nueva rifa", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int tamaño = Integer.parseInt(sizeField.getText());
                String loteria = loteriaField.getText();
                String fecha = fechaField.getText();
                gestorRifas.crearRifa(tamaño, loteria, fecha);
                JOptionPane.showMessageDialog(this, "Rifa creada exitosamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Entrada inválida. Verifique los datos.");
            }
        }
    }

    private void eliminarRifa(GestorRifas gestorRifas) {
        JTextField rifaIDField = new JTextField();

        Object[] inputs = {
            "ID de la rifa a eliminar:", rifaIDField
        };

        int option = JOptionPane.showConfirmDialog(this, inputs, "Eliminar rifa", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(rifaIDField.getText());
                gestorRifas.eliminarRifa(id);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Entrada inválida. Verifique los datos.");
            }
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
