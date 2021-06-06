/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DBConnect;

public class View extends javax.swing.JFrame {

    private String id;

    /**
     * Creates new form TblSession
     */
    public View() {
        initComponents();
        sessionTable();
        setLecturers();
        setGroups();
        setTags();
        setSubject();
    }
    
    private int count(ResultSet resultSet){
        try{
            int i = 0;
            while (resultSet.next()) {
                i++;
            }
            return i;
        } catch (Exception e){
           System.out.println("Error row count");
           e.printStackTrace();
        }
        return 0;
    }
    
    
    private void setLecturers() {
        
        Connection connection;
	PreparedStatement preparedStatement;
        
        try{
            connection = DBConnect.getDBConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM lecturer");

            ResultSet rs1 = preparedStatement.executeQuery();
            
            lectuererSelect.addItem("Select a Lecturer");

            while(rs1.next())
            {
                lectuererSelect.addItem(rs1.getString(1)+"-"+rs1.getString(2));
            }
            
        }catch (ClassNotFoundException | SQLException  e) {
                System.out.println(e.getMessage());
        }
        
    }
    
    private void setGroups() {
        
        Connection connection;
	PreparedStatement preparedStatement;
        
        try{
            connection = DBConnect.getDBConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM groups");

            ResultSet rs1 = preparedStatement.executeQuery();
            
            groupSelect.addItem("Select a Group");

            while(rs1.next())
            {
                groupSelect.addItem(rs1.getString(1)+"-"+rs1.getString(2));
            }
            
        }catch (ClassNotFoundException | SQLException  e) {
                System.out.println(e.getMessage());
        }
        
    }
    
    private void setSubject() {
        
        Connection connection;
	PreparedStatement preparedStatement;
        
        try{
            connection = DBConnect.getDBConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM subjects");

            ResultSet rs1 = preparedStatement.executeQuery();
            
            subjectSelect.addItem("Select a Subject");

            while(rs1.next())
            {
                subjectSelect.addItem(rs1.getString(1)+"-"+rs1.getString(2));
            }
            
        }catch (ClassNotFoundException | SQLException  e) {
                System.out.println(e.getMessage());
        }
        
    }
    
    private void setTags() {
        
        Connection connection;
	PreparedStatement preparedStatement;
        
        try{
            connection = DBConnect.getDBConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM tag");

            ResultSet rs1 = preparedStatement.executeQuery();
            
            tagSelect.addItem("Select a Tag");

            while(rs1.next())
            {
                tagSelect.addItem(rs1.getString(1)+"-"+rs1.getString(2));
            }
            
        }catch (ClassNotFoundException | SQLException  e) {
                System.out.println(e.getMessage());
        }
        
    }
    
    private void clear() {
        lectuererSelect.setSelectedIndex(0);
        tagSelect.setSelectedIndex(0); 
        groupSelect.setSelectedIndex(0);        
        subjectSelect.setSelectedIndex(0);
        txtStdCount.setText("");
        txtDuration.setText("");
        sessionTable();
    }
    
