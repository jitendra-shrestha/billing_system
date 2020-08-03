/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashier_system;
import Report.ConnectionDB;
import admin_section.Menu_Form_cashier;
import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author tjite
 */
public class home extends javax.swing.JInternalFrame {
    public static Double famount;
    public static Double fdiscount;
    public static int counter;
    /**
     * Creates new form home
     */
    public home() {
        initComponents();
        famount=fdiscount=0.0;
        counter=1;
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi=(BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.getMessage();
        } 
        Barcode.requestFocus();
        jButton6.setVisible(false);
        jButton3.setVisible(false);
       
        gross.setVisible(false);
        jtxtnext.setVisible(false);
    }
    public ArrayList<Temp> templist(){
        ArrayList<Temp> tempslist= new ArrayList<>();
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            Statement st= con.createStatement();
           
            ResultSet rs;
            String query = "SELECT * FROM temp";
            rs = st.executeQuery(query);
            Temp temp;
            while(rs.next()){
                temp=new Temp(rs.getInt("temp_id"),rs.getString("name"),rs.getString("rate"),rs.getString("category"),rs.getString("barcode"),
                rs.getString("quantity"),rs.getDouble("amount"),rs.getDouble("discount"));
                tempslist.add(temp);
            }
            
         st.close();
        con.close();
         }
          catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
         return tempslist;
    }
    
    public void show_temp(){
        ArrayList<Temp> list= templist();
        DefaultTableModel model=(DefaultTableModel)show_temp.getModel();
        Object[] row=new Object[11];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).gettemp_id();
            row[1]=list.get(i).getname();
            row[2]=list.get(i).getrate();
            row[3]=list.get(i).getcategory();
            row[4]=list.get(i).getbarcode();
            row[5]=list.get(i).getquantity();
            row[6]=list.get(i).getamount();
            row[7]=list.get(i).getdiscount();
            model.addRow(row);
        }
    }
    
    public void copy(String name,Double quantity,String category,String cashier,Double amount,Double discount,String date){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            Statement st= con.createStatement();
            String query = "insert into sales(name,quantity,category,cashier,amount,discount,date) values('"+name+"','"+quantity+"','"+category+"','"+cashier+"','"+amount+"','"+discount+"','"+date+"')";
                st.executeUpdate(query);
                //System.out.println(query);
         st.close();
        con.close();
      }catch(Exception ex){}
        
    }
    
     public void stockout(String pname,Double quantity){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            Statement st= con.createStatement();
            String query = "select stock from product where name='"+pname+"'";
            ResultSet rs;
            rs=st.executeQuery(query);
            while(rs.next()){
                Double pstock=Double.parseDouble(rs.getString("stock"));
                Double nstock=pstock-quantity;
                String fstock=Double.toString(nstock);
                query = "update product set stock='"+fstock+"' where name='"+pname+"'";
                st.executeUpdate(query);
                //System.out.println(query);
            }
         st.close();
        con.close();
      }catch(Exception ex){}
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Barcode = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        show_temp = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jtxtname = new javax.swing.JTextField();
        jtxtcategory = new javax.swing.JTextField();
        jtxtrate = new javax.swing.JTextField();
        jtxtquantity = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtxtchange = new javax.swing.JTextField();
        jtxtcash = new javax.swing.JTextField();
        jtxttd = new javax.swing.JTextField();
        jtxtna = new javax.swing.JTextField();
        jtxtnext = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtxtamount = new javax.swing.JTextField();
        jtxtdiscount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtnetamount = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        gross = new javax.swing.JTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        Barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarcodeActionPerformed(evt);
            }
        });
        Barcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BarcodeKeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        show_temp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        show_temp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.N", "Product name", "Rate", "Category", "Barcode", "Quantity", "Amount", "Discount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        show_temp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show_tempMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(show_temp);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Product ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Category");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Rate");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Quantity");

        jButton3.setBackground(new java.awt.Color(0, 84, 140));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 204));
        jButton3.setText("DELETE");
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton3KeyPressed(evt);
            }
        });

        jtxtname.setEditable(false);
        jtxtname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jtxtcategory.setEditable(false);
        jtxtcategory.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jtxtrate.setEditable(false);
        jtxtrate.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jtxtquantity.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jtxtquantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtquantityKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtname, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtrate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setPreferredSize(new java.awt.Dimension(326, 275));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Net Amount");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Total Discount");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Cash");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Change");

        jtxtcash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcashKeyPressed(evt);
            }
        });

        jtxttd.setEditable(false);

        jtxtna.setEditable(false);

        jtxtnext.setBackground(new java.awt.Color(0, 84, 140));
        jtxtnext.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jtxtnext.setForeground(new java.awt.Color(0, 0, 204));
        jtxtnext.setText("NEXT");
        jtxtnext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtnextMouseClicked(evt);
            }
        });
        jtxtnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtnextActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 84, 140));
        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 204));
        jButton7.setText("RESET");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtna, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxttd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtcash, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtchange, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jtxtnext, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxttd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtcash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtchange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(jtxtnext))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setPreferredSize(new java.awt.Dimension(326, 275));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Amount");

        jtxtamount.setEditable(false);

        jtxtdiscount.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Discount");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Net Amount");

        jtxtnetamount.setEditable(false);

        jButton6.setBackground(new java.awt.Color(0, 84, 140));
        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 204));
        jButton6.setText("OK");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtamount, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtnetamount, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtnetamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(22, 22, 22))
        );

        jButton1.setBackground(new java.awt.Color(0, 84, 140));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(Barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(gross, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Barcode)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(gross, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1260, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    
    
    
    private void BarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarcodeActionPerformed

    private void BarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarcodeKeyPressed
        // TODO add your handling code here:
        
        Robot r;
        try {
            r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
        } catch (AWTException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            Statement st= con.createStatement();   
            String query = "SELECT * FROM product WHERE barcode='"+Barcode.getText()+"'";
            ResultSet rs,rc;
            rs = st.executeQuery(query);
            while(rs.next())
            {
                if(rs.getDouble("stock")>0.0){
                    jtxtname.setText(rs.getString("name"));
                    jtxtrate.setText(rs.getString("price"));
                    jtxtquantity.requestFocus();
                    jtxtquantity.setText("1");
                    jtxtcategory.setText(rs.getString("c_id"));
                        query = "SELECT * FROM category where c_id='"+jtxtcategory.getText()+"'";
                        rc = st.executeQuery(query);
                        while(rc.next()){
                                jtxtcategory.setText(rc.getString("name"));
                        }
            jtxtamount.setText("");
            jtxtdiscount.setText("");
            jtxtnetamount.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Out of stock", "Error", 2);
                    Barcode.setText("");
                    Barcode.requestFocus();
                }
            }   
         st.close();
        con.close();}
        catch(Exception e){}
        }
    }//GEN-LAST:event_BarcodeKeyPressed

    private void jtxtcashKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcashKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
         Double naa=Double.parseDouble(jtxtna.getText());
         Double nbb=Double.parseDouble(jtxtcash.getText());  
         if(nbb<naa){
             JOptionPane.showMessageDialog(null, "Not sufficient balance", "Error", 2);
         }else{
             Double ncc=nbb-naa;
             String n=String.format("%.2f", ncc);
             jtxtchange.setText(n);
             jtxtnext.setVisible(true);
         }  
        }
    }//GEN-LAST:event_jtxtcashKeyPressed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            Statement st= con.createStatement();
            String query = "truncate temp";
            st.executeUpdate(query);
         st.close();
        con.close();}catch(Exception ex){}
        DefaultTableModel model = (DefaultTableModel)show_temp.getModel();
        model.setRowCount(0);
        show_temp();
        counter=0;
        famount=0.0;
        fdiscount=0.0;
        jtxtname.setText("");
        jtxtrate.setText("");
        jtxtcategory.setText("");
        jtxtamount.setText("");
        jtxtdiscount.setText("");
        jtxtnetamount.setText("");
        jtxtna.setText("");
        jtxttd.setText("");
        jtxtquantity.setText("");
        jtxtcash.setText("");
        jtxtchange.setText("");
        jButton3.setVisible(false);
      
        jButton6.setVisible(false);
        Barcode.setText("");
        Barcode.requestFocus();
    }//GEN-LAST:event_jButton7MouseClicked

    private void jtxtnextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtnextMouseClicked
       //JOptionPane.showMessageDialog(null, "Transaction sucessed", "Sucess", 1);
      try{
            String name,category,rate,date;
            double quantity,amount,discount;
            Menu_Form_cashier m=new Menu_Form_cashier();
            String cashier = m.uname;
                    Calendar cal = new GregorianCalendar();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    date=(year + "-" + (month+1) + "-" + day);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            Statement st= con.createStatement();
            ResultSet rs;
            String query = "Select name,rate,category,quantity,amount,discount from temp";
            rs=st.executeQuery(query);
            String barcode=Barcode.getText();
            while(rs.next()){
                name=rs.getString("name");
                rate=rs.getString("rate");
                category=rs.getString("category");
                quantity=rs.getDouble("quantity");
                amount=rs.getDouble("amount");
                discount=rs.getDouble("discount"); 
                copy(name,quantity,category,cashier,amount,discount,date);
                stockout(name,quantity);
            } 
         st.close();
        con.close();
      }catch(Exception ex){}
      
      try{
            Connection con = ConnectionDB.koneksiDb();
            String jrxmlfile="src/Report/report2.jrxml";
            Menu_Form_cashier m=new Menu_Form_cashier();
            String cashier = m.uname;
//            InputStream in =new FileInputStream(new File("C:\\Users\\tjite\\Documents\\NetBeansProjects\\billing_system\\src\\Report\\report1.jrxml"));
//            JasperDesign jd=JRXmlLoader.load(in);
            HashMap para=new HashMap();
            para.put("cashier",cashier);
            para.put("tender",jtxtcash.getText());
            para.put("change",jtxtchange.getText());
            para.put("gross",gross.getText());
            para.put("net",famount);
            para.put("dis",fdiscount);
            JasperReport jr=JasperCompileManager.compileReport(jrxmlfile);
            JasperPrint j=JasperFillManager.fillReport(jr, para,con);
            JasperViewer.viewReport(j,false);
            //OutputStream os=new FileOutputStream(new File("C:\\Users\\tjite\\Documents\\NetBeansProjects\\billing_system\\src\\Report"));
            //JasperExportManager.exportReportToPdfStream(j,os);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,e);
      }
      
      //truncate after transaction
       try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            Statement st= con.createStatement();
            String query = "truncate temp";
            st.executeUpdate(query);
        }catch(Exception ex){}
       DefaultTableModel model = (DefaultTableModel)show_temp.getModel();
        model.setRowCount(0);
        show_temp();
        famount=0.0;
        fdiscount=0.0;
        jtxtname.setText("");
        jtxtrate.setText("");
        jtxtcategory.setText("");
        jtxtamount.setText("");
        jtxtdiscount.setText("");
        jtxtnetamount.setText("");
        jtxtna.setText("");
        jtxttd.setText("");
        jtxtquantity.setText("");
        jtxtcash.setText("");
        jtxtchange.setText("");
        jButton3.setVisible(false);
     
        jButton6.setVisible(false);
        jtxtnext.setVisible(false);
        Barcode.setText("");
        Barcode.requestFocus();
        
       
    }//GEN-LAST:event_jtxtnextMouseClicked

    private void show_tempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show_tempMouseClicked
            jButton3.setVisible(true);
            
            int i = show_temp.getSelectedRow();
            TableModel model = show_temp.getModel();
            String suid = model.getValueAt(i, 0).toString();
            int id=Integer.parseInt(suid);
            jtxtname.setText(model.getValueAt(i, 1).toString());
            jtxtrate.setText(model.getValueAt(i, 2).toString());
            jtxtcategory.setText(model.getValueAt(i, 3).toString());
            Barcode.setText(model.getValueAt(i, 4).toString());
            jtxtquantity.setText(model.getValueAt(i, 5).toString());
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            Statement st= con.createStatement();
            String query = "delete from temp where temp_id='"+id+"'";
            st.executeUpdate(query);
             st.close();
        con.close();}catch(Exception ex){}
            Barcode.requestFocus();
    }//GEN-LAST:event_show_tempMouseClicked

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            Statement st= con.createStatement();
            String query = "delete from temp where name='"+jtxtname.getText()+"'";
            st.executeUpdate(query);
             st.close();
        con.close();}catch(Exception ex){}
             JOptionPane.showMessageDialog(null, "Deleted","Sucess",1);
            DefaultTableModel model = (DefaultTableModel)show_temp.getModel();
            model.setRowCount(0);
            show_temp();
            jtxtname.setText("");
            jtxtrate.setText("");
            jtxtcategory.setText("");
            jtxtquantity.setText("");
            jtxtamount.setText("");
            jtxtdiscount.setText("");
            jtxtnetamount.setText("");
            jButton3.setVisible(false);
       
            Barcode.requestFocus();
    }//GEN-LAST:event_jButton3KeyPressed

    private void jtxtnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtnextActionPerformed
           
   
    }//GEN-LAST:event_jtxtnextActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        jButton6.setVisible(false);
       
        jButton3.setVisible(false);
        try{
            String name=jtxtname.getText();
            String rate=jtxtrate.getText();
            String quantity=jtxtquantity.getText();
            String na=jtxtnetamount.getText();
            String d=jtxtdiscount.getText();
            String cat=jtxtcategory.getText();
            String bcode=Barcode.getText();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            Statement st= con.createStatement();
            ResultSet rs;
            String query = "insert into temp(name,rate,category,barcode,quantity,amount,discount) values('"+name+"','"+rate+"','"+cat+"','"+bcode+"','"+quantity+"','"+na+"','"+d+"')";
            st.executeUpdate(query);
            query = "SELECT SUM(amount) as total FROM temp";
            rs=st.executeQuery(query);
            while(rs.next()){
                Double aa=rs.getDouble("total");
                String n=String.format("%.2f", aa);
                famount=Double.parseDouble(n);
                jtxtna.setText(n);
            }
            query = "SELECT SUM(discount) as total FROM temp";
            rs=st.executeQuery(query);
            while(rs.next()){
                Double bb=rs.getDouble("total");
                String n=String.format("%.2f", bb);
                fdiscount=Double.parseDouble(n);
                jtxttd.setText(n);
            }
            Double cc=famount+fdiscount;
            gross.setText(Double.toString(cc));
            st.close();
            con.close();}catch(Exception ex){}
        DefaultTableModel model = (DefaultTableModel)show_temp.getModel();
        model.setRowCount(0);
        show_temp();
        jtxtname.setText("");
        jtxtrate.setText("");
        jtxtcategory.setText("");
        jtxtquantity.setText("");
        jtxtamount.setText("");
        jtxtdiscount.setText("");
        jtxtnetamount.setText("");
        Barcode.setText("");
        Barcode.requestFocus();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jtxtquantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtquantityKeyPressed
               jButton6.setVisible(true);
        try
        {
            double discount,amount,netamount,quantity,price;
            famount=fdiscount=0.0;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            Statement st= con.createStatement();   
            String query = "SELECT * FROM product WHERE barcode='"+Barcode.getText()+"'";
            ResultSet rs,rc;
            rs = st.executeQuery(query);
            while(rs.next())
            {
                        Double stock=Double.parseDouble(rs.getString("stock"));
                        quantity=Double.parseDouble(jtxtquantity.getText());
                        if(stock>quantity){
                                jtxtname.setText(rs.getString("name"));
                                jtxtrate.setText(rs.getString("price"));
                                price=Double.parseDouble(rs.getString("price"));
                                amount=price*quantity;
                                jtxtcategory.setText(rs.getString("c_id"));

                                jtxtamount.setText(String.valueOf(amount));
                                query = "SELECT * FROM category where c_id='"+jtxtcategory.getText()+"'";
                                rc = st.executeQuery(query);
                                while(rc.next()){
                                        jtxtcategory.setText(rc.getString("name"));
                                        discount=amount*(Double.parseDouble(rc.getString("discount")));
                                        jtxtdiscount.setText(String.valueOf(discount));
                                        netamount=amount-discount;
                                        jtxtnetamount.setText(String.valueOf(netamount));
                                        famount=famount+netamount;
                                        fdiscount=fdiscount+discount;
                                }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Out of stock", "Error", 2);
                            jtxtquantity.setText("");
                            jtxtquantity.requestFocus();
                        }
            } 
         st.close();
        con.close();}
        catch(Exception e){}
        
    }//GEN-LAST:event_jtxtquantityKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            Statement st= con.createStatement();   
            String query = "SELECT * FROM product WHERE barcode='"+Barcode.getText()+"'";
            ResultSet rs,rc;
            rs = st.executeQuery(query);
            while(rs.next())
            {
                if(rs.getDouble("stock")>0.0){
                    jtxtname.setText(rs.getString("name"));
                    jtxtrate.setText(rs.getString("price"));
                    jtxtquantity.requestFocus();
                    jtxtquantity.setText("1");
                    jtxtcategory.setText(rs.getString("c_id"));
                        query = "SELECT * FROM category where c_id='"+jtxtcategory.getText()+"'";
                        rc = st.executeQuery(query);
                        while(rc.next()){
                                jtxtcategory.setText(rc.getString("name"));
                        }
            jtxtamount.setText("");
            jtxtdiscount.setText("");
            jtxtnetamount.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Out of stock", "Error", 2);
                    Barcode.setText("");
                    Barcode.requestFocus();
                }
            }   
         st.close();
        con.close();}
        catch(Exception e){}
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Barcode;
    private javax.swing.JTextField gross;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtxtamount;
    private javax.swing.JTextField jtxtcash;
    private javax.swing.JTextField jtxtcategory;
    private javax.swing.JTextField jtxtchange;
    private javax.swing.JTextField jtxtdiscount;
    private javax.swing.JTextField jtxtna;
    private javax.swing.JTextField jtxtname;
    private javax.swing.JTextField jtxtnetamount;
    private javax.swing.JButton jtxtnext;
    private javax.swing.JTextField jtxtquantity;
    private javax.swing.JTextField jtxtrate;
    private javax.swing.JTextField jtxttd;
    private javax.swing.JTable show_temp;
    // End of variables declaration//GEN-END:variables
}
