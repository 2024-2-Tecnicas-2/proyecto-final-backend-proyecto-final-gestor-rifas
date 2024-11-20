package Interfaz;

import com.mycompany.mavenproject1.GestorRifas;
import javax.swing.*;
import java.awt.*;

public class MostrarBoletas extends javax.swing.JFrame {

   public MostrarBoletas(GestorRifas gestorRifas) {
        setTitle("Estado de Boletas");
        setSize(600, 400);
        setLayout(new GridLayout(0, 10)); 

        gestorRifas.getRifaActual().getBoletas().forEach(boleta -> {
            JButton button = new JButton(String.valueOf(boleta.getNumero()));
            button.setBackground(boleta.isVendida() ? Color.RED : Color.GREEN);
            button.setForeground(Color.WHITE);
            add(button);
        });

        setVisible(true);
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
