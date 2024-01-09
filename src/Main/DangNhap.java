package Main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.google.common.hash.Hashing;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.charset.StandardCharsets;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class DangNhap extends javax.swing.JFrame {
	 private JButton jButton1;
	    private JButton jButton2;
	    private JLabel jLabel1;
	    private JLabel jLabel2;
	    private JLabel jLabel3;
	    private JPanel jPanel1;
	    private JPasswordField jPasswordField1;
	    private JTextField jTextField1;
    public DangNhap() {
    	getContentPane().setBackground(Color.WHITE);
        initComponents();
        this.setTitle("Cờ Caro");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setSize(410,228);
        this.setIconImage(new ImageIcon("src/images/unnamed.png").getImage());
    }
 
    public DangNhap(String taiKhoan, String matKhau) {
        initComponents();
        jPasswordField1.setText(matKhau);
        jTextField1.setText(taiKhoan);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
    }
    public void showError(String message){
        JOptionPane.showMessageDialog(rootPane, message);
    }
    public void log(String message){
        JOptionPane.showMessageDialog(rootPane,"ID của server thread là:"+ message);
    }
   
    private void initComponents() {

        jTextField1 = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton2.setForeground(Color.BLUE);
        jButton2.setBorder(null);
        jButton2.setBackground(Color.WHITE);
        jPanel1 = new JPanel();
        jLabel3 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tài khoản");

        jLabel2.setText("Mật khẩu");

        jButton1.setText("Đăng Nhập");
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyPressed(java.awt.event.KeyEvent evt) {
	        	if(evt.getKeyCode() == 10){
	        		try {
	                    String taiKhoan = jTextField1.getText();
	                    if(taiKhoan.isEmpty())
	                        throw new Exception("Vui lòng nhập tên tài khoản");
	                    String matKhau = String.copyValueOf(jPasswordField1.getPassword());
	                    if(matKhau.isEmpty())
	                        throw new Exception("Vui lòng nhập mật khẩu");
	                    Client.closeAllViews();
	                    Client.openView("GAMENOTICE", "Đăng nhập", "Đang xác thực thông tin đăng nhập");
	                    Client.threadClient.write("client-verify,"+taiKhoan+","+matKhau);            
	                } catch (Exception ex) {
	                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
	                }
	            }
	        }
	    });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyPressed(java.awt.event.KeyEvent evt) {
	        	if(evt.getKeyCode() == 10){
	        		jPasswordField1.requestFocus();
	            }
	        }
	    });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
                    String taiKhoan = jTextField1.getText();
                    if(taiKhoan.isEmpty())
                        throw new Exception("Vui lòng nhập tên tài khoản");
                    String matKhau = String.copyValueOf(jPasswordField1.getPassword());
                    if(matKhau.isEmpty())
                        throw new Exception("Vui lòng nhập mật khẩu");
                    Client.closeAllViews();
                    Client.openView("GAMENOTICE", "Đăng nhập", "Đang xác thực thông tin đăng nhập");
                    Client.threadClient.write("client-verify,"+taiKhoan+","+matKhau);            
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
            }
        });

        jButton2.setText("Chưa có tài khoản?Đăng kí ngay");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	Client.closeView("LOGIN");
                Client.openView("REGISTER");
            }
        });

        jPanel1.setBackground(Color.WHITE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(Color.DARK_GRAY);
        jLabel3.setText("Đăng Nhập");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(167)
        			.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(196, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel3)
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Hiện mật khẩu");
        chckbxNewCheckBox.setBackground(Color.WHITE);
        jPasswordField1.setEchoChar('*');
        chckbxNewCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
                    jPasswordField1.setEchoChar((char) 0);
                } else {
                	jPasswordField1.setEchoChar('*');
                }
				
			}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(32)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(20)
        					.addComponent(chckbxNewCheckBox, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        					.addGap(173))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(jTextField1))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
        						.addComponent(jButton2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
        					.addContainerGap())))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(chckbxNewCheckBox)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jButton2)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
        
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyPressed(java.awt.event.KeyEvent evt) {
	        	if(evt.getKeyCode() == 10){
	        		
	            }
	        }
	    });
        
    }
    
    

   

    

    
   
}