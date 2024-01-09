package Main;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

import Model.User;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GameFrame extends JFrame {
	private User competitor;
	private Timer timer;
    private Integer second, minute;
    
    private int numberOfMatch;
    
    
    private JButton preButton;
    private int userWin;
    private int competitorWin;

    private JLabel lblNewLabel_7;
    private JTextArea textArea_1,textArea;
    private boolean denluot;
    JLabel lblNewLabel_3_1;
    private JLabel lblNewLabel_4;
    JLabel lblNewLabel_2_1_1;
    JLabel lblNewLabel,lblNewLabel_2_1;
    JPanel panel_7_1;
    JLabel lblNewLabel_5,lblNewLabel_5_1;
    JLabel lblNewLabel_2_1_1_1;
    JLabel lblNewLabel_3_1_1;
    JLabel lblNewLabel_1;

    
    

	private JPanel contentPane;
	private Caro caro = caro = new Caro();

	public GameFrame(User competitor, int room_ID, int isStart) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(892,618);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setIconImage(new ImageIcon("src/images/unnamed.png").getImage());
		setTitle("Caro - Đang Trong Trận");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel);
		panel.add(caro);	
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.WEST);		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 284, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
		);
		
		lblNewLabel = new JLabel("{Ph\u00F2ng}");
		lblNewLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 3), "\u0110\u1ED1i th\u1EE7", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.CYAN);
		
		JPanel panel_7 = new JPanel();
//		panel_7.setBackground(Color.YELLOW);
		GroupLayout gl_panel_3_1 = new GroupLayout(panel_3_1);
		gl_panel_3_1.setHorizontalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_3_1.setVerticalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
				.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("src/images/"+competitor.getAvatar()+".jpg"));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		panel_5.setLayout(new GridLayout(4, 1, 0, 0));
		
		lblNewLabel_2_1 = new JLabel("T\u00EAn T\u00E0i Kho\u1EA3n");
		panel_5.add(lblNewLabel_2_1);
		
		lblNewLabel_3_1 = new JLabel("Tổng Số Trận");
		panel_5.add(lblNewLabel_3_1);
		
		lblNewLabel_2_1_1 = new JLabel("Số Trận Thắng");
		panel_5.add(lblNewLabel_2_1_1);
		panel_3_1.setLayout(gl_panel_3_1);
		
		JPanel panel_4 = new JPanel();
//		panel_4.setBackground(Color.WHITE);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(Color.WHITE);
		panel_3_1_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 3), " B\u1EA1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		
		panel_7_1 = new JPanel();
