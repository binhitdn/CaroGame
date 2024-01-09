package Main;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Model.UserData;
public class Admin extends JFrame implements Runnable{
    private UserData userData;
    private JButton jButton3;
    private JScrollPane jScrollPane2;
    public static JTextArea jTextArea2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextArea jTextArea2_1;
    private JButton btnNewButton;
    private JFrame j;
    public Admin() {
    	
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(487,538);
        jTextArea2.setEditable(false);
        userData = new UserData();
        this.setIconImage(new ImageIcon("src/images/unnamed.png").getImage());
        j = this;
    }

    private void initComponents() {

        jTextField2 = new JTextField();
        jTextField1 = new JTextField();
        jButton3 = new JButton();
        jScrollPane2 = new JScrollPane();
        jTextArea2 = new JTextArea();
        jTextArea2.append("Đã khởi động máy chủ:"+"\n");     

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
            	 if(evt.getKeyCode()==10){
                     sendMessage();
                 }
            }
        });

        jButton3.setFont(new Font("Segoe UI", Font.PLAIN, 9)); // NOI18N
        jButton3.setText("Phát thông báo");
        jButton3.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
				
			}
        	
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);
        
        JScrollPane jScrollPane2_1 = new JScrollPane();
        
        btnNewButton = new JButton("Gửi Lời Chào");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		BufferedWriter buffer;
				try {
					FileWriter writer = new FileWriter("file/noiquy.txt");
					buffer = new BufferedWriter(writer);
					buffer.write(jTextArea2_1.getText());
					buffer.close();
	                
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(j, "Ghi lời chào thành công");
        	}
        	
        });

       

        

        

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(15)
        					.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jScrollPane2_1, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnNewButton)))
        			.addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jScrollPane2_1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(97)
        					.addComponent(btnNewButton)))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(17, Short.MAX_VALUE))
        );
        
        jTextArea2_1 = new JTextArea();
        jTextArea2_1.setRows(5);
        jTextArea2_1.setColumns(20);
        jScrollPane2_1.setViewportView(jTextArea2_1);
        getContentPane().setLayout(layout);

        
    }

    

   
    

    
    private void sendMessage(){
        String message = jTextField1.getText();
        if(message.length()==0) return;
        String temp = jTextArea2.getText();
        temp+= "Thông báo từ máy chủ : "+message+"\n";
        jTextArea2.setText(temp);
        jTextArea2.setCaretPosition(jTextArea2.getDocument().getLength());
        Server.threadServers.boardCast(-1,"chat-server,Thông báo từ máy chủ : "+ message);
        jTextField1.setText("");
    }
    public void addMessage(String message) {
        String tmp = jTextArea2.getText();
        tmp=tmp+message+"\n";
        jTextArea2.setText(tmp);
        jTextArea2.setCaretPosition(jTextArea2.getDocument().getLength());
    }
    
  

    @Override
    public void run() {
        new Admin().setVisible(true);
    }
}