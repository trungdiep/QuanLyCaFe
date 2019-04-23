/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabs;

import Connection.CFConnection;
import DAO.DAOCTHDB;
import DAO.DAOHDB;
import DAO.DAOKhachHang;
import DAO.DAOSanPham;
import Entity.CTHDB;
import Entity.HDB;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

/**
 *
 * @author MSI
 */
public class ThanhToan extends javax.swing.JPanel {

    /**
     * Creates new form ThanhToan
     */
    
    
    public ThanhToan(String employeecode) throws SQLException   {
        initComponents();
        txtmaNhanVien.setText(employeecode);
        hienthi();
        tableTitle.add("STT");
        tableTitle.add("San Pham");
        tableTitle.add("SL");
        tableTitle.add("Gia");
    }
    

    public ThanhToan() throws SQLException {
        initComponents();
        
    }
    int i ;
    Vector tableRecord = new Vector();
    Vector tableTitle = new Vector();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cboKH = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        addSanPham = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        cboSP = new javax.swing.JComboBox<>();
        txtThanhTien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        removeSP = new javax.swing.JButton();
        btnNewHD = new javax.swing.JButton();
        btnNewHD1 = new javax.swing.JButton();
        txtmaHD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtmaNhanVien = new javax.swing.JTextField();
        show_validation_here = new javax.swing.JLabel();
        btnIn = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Ten KH:");

        cboKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Ma HD :");

