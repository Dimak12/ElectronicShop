package electronicshop;

import com.sun.glass.events.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Stock extends javax.swing.JFrame {
    
    private String feedback = null;
    ElectronicShop eShop ;
     
    public Stock() {
        initComponents();
        eShop = new ElectronicShop("root", "root", "electronic_shop");
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barcodeLab = new javax.swing.JLabel();
        barcodeTF = new javax.swing.JTextField();
        productLab = new javax.swing.JLabel();
        productTF = new javax.swing.JTextField();
        descriptionLab = new javax.swing.JLabel();
        descriptionTF = new javax.swing.JTextField();
        quantityTF = new javax.swing.JTextField();
        quantityLab = new javax.swing.JLabel();
        priceLab = new javax.swing.JLabel();
        priceTF = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        upload = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        display = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barcodeLab.setText("Barcode");

        barcodeTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                barcodeTFKeyPressed(evt);
            }
        });

        productLab.setText("Product Name");

        productTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productTFActionPerformed(evt);
            }
        });
        productTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productTFKeyPressed(evt);
            }
        });

        descriptionLab.setText("Description");

        descriptionTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionTFActionPerformed(evt);
            }
        });

        quantityLab.setText("Quantity");

        priceLab.setText("Price(R)");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        upload.setText("Upload File");
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        title.setText("Stock Management");

        display.setText("Display Stock");
        display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barcodeLab, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productLab)
                    .addComponent(descriptionLab)
                    .addComponent(quantityLab)
                    .addComponent(priceLab))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Back))
                    .addComponent(priceTF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionTF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productTF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barcodeTF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upload, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(display, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(title)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barcodeLab)
                    .addComponent(barcodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upload))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productLab)
                    .addComponent(productTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionLab)
                    .addComponent(descriptionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityLab))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLab)
                    .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(Back)
                    .addComponent(display))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void descriptionTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionTFActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
 
        String barcode = barcodeTF.getText();
        String product = productTF.getText();
        String description = descriptionTF.getText();
        String quantity = quantityTF.getText();
        String price = priceTF.getText();
        String query = "select * from stock where barcode = ?";
        
        ValidateInput val = new ValidateInput();
        
        if(!val.valBarcode(barcode)){
            
            JOptionPane.showMessageDialog(null, "Invalid barcode entry");
        }
        
        else if(!val.valProduct(product)){
            
            JOptionPane.showMessageDialog(null, "Invalid product entry");
        }
        
        else if(!val.valDescription(description)){
            
            JOptionPane.showMessageDialog(null, "Invalid description input");
        }
        
        else if(!val.valQuantity(quantity)){
            
            JOptionPane.showMessageDialog(null, "Invalid quantity entry");
        }
        
        else if(!val.valPrice(price)){
            
            JOptionPane.showMessageDialog(null, "Invalid price entry");
        }
        
        else {
                       
            
            eShop.checkDatabase(barcode,query,barcode,product,description,quantity,price);         
    
       
       if(eShop.getFeedback() == "Database successfully updated"){
           
           barcodeTF.setText("");
           productTF.setText("");
           descriptionTF.setText("");
           quantityTF.setText("");
           priceTF.setText(""); 
           JOptionPane.showMessageDialog(null, eShop.getFeedback());
       }
        
        }
        
    }//GEN-LAST:event_saveActionPerformed

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
        
        eShop.chooser();
        if(eShop.getFeedback() == "Database successfully updated"){
           
            JOptionPane.showMessageDialog(null, eShop.getFeedback());
        }
    }//GEN-LAST:event_uploadActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
 
        Menu menu = new Menu();
        this.setVisible(false);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void barcodeTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barcodeTFKeyPressed
        
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            
            String query = "select * from stock where barcode = ?";
            eShop.readDatabase(barcodeTF.getText().trim(),query,getBarcodeTF(),getProductTF(),getDescriptionTF(),getQuantityTF(),getPriceTF());
            
        }
        else if(evt.getKeyCode()== KeyEvent.VK_BACKSPACE){
            
            productTF.setText("");
            descriptionTF.setText("");
            priceTF.setText("");
            quantityTF.setText("");
            
        }
        
    }//GEN-LAST:event_barcodeTFKeyPressed

    private void displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayActionPerformed

        DataTable dt = new DataTable();
        
        eShop.displayDatabase(dt.getDataTab());
        this.setVisible(false);
        dt.setVisible(true);
        dt.setLocationRelativeTo(null);
        
        
    }//GEN-LAST:event_displayActionPerformed

    private void productTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productTFActionPerformed

    private void productTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productTFKeyPressed
       if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            
            String query = "select * from stock where product = ?";
            eShop.readDatabase(productTF.getText().trim(),query,getBarcodeTF(),getProductTF(),getDescriptionTF(),getQuantityTF(),getPriceTF());
            
        }
        
    }//GEN-LAST:event_productTFKeyPressed

    
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
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel barcodeLab;
    private javax.swing.JTextField barcodeTF;
    private javax.swing.JLabel descriptionLab;
    private javax.swing.JTextField descriptionTF;
    private javax.swing.JButton display;
    private javax.swing.JLabel priceLab;
    private javax.swing.JTextField priceTF;
    private javax.swing.JLabel productLab;
    private javax.swing.JTextField productTF;
    private javax.swing.JLabel quantityLab;
    private javax.swing.JTextField quantityTF;
    private javax.swing.JButton save;
    private javax.swing.JLabel title;
    private javax.swing.JButton upload;
    // End of variables declaration//GEN-END:variables

    public JTextField getBarcodeTF() {
        return barcodeTF;
    }

    public JTextField getDescriptionTF() {
        return descriptionTF;
    }

    public JTextField getPriceTF() {
        return priceTF;
    }

    public JTextField getProductTF() {
        return productTF;
    }

    public JTextField getQuantityTF() {
        return quantityTF;
    }

  
    


}

