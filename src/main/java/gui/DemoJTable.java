/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public final class DemoJTable extends JFrame {

    private JTable tblTaiKhoan;
    private JTextField txtTen, txtTien;
    private JButton btThem, btXoa;
    private JLabel lbTen, lbTien;

    public DemoJTable() {
        super("Demo JTable");
        createGUI();
        processEvent();
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public void createGUI() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        String[] columnName = {"Tên tài khoản", "Số tiền"};
        Object[][] data = new Object[][]{
            {"Nguyễn Thị Chung", 50000000},
            {"Nguyễn Ngọc Vương", 65000000},
            {"Hồ Nhật Anh", 45000000}

        };
        DefaultTableModel model = new DefaultTableModel(data, columnName);
        tblTaiKhoan = new JTable(model);
        JScrollPane srollPaneTable = new JScrollPane(tblTaiKhoan);
        p.add(srollPaneTable);

        JPanel pNhapLieu = new JPanel();
        pNhapLieu.add(lbTien = new JLabel("Tên tài khoản"));
        pNhapLieu.add(txtTen = new JTextField(15));
        pNhapLieu.add(lbTien = new JLabel("Số tiền"));
        pNhapLieu.add(txtTien = new JTextField(10));
        pNhapLieu.add(btThem = new JButton("Thêm"));
        pNhapLieu.add(btXoa = new JButton("Xóa"));

        p.add(pNhapLieu, BorderLayout.NORTH);
        add(p);

    }

    public static void main(String[] args) {
        DemoJTable frm = new DemoJTable();
        frm.setVisible(true);
    }

    private void processEvent() {
        btThem.addActionListener((e) -> {
            DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
            model.addRow(new Object[]{txtTen.getText(), txtTien.getText()});

        });
        btXoa.addActionListener((e) -> {
            int selectedRow = tblTaiKhoan.getSelectedRow();
            if (selectedRow >= 0) {
                int cm = JOptionPane.showConfirmDialog(this,
                        "Bạn có chắc chắn muốn xóa dòng này?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION);
                if (cm == JOptionPane.YES_OPTION) {
                    DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
                    model.removeRow(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng để xóa.");
            }
        });

    }
}
