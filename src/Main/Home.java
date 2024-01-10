package Main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

public class Home extends JFrame {
	JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_6,lblNewLabel_8;
	public JTextArea textArea;
	JTextArea textArea_1;
	private JPanel contentPane;
	public Home() {
		 this.setTitle("Trang Chủ - Cờ Caro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
        this.setIconImage(new ImageIcon("src/images/unnamed.png").getImage());
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)), "Th\u00F4ng tin c\u00E1 nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.DARK_GRAY));
		panel_1.setBackground(SystemColor.control);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		lblNewLabel = new JLabel("");
		
		lblNewLabel_1 = new JLabel("{TenDangNhap}");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setText(Client.user.getUsername());
		lblNewLabel.setIcon(new ImageIcon("src/images/"+Client.user.getAvatar()+".jpg"));
		
		JButton btnNewButton_7 = new JButton("Thông tin cá nhân");
		btnNewButton_7.setBackground(new Color(240, 230, 140));
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
		        Client.openView("INFOUSER");
		        Client.closeView("HOMEPAGE");
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("NickName");
		lblNewLabel_2.setText("NickName: "+Client.user.getNickname());
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(53)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(53, Short.MAX_VALUE)
					.addComponent(btnNewButton_7)
					.addGap(46))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addComponent(btnNewButton_7)
					.addGap(22))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.control);
		panel_2.add(panel_4, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.control);
		
		JLabel lblNewLabel_9 = new JLabel("Chat Toàn Server");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel_5, 0, 0, Short.MAX_VALUE))
							.addGroup(gl_panel_4.createSequentialGroup()
								.addGap(10)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(4)
					.addComponent(lblNewLabel_9, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.ITALIC, 16));
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnNewButton_6 = new JButton("Gửi");
		btnNewButton_6.setBackground(new Color(255, 250, 205));
		btnNewButton_6.setForeground(SystemColor.activeCaptionText);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addComponent(btnNewButton_6, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
		);
		
		textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		panel_5.setLayout(gl_panel_5);
		panel_4.setLayout(gl_panel_4);
		 textArea_1.addKeyListener(new java.awt.event.KeyAdapter() {
		        public void keyPressed(java.awt.event.KeyEvent evt) {
		        	if(evt.getKeyCode() == 10){
		                sendMessage();
		            }
		        }
		    });
		 textArea_1.setDisabledTextColor(Color.BLACK);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_2.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.add(panel_3);
		
		JButton btnNewButton_1 = new JButton("Chơi");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(50, 205, 50));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client.closeView("HOMEPAGE");
		        Client.openView("FINDROOM");
			}
		});
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("B\u1EA3ng x\u1EBFp h\u1EA1ng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client.closeView("HOMEPAGE");
		        Client.openView("BXH");
			}
		});
		btnNewButton.setForeground(SystemColor.activeCaptionText);
		btnNewButton.setBackground(new Color(253, 245, 230));
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Client.threadClient.write("offline,"+Client.user.getID());
		        } catch (IOException ex) {
		            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
		        }
		        Client.closeView("HOMEPAGE");
		        Client.openView("LOGIN");
			}
		});
		btnNewButton_4.setBackground(new Color(255, 69, 0));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Tạo phòng");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn đặt mật khẩu cho phòng không?", "Tạo phòng", JOptionPane.YES_NO_OPTION);
		        if (res == JOptionPane.YES_OPTION) {
		            Client.closeView("HOMEPAGE");
		            Client.openView("CREATE_ROOM_PASSWORD");
		        } else if (res == JOptionPane.NO_OPTION) {
		            try {
		                Client.threadClient.write("create-room,");
		                Client.closeView("HOMEPAGE");
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
		            }
		        }
			}
		});
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Tìm phòng");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Client.closeView("HOMEPAGE");
		            Client.openView("ROOM_LIST");
		            Client.threadClient.write("view-room-list,");
		        } catch (IOException ex) {
		            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
		        }
			}
		});
		
		JButton btnNewButton_5 = new JButton("Vào phòng");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client.openView("ROOM_NAME");
			}
		});
		panel_3.add(btnNewButton_5);
		panel_3.add(btnNewButton_3);
		
//		JButton btnNewButton_5 = new JButton("Bạn bè");
//		btnNewButton_5.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			
//			}
//		});
//		panel_3.add(btnNewButton_5);
		
//		JButton btnNewButton_8 = new JButton("Chơi v ới máy");
//		btnNewButton_8.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		panel_3.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Thoát");
		panel_3.add(btnNewButton_9);
		
		JLabel label = new JLabel("");
		panel_3.add(label);
		
		JLabel label_1 = new JLabel("");
		panel_3.add(label_1);
	}
	private void sendMessage(){
        try {
        	String temp="";
            if (textArea_1.getText().isEmpty()) {
                throw new Exception("Vui lòng nhập nội dung tin nhắn");
            }
            temp = "("+(new Date()).time()+")"+"Tôi: " + textArea_1.getText() + "\n";
            textArea.append(temp);
            Client.threadClient.write("chat-server," + textArea_1.getText());
            textArea_1.setText("");
           
            
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    public void addMessage(String message){
        String temp = textArea.getText();
        temp+=message+"\n";
        textArea.setText(temp);
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