//		panel_7_1.setBackground(Color.YELLOW);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("src/images/"+Client.user.getAvatar()+".jpg"));
		GroupLayout gl_panel_7_1 = new GroupLayout(panel_7_1);
		gl_panel_7_1.setHorizontalGroup(
			gl_panel_7_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7_1.createSequentialGroup()
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel_7_1.setVerticalGroup(
			gl_panel_7_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
		);
		panel_7_1.setLayout(gl_panel_7_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(Color.CYAN);
		panel_5_1.setLayout(new GridLayout(4, 1, 0, 0));
		GroupLayout gl_panel_3_1_1 = new GroupLayout(panel_3_1_1);
		gl_panel_3_1_1.setHorizontalGroup(
			gl_panel_3_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_7_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(panel_5_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_3_1_1.setVerticalGroup(
			gl_panel_3_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3_1_1.createSequentialGroup()
					.addGroup(gl_panel_3_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_7_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Tên Tài Khoản: <dynamic>");
		panel_5_1.add(lblNewLabel_2_1_2);
		
		lblNewLabel_3_1_1 = new JLabel("Số ván: 0");
		panel_5_1.add(lblNewLabel_3_1_1);
		
		lblNewLabel_2_1_1_1 = new JLabel("Thắng: 0");
		panel_5_1.add(lblNewLabel_2_1_1_1);
		lblNewLabel_2_1_2.setText(""+Client.user.getNickname());	
		lblNewLabel_3_1_1.setText("Số ván: "+Client.user.getNumberOfGame());
		lblNewLabel_2_1_1_1.setText("Thắng: "+Client.user.getNumberOfwin());
		
		JButton btnNewButton_2_1 = new JButton("Xem thông Tin");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client.openView("INFOC", Client.user);
			}
		});
		panel_5_1.add(btnNewButton_2_1);
		panel_3_1_1.setLayout(gl_panel_3_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 264, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3_1, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3_1_1, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Gửi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		            try {
		                if (textArea.getText().isEmpty()) {
		                    return;
		                }
		                String temp = textArea_1.getText();
		                temp += "Tôi: " + textArea.getText() + "\n";
		                textArea_1.setText(temp);
		                Client.threadClient.write("chat," + textArea.getText());
		                textArea.setText("");
		                textArea_1.setCaretPosition(textArea_1.getDocument().getLength());
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
		            }
		        }
			
		});
		
		textArea = new JTextArea();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		
		textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		textArea_1.setDisabledTextColor(Color.BLACK);
		panel_3.setLayout(gl_panel_3);
		
		lblNewLabel_4 = new JLabel("T\u1EC9 s\u1ED1");
		
		lblNewLabel_7 = new JLabel("Th\u1EDDi gian");
		lblNewLabel_7.setFont(new Font("Segoe UI Variable", Font.BOLD | Font.ITALIC, 12));
		
		JButton btnNewButton_1 = new JButton(" hòa");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            int res = JOptionPane.showConfirmDialog(rootPane, "Bạn có thực sự muốn cầu hòa ván chơi này", "Yêu cầu cầu hòa", JOptionPane.YES_NO_OPTION);
		            if (res == JOptionPane.YES_OPTION) {
		                Client.threadClient.write("draw-request,");
		                timer.stop();		     
		                Client.openView("GAMENOTICE", "Yêu cầu hòa", "Đang chờ phản hồi từ đối thủ");
		            }
		        } catch (IOException ex) {
		            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
		        }
			}
		});
		btnNewButton_1.setBackground(Color.BLACK);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.YELLOW);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(22)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(24))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(27)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
							.addContainerGap())))
				.addComponent(panel_8, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_7)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		panel_8.setLayout(new GridLayout(0, 5, 0, 0));
		
		lblNewLabel_5_1 = new JLabel("");
		panel_8.add(lblNewLabel_5_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.YELLOW);
		panel_8.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.YELLOW);
		panel_8.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.YELLOW);
		panel_8.add(panel_11);
		
		lblNewLabel_5 = new JLabel("");
		panel_8.add(lblNewLabel_5);
		panel_4.setLayout(gl_panel_4);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
		
        lblNewLabel.setText("Phòng: " + room_ID);
        
        lblNewLabel_2_1.setText(""+competitor.getNickname());
        lblNewLabel_3_1.setText("Số ván: "+Integer.toString(competitor.getNumberOfGame()));
        lblNewLabel_2_1_1.setText("Thắng: "+ Integer.toString(competitor.getNumberOfwin()));
        
        JButton btnNewButton_2 = new JButton("Xem thông Tin");
        panel_5.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Client.openView("INFOC", competitor);
        		
        		
        	}
        });

	        numberOfMatch = isStart;
	        this.competitor = competitor;
	       
