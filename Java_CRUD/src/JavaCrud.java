import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JavaCrud {

    private JFrame frame;
    private JTextField bNameTf;
    private JTextField editionTf;
    private JTextField priceTf;
    private JTable table;
    private JTextField idTf;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JavaCrud window = new JavaCrud();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public JavaCrud() {
        initialize();
        Connect();
        load_table();
    }
    
    Connection con;
    PreparedStatement prepStatment;
    ResultSet result;
    
     public void Connect() {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root", "");
        } catch (ClassNotFoundException cnfe) {
             
        }
         catch(SQLException sqle) {
             
         }
     }
     
     public void load_table() {
         try {
             prepStatment = con.prepareStatement("select * from book");
             result = prepStatment.executeQuery();
             table.setModel(DbUtils.resultSetToTableModel(result));
         }
        catch(SQLException sqle) {
                     
                 }
     }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 23));
        frame.setBounds(100, 100, 914, 593);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Book shop");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblNewLabel.setBounds(348, 33, 182, 51);
        frame.getContentPane().add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(46, 127, 382, 230);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Book name");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(10, 27, 127, 25);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Edition");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(10, 84, 107, 25);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Price");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_3.setBounds(10, 137, 92, 25);
        panel.add(lblNewLabel_3);
        
        bNameTf = new JTextField();
        bNameTf.setBounds(169, 34, 121, 19);
        panel.add(bNameTf);
        bNameTf.setColumns(10);
        
        editionTf = new JTextField();
        editionTf.setBounds(169, 91, 121, 19);
        panel.add(editionTf);
        editionTf.setColumns(10);
        
        priceTf = new JTextField();
        priceTf.setBounds(169, 144, 121, 19);
        panel.add(priceTf);
        priceTf.setColumns(10);
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                bNameTf.setText("");
                editionTf.setText("");
                priceTf.setText("");
                bNameTf.requestFocus(); 
            }
        });
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnClear.setBounds(321, 377, 107, 54);
        frame.getContentPane().add(btnClear);
        
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(185, 377, 107, 54);
        frame.getContentPane().add(btnExit);
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
              String bookName, edition, price;
                
              bookName = bNameTf.getText();
              edition = editionTf.getText();
              price = priceTf.getText();
              
              try {
                  prepStatment = con.prepareStatement("insert into book(name, edition, price) values(?, ?, ?)");
                  prepStatment.setString(1, bookName);
                  prepStatment.setString(2, edition);
                  prepStatment.setString(3, price);
                  prepStatment.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Record added successfully!");
                  load_table();
                  bNameTf.setText("");
                  editionTf.setText("");
                  priceTf.setText("");
                  bNameTf.requestFocus();
              }
              catch(SQLException e1) {
                  e1.printStackTrace();
              }
            }
        });
        btnSave.setBounds(49, 377, 107, 54);
        frame.getContentPane().add(btnSave);
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(506, 125, 324, 305);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_1.setBounds(46, 453, 382, 71);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_2_1 = new JLabel("Book ID");
        lblNewLabel_2_1.setBounds(10, 16, 165, 25);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_1.add(lblNewLabel_2_1);
        
        idTf = new JTextField();
        idTf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    
                     String id = idTf.getText();
                     
                     prepStatment = con.prepareStatement("select name, edition, price from book whre id= ?");
                     prepStatment.setString(1, id);
                     ResultSet result = prepStatment.executeQuery();
                     
                     if(result.next() == true) {
                         String name = result.getString(1);
                         String edition = result.getString(2);
                         String price = result.getString(3);
                         
                         bNameTf.setText(name);
                         editionTf.setText(edition);
                         priceTf.setText(price);
                     }
                     else {
                         bNameTf.setText("");
                         editionTf.setText("");
                         priceTf.setText("");
                     }
                } catch (SQLException sqle) {
                     
                }
            }
        });
        idTf.setBounds(180, 16, 144, 26);
        idTf.setColumns(10);
        panel_1.add(idTf);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String bookName, edition, price, id;
                
                bookName = bNameTf.getText();
                edition = editionTf.getText();
                price = priceTf.getText();
                id = idTf.getText();
                
                try {
                    prepStatment = con.prepareStatement("update book set name = ?, edition = ?, price = ? where id = ?");
                    prepStatment.setString(1, bookName);
                    prepStatment.setString(2, edition);
                    prepStatment.setString(3, price);
                    prepStatment.setString(4, id);
                    prepStatment.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record updated successfully!");
                    load_table();
                    
                    bNameTf.setText("");
                    editionTf.setText("");
                    priceTf.setText("");
                    bNameTf.requestFocus();
                }
                catch(SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnUpdate.setBounds(506, 453, 128, 71);
        frame.getContentPane().add(btnUpdate);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                
                String id;
                id = idTf.getText();
                
                try {
                    prepStatment = con.prepareStatement("delete from book where id = ?"); 
                    prepStatment.setString(1, id);
                    prepStatment.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record deleted successfully!");
                    load_table();
                    
                    bNameTf.setText("");
                    editionTf.setText("");
                    priceTf.setText("");
                    bNameTf.requestFocus();
                }
                catch(SQLException e1) {
                    e1.printStackTrace();
                }
            }
            
        });
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDelete.setBounds(703, 453, 128, 71);
        frame.getContentPane().add(btnDelete);
    }
}
