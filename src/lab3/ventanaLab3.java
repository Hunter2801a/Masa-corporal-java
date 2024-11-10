package lab3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ventanaLab3 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField campoEmpleado;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField Altura;
    private JTable table;
    private JTextField Peso;
    private JTextField IMC;
    private JTextField EmplTotal;
    private int totalEmpleados = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ventanaLab3 frame = new ventanaLab3();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ventanaLab3() {
        setTitle("<h1>centro medico: \"LA CASA DEL CLAN\"</h1>");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 702, 469);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("CALCULO DE MASA CORPORAL");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 11, 664, 34);
        lblNewLabel.setForeground(new Color(0, 153, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel);

        JLabel lbEmpleado = new JLabel("NOMBRE DEL EMPLEADO:");
        lbEmpleado.setBounds(10, 48, 206, 34);
        lbEmpleado.setForeground(new Color(255, 0, 51));
        lbEmpleado.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lbEmpleado);

        campoEmpleado = new JTextField();
        campoEmpleado.setBounds(207, 56, 467, 20);
        contentPane.add(campoEmpleado);
        campoEmpleado.setColumns(10);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sexo: ", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(204, 0, 0)));
        panel.setBounds(10, 106, 173, 59);
        contentPane.add(panel);
        panel.setLayout(null);

        JRadioButton Btnhombre = new JRadioButton("Hombre");
        buttonGroup.add(Btnhombre);
        Btnhombre.setForeground(new Color(0, 153, 255));
        Btnhombre.setFont(new Font("Tahoma", Font.BOLD, 11));
        Btnhombre.setBounds(6, 22, 78, 23);
        Btnhombre.setActionCommand("Hombre");
        panel.add(Btnhombre);

        JRadioButton Btnmujer = new JRadioButton("Mujer");
        buttonGroup.add(Btnmujer);
        Btnmujer.setForeground(new Color(0, 153, 255));
        Btnmujer.setFont(new Font("Tahoma", Font.BOLD, 11));
        Btnmujer.setBounds(95, 22, 69, 23);
        Btnmujer.setActionCommand("Mujer");
        panel.add(Btnmujer);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(49, 244, 601, 127);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Empleado", "Sexo", "Altura", "Peso", "IMC", "Estado"}
        ));
        scrollPane.setViewportView(table);

        Altura = new JTextField();
        Altura.setBounds(422, 103, 57, 20);
        contentPane.add(Altura);
        Altura.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Altura en metros (ejemplo 1.75):");
        lblNewLabel_1.setBounds(207, 105, 214, 14);
        contentPane.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));

        JButton BtnLimpiar = new JButton("Limpiar");
        BtnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 14));
        BtnLimpiar.setBounds(205, 191, 89, 23);
        BtnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });
        contentPane.add(BtnLimpiar);

        JButton BtnAgregar = new JButton("Agregar");
        BtnAgregar.setForeground(new Color(0, 153, 255));
        BtnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
        BtnAgregar.setBounds(49, 191, 95, 23);
        BtnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarEmpleado();
            }
        });
        contentPane.add(BtnAgregar);

        JButton BtnEliminar = new JButton("Eliminar");
        BtnEliminar.setForeground(Color.RED);
        BtnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
        BtnEliminar.setBounds(371, 191, 89, 23);
        BtnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarEmpleado();
            }
        });
        contentPane.add(BtnEliminar);

        JButton BtnSalir = new JButton("Salir");
        BtnSalir.setForeground(new Color(0, 153, 255));
        BtnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
        BtnSalir.setBounds(541, 191, 89, 23);
        BtnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra el programa
            }
        });
        contentPane.add(BtnSalir);

        Peso = new JTextField();
        Peso.setColumns(10);
        Peso.setBounds(281, 135, 57, 20);
        contentPane.add(Peso);

        JLabel lblNewLabel_1_1 = new JLabel("Peso (Kg):");
        lblNewLabel_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_1.setBounds(207, 134, 78, 20);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("I.M.C:");
        lblNewLabel_1_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_1_1.setBounds(377, 135, 41, 20);
        contentPane.add(lblNewLabel_1_1_1);

        IMC = new JTextField();
        IMC.setColumns(10);
        IMC.setBounds(423, 136, 57, 20);
        contentPane.add(IMC);

        JLabel lblNewLabel_1_2 = new JLabel("Total de empleados:");
        lblNewLabel_1_2.setForeground(Color.BLACK);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_2.setBounds(458, 397, 137, 14);
        contentPane.add(lblNewLabel_1_2);

        EmplTotal = new JTextField();
        EmplTotal.setColumns(10);
        EmplTotal.setBounds(593, 395, 57, 20);
        contentPane.add(EmplTotal);

        // Escuchadores para actualizar el IMC automáticamente
        Altura.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { actualizarIMC(); }
            public void removeUpdate(DocumentEvent e) { actualizarIMC(); }
            public void changedUpdate(DocumentEvent e) { actualizarIMC(); }
        });

        Peso.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { actualizarIMC(); }
            public void removeUpdate(DocumentEvent e) { actualizarIMC(); }
            public void changedUpdate(DocumentEvent e) { actualizarIMC(); }
        });
    }

    private void agregarEmpleado() {
        // Validar que todos los campos estén completos
        if (campoEmpleado.getText().isEmpty() || Altura.getText().isEmpty() || Peso.getText().isEmpty() || buttonGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos antes de agregar un empleado.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombre = campoEmpleado.getText();
        String sexo = buttonGroup.getSelection() != null ? buttonGroup.getSelection().getActionCommand() : "No especificado";
        double altura = Double.parseDouble(Altura.getText());
        double peso = Double.parseDouble(Peso.getText());
        double imc = calcularIMC(peso, altura);
        String estado = obtenerEstadoIMC(imc);

        IMC.setText(String.format("%.2f", imc));

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{nombre, sexo, altura, peso, imc, estado});

        totalEmpleados++;
        EmplTotal.setText(String.valueOf(totalEmpleados));
    }

    private void eliminarEmpleado() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar el empleado seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.removeRow(selectedRow);

            totalEmpleados--;
            EmplTotal.setText(String.valueOf(totalEmpleados));
        }
    }

    private double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    private String obtenerEstadoIMC(double imc) {
        if (imc < 18.5) return "Bajo peso";
        else if (imc <= 24.9) return "Normal";
        else if (imc <= 29.9) return "Sobrepeso";
        else if (imc <= 34.9) return "Obesidad I";
        else if (imc <= 39.9) return "Obesidad II";
        else return "Obesidad Mórbida";
    }

    private void limpiarFormulario() {
        campoEmpleado.setText("");
        buttonGroup.clearSelection();
        Altura.setText("");
        Peso.setText("");
        IMC.setText("");
    }

    private void actualizarIMC() {
        try {
            double altura = Double.parseDouble(Altura.getText());
            double peso = Double.parseDouble(Peso.getText());
            double imc = calcularIMC(peso, altura);
            IMC.setText(String.format("%.2f", imc));
        } catch (NumberFormatException e) {
            IMC.setText("");
        }
    }
}
