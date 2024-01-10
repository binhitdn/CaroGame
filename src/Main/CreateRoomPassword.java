package Main;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

 class CreateRoomPassword extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton createRoomButton;
    private javax.swing.JLabel frameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loadingButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordTextField;
	
    public CreateRoomPassword() {
        initComponents();
        this.setTitle("Caro Game ");
        this.setIconImage(new ImageIcon("assets/image/caroicon.png").getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        loadingButton.setIcon(null);
    }

    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        frameLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        createRoomButton = new javax.swing.JButton();
        loadingButton = new javax.swing.JButton();
        loadingButton.setText("Thoát");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(Color.CYAN);

        frameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        frameLabel.setForeground(new java.awt.Color(255, 255, 255));
        frameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frameLabel.setText("Tạo phòng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(frameLabel)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("Nhập mật khẩu");

        createRoomButton.setText("Tạo");
        createRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRoomButtonActionPerformed(evt);
            }
        });

        loadingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(28)
        			.addComponent(passwordTextField, 159, 159, 159)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(createRoomButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(114, Short.MAX_VALUE)
        			.addComponent(loadingButton)
        			.addGap(93))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(29)
        			.addComponent(passwordLabel)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(createRoomButton))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(loadingButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void loadingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadingButtonActionPerformed
        Client.closeView("CREATE_ROOM_PASSWORD");
        Client.openView("HOMEPAGE");
    }

    private void createRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRoomButtonActionPerformed
        try {
            String password = passwordTextField.getText();
            if (password.isEmpty())
                throw new Exception("Vui lòng nhập mật khẩu bạn muốn đặt cho phòng");
            Client.threadClient.write("create-room," + password);
            Client.closeView("CREATE_ROOM_PASSWORD");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

   
    
}