/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.etapa.frontend;

import codeandbugs01.BaseDatos;
import java.util.LinkedList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import project.etapa.backend.Etapa;
import project.etapa.backend.ManejadorEtapa;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class RegistradorTrabajoEtapa extends javax.swing.JInternalFrame {

    private BaseDatos DB = null;
    private List<Etapa> listaEtapas = null;
    private ObservableList<Etapa> listaEtapasObs = null;
    private Etapa etapaSelecc = null;
    private Usuario usuario = null;
    
    public RegistradorTrabajoEtapa(BaseDatos DB, Usuario usuario) {
        this.DB = DB;
        this.listaEtapas = new LinkedList<>();
        this.listaEtapasObs = ObservableCollections.observableList(listaEtapas);
        this.etapaSelecc = new Etapa(0, 0, null, 0, new Byte("0"), 0,0);
        this.usuario = usuario;
        initComponents();
        actualizarLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        textFieldNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        buttonModificar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        formattedTextFieldFechaLim = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(30, 144, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setTitle("Entregar Trabajo");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 144, 255));
        jLabel1.setText("Entrega de Trabajo");

        jSeparator1.setForeground(new java.awt.Color(30, 144, 255));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaEtapasObs}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numeroPaso}"));
        columnBinding.setColumnName("Numero de Paso");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idCaso}"));
        columnBinding.setColumnName("ID Caso");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${aprobacion}"));
        columnBinding.setColumnName("Aprobacion");
        columnBinding.setColumnClass(Byte.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${horasTrabajadas}"));
        columnBinding.setColumnName("Horas Trabajadas");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        textFieldNombre.setBackground(new java.awt.Color(192, 192, 192));
        textFieldNombre.setForeground(new java.awt.Color(254, 254, 254));
        textFieldNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldNombre.setCaretColor(new java.awt.Color(254, 254, 254));
        textFieldNombre.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel5.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(105, 105, 105));
        jLabel5.setText("COMENTARIO:");

        buttonModificar.setBackground(new java.awt.Color(30, 144, 255));
        buttonModificar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonModificar.setForeground(new java.awt.Color(254, 254, 254));
        buttonModificar.setText("ENTREGAR");
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(105, 105, 105));
        jLabel6.setText("HORAS:");

        formattedTextFieldFechaLim.setBackground(new java.awt.Color(192, 192, 192));
        formattedTextFieldFechaLim.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        formattedTextFieldFechaLim.setForeground(new java.awt.Color(254, 254, 254));
        formattedTextFieldFechaLim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###.00"))));
        formattedTextFieldFechaLim.setCaretColor(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(89, 89, 89))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(formattedTextFieldFechaLim, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formattedTextFieldFechaLim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        
    }//GEN-LAST:event_buttonModificarActionPerformed

    public ObservableList<Etapa> getListaEtapasObs() {
        return listaEtapasObs;
    }

    public void setListaEtapasObs(ObservableList<Etapa> listaEtapasObs) {
        this.listaEtapasObs = listaEtapasObs;
    }

    public Etapa getEtapaSelecc() {
        return etapaSelecc;
    }

    public void setEtapaSelecc(Etapa etapaSelecc) {
        this.etapaSelecc = etapaSelecc;
    }
    
    private void actualizarLista(){
        ManejadorEtapa me = new ManejadorEtapa(this.DB);
        listaEtapasObs.clear();
        if (me.getEtapaByDpiDesarr(this.usuario) != null){
            listaEtapasObs.addAll(me.getEtapaByDpiDesarr(this.usuario));
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonModificar;
    private javax.swing.JFormattedTextField formattedTextFieldFechaLim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textFieldNombre;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}