    public void sessionTable(){
        
        String[] colNames = {"Lecturer ID","Tag","Group ID","Subject Code","No of Students","Duration (Hrs)"};
        Object[][]rows= new Object[0][8];
        
        Connection connection;
        PreparedStatement preparedStatement;
        try{
            connection = DBConnect.getDBConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM sessions");
            
            ResultSet rs1 = preparedStatement.executeQuery();
            int x =count(rs1);
            int i=0;
            rows= new Object[x][8];
            rs1 = preparedStatement.executeQuery();
            
            while(rs1.next())
            {
                rows[i][0] = rs1.getString(1);
                rows[i][1] = rs1.getString(2);
                rows[i][2] = rs1.getString(3);
                rows[i][3] = rs1.getString(4);
                rows[i][4] = rs1.getString(5);
                rows[i][5] = rs1.getString(6);
                rows[i][6] = rs1.getString(7);
                i++;
            }
            

        }catch (ClassNotFoundException | SQLException  e) {
            System.out.println(e.getMessage());
        }
        
        DefaultTableModel tbm= new DefaultTableModel(rows,colNames);
        sessionTbl.setModel(tbm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sclpn = new javax.swing.JScrollPane();
        sessionTbl = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lectuererSelect = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        subjectSelect = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        groupSelect = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tagSelect = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtStdCount = new javax.swing.JTextField();
        txtDuration = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sessionTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        sessionTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sessionTblMouseClicked(evt);
            }
        });
        sclpn.setViewportView(sessionTbl);

        getContentPane().add(sclpn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 654, 322));

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 90, -1));

        jLabel2.setText("Lecturer");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 72, -1));

        getContentPane().add(lectuererSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 200, -1));

        jLabel3.setText("No of Students");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 100, -1));

        jLabel6.setText("Subject");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 72, -1));

        getContentPane().add(subjectSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 210, -1));

        jLabel4.setText("Group");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 72, -1));

        getContentPane().add(groupSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 200, -1));

        jLabel5.setText("Tag");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 72, -1));

        getContentPane().add(tagSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 200, -1));

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, 90, -1));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 90, -1));

        jLabel7.setText("Duration");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 72, -1));
        getContentPane().add(txtStdCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 200, -1));
        getContentPane().add(txtDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 200, -1));

        jButton4.setText("Menu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFrame frame = new Add();
        setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(id!=null){
            if(lectuererSelect.getSelectedIndex()!=0){
                if(txtStdCount.getText()!=""){
                    if(subjectSelect.getSelectedIndex()!=0){
                        if(groupSelect.getSelectedIndex()!=0){
                            if(tagSelect.getSelectedIndex()!=0){

                                String[] lec = lectuererSelect.getSelectedItem().toString().split("-",2);
                                String[] tag = tagSelect.getSelectedItem().toString().split("-",2);
                                String[] group = groupSelect.getSelectedItem().toString().split("-",2);
                                String[] sub = subjectSelect.getSelectedItem().toString().split("-",2);
                                String[] stdCount = txtStdCount.getText().toString().split("-",2);
                                String[] durationCount = txtDuration.getText().toString().split("-",2);

                                Connection connection;
                                PreparedStatement preparedStatement;

                                try{
                                    connection = DBConnect.getDBConnection();

                                    preparedStatement = connection.prepareStatement("Update sessions SET lecId=?, tagId=?, groupId=?, subjectId=?, stdCount=?, duration=? WHERE id=?");
                                    preparedStatement.setString(2, lec[0]);
                                    preparedStatement.setString(3, tag[0]);
                                    preparedStatement.setString(4, group[0]);
                                    preparedStatement.setString(5, sub[0]);
                                    preparedStatement.setString(6, stdCount[0]);
                                    preparedStatement.setString(7, durationCount[0]);

                                    if(!preparedStatement.execute()){
                                        JFrame f=new JFrame();
                                        JOptionPane.showMessageDialog(f,"Updated!");
                                        clear();
                                    }else{
                                        JFrame f=new JFrame();
                                        JOptionPane.showMessageDialog(f,"Filed!");
                                    }

                                }catch (ClassNotFoundException | SQLException  e) {
                                    System.out.println(e.getMessage());
                                }
                            }else{
                                JFrame f=new JFrame();
                                JOptionPane.showMessageDialog(f,"Tag!");
                            }
                        }else{
                            JFrame f=new JFrame();
                            JOptionPane.showMessageDialog(f,"Group!");
                        }
                    }else{
                        JFrame f=new JFrame();
                        JOptionPane.showMessageDialog(f,"Subject!");
                    }
                }else{
                    JFrame f=new JFrame();
                    JOptionPane.showMessageDialog(f,"Lecturer!");
                }
            }else{
                JFrame f=new JFrame();
                JOptionPane.showMessageDialog(f,"Lecturer!");
            }
        }else{
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,"Select Table Row!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sessionTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sessionTblMouseClicked
        int rowIndex = sessionTbl.getSelectedRow();
        id = sessionTbl.getValueAt(rowIndex, 0).toString();
        
        Connection connection;
	PreparedStatement preparedStatement;
        try{
            connection = DBConnect.getDBConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM sessions WHERE id=?");
            preparedStatement.setString(1, id);
            ResultSet rs1 = preparedStatement.executeQuery();

            while(rs1.next())
            {
                lectuererSelect.setSelectedItem(rs1.getString(1)+"-"+rs1.getString(2));
                tagSelect.setSelectedItem(rs1.getString(3)+"-"+rs1.getString(4));
                groupSelect.setSelectedItem(rs1.getString(5)+"-"+rs1.getString(6));
                subjectSelect.setSelectedItem(rs1.getString(7)+"-"+rs1.getString(8));
                txtStdCount.setText(rs1.getString(9)+"-"+rs1.getString(10)+"-"+rs1.getString(11));
                txtDuration.setText(rs1.getString(12)+"-"+rs1.getString(13)+"-"+rs1.getString(14));
                
            }
        }catch ( ClassNotFoundException | SQLException  e) {
                System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_sessionTblMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Connection connection;
	PreparedStatement preparedStatement;
        try{
            connection = DBConnect.getDBConnection();

            preparedStatement = connection.prepareStatement("DELETE FROM sessions WHERE id=?");
            preparedStatement.setString(1, id);
            
            if(!preparedStatement.execute()){
                JFrame f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Delete Successful!");
                clear();
                sessionTable();
            }else{
                JFrame f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Delete Unsuccessful!");
                clear();
            }
            
        }catch ( ClassNotFoundException | SQLException  e) {
                System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFrame frame = new Menu.Menu();
        setVisible(false);
        frame.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> groupSelect;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> lectuererSelect;
    private javax.swing.JScrollPane sclpn;
    private javax.swing.JTable sessionTbl;
    private javax.swing.JComboBox<String> subjectSelect;
    private javax.swing.JComboBox<String> tagSelect;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtStdCount;
    // End of variables declaration//GEN-END:variables
}
