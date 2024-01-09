package Main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import Model.UserData;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Info extends JFrame {

	private JPanel contentPane;
	JComboBox<ImageIcon> avatarComboBox1;
	int Tong;
	int Thang,Hoa,Thua;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	public Info() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 464, 413);
		setTitle("Thông Tin Của Bạn");
		this.setIconImage(new ImageIcon("src/images/unnamed.png").getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		avatarComboBox1 = new JComboBox<ImageIcon>();
		avatarComboBox1.setForeground(Color.WHITE);
		avatarComboBox1.setBackground(Color.MAGENTA);
		avatarComboBox1.setMaximumRowCount(5);
		for (int i=1; i<=10; i++) {
            avatarComboBox1.addItem(new ImageIcon("src/images/"+i+".jpg"));
        }
		avatarComboBox1.setSelectedIndex(Integer.parseInt(Client.user.getAvatar())-1);
		
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.controlText);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(180, 180, 180), 1, true), "Th\u00F4ng Tin C\u00E1 Nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		
	
		
		JLabel SoVanDaChoi = new JLabel("T\u1ED5ng s\u1ED1 v\u00E1n: 0");
		SoVanDaChoi.setText("Số Trận: " + Client.user.getNumberOfGame());
		
		JLabel SoVanThang = new JLabel("Th\u1EAFng: 0");
		SoVanThang.setText("Thắng: " +Client.user.getNumberOfwin());
		
		JLabel SoVanHoa = new JLabel("H\u00F2a: 0");
		SoVanHoa.setText("Hòa: " +Client.user.getNumberOfDraw());
		
		JLabel SoVanThua = new JLabel("Thua: 0");
		SoVanThua.setText("Thua: " +Client.user.thua);
		
		JLabel NickName = new JLabel("T\u00EAn T\u00E0i Kho\u1EA3n");
		NickName.setHorizontalAlignment(SwingConstants.CENTER);
		NickName.setText(Client.user.getUsername());
		NickName.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		
		JLabel lblim = new JLabel("Điểm:");
		lblim.setText("Điểm: "+Client.user.getDiem());
		UserData us = new UserData();
		
		textField_2 = new JTextField();
		textField_2.setText(Client.user.getNickname());
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.setBackground(SystemColor.activeCaptionText);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				us.setAvatarByID(Client.user.getID(), avatarComboBox1.getSelectedIndex()+1);
				
				us.setNickNameByID(Client.user.getID(),textField_2.getText() );
				Client.user.setAvatar(""+(avatarComboBox1.getSelectedIndex()+1));
				Client.user.setNickname(textField_2.getText());
				(new Message()).EditName(Client.user.getID(),textField_2.getText());
				
				JOptionPane.showMessageDialog(Client.info, "Đã Thay Đổi Avatar và NickName thành công");
			}
		});
		
		JButton btnNewButton_1 = new JButton("Về trang chủ");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client.openView("HOMEPAGE");
		    	Client.closeView("INFOUSER");
				
			}
		});
		
		JLabel lblTLThng = new JLabel("Tỉ lệ thắng");
		lblTLThng.setText("Tỉ lệ thắng: "+Client.user.getTiLeThang()+"%");
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(NickName, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addComponent(avatarComboBox1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addGap(66))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(SoVanDaChoi, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SoVanThang, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(42, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(SoVanHoa, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTLThng, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblim, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(6))
						.addComponent(SoVanThua, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
					.addGap(23))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(49)
					.addComponent(btnNewButton_1)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(avatarComboBox1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(NickName)
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(52)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(SoVanDaChoi)
						.addComponent(SoVanThang))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(SoVanHoa)
						.addComponent(SoVanThua))
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTLThng)
						.addComponent(lblim))
					.addGap(40)
					.addComponent(btnNewButton_1)
					.addGap(32))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Rank", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_2);
		
		JLabel lblRank = new JLabel("Rank:"+Client.user.getRankChu());
		lblRank.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		
		JLabel imgrank = new JLabel("");
		
		ImageIcon rankimg = new ImageIcon("img/rank/"+Client.user.getRank()+".jpg");
		Image img = rankimg.getImage();
	    Image newimg = img.getScaledInstance(111, 111, java.awt.Image.SCALE_SMOOTH);
	    rankimg = new ImageIcon(newimg);
	    imgrank.setIcon(rankimg);
		
		JLabel lblNewLabel_2 = new JLabel("Kim Cương");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		JLabel lblNewLabel_2_1 = new JLabel("Bạch Kim");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Vàng");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Bạc");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Đồng");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Cao Thủ");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_3.setText("Top Server: "+ us.getRank(Client.user.getID()));
	   
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(imgrank, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(lblRank, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(92, Short.MAX_VALUE))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(lblRank)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel_2_1_1_1_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_2_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2_1_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2_1_1_1_1))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(imgrank, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addGap(4))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.text);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Thay \u0110\u1ED5i M\u1EADt Kh\u1EA9u", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mật Khẩu");
		
		JLabel lblNewLabel_1 = new JLabel("Nhập lại MK");
		
		JButton Lưu = new JButton("Lưu");
		Lưu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty() || textField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Trống thông tin");
				} else if(!textField.getText().equals(textField_1.getText())) {
					JOptionPane.showMessageDialog(rootPane, "Mật khẩu nhập lại chưa chính xác");
				} else {
					us.setPassWordByID(Client.user.getID(),textField.getText());
					JOptionPane.showMessageDialog(rootPane, "Thay đổi mật khẩu thành công");
				}
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(Lưu)
						.addComponent(textField_1)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
					.addGap(52))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(31)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(Lưu)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
	}
	
	
}