//	        isSending = false;
//	        isListening = false;	        	        
	        userWin = 0;
	        competitorWin = 0;    
	        setupButton();	
		timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = minute.toString();
                String temp1 = second.toString();
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                if (temp1.length() == 1) {
                    temp1 = "0" + temp1;
                }
                if (second == 0) {
                	lblNewLabel_7.setText("Thời Gian:" + temp + ":" + temp1);
//                    second = 15;
//                    minute = 0;
             
                    denluot=false;
                    stopTimer();
                    try {
						Client.threadClient.write("caroendtime,");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                  
                    displayCompetitorTurn();
                    JOptionPane.showMessageDialog(rootPane, "Bạn đã bị quá thời gian,đến lượt của đối thủ");     
                } else {
                	lblNewLabel_7.setText("Thời Gian:" + temp + ":" + temp1);
                    second--;
                }

            }

        });
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitGame();
            }
        });
		
	}
	 public void exitGame() {
	        try {
	            timer.stop();
	            Client.threadClient.write("left-room,");
	            Client.closeAllViews();
	            Client.openView("HOMEPAGE");
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
	        }
	        Client.closeAllViews();
	        Client.openView("HOMEPAGE");
	    }
	
public void newgame() {
	caro.reset();
	ImageIcon iconX = new ImageIcon("X caro.jpg");
	ImageIcon iconY = new ImageIcon("O caro.jpg");
	Image img = iconX.getImage();
    Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
    iconX = new ImageIcon(newimg);
    Image img2 = iconY.getImage();
    Image newimg2 = img2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
    iconY = new ImageIcon(newimg2);
    
        if (numberOfMatch % 2 == 0) {
            JOptionPane.showMessageDialog(rootPane, "Đến lượt bạn đi trước");
            
            startTimer();
            displayUserTurn();
            lblNewLabel_7.setVisible(true);
            denluot = true;
            lblNewLabel_5_1.setIcon(iconX);
            lblNewLabel_5.setIcon(iconY);
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Đối thủ đi trước");
            displayCompetitorTurn();
            denluot = false;
            lblNewLabel_5.setIcon(iconX);
            lblNewLabel_5_1.setIcon(iconY);
        }      
        numberOfMatch++;
    }
public void startTimer(){
	lblNewLabel_7.setVisible(true);
    second = 15;
    minute = 0;
    timer.start();
}
public void displayCompetitorTurn() {
	lblNewLabel_1.setText("Lượt của đối thủ");
	lblNewLabel_7.setVisible(false);
	lblNewLabel_5.setVisible(true);
	lblNewLabel_5_1.setVisible(false);
   
}
public void displayUserTurn(){
	lblNewLabel_1.setText("Lượt của bạn");
	lblNewLabel_7.setVisible(true);
	lblNewLabel_5.setVisible(false);
	lblNewLabel_5_1.setVisible(true);
   
}


