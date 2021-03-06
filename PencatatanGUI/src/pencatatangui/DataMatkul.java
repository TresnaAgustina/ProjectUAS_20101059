package pencatatangui;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * @author user
 */
public class DataMatkul extends javax.swing.JInternalFrame {
    private DefaultTableModel model;
    static ResultSet rs;
    static Statement stmt;
    DbCnn cnn = new DbCnn();
    /*
     * Creates new form DataMatkul
     */
    public DataMatkul() {
        initComponents();
        this.InitTable();
        this.GetData();
    }
   
    
    private void InitTable(){
        model = new DefaultTableModel();
        TabelMatkul.setModel(model);
        model.addColumn("Kode MK");
        model.addColumn("Nama MK");
        model.addColumn("Tipe MK");
        model.addColumn("Jumlah SKS");
        model.addColumn("Semester");

    }
    private void ShowData(String sql){
        try{
            Statement stmt = cnn.koneksi().createStatement();
            this.rs = stmt.executeQuery(sql);
        }catch(Exception e){
            System.out.println("Terjadi Kendala pada query");
        }
    }
    private void GetData(){
        String sql = "Select kode_mk, nama_mk, tipe_mk, jmlh_sks, semester_mk FROM matakuliah;";
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            this.ShowData(sql);
            while(this.rs.next()){
                Object[] obj = new Object[5];
                obj[0] = this.rs.getString("kode_mk");
                obj[1] = this.rs.getString("nama_mk");
                obj[2] = this.rs.getString("jmlh_sks");
                obj[3] = this.rs.getString("semester_mk");
                String TIPE = this.rs.getString("tipe_mk");
                if(TIPE.equals("W")){
                    obj[4] = "Wajib";
                }else{
                    obj[4] = "Pilihan";
                }
                model.addRow(obj);
            }
        }catch(Exception e){
        }
    }
    private boolean UpdateData(String SQL){
        boolean hsl = false;
        try{
            Statement stmt = cnn.koneksi().createStatement();
            stmt.executeUpdate(SQL);
            hsl = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi kendala pada instruksi SQL");
        }
        return hsl;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BtnAddNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelMatkul = new javax.swing.JTable();
        LabelDetail = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Fkode_mk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Fnama_mk = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        FtipeW = new javax.swing.JRadioButton();
        FtipeP = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Fsemester = new javax.swing.JComboBox<>();
        Fjmlh_sks = new javax.swing.JComboBox<>();
        BtnClose = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();
        BtnCancel = new javax.swing.JButton();
        BtnUpdate = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1050, 550));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setText("Tabel Data Mata Kuliah");

        BtnAddNew.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        BtnAddNew.setText("Tambah Data");
        BtnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddNewActionPerformed(evt);
            }
        });

        TabelMatkul.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelMatkul.setPreferredSize(new java.awt.Dimension(300, 60));
        TabelMatkul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMatkulMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelMatkul);

        LabelDetail.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelDetail.setText("Detail Mata Kuliah");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setText("Kode Mata Kuliah");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setText("Nama Mata Kuliah");

        Fnama_mk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fnama_mkActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setText("Tipe Mata Kuliah");

        FtipeW.setText("Wajib");

        FtipeP.setText("Pilihan");
        FtipeP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FtipePActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setText("Jumlah SKS");

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setText("Semester");

        Fsemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Semester", "I", "II", "III", "IV", "V", "VI", "VII", "VIII" }));

        Fjmlh_sks.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jumlah SKS", "1", "2", "3", "4" }));

        BtnClose.setText("Tutup Form");
        BtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseActionPerformed(evt);
            }
        });

        BtnSave.setText("Simpan Data");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        BtnCancel.setText("Batal");
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });

        BtnUpdate.setText("Update Data");
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });

        BtnDelete.setText("Delete Data");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelDetail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Fnama_mk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                        .addComponent(Fkode_mk, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BtnUpdate)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnDelete)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(FtipeW)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(FtipeP)))
                                                .addGap(130, 130, 130)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(Fsemester, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(Fjmlh_sks, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(228, 228, 228)
                                        .addComponent(BtnSave)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnCancel)))))
                        .addContainerGap(285, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BtnClose))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnAddNew)))
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAddNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Fkode_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FtipeW)
                        .addComponent(FtipeP)
                        .addComponent(Fsemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fnama_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fjmlh_sks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnClose)
                    .addComponent(BtnSave)
                    .addComponent(BtnCancel)
                    .addComponent(BtnUpdate)
                    .addComponent(BtnDelete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddNewActionPerformed
        this.BtnAddNew.setEnabled(false);
        this.BtnUpdate.setEnabled(false);
        this.BtnDelete.setEnabled(false);
        this.BtnClose.setEnabled(false);
        this.BtnSave.setEnabled(true);
        this.BtnCancel.setVisible(true);
        
        this.Fkode_mk.setText("");
        this.Fnama_mk.setText("");
        this.Fjmlh_sks.setSelectedIndex(0);
        this.Fsemester.setSelectedIndex(0);

        this.LabelDetail.setText("Tambah data Matakuliah");
    }//GEN-LAST:event_BtnAddNewActionPerformed

    private void Fnama_mkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fnama_mkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fnama_mkActionPerformed

    private void FtipePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FtipePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FtipePActionPerformed

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelActionPerformed
        this.BtnClose.setEnabled(true);
        this.BtnAddNew.setEnabled(true);
        this.BtnSave.setEnabled(false);
        this.BtnCancel.setVisible(false);
    }//GEN-LAST:event_BtnCancelActionPerformed

    private void TabelMatkulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMatkulMouseClicked
        this.Fkode_mk.setText( model.getValueAt(TabelMatkul.getSelectedRow(), 0).toString());
        this.Fnama_mk.setText( model.getValueAt(TabelMatkul.getSelectedRow(), 1).toString());
        this.Fjmlh_sks.setSelectedItem(model.getValueAt(TabelMatkul.getSelectedRow(), 2).toString());
        this.Fsemester.setSelectedItem(model.getValueAt(TabelMatkul.getSelectedRow(), 3).toString());
        String TIPE = model.getValueAt(TabelMatkul.getSelectedRow(), 4).toString();
        if(TIPE.equals("Pilihan")){
            this.FtipeP.setSelected(true);
        }else{
            this.FtipeW.setSelected(true);
        }
        
        this.LabelDetail.setText("Edit Data "+this.Fnama_mk.getText());
        this.BtnSave.setEnabled(false);
        this.BtnUpdate.setEnabled(true);
        this.BtnDelete.setEnabled(true);
    }//GEN-LAST:event_TabelMatkulMouseClicked

    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        String KOD = this.Fkode_mk.getText();
        String NAMA = this.Fnama_mk.getText();
        String JMLH = this.Fjmlh_sks.getSelectedItem().toString();        
        String SEM = this.Fsemester.getSelectedItem().toString();
        String TIPE = "W";
        if(this.FtipeP.isSelected()){
            TIPE = "P";
        }
        String SQLUpdate = "UPDATE matakuliah SET nama_mk='"+NAMA+"', jmlh_sks='"+JMLH+"', semester_mk='"+SEM+"', tipe_mk='"+TIPE+"' WHERE kode_mk='"+KOD+"';";
        if(this.UpdateData(SQLUpdate)){
            this.GetData();
            JOptionPane.showMessageDialog(null, "Data telah di Update");
        }
    }//GEN-LAST:event_BtnUpdateActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        String KOD = this.Fkode_mk.getText();
        String NAMA = this.Fnama_mk.getText();
        
        int opsi = JOptionPane.showConfirmDialog(null,"Yakin akan menghapus data dari "+NAMA+"("+KOD+")?","Konfirmasi", JOptionPane.YES_NO_OPTION );
        if(opsi == JOptionPane.YES_OPTION){
            String SQLDelete = "DELETE FROM matakuliah WHERE kode_mk='"+KOD+"';";
            if(this.UpdateData(SQLDelete)){
                this.GetData();
                JOptionPane.showMessageDialog(null, "Data telah dihapus");
            }
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnCloseActionPerformed

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        String KOD = this.Fkode_mk.getText();
        String NAMA = this.Fnama_mk.getText();
        String JMLH = this.Fjmlh_sks.getSelectedItem().toString();
        String SEM = this.Fsemester.getSelectedItem().toString();
        String TIPE = "W";
        if(this.FtipeP.isSelected()){
            TIPE = "P";
        }
        String SQLInsert = "INSERT INTO matakuliah(kode_mk, nama_mk, tipe_mk, jmlh_sks, semester_mk) VALUES('"+KOD+"','"+NAMA+"','"+TIPE+"','"+JMLH+"','"+SEM+"');";
        if(this.UpdateData(SQLInsert)){
            this.GetData();
            JOptionPane.showMessageDialog(null, "Data telah di Tambahkan");
        }
        this.BtnSave.setEnabled(false);
        this.BtnCancel.setVisible(false);
        this.BtnClose.setEnabled(true);
        this.BtnAddNew.setEnabled(true);
    }//GEN-LAST:event_BtnSaveActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddNew;
    private javax.swing.JButton BtnCancel;
    private javax.swing.JButton BtnClose;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnSave;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JComboBox<String> Fjmlh_sks;
    private javax.swing.JTextField Fkode_mk;
    private javax.swing.JTextField Fnama_mk;
    private javax.swing.JComboBox<String> Fsemester;
    private javax.swing.JRadioButton FtipeP;
    private javax.swing.JRadioButton FtipeW;
    private javax.swing.JLabel LabelDetail;
    private javax.swing.JTable TabelMatkul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
