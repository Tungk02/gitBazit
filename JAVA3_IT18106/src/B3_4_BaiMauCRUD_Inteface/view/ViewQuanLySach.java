/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package B3_4_BaiMauCRUD_Inteface.view;

import B3_4_BaiMauCRUD_Inteface.model.Sach;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import B3_4_BaiMauCRUD_Inteface.service.QuanLySachService;
import B3_4_BaiMauCRUD_Inteface.service.impl.QuanLySachServiceImpl;


/**
 *
 * @author Bânbân
 */
public class ViewQuanLySach extends javax.swing.JFrame {
    // Tạo instance cho biến
    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm;
    private List<Sach> list ;
    private List<String> listNamIn;
    // interface = new class;
    // ArrayList<Sach> lists = new ArrayList<>();
    // class = new Class()
    private QuanLySachService quanLySachService ;
    /**
     * Creates new form ViewQuanLySach
     */
    public ViewQuanLySach() {
        initComponents();
        //B1:Khởi tao instance 
        dtm = new DefaultTableModel();
        dcbm = new DefaultComboBoxModel();
        list = new ArrayList<>();
        listNamIn = new ArrayList<>();
        quanLySachService = new QuanLySachServiceImpl();
//        doDuLieu();
        // B2:
        dtm = (DefaultTableModel) this.tblListSach.getModel();
        dcbm = (DefaultComboBoxModel) this.cboNamIn.getModel();
        // B3:Add phần tử vao list
        list.add(new Sach("ten 1", "tac gia 1", "Tiểu Thuyết", "2000"));
        list.add(new Sach("ten 2", "tac gia 2", "Truyện ngắn", "2001"));
        list.add(new Sach("ten 3", "tac gia 3", "Tiểu Thuyết", "2002"));
        list.add(new Sach("ten 4", "tac gia 4", "Truyện ngắn", "2003"));
        list.add(new Sach("ten 5", "tac gia 5", "Tiểu Thuyết", "2004"));
       
        showDataTable(list);
        
        listNamIn.add("1999");
        listNamIn.add("2000");
        listNamIn.add("2001");
        listNamIn.add("2002");
        listNamIn.add("2003");
        listNamIn.add("2004");
        
        showDataComboBox(listNamIn);
        
        
    }
    private void showDataTable(List<Sach> listSach){
        dtm.setRowCount(0);
        for (Sach sach : listSach) {
            dtm.addRow(sach.toDataRow());
        }
    }
    private void showDataComboBox(List<String> listComboBox){
        for (String s : listComboBox) {
            dcbm.addElement(s);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        rdoTN = new javax.swing.JRadioButton();
        rdoTT = new javax.swing.JRadioButton();
        cboNamIn = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListSach = new javax.swing.JTable();
        btnThen = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnSearchTheoTen = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Quản Lý Sách");

        jLabel2.setText("Tên Sách");

        jLabel3.setText("TácGiả");

        jLabel4.setText("Thể Loại");

        jLabel5.setText("Năn In");

        buttonGroup1.add(rdoTN);
        rdoTN.setSelected(true);
        rdoTN.setText("Truyện ngắn");
        rdoTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTNActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTT);
        rdoTT.setText("Tiểu Thuyết");

        tblListSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên Sách", "Tác giả", "Thể Loại", "Năm in", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblListSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListSach);

        btnThen.setText("Thêm");
        btnThen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThenMouseClicked(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });

        btnSearchTheoTen.setText("Search theo tên");
        btnSearchTheoTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchTheoTenMouseClicked(evt);
            }
        });

        btnSort.setText("Sort");
        btnSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSortMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenSach)
                                    .addComponent(txtTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearchTheoTen)
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoTN)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoTT))
                                    .addComponent(cboNamIn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)))
                        .addComponent(btnSort)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThen)
                            .addComponent(btnThoat)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnThen))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchTheoTen)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnXoa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdoTN)
                    .addComponent(rdoTT))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboNamIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnThoat))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSort)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void detailSach(int index){
        Sach s = list.get(index);
        txtTenSach.setText(s.getTenSach());
        txtTacGia.setText(s.getTacGia());
        if(s.getTheLoai().equalsIgnoreCase("Truyện ngắn")){
            rdoTN.setSelected(true);
        }else{
            rdoTT.setSelected(true);
        }
        cboNamIn.setSelectedItem(s.getNamIn());
    }
    private Sach getDataFormView(){
        Sach s = new Sach();
        String tenSach = txtTenSach.getText();
        String tacGia = txtTacGia.getText();
        String namIn  = cboNamIn.getSelectedItem().toString();
        String theLoai = "Truyện ngắn";
        if(rdoTT.isSelected()){
            theLoai = "Tiểu Thuyết";
        }
        return new Sach(tenSach,tacGia,theLoai,namIn);
    }
//    private void doDuLieu(){
//        defaultTableModel.setRowCount(0);
//        list = service.getList();
//        for (Sach s : list) {
//            defaultTableModel.addRow(new Object[]{
//                s.getTenSach(),
//                s.getTacGia(),
//                s.getTheLoai(),
//                s.getNamIn(),
//                s.getTrangThai(s.getNamIn())
//            });
//        }
//    }
    private boolean kiemTraDuLieu(){
        if(txtTenSach.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sách");
            return false;
        }else if(txtTacGia.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên tác giả");
            return false;
        }
        return true;
    }
    private void rdoTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoTNActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtTenSach.setText("");
        txtTacGia.setText("");
        buttonGroup1.clearSelection();
        cboNamIn.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnThenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThenMouseClicked
        // TODO add your handling code here:
        if(kiemTraDuLieu()){
            Sach s = getDataFormView();
            quanLySachService.add(list, s);
            showDataTable(list);
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công");
        }
    }//GEN-LAST:event_btnThenMouseClicked

    private void tblListSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListSachMouseClicked
        // TODO add your handling code here:
        int rowIndex = tblListSach.getSelectedRow();
        if(rowIndex >=0 && rowIndex <= list.size()){
            detailSach(rowIndex);
        }
    }//GEN-LAST:event_tblListSachMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
        int rowIndex = tblListSach.getSelectedRow();
        if(rowIndex >= 0){
            int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa dòng này không");
            //0:có;1:không;2:cancel;
            System.out.println(result);
            if(result == 0){
                quanLySachService.xoa(list, rowIndex);
                showDataTable(list);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
        }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        // TODO add your handling code here:
        System.exit(0);
        //this.dispose();
    }//GEN-LAST:event_btnThoatMouseClicked

    private void btnSearchTheoTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchTheoTenMouseClicked
        // TODO add your handling code here:
       String ten = txtTenSach.getText();
       List<Sach> listSearch = quanLySachService.searchTheoTen(list, ten);
        showDataTable(listSearch);
        
    }//GEN-LAST:event_btnSearchTheoTenMouseClicked

    private void btnSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortMouseClicked
        // TODO add your handling code here:
        quanLySachService.sortByName(list);
        showDataTable(list);
    }//GEN-LAST:event_btnSortMouseClicked
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewQuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewQuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewQuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewQuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewQuanLySach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearchTheoTen;
    private javax.swing.JButton btnSort;
    private javax.swing.JButton btnThen;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboNamIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoTN;
    private javax.swing.JRadioButton rdoTT;
    private javax.swing.JTable tblListSach;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}