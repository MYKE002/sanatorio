package Vista;

import Modelo.Especialidad;
import Modelo.Seguro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
/**
 *
 * @author hp
 */
public class SeguroForm extends javax.swing.JInternalFrame {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public SeguroForm() {
        initComponents();
        entityManagerFactory = Persistence.createEntityManagerFactory("C:/sanatorio/seguro.odb");
        entityManager = entityManagerFactory.createEntityManager();
        llenarTabla();
        modifyButton.setEnabled(false);
        saveButton.setEnabled(true);
        deleteButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        campoId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        modifyButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Seguros");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 64, -1, -1));
        jPanel1.add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 61, 179, -1));

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_guardar.png"))); // NOI18N
        saveButton.setToolTipText("GUARDAR");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 50, 40));
        jPanel1.add(campoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 130, -1));

        jLabel1.setText("ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        table.setBackground(new java.awt.Color(153, 255, 204));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Especialidad"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 360, 210));

        modifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_actualizar.png"))); // NOI18N
        modifyButton.setToolTipText("EDITAR");
        modifyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyButtonMouseClicked(evt);
            }
        });
        jPanel1.add(modifyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_borrar.png"))); // NOI18N
        deleteButton.setToolTipText("Eliminar");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void llenarTabla() {
        Query query = entityManager.createQuery("SELECT seguroDb FROM Seguro seguroDb");
        List<Seguro> result = query.getResultList();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Seguro seguroDb : result) {
            model.addRow(new Object[]{seguroDb.getId(), seguroDb.getNombre()});
        }

    }

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked

        if (campoNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese los datos");
            campoNombre.requestFocus();
        } else {

            String nombre = campoNombre.getText();

            
                Seguro seguroDb = new Seguro(nombre);
                entityManager.getTransaction().begin();
                entityManager.persist(seguroDb);
                entityManager.getTransaction().commit();

                llenarTabla();
                campoId.setText("");
                campoNombre.setText("");
                JOptionPane.showMessageDialog(null, "Guardado Satisfactorio");
        }
    }//GEN-LAST:event_saveButtonMouseClicked
        
    

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getButton() == 1) {
            int row = table.getSelectedRow();
            // Busqueda por id
            Seguro seguroDb = entityManager.find(Seguro.class, table.getValueAt(row, 0));

            campoId.setEnabled(false);
            saveButton.setEnabled(false);
            campoId.setText(String.valueOf(seguroDb.getId()));
            campoNombre.setText(seguroDb.getNombre());

            modifyButton.setEnabled(true);
            saveButton.setEnabled(false);
            deleteButton.setEnabled(true);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void modifyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyButtonMouseClicked
        long id = Integer.parseInt(campoId.getText());
        String nombre = campoNombre.getText();

        Seguro seguroDb = entityManager.find(Seguro.class, id);
        entityManager.getTransaction().begin();
        seguroDb.setId(id);
        seguroDb.setNombre(nombre);
        entityManager.getTransaction().commit();

        llenarTabla();
        campoId.setText("");
        campoNombre.setText("");
        saveButton.setEnabled(true);
        campoId.setEnabled(true);
    }//GEN-LAST:event_modifyButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        long id = Integer.parseInt(campoId.getText());

        Seguro seguroDb = entityManager.find(Seguro.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(seguroDb);
        entityManager.getTransaction().commit();

        llenarTabla();
        campoId.setText("");
        campoNombre.setText("");

        campoId.setEnabled(true);
        saveButton.setEnabled(true);
        modifyButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }//GEN-LAST:event_deleteButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
