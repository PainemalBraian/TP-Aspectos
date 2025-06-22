package aop.ejercicio3.ui;

import aop.ejercicio3.model.ConcursoAPI;
import aop.ejercicio3.model.exceptions.ConcursoException;
import aop.ejercicio3.model.exceptions.InscripcionException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RadioCompetition {
    private JPanel contentPane;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblPhone;
    private JTextField txtPhone;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JComboBox<String> comboBox;
    private JButton btnOk;
    private JLabel lblCompetition;

    ConcursoAPI controller;

    public RadioCompetition(ConcursoAPI controller) {
        this.controller = controller;
        var frame = new JFrame("Inscription to Competition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 451, 270);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        formElements();
        layout();
        frame.setVisible(true);
    }

    private void formElements() {
        lblName = new JLabel("Nombre:");
        txtName = new JTextField();
        txtName.setColumns(10);

        lblLastName = new JLabel("Apellido:");
        txtLastName = new JTextField();
        txtLastName.setColumns(10);

        lblId = new JLabel("Dni:");
        txtId = new JTextField();
        txtId.setColumns(10);

        lblPhone = new JLabel("Telefono:");
        txtPhone = new JTextField();
        txtPhone.setColumns(10);

        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        txtEmail.setColumns(10);

        lblCompetition = new JLabel("Concurso:");
        comboBox = new JComboBox<String>();
        cargarTodosLosConcursos();

        btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnOk.setEnabled(false);
                guardarInscripcion();

                btnOk.setEnabled(true);
            }
        });

    }

    private void guardarInscripcion() {
        String name = txtName.getText();
        String lastName = txtLastName.getText();
        String dni = txtId.getText();
        String telefono = txtPhone.getText();
        String email = txtEmail.getText();

        try {
            controller.saveInscription(name, lastName, dni, telefono, email, comboBox.getSelectedItem().toString());
            JOptionPane.showMessageDialog(this.contentPane, "Guardado Exitosamente!", "Error", JOptionPane.INFORMATION_MESSAGE);

        } catch (InscripcionException e) {
            JOptionPane.showMessageDialog(this.contentPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarTodosLosConcursos() {
        try {
            List<String> concursos = controller.getTodosLosConcursos();
            comboBox.removeAllItems(); // Limpiar elementos previos
            for (String concurso : concursos) {
                comboBox.addItem(concurso);
            }
        } catch (ConcursoException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.contentPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void layout() { //Corregido con IA por errores con groupLayouts
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        contentPane.setLayout(gl_contentPane);

        gl_contentPane.setAutoCreateGaps(true);
        gl_contentPane.setAutoCreateContainerGaps(true);

        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createSequentialGroup()
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lblLastName)
                                .addComponent(lblId)
                                .addComponent(lblPhone)
                                .addComponent(lblEmail)
                                .addComponent(lblName)
                                .addComponent(lblCompetition)
                        )
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtId, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnOk, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                        )
        );

        gl_contentPane.setVerticalGroup(
                gl_contentPane.createSequentialGroup()
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblLastName)
                                .addComponent(txtLastName))
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblId)
                                .addComponent(txtId))
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPhone)
                                .addComponent(txtPhone))
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblEmail)
                                .addComponent(txtEmail))
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblName)
                                .addComponent(txtName))
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCompetition)
                                .addComponent(comboBox))
                        .addComponent(btnOk)
        );
    }

//    private void layout() { //"Original"
//        GroupLayout gl_contentPane = new GroupLayout(contentPane);
//        gl_contentPane.setHorizontalGroup(
//                gl_contentPane.createParallelGroup(Alignment.LEADING)
//                        .addGroup(gl_contentPane.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//                                        .addGroup(gl_contentPane.createSequentialGroup()
//                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//                                                        .addComponent(lblLastName)
//                                                        .addComponent(lblId)
//                                                        .addComponent(lblPhone)
//                                                        .addComponent(lblEmail)
//                                                        .addComponent(lblName)
//                                                        .addComponent(lblCompetition))
//                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
//                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
//                                                        .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                        .addComponent(txtEmail, Alignment.TRAILING)
//                                                        .addComponent(txtPhone, Alignment.TRAILING)
//                                                        .addComponent(txtId, Alignment.TRAILING)
//                                                        .addComponent(txtLastName, Alignment.TRAILING)
//                                                        .addComponent(txtName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
//                                        .addComponent(btnOk, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
//                                .addContainerGap()));
//        contentPane.setLayout(gl_contentPane);
//    }
}
