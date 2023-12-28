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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class InfoCompetitor extends JFrame {

	private JPanel contentPane;
	int Tong;
	int Thang,Hoa,Thua;
	User competitor;

	
	public InfoCompetitor(User competitor) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 464, 413);
		setTitle("Thông Tin Đối Thủ");
		this.setIconImage(new ImageIcon("src/unnamed.png").getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		this.competitor = competitor;
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255), 6, true), "Th\u00F4ng Tin \u0110\u1ED1i Th\u1EE7", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		
		JLabel NickName = new JLabel("T\u00EAn T\u00E0i Kho\u1EA3n");
		NickName.setHorizontalAlignment(SwingConstants.CENTER);
		NickName.setText(competitor.getNickname());
		NickName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		UserData us = new UserData();
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.setBackground(Color.MAGENTA);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("");
		
		lblNewLabel_4.setIcon(new ImageIcon("src/"+competitor.getAvatar()+".jpg"));
		
		JLabel NickName_1 = new JLabel((String) null);
		NickName_1.setText("Tên tài khỏan: "+competitor.getUsername());
		NickName_1.setHorizontalAlignment(SwingConstants.CENTER);
		NickName_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(66)
							.addComponent(btnNewButton_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(NickName, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(NickName_1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(NickName)
					.addGap(18)
					.addComponent(NickName_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(32))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255), 5), "Rank", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_2);
		
		JLabel lblRank = new JLabel("Rank:"+competitor.getRankChu());
		lblRank.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		
		JLabel imgrank = new JLabel("");
		
		ImageIcon rankimg = new ImageIcon("img/rank/"+competitor.getRank()+".jpg");
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
		lblNewLabel_3.setText("Top Server: "+ us.getRank(competitor.getID()));
	   
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
		panel_3.setBackground(Color.CYAN);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255), 5, true), "Th\u00E0nh T\u00EDch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_3);
		
		JLabel lblTLThng = new JLabel("Tỉ lệ thắng");
		lblTLThng.setText("Tỉ lệ thắng: "+competitor.getTiLeThang()+"%");
		
		JLabel SoVanThang = new JLabel("Th\u1EAFng: 0");
		SoVanThang.setText("Thắng: " +competitor.getNumberOfwin());
		
	
		
		JLabel SoVanDaChoi = new JLabel("T\u1ED5ng s\u1ED1 v\u00E1n: 0");
		SoVanDaChoi.setText("Số Trận: " + competitor.getNumberOfGame());
		
		JLabel SoVanHoa = new JLabel("H\u00F2a: 0");
		SoVanHoa.setText("Hòa: " +competitor.getNumberOfDraw());
		
		JLabel SoVanThua = new JLabel("Thua: 0");
		SoVanThua.setText("Thua: " +competitor.thua);
		
		JLabel lblim = new JLabel("Điểm:");
		lblim.setText("Điểm: "+competitor.getDiem());
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblim, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(SoVanThua, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
							.addComponent(SoVanHoa, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addComponent(SoVanDaChoi, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addComponent(SoVanThang, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTLThng, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(18)
					.addComponent(lblTLThng)
					.addGap(9)
					.addComponent(SoVanDaChoi)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(SoVanThang)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SoVanHoa)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SoVanThua)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblim)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
	}
	
	
}
