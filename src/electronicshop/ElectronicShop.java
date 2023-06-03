
/*PLANDI MAKALI
  220344817
*/

package electronicshop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class ElectronicShop {

    private Connection con;
    private PreparedStatement pstmnt;
    private String feedback;
    
    
    public ElectronicShop(String user,String password,String dbName){
        
        String url = "jdbc:mysql://localhost:3306/"+dbName;  
        try {
            con= DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
            
        }
    }
    
    public static void main(String[] args) {
        
       
        Menu menu = new Menu();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
       
        
    }

    public Connection getCon() {
        return con;
    }

    public PreparedStatement getStmnt() {
        return pstmnt;
    }
     
       
    public void chooser (){
        
        JFileChooser fChooser = new JFileChooser();
        
        fChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fChooser.addChoosableFileFilter(new FileNameExtensionFilter("CSV Only","CSV"));
        fChooser.setAcceptAllFileFilterUsed(true);
        int response = fChooser.showOpenDialog(null);
               
        if (response == JFileChooser.APPROVE_OPTION){
            
            File file = fChooser.getSelectedFile().getAbsoluteFile();
            try {
                csvRead(file);
                
            } catch (SQLException ex) {
                Logger.getLogger(ElectronicShop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void csvRead (File file) throws SQLException{
        
        String line ="";
        String splitBy= ";";
        String query = "select * from stock where barcode = ?";
        try{
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            while((line = br.readLine()) !=null  ){
               
                String[] content = line.split(splitBy);
                
                String barcode = content[0];
                String product = content[1];
                String description = content[2];
                String quantity = content[3];
                String price = content[4];
                
                ValidateInput val = new ValidateInput();
        
        if(!val.valBarcode(barcode)){
           
            JOptionPane.showMessageDialog(null, "Invalid barcode entry for "+barcode);
            break;
            
        }
        
        else if(!val.valProduct(product)){
            
            JOptionPane.showMessageDialog(null, "Invalid product entry for "+ barcode);
            break;
        }
        
        else if(!val.valDescription(description)){
            
            JOptionPane.showMessageDialog(null, "Invalid description input for "+ barcode);
            break;
        }
        
        else if(!val.valQuantity(quantity)){
            
            JOptionPane.showMessageDialog(null, "Invalid quantity entry for "+ barcode);
            break;
        }
        
        else if(!val.valPrice(price)){
            
            JOptionPane.showMessageDialog(null, "Invalid price entry for "+barcode);
            break;
        }
        
        else{
            
            checkDatabase (barcode,query,barcode,product,description,quantity,price);
        }
                
               
            }
        } catch(IOException e){ e.printStackTrace();}
    }
    
    public String manualUpdate (String barcode,String product,String description,String quantity,String price) throws ClassNotFoundException,SQLException{

   
  
   String insert = "insert into stock (barcode,product,description,quantity,price_zar) values (?,?,?,?,?)";
   String query = "select * from stock where barcode = ?";
   
   
   
   pstmnt = con.prepareStatement(insert);
   pstmnt.setString(1, barcode);
   pstmnt.setString(2, product);
   pstmnt.setString(3, description);
   pstmnt.setInt(4, Integer.parseInt(quantity));
   pstmnt.setDouble(5, Double.parseDouble(price));
   
   pstmnt.executeUpdate();
   
    //con.close();
    feedback = "Database successfully updated"; 
   
return feedback;
}

    public String getFeedback() {
        return feedback;
    }
    
    public void deduct (JTable table){
        
        for(int i = 0; i<table.getRowCount(); i++){
            
            String barcode = table.getValueAt(i, 0).toString();
            String quantity = table.getValueAt(i, 3).toString();
           
            try {
                pstmnt = con.prepareStatement("update stock set quantity = quantity - ? where barcode = ?");
                pstmnt.setInt(1, Integer.parseInt(quantity));
                pstmnt.setString(2, barcode);
                pstmnt.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(ElectronicShop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void checkDatabase (String column,String query,String barcode,String product,String description,String quantity,String price){
    
    try{
        
        
        
        
        pstmnt = con.prepareStatement(query);
        PreparedStatement pst = con.prepareStatement("update stock set quantity = quantity + ? where barcode = ?");
        
        pstmnt.setString(1, column);
        pst.setInt(1, Integer.parseInt(quantity));
        pst.setString(2, column);
        ResultSet result = pstmnt.executeQuery();
        
        if(!result.next()){
            
            feedback = manualUpdate(barcode,product,description,quantity,price); 
        }
        
        else{
            
            pst.executeUpdate();
            feedback = "Database successfully updated";
        }
        
        //con.close();
    
    }catch(SQLException|ClassNotFoundException e){
    
    }
}
    
     public void readDatabase (String column,String query, JTextField barcodeTF, JTextField productTF, JTextField descriptionTF, JTextField quantityTF, JTextField priceTF ){
        
        try {
            
            
            pstmnt = con.prepareStatement(query);
            pstmnt.setString(1, column);
            ResultSet result = pstmnt.executeQuery();
            
            if(!result.next()){
                
                JOptionPane.showMessageDialog(null, "Product not found");
                barcodeTF.setText("");
            }
            
            else{
                SellProducts sell = new SellProducts();
                String code = result.getString(1);
                String prod = result.getString(2);
                String desc = result.getString(3);
                String price = ""+result.getDouble(5);
                
                barcodeTF.setText(code.trim());
                productTF.setText(prod.trim());
                descriptionTF.setText(desc.trim());
                priceTF.setText(price.trim());
                quantityTF.requestFocus();
            }
            
            //con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ElectronicShop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void displayDatabase (JTable tab){
         try {
             
             
             pstmnt = con.prepareStatement("select * from stock");
             ResultSet result = pstmnt.executeQuery();
             
             while(result.next()){
                 
                String barcode = result.getString(1);
                String product = result.getString(2);
                String description =result.getString(3); 
                String quantity = ""+ result.getInt(4);
                String price = ""+ result.getDouble(5);
                
                String [] tbData = {barcode,product,description,quantity,price};
                DefaultTableModel model = new DefaultTableModel();
                model = (DefaultTableModel)tab.getModel();
                model.addRow(tbData);
                
             }
            
             
         }catch(SQLException s){
             
         }
         
     }
}




class ValidateInput {
    
    public ValidateInput(){
        
    }
    public  boolean valBarcode(String barcode){
        
        return barcode.matches("[0-9]{1,128}");
    }
     public boolean valProduct(String product){
        
        return product.matches(".+");
    }
     public boolean valDescription(String description){
       
        return description.matches(".+") ;
    }
     public boolean valQuantity(String quantity){
        
        return quantity.matches("[0-9]+");
    }
     
     public boolean valPrice (String price){
         
         return price.matches("\\d+(\\.\\d+)?");
     }
     
     public boolean valPayment (String pay){
         
         return pay.matches("\\d+(\\.\\d+)?");
     }
     
}

