/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.usuario.frontend;

/**
 *
 * @author fabricio
 */
public class CreadorUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form CreadorUsuario
     */
    public CreadorUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        comboBoxTipo = new javax.swing.JComboBox<>();
        textFieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        buttonRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        formattedTextFieldDPI = new javax.swing.JFormattedTextField();
        textFieldApellido = new javax.swing.JTextField();
        textFieldUsuario = new javax.swing.JTextField();
        textFieldPassword = new javax.swing.JTextField();

        jTextField7.setBackground(new java.awt.Color(254, 254, 254));
        jTextField7.setForeground(new java.awt.Color(1, 1, 1));
        jTextField7.setCaretColor(new java.awt.Color(1, 1, 1));
        jTextField7.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jTextField8.setBackground(new java.awt.Color(254, 254, 254));
        jTextField8.setForeground(new java.awt.Color(1, 1, 1));
        jTextField8.setCaretColor(new java.awt.Color(1, 1, 1));
        jTextField8.setMargin(new java.awt.Insets(5, 5, 5, 5));

        setBackground(new java.awt.Color(2, 161, 192));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setTitle("Creacion/Registro de Usuario");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(2, 161, 192));

        comboBoxTipo.setBackground(new java.awt.Color(2, 124, 139));
        comboBoxTipo.setForeground(new java.awt.Color(254, 254, 254));
        comboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1. Administrador de Sistema", "2. Administrador de Proyecto", "3. Desarrollador" }));
        comboBoxTipo.setToolTipText("Seleccione una opcion");

        textFieldNombre.setBackground(new java.awt.Color(2, 124, 139));
        textFieldNombre.setForeground(new java.awt.Color(254, 254, 254));
        textFieldNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldNombre.setCaretColor(new java.awt.Color(254, 254, 254));
        textFieldNombre.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Nombre*:");

        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Apellido*:");

        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("DPI*:");

        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Tipo*:");

        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Nombre Usuario*:");

        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Contraseña*:");

        buttonRegistrar.setBackground(new java.awt.Color(246, 145, 1));
        buttonRegistrar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        buttonRegistrar.setForeground(new java.awt.Color(254, 254, 254));
        buttonRegistrar.setText("Registrar");
        buttonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Creacion Usuario");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        formattedTextFieldDPI.setBackground(new java.awt.Color(2, 124, 139));
        formattedTextFieldDPI.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        formattedTextFieldDPI.setForeground(new java.awt.Color(254, 254, 254));
        try {
            formattedTextFieldDPI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formattedTextFieldDPI.setCaretColor(new java.awt.Color(254, 254, 254));

        textFieldApellido.setBackground(new java.awt.Color(2, 124, 139));
        textFieldApellido.setForeground(new java.awt.Color(254, 254, 254));
        textFieldApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldApellido.setCaretColor(new java.awt.Color(254, 254, 254));
        textFieldApellido.setMargin(new java.awt.Insets(5, 5, 5, 5));

        textFieldUsuario.setBackground(new java.awt.Color(2, 124, 139));
        textFieldUsuario.setForeground(new java.awt.Color(254, 254, 254));
        textFieldUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldUsuario.setCaretColor(new java.awt.Color(254, 254, 254));
        textFieldUsuario.setMargin(new java.awt.Insets(5, 5, 5, 5));

        textFieldPassword.setBackground(new java.awt.Color(2, 124, 139));
        textFieldPassword.setForeground(new java.awt.Color(254, 254, 254));
        textFieldPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldPassword.setCaretColor(new java.awt.Color(254, 254, 254));
        textFieldPassword.setMargin(new java.awt.Insets(5, 5, 5, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldNombre)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textFieldApellido)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxTipo, 0, 210, Short.MAX_VALUE)
                    .addComponent(textFieldPassword))
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(buttonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarActionPerformed
        
    }//GEN-LAST:event_buttonRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRegistrar;
    private javax.swing.JComboBox<String> comboBoxTipo;
    private javax.swing.JFormattedTextField formattedTextFieldDPI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField textFieldApellido;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldPassword;
    private javax.swing.JTextField textFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
