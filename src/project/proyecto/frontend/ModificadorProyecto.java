package project.proyecto.frontend;

import codeandbugs01.BaseDatos;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import project.proyecto.backend.ManejadorProyecto;
import project.proyecto.backend.Proyecto;
/**
 *
 * @author fabricio
 */
public class ModificadorProyecto extends javax.swing.JInternalFrame {
    
    private BaseDatos DB = null;
    private List<Proyecto> listaProyectos;
    private ObservableList<Proyecto> listaProyObserv;
    private Proyecto proyectoSeleccionado;
    
    public ModificadorProyecto(BaseDatos DB) {
        this.listaProyectos = new LinkedList<>();
        this.listaProyObserv = ObservableCollections.observableList(listaProyectos);
        this.proyectoSeleccionado = null;
        this.DB = DB;
        initComponents();
        actualizarProyectos();
        modificarBotones(false);
    }
    
    private void actualizarProyectos(){
        ManejadorProyecto mp = new ManejadorProyecto(this.DB);
        listaProyObserv.clear();
        listaProyObserv.addAll(mp.getProyectos());
    }

    public ObservableList<Proyecto> getListaProyectosObservable() {
        return listaProyObserv;
    }

    public void setListaProyectosObservable(ObservableList<Proyecto> listaProyectosObservable) {
        this.listaProyObserv = listaProyectosObservable;
    }

    public Proyecto getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    public void setProyectoSeleccionado(Proyecto proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
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
        jTableProyecto = new javax.swing.JTable();
        buttonModificar = new javax.swing.JButton();
        buttonDesactivar = new javax.swing.JButton();
        textFieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        formattedTextFieldDPI = new javax.swing.JFormattedTextField();
        buttonActivar = new javax.swing.JButton();

        setBackground(new java.awt.Color(2, 161, 192));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(2, 161, 192));

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Modificar Proyecto");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaProyectosObservable}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTableProyecto);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ID}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${DPIAdministrador}"));
        columnBinding.setColumnName("DPI Administrador");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(Byte.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${proyectoSeleccionado}"), jTableProyecto, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jTableProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProyectoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProyecto);

        buttonModificar.setBackground(new java.awt.Color(246, 145, 1));
        buttonModificar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonModificar.setForeground(new java.awt.Color(254, 254, 254));
        buttonModificar.setText("Modificar");
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        buttonDesactivar.setBackground(new java.awt.Color(254, 87, 87));
        buttonDesactivar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonDesactivar.setForeground(new java.awt.Color(254, 254, 254));
        buttonDesactivar.setText("Desactivar");
        buttonDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesactivarActionPerformed(evt);
            }
        });

        textFieldNombre.setBackground(new java.awt.Color(2, 124, 139));
        textFieldNombre.setForeground(new java.awt.Color(254, 254, 254));
        textFieldNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldNombre.setCaretColor(new java.awt.Color(254, 254, 254));
        textFieldNombre.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Nombre:");

        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("DPI Admin:");

        formattedTextFieldDPI.setBackground(new java.awt.Color(2, 124, 139));
        formattedTextFieldDPI.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        formattedTextFieldDPI.setForeground(new java.awt.Color(254, 254, 254));
        try {
            formattedTextFieldDPI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formattedTextFieldDPI.setCaretColor(new java.awt.Color(254, 254, 254));

        buttonActivar.setBackground(new java.awt.Color(50, 205, 50));
        buttonActivar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonActivar.setForeground(new java.awt.Color(254, 254, 254));
        buttonActivar.setText("Activar");
        buttonActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(110, 110, 110))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6)
                                .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(buttonDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(buttonActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModificar)
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDesactivar)
                    .addComponent(buttonActivar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProyectoMouseClicked
        textFieldNombre.setText(proyectoSeleccionado.getNombre());
        formattedTextFieldDPI.setText(Integer.toString(proyectoSeleccionado.getDPIAdministrador()));
        buttonModificar.setEnabled(true);
        if(proyectoSeleccionado.getEstado() == 1){
            buttonDesactivar.setEnabled(true);
        } else {
            buttonDesactivar.setEnabled(false);
        }
        if(proyectoSeleccionado.getEstado() == 0){
            buttonActivar.setEnabled(true);
        } else {
            buttonActivar.setEnabled(false);
        }
    }//GEN-LAST:event_jTableProyectoMouseClicked

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        ManejadorProyecto mp = new ManejadorProyecto(this.DB);
        try {
            mp.updateProyecto(proyectoSeleccionado, textFieldNombre.getText().trim(), formattedTextFieldDPI.getText().trim());
            JOptionPane.showMessageDialog(rootPane, "Se ha modificado exitosamente el proyecto \"" + textFieldNombre.getText() + "\"", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
            actualizarProyectos();
            modificarBotones(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Error de validacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void buttonDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesactivarActionPerformed
        ManejadorProyecto mp = new ManejadorProyecto(this.DB);
        mp.modifyStatusProyecto(proyectoSeleccionado, "0");
        JOptionPane.showMessageDialog(rootPane, "Se ha desactivado el proyecto \"" + proyectoSeleccionado.getNombre() + "\"", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
        modificarBotones(false);
        actualizarProyectos();
    }//GEN-LAST:event_buttonDesactivarActionPerformed

    private void buttonActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActivarActionPerformed
        ManejadorProyecto mp = new ManejadorProyecto(this.DB);
        mp.modifyStatusProyecto(proyectoSeleccionado, "1");
        JOptionPane.showMessageDialog(rootPane, "Se ha Activado el proyecto \"" + proyectoSeleccionado.getNombre() + "\"", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
        modificarBotones(false);
        actualizarProyectos();
    }//GEN-LAST:event_buttonActivarActionPerformed

    private void modificarBotones(boolean estado){
        buttonDesactivar.setEnabled(estado);
        buttonModificar.setEnabled(estado);
        buttonActivar.setEnabled(estado);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActivar;
    private javax.swing.JButton buttonDesactivar;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JButton buttonRegistrar;
    private javax.swing.JFormattedTextField formattedTextFieldDPI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableProyecto;
    private javax.swing.JTextField textFieldNombre;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
