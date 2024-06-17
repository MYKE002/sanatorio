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
import javax.swing.table.DefaultTableModel;

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
        llenarTabla();
        CargarEspecialidades(); // Llamar a este método para cargar las especialidades
        modifyButton.setEnabled(false);
        saveButton.setEnabled(true);
        deleteButton.setEnabled(false);
    }

    private void CargarEspecialidades() {
        EntityManager localEntityManager = null;
        EntityManagerFactory localEntityManagerFactory = null;
        try {
            comboEspecialidad.removeAllItems(); // Limpiar el combo box antes de cargar las especialidades

            // Crear y agregar un ítem inicial
            Especialidad seleccionar = new Especialidad();
            seleccionar.setNombre("Seleccione una opción");
            comboEspecialidad.addItem(seleccionar);

            // Cargar las especialidades desde la base de datos
            localEntityManagerFactory = Persistence.createEntityManagerFactory("C:/sanatorio/especialidad.odb");
            localEntityManager = localEntityManagerFactory.createEntityManager();
            Query query = localEntityManager.createQuery("SELECT especialidadDb FROM Especialidad especialidadDb");
            List<Especialidad> especialidades = query.getResultList();

            // Agregar las especialidades al combo box
            for (Especialidad especialidad : especialidades) {
                comboEspecialidad.addItem(especialidad);
            }

            // Seleccionar el primer ítem por defecto
            comboEspecialidad.setSelectedIndex(0);

        } catch (Exception e) {
            System.err.println("Error al intentar listar los medicos: " + e);
        } finally {
            if (localEntityManager != null) {
                localEntityManager.close();
            }
            if (localEntityManagerFactory != null) {
                localEntityManagerFactory.close();
            }
        }
    }

    public void llenarTabla() {
        Query query = entityManager.createQuery("SELECT medicoDb FROM Medico medicoDb");
        List<Medico> result = query.getResultList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Medico medicoDb : result) {
            model.addRow(new Object[]{medicoDb.getId(), medicoDb.getNombre(), medicoDb.getCedula(), medicoDb.getEspecialidades()});
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
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Numero de Cedula", "Nombre", "Especialidad"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 410, 240));

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_guardar.png"))); // NOI18N
        saveButton.setToolTipText("GUARDAR"); // NOI18N
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, 50));

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_borrar.png"))); // NOI18N
        deleteButton.setToolTipText("ELIMINAR");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 50, 50));

        modifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_actualizar.png"))); // NOI18N
        modifyButton.setToolTipText("ACTUALIZAR");
        modifyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyButtonMouseClicked(evt);
            }
        });
        jPanel1.add(modifyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 50, 50));

        campoId.setEditable(false);
        jPanel1.add(campoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        Especialidad especialidad = (Especialidad) comboEspecialidad.getSelectedItem();
        if (especialidad == null || "Seleccione una opción".equals(especialidad.getNombre())) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una especialidad.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombre = campoNombre.getText().trim();
        String cedula = campoCedula.getText().trim();

        if (nombre.isEmpty() || cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            Medico medico = new Medico(nombre, cedula);

            // Verificar si la especialidad ya existe en la base de datos
            Especialidad especialidadExistente = entityManager.find(Especialidad.class, especialidad.getId());
            if (especialidadExistente != null) {
                medico.agregarEspecialidad(especialidadExistente);
            } else {
                medico.agregarEspecialidad(especialidad);
            }

            entityManager.persist(medico);
            transaction.commit();
            JOptionPane.showMessageDialog(null, "Médico guardado satisfactoriamente.");

            campoNombre.setText("");
            campoCedula.setText("");
            llenarTabla();

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Error al guardar el médico: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_saveButtonMouseClicked

    private void comboEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEspecialidadActionPerformed

    private void modifyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyButtonMouseClicked
        // Obtener el ID del médico seleccionado para modificar
        long id;
        try {
            id = Long.parseLong(campoId.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID de médico no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar el médico en la base de datos
        Medico medico = entityManager.find(Medico.class, id);

        if (medico == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún médico con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener la especialidad seleccionada del combo box
        Especialidad especialidadSeleccionada = (Especialidad) comboEspecialidad.getSelectedItem();

        if (especialidadSeleccionada == null || "Seleccione una opción".equals(especialidadSeleccionada.getNombre())) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una especialidad.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Buscar la especialidad existente en la base de datos
        Especialidad especialidad = entityManager.find(Especialidad.class, especialidadSeleccionada.getId());

        if (especialidad == null) {
            JOptionPane.showMessageDialog(null, "La especialidad seleccionada no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener los valores de nombre y cédula para actualizar
        String nombre = campoNombre.getText().trim();
        String cedula = campoCedula.getText().trim();

        if (nombre.isEmpty() || cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Iniciar una transacción
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            // Actualizar los datos del médico
            medico.setNombre(nombre);
            medico.setCedula(cedula);
            medico.getEspecialidades().clear(); // Limpiar las especialidades actuales
            medico.agregarEspecialidad(especialidad); // Agregar la especialidad existente seleccionada

            // Confirmar la transacción
            entityManager.merge(medico);
            transaction.commit();
            JOptionPane.showMessageDialog(null, "Médico actualizado satisfactoriamente.");

            // Limpiar los campos después de actualizar
            campoId.setText("");
            campoNombre.setText("");
            campoCedula.setText("");

            // Habilitar los botones y campos después de actualizar
            saveButton.setEnabled(true);
            modifyButton.setEnabled(false);
            deleteButton.setEnabled(false);

            // Actualizar la tabla
            llenarTabla();

        } catch (Exception e) {
            // Manejo de errores
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Error al actualizar el médico: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_modifyButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        //// Obtener el ID del médico seleccionado para modificar
        long id = Long.parseLong(campoId.getText());

        // Buscar el médico en la base de datos
        Medico medico = entityManager.find(Medico.class, id);

        if (medico == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún médico con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener la especialidad seleccionada del combo box
        Especialidad especialidad = (Especialidad) comboEspecialidad.getSelectedItem();

        if (especialidad == null || "Seleccione una opción".equals(especialidad.getNombre())) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una especialidad.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener los valores de nombre y cédula para actualizar
        String nombre = campoNombre.getText().trim();
        String cedula = campoCedula.getText().trim();

        if (nombre.isEmpty() || cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            // Iniciar una transacción
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            // Actualizar los datos del médico
            medico.setNombre(nombre);
            medico.setCedula(cedula);
            medico.getEspecialidades().clear(); // Limpiar las especialidades actuales
            medico.agregarEspecialidad(especialidad); // Agregar la nueva especialidad seleccionada

            // Confirmar la transacción
            entityManager.merge(medico);
            transaction.commit();
            JOptionPane.showMessageDialog(null, "Médico actualizado satisfactoriamente.");

            // Limpiar los campos después de actualizar
            campoId.setText("");
            campoNombre.setText("");
            campoCedula.setText("");

            // Habilitar los botones y campos después de actualizar
            saveButton.setEnabled(true);
            modifyButton.setEnabled(false);
            deleteButton.setEnabled(false);

            // Actualizar la tabla
            llenarTabla();

        } catch (Exception e) {
            // Manejo de errores
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Error al actualizar el médico: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getButton() == 1) { // Botón izquierdo del ratón
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            // Obtener el ID del médico desde la tabla (debes asegurarte de que la primera columna sea el ID)
            long id = (long) jTable1.getValueAt(row, 0);

            // Buscar el médico en la base de datos
            Medico medico = entityManager.find(Medico.class, id);

            if (medico == null) {
                JOptionPane.showMessageDialog(null, "No se encontró ningún médico con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Mostrar los datos del médico en los campos correspondientes
            campoId.setText(String.valueOf(medico.getId()));
            campoNombre.setText(medico.getNombre());
            campoCedula.setText(medico.getCedula());

            // Seleccionar la especialidad actual del médico en el combo box
            if (!medico.getEspecialidades().isEmpty()) {
                Especialidad especialidadMedico = medico.getEspecialidades().iterator().next(); // Suponiendo que un médico tiene una sola especialidad
                comboEspecialidad.setSelectedItem(especialidadMedico);
            } else {
                comboEspecialidad.setSelectedIndex(0); // Si no tiene especialidades, seleccionar el primer ítem por defecto
            }

            // Habilitar botones para modificar y eliminar
            modifyButton.setEnabled(true);
            saveButton.setEnabled(false);
            deleteButton.setEnabled(true);
        }
    }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoCedula;
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox<Object> comboEspecialidad;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    private Object getEntityManagerFactory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
