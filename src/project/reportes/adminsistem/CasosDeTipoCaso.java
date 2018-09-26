package project.reportes.adminsistem;

import codeandbugs01.BaseDatos;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import project.caso.backend.Caso;
import project.caso.backend.ManejadorCaso;
import project.caso.backend.TipoCaso;
import project.proyecto.backend.ManejadorProyecto;
import project.proyecto.backend.Proyecto;
import project.reportes.html.ExportadorHTML;
import project.reportes.html.ManejadorReportes;

/**
 *
 * @author fabricio
 */
public class CasosDeTipoCaso extends javax.swing.JInternalFrame {

    private BaseDatos DB = null; 
    private List<TipoCaso> listaTipoCasos = null;
    private List<Caso> listaCasos = null;
    private ObservableList<Caso> listaCasosObsr = null;
    /**
     * Creates new form CasosDeProyecto
     */
    public CasosDeTipoCaso(BaseDatos DB) {
        this.DB = DB;
        this.listaTipoCasos = new LinkedList<>();
        this.listaCasos = new LinkedList<>();
        this.listaCasosObsr = ObservableCollections.observableList(listaCasos);
        initComponents();
        actualizarTipoCasos();
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
        buttonTodo = new javax.swing.JButton();
        jComboBoxTipoCaso = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        buttonTodo1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(2, 161, 192));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(2, 161, 192));

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Casos de Proyecto");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaCasosObsr}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ID}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${avance}"));
        columnBinding.setColumnName("Avance");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaEntrega}"));
        columnBinding.setColumnName("Fecha Entrega");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaInicio}"));
        columnBinding.setColumnName("Fecha Inicio");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaLimite}"));
        columnBinding.setColumnName("Fecha Limite");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProyecto}"));
        columnBinding.setColumnName("Id Proyecto");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${motivoCancelacion}"));
        columnBinding.setColumnName("Cancelacion");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipoCaso}"));
        columnBinding.setColumnName("Tipo Caso");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        buttonTodo.setBackground(new java.awt.Color(246, 145, 1));
        buttonTodo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonTodo.setForeground(new java.awt.Color(254, 254, 254));
        buttonTodo.setText("Mostrar");
        buttonTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTodoActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Tipo Caso:");

        buttonTodo1.setBackground(new java.awt.Color(246, 145, 1));
        buttonTodo1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonTodo1.setForeground(new java.awt.Color(254, 254, 254));
        buttonTodo1.setText("Exportar a HTML");
        buttonTodo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTodo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTipoCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(206, 206, 206))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(buttonTodo1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTodo)
                    .addComponent(jComboBoxTipoCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonTodo1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTodoActionPerformed
        actualizarCasos();
    }//GEN-LAST:event_buttonTodoActionPerformed

    private void buttonTodo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTodo1ActionPerformed
        ExportadorHTML exportador = new ExportadorHTML(null, closable);
        ManejadorReportes mr = new ManejadorReportes();
        exportador.setVisible(true);
        mr.exportarHtmlCasosTipoCaso(exportador.getFile(), listaCasosObsr);
        JOptionPane.showMessageDialog(rootPane, "Se ha guardado exitosamente el archivo HTML deseado", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_buttonTodo1ActionPerformed

    private void actualizarTipoCasos(){
        ManejadorCaso mc = new ManejadorCaso(DB);
        this.listaTipoCasos.clear();
        if(mc.getTipoCaso() != null){
            this.listaTipoCasos.addAll(mc.getTipoCaso());
            for (TipoCaso tipoCasos : listaTipoCasos) {
                jComboBoxTipoCaso.addItem(tipoCasos.getNombre());
            }
        }
    }
    
    private void actualizarCasos(){
        ManejadorCaso mc = new ManejadorCaso(DB);
        this.listaCasosObsr.clear();
        if(mc.getCasoByTipoCaso((String) jComboBoxTipoCaso.getSelectedItem()) != null){
            this.listaCasosObsr.addAll(mc.getCasoByTipoCaso((String) jComboBoxTipoCaso.getSelectedItem()));
        }
    }

    public ObservableList<Caso> getListaCasosObsr() {
        return listaCasosObsr;
    }

    public void setListaCasosObsr(ObservableList<Caso> listaCasosObsr) {
        this.listaCasosObsr = listaCasosObsr;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTodo;
    private javax.swing.JButton buttonTodo1;
    private javax.swing.JComboBox<String> jComboBoxTipoCaso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