        addSanPham.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addSanPham.setText("+");
        addSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSanPhamActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("San Pham :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("So Luong");

        txtSL.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSLKeyTyped(evt);
            }
        });

        cboSP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtThanhTien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Thành tiền :");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "San Pham", "SL", "Gia"
            }
        ));
        table1.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jScrollPane2.setViewportView(table1);

        removeSP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        removeSP.setText("-");
        removeSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSPActionPerformed(evt);
            }
        });

        btnNewHD.setText("Tạo Hóa Đơn ");
        btnNewHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewHDActionPerformed(evt);
            }
        });

        btnNewHD1.setText("Lưa Hóa Đơn");
        btnNewHD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewHD1ActionPerformed(evt);
            }
        });

        txtmaHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Ma NhanVien :");

        txtmaNhanVien.setEditable(false);
        txtmaNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        show_validation_here.setForeground(new java.awt.Color(255, 51, 51));

        btnIn.setText("Printf");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnNewHD)
                                .addComponent(btnNewHD1)
                                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(292, 292, 292))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtmaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtmaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(show_validation_here, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboKH, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeSP, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel6, jLabel8});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboKH, cboSP, txtSL});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnIn, btnNewHD, btnNewHD1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(addSanPham)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeSP))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(show_validation_here)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnNewHD)
                        .addGap(13, 13, 13)
                        .addComponent(btnNewHD1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel6, jLabel8});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboKH, cboSP, txtSL});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnIn, btnNewHD, btnNewHD1});

    }// </editor-fold>//GEN-END:initComponents
   
    
    private void addSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSanPhamActionPerformed
       
            // TODO add your handling code here:
        
        tableRecord.add(addRow());
        table1.setModel(new DefaultTableModel(tableRecord, tableTitle));
        txtThanhTien.setText(TongTien().toString());
        
    }//GEN-LAST:event_addSanPhamActionPerformed

    private void removeSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSPActionPerformed
        // TODO add your handling code here:
         
        int iDongDaChon = table1.getSelectedRow();
            if (iDongDaChon == -1) {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn record cần xóa");
            } else {
                Vector vDongDaChon = (Vector) tableRecord.get(iDongDaChon);
                String idCuaDongDaChon = vDongDaChon.get(0).toString();
                if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dòng đã chọn có id: " + idCuaDongDaChon, "Lua chon", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                {
                    tableRecord.remove(iDongDaChon);
                    table1.setModel(new DefaultTableModel(tableRecord, tableTitle));
                }
            }
        //model.removeRow(index);
      txtThanhTien.setText(TongTien().toString());
    }//GEN-LAST:event_removeSPActionPerformed

    private void btnNewHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewHDActionPerformed
        // TODO add your handling code here:
        txtSL.setText("");
        txtmaHD.setText("");
        txtThanhTien.setText("");
        tableRecord.removeAllElements();
        table1.setModel(new DefaultTableModel(tableRecord, tableTitle));
    }//GEN-LAST:event_btnNewHDActionPerformed

    private void btnNewHD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewHD1ActionPerformed
        // TODO add your handling code here:
        CFConnection conn = new CFConnection();
        DAOCTHDB dcthdb = new DAOCTHDB(conn);
        DAOKhachHang dkh = new DAOKhachHang(conn);
        DAOSanPham dsp = new DAOSanPham(conn);
        DAOHDB hdb = new DAOHDB(conn);
        int n = 1;
        Double totalmoney = Double.valueOf(txtThanhTien.getText());
        String makh = dkh.displayMaKhacHang(cboKH.getSelectedItem().toString());
        System.out.println(totalmoney + " - " + txtmaNhanVien.getText() + " - " +makh+ " - " + txtmaHD.getText());
        HDB hd = new HDB(txtmaHD.getText(),txtmaNhanVien.getText(),makh,totalmoney);
        int kt = hdb.addHDB(hd);
        System.out.println(kt);
        for(int i = 0;i<table1.getRowCount();i++)   {
             Vector vDongDaChon = (Vector) tableRecord.get(i);
             String tensp = vDongDaChon.get(1).toString();
             String masp = dsp.displayMaSP(tensp);
             int sl = Integer.valueOf(vDongDaChon.get(2).toString());
             Double thanhtien = Double.valueOf(vDongDaChon.get(3).toString());
             CTHDB ct = new CTHDB(txtmaHD.getText(),masp, tensp, sl, thanhtien);
             System.out.println(ct.toString());
             n = dcthdb.addCTDHB(ct);
             System.out.println(n);
        }
        if( kt == 1 && n ==1) {
            JOptionPane.showMessageDialog(this,"them thanh cong");
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Loi !!!");
        }
    }//GEN-LAST:event_btnNewHD1ActionPerformed

    private void txtSLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSLKeyTyped
        // TODO add your handling code here:
        char  c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) ))  {
            evt.consume();
        }
    }//GEN-LAST:event_txtSLKeyTyped

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        // TODO add your handling code here:
        try {
            MessageFormat heardFormat = new MessageFormat("Thanh Toan");
            MessageFormat footerFormat = new MessageFormat("- {0} -");
            table1.print(JTable.PrintMode.FIT_WIDTH,heardFormat,footerFormat,true, new HashPrintRequestAttributeSet(),true);
        } catch (PrinterException ex) {
            Logger.getLogger(ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error: " + ex.getMessage());
        } catch (HeadlessException ex) {
            Logger.getLogger(ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInActionPerformed
    private  Vector addRow()  {
        CFConnection conn = new CFConnection();
        DAO.DAOSanPham dsp = new DAOSanPham(conn);
        int sl = Integer.parseInt(txtSL.getText());
        Double prices = 0.0;
        ResultSet rs = dsp.displayPrice(cboSP.getSelectedItem().toString());
        try{
            if (rs.next()) {
                String pricesql = rs.getString("GiaBan");
                prices = sl * Double.valueOf(pricesql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       Vector record = new Vector();
       record.add(String.valueOf(++i));
       record.add(cboSP.getSelectedItem().toString());
       record.add(txtSL.getText());
       record.add(prices.toString());
       return record;
    }
    public Double TongTien()
    {
        Double totalmoney = 0.0;
         
        int lengt = table1.getRowCount();
            for(int j =0;j<lengt;j++) {
                Vector vDongDaChon = (Vector) tableRecord.get(j);
                totalmoney += Double.valueOf(vDongDaChon.get(3).toString());
            }
                      
        return totalmoney;
        
    }
    public void hienthi() throws SQLException   {
        CFConnection conn = new CFConnection();
        DAO.DAOKhachHang dkh = new DAOKhachHang(conn);
        ResultSet rs  = dkh.display();
        while(rs.next())
        {
            cboKH.addItem(rs.getString("TenKhachHang"));
        }
        
        DAO.DAOSanPham dsp = new DAOSanPham(conn);
        /**ResultSet rsp = dsp.display();
        while (rsp.next()) {
            cboSP.addItem(rsp.getString("TenSanPham"));
        }*/
        Set set = dsp.getHashMap().entrySet();
        Iterator i  = set.iterator();
        while(i.hasNext())  {
            Map.Entry me = (Map.Entry) i.next();
            cboSP.addItem((String) me.getKey());
        }
        DefaultTableModel model = new DefaultTableModel();
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSanPham;
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnNewHD;
    private javax.swing.JButton btnNewHD1;
    private javax.swing.JComboBox<String> cboKH;
    private javax.swing.JComboBox<String> cboSP;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeSP;
    private javax.swing.JLabel show_validation_here;
    private javax.swing.JTable table1;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtmaHD;
    private javax.swing.JTextField txtmaNhanVien;
    // End of variables declaration//GEN-END:variables
}
