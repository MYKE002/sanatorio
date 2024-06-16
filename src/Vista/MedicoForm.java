/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.Especialidad;
import Modelo.Medico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class MedicoForm extends javax.swing.JInternalFrame {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public MedicoForm() {
        initComponents();
        entityManagerFactory = Persistence.createEntityManagerFactory("C:/sanatorio/medicos.odb");
        entityManager = entityManagerFactory.createEntityManager();
        CargarEspecialidades();
    }


    private void CargarEspecialidades() {
        try {
            Especialidad seleccionar = new Especialidad();
            seleccionar.setNombre("Seleccione una opción");
            comboEspecialidad.addItem(seleccionar.getNombre());

            entityManagerFactory = Persistence.createEntityManagerFactory("C:/sanatorio/especialidad.odb");
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createQuery("SELECT especialidadDb FROM Especialidad especialidadDb");
            List<Especialidad> especialidades = query.getResultList();

            for (Especialidad nombreArbitro : especialidades) {
                comboEspecialidad.addItem(nombreArbitro.getNombre());
            }

            comboEspecialidad.setSelectedIndex(0);
        } catch (Exception e) {
            System.err.println("Error al intentar listar los medicos: " + e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoCedula = new javax.swing.JTextField();
        comboEspecialidad = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        campoId = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("MEDICOS");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setText("Especialidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });
        jPanel1.add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 130, -1));

        jLabel4.setText("N° Cedula:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));
        jPanel1.add(campoCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 130, -1));

        comboEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEspecialidadActionPerformed(evt);
            }
        });
        jPanel1.add(comboEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 120, -1));

        jTable1.setBackground(new java.awt.Color(0, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Numero de Cedula", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 410, 240));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_guardar.png"))); // NOI18N
        jButton1.setToolTipText("GUARDAR"); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, 50));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_borrar.png"))); // NOI18N
        jButton2.setToolTipText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 50, 50));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_actualizar.png"))); // NOI18N
        jButton3.setToolTipText("ACTUALIZAR");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 50, 50));

        campoId.setEditable(false);
        jPanel1.add(campoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // Verificar si se ha seleccionado una especialidad
        // Verificar si se ha seleccionado una especialidad

        Especialidad especialidad = (Especialidad) comboEspecialidad.getSelectedItem();
        if (especialidad == null || "Seleccione una opción".equals(especialidad.getNombre())) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una especialidad.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener los valores de nombre y cédula
        String nombre = campoNombre.getText().trim();
        String cedula = campoCedula.getText().trim();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Iniciar una transacción
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            // Crear el objeto Medico con la especialidad seleccionada
            Medico medico = new Medico(nombre, cedula);
            medico.agregarEspecialidad(especialidad);

            // Guardar el objeto Medico en la base de datos
            entityManager.persist(medico);

            // Confirmar la transacción
            transaction.commit();
            JOptionPane.showMessageDialog(null, "Médico guardado satisfactoriamente.");

            // Limpiar los campos después de guardar
            campoNombre.setText("");
            campoCedula.setText("");

        } catch (Exception e) {
            // Manejo de errores
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Error al guardar el médico: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1MouseClicked

    private void comboEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEspecialidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoCedula;
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox<Object> comboEspecialidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
