/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.reportes.html;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author fabricio
 */
public class ExportadorHTML extends javax.swing.JDialog {

    private String reporte = "";
    private int tipo = 0;
    private File direccion = null;
    /**
     * Creates new form exportadorHTML
     */
    public ExportadorHTML(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Exportador a html");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        obtenedorDireccionFileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        obtenedorDireccionFileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        obtenedorDireccionFileChooser.setDialogTitle("");
        obtenedorDireccionFileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        obtenedorDireccionFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtenedorDireccionFileChooserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 136));
        jLabel1.setText("Exportar HTML");

        jLabel2.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel2.setText("Seleccione la carpeta en la cual desea exportar el reporte en HTML");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(obtenedorDireccionFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel2)))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(obtenedorDireccionFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void obtenedorDireccionFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obtenedorDireccionFileChooserActionPerformed
        ManejadorReportes mr = new ManejadorReportes();
        obtenedorDireccionFileChooser = (JFileChooser) evt.getSource();
        String comando = evt.getActionCommand();
        File direccion = obtenedorDireccionFileChooser.getSelectedFile();
        if (comando.equals(JFileChooser.APPROVE_SELECTION)) {
            this.direccion = direccion;
            this.dispose();
        } else if (comando.equals(JFileChooser.CANCEL_SELECTION)) {
            this.dispose();
            this.direccion = null;
        }
    }//GEN-LAST:event_obtenedorDireccionFileChooserActionPerformed

    public void setReporte(String reporte, int tipo){
        this.tipo = tipo;
        this.reporte = reporte;
    }
    
    public File getFile(){
        return this.direccion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFileChooser obtenedorDireccionFileChooser;
    // End of variables declaration//GEN-END:variables
}