void setupButton() {
    for (int i = 0; i < 18; i++) {
        for (int j = 0; j < 18; j++) {
            final int a = i, b = j;
            caro.buttons[a][b].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(denluot==true &&caro.tick[a][b]==false) {
                    	try {
                        	ImageIcon icon;
                        	if(numberOfMatch % 2 == 0) {
                        		icon = new ImageIcon("O caro.jpg");
                            } else {
                            	icon = new ImageIcon("X caro.jpg");
                            }
                        	 
                           Image img = icon.getImage();
                           Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
                           icon = new ImageIcon(newimg);
                           caro.buttons[a][b].setIcon(icon);
                           caro.buttons[a][b].setBackground(Color.WHITE);
                           caro.tick[a][b] = true;
                           Client.threadClient.write("caro," + a + "," + b);
                           if(numberOfMatch % 2 == 0) {
                        	   caro.buttons[a][b].setName("O");
                           } else {
                        	   caro.buttons[a][b].setName("X");
                           }                    
                            denluot=false;
                            try {
                                if (checkWin(a, b)) {
                                	timer.stop();
                       
                                    int outputwin = JOptionPane.showConfirmDialog(contentPane, 
                                            "Bạn đã thắng,Bạn có muốn chơi tiếp không", "Kết thúc ván đấu",
                                            JOptionPane.YES_NO_OPTION);
                                    if (outputwin == JOptionPane.YES_OPTION) {
                                    	Client.threadClient.write("win,"+a+","+b);
                                    	increaseWinMatchToUser();
                                    } else if (outputwin == JOptionPane.NO_OPTION) {
                                    	exitGame();
                                    	JOptionPane.showMessageDialog(contentPane, 
                                                "Thoát Phòng Thành Công!!!");                                  	
                                    }                                                                    
                                }
                                else{ 
                                    Client.threadClient.write("caro," + a + "," + b);
                                    displayCompetitorTurn();                                 
                                }
                                timer.stop();
                            } catch (Exception ie) {
                                ie.printStackTrace();
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                        }
                    }
                }
            });
           
            caro.buttons[a][b].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    if(denluot==true) {
                    	caro.buttons[a][b].setBackground(Color.YELLOW);
                    	
                    }
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    if(denluot==true){
                    	caro.buttons[a][b].setBackground(Color.WHITE);
                    	
                    }
                }
            });
           }
        }
    
}
public boolean checkWin(int i, int j) {
	System.out.println(i+","+j);
    int d = 0, k = i, h; 
 // cot
    while (k < 18 && (caro.buttons[k][j].getName() == caro.buttons[i][j].getName())) {
      d++;
      k++;
    }
    k = i - 1;
    while (k > 0 && caro.buttons[k][j].getName() == caro.buttons[i][j].getName()) {
      d++;
      k--;
    }
    if (d > 4) return true;
    d = 0;
    h = j;  
    //hang
    while (h < 18 && (caro.buttons[i][h].getName() == caro.buttons[i][j].getName())) {
      d++;
      h++;
    }
    h = j - 1;
    while (h > 0 && (caro.buttons[i][h].getName() == caro.buttons[i][j].getName())) {
      d++;
      h--;
    }
    if (d > 4) return true;
    //cheo
    h = i;
    k = j;
    d = 0;
    while (h < 18 && k < 18 && (caro.buttons[i][j].getName() == caro.buttons[h][k].getName())) {
      d++;
      h++;
      k++;
    }
    h = i - 1;
    k = j - 1;
    while (h > 0 && k > 0 && (caro.buttons[i][j].getName() == caro.buttons[h][k].getName())) {
      d++;
      h--;
      k--;
    }
    if (d > 4) return true;
    h = i;
    k = j;
    d = 0;
    //cheo
    while (h < 18 && k > 0 && (caro.buttons[i][j].getName() == caro.buttons[h][k].getName())) {
      d++;
      h++;
      k--;
    }
    h = i - 1;
    k = j + 1;
    while (h > 0 && k < 18 && (caro.buttons[i][j].getName() == caro.buttons[h][k].getName())) {
      d++;
      h--;
      k++;
    }
    if (d > 4) return true;
    
    return false;
  }
public void addCompetitorMove(String x, String y){
    caro(x, y);
    startTimer();
}
public void caro(String x, String y) {
    int xx, yy;
    xx = Integer.parseInt(x);
    yy = Integer.parseInt(y);
    ImageIcon icon;
	if(!(numberOfMatch % 2 == 0)) {
		icon = new ImageIcon("O caro.jpg");
    } else {
    	icon = new ImageIcon("X caro.jpg");
    }
	
    	Image img = icon.getImage();
    	   Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
    	   icon = new ImageIcon(newimg);
    	   caro.buttons[xx][yy].setIcon(icon);
    	   caro.tick[xx][yy] = true;
    	   
    	   if(!(numberOfMatch % 2 == 0)) {
    		   caro.buttons[xx][yy].setName("O");
    	   } else {
    		   caro.buttons[xx][yy].setName("X");
    	   }
    	   if (checkWin(xx, yy)) {
    		                      
    		   increaseWinMatchToCompetitor();
                           int output = JOptionPane.showConfirmDialog(this, 
                                   "Bạn đã thua,Bạn có muốn chơi tiếp không", "Kết thúc ván đấu",
                                   JOptionPane.YES_NO_OPTION);
                           if (output == JOptionPane.YES_OPTION) {
                               
                           } else if (output == JOptionPane.NO_OPTION) {
                        	   exitGame();
                           	JOptionPane.showMessageDialog(contentPane, "Thoát Phòng Thành Công!!!");  
                           }                                        
                  stopTimer(); 
           }
           else{ 
        	   displayUserTurn();
        	    denluot=true;              
           }
}

public void stopTimer(){
	lblNewLabel_7.setVisible(false);
    timer.stop();
}
public void updateNumberOfGame(){
    competitor.setNumberOfGame(competitor.getNumberOfGame() + 1);
    lblNewLabel_3_1.setText("Số ván: "+Integer.toString(competitor.getNumberOfGame()));
    Client.user.setNumberOfGame(Client.user.getNumberOfGame() + 1);
    lblNewLabel_3_1_1.setText("Số ván: "+Integer.toString(Client.user.getNumberOfGame()));
}
public void increaseWinMatchToUser(){
    Client.user.setNumberOfwin(Client.user.getNumberOfwin()+1);
    lblNewLabel_2_1_1_1.setText("Thắng: "+Client.user.getNumberOfwin());
    userWin++;
    lblNewLabel_4.setText("Tỉ số: "+userWin+"-"+competitorWin);
    textArea_1.append("YOU WIN-Tỉ Số: "+userWin+"-"+competitorWin+"--\n");
}
public void increaseWinMatchToCompetitor() {
    competitor.setNumberOfwin(competitor.getNumberOfwin()+1);
    lblNewLabel_2_1_1.setText("Thắng: "+competitor.getNumberOfwin());
    competitorWin++;
    lblNewLabel_4.setText("Tỉ số: "+userWin+"-"+competitorWin);
    textArea_1.append("YOU-LOSE-Tỉ Số: "+userWin+"-"+competitorWin+"--\n");
}
public void stopAllThread(){
    timer.stop();
}
public void displayDrawRefuse(){
    JOptionPane.showMessageDialog(rootPane, "Yêu cầu cầu hòa thất bại : (( ");
    timer.start();   
}
public void displayDrawGame(){
	int outputdraw = JOptionPane.showConfirmDialog(contentPane, 
            "Ván hòa,Bạn có muốn chơi tiếp không", "Kết thúc ván đấu",
            JOptionPane.YES_NO_OPTION);
    if (outputdraw == JOptionPane.YES_OPTION) {
    	
    } else if (outputdraw == JOptionPane.NO_OPTION) {
    	exitGame();
    	JOptionPane.showMessageDialog(contentPane, 
                "Thoát Phòng Thành Công!!!");                                  	
    }             
    String tmp = textArea_1.getText();
    tmp += "--Ván chơi hòa--\n";
    textArea_1.setText(tmp);
    textArea_1.setCaretPosition(textArea_1.getDocument().getLength());
    Client.user.setNumberOfDraw(Client.user.getNumberOfDraw()+1);
   
    
}
public void showDrawRequest() {
    int res = JOptionPane.showConfirmDialog(rootPane, "Yêu cầu hòa từ đối thủ", "Yêu cầu cầu hòa", JOptionPane.YES_NO_OPTION);
    if (res == JOptionPane.YES_OPTION) {
        try {
            timer.stop();
            
            Client.threadClient.write("draw-confirm,");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    else{
        try {
            Client.threadClient.write("draw-refuse,");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
}
public void addMessage(String message){
    String temp = textArea.getText();
    temp += competitor.getNickname() + ": " + message+"\n";
    textArea_1.setText(temp);
    textArea_1.setCaretPosition(textArea_1.getDocument().getLength());
}

public void userTurn() {
	JOptionPane.showMessageDialog(rootPane, "Đối thủ hết thời gian,Đến lượt bạn");
	startTimer();
	displayUserTurn();
	denluot=true;
}
}
