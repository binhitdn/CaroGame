package Main;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Model.UserData;
public class BangXepHang extends JFrame {

	private JPanel contentPane;

	
	public BangXepHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		DefaultTableModel dModel = new DefaultTableModel();
		dModel.addColumn("Top Server");	
		dModel.addColumn("Ten Tai Khoan");	
		dModel.addColumn("NickName");
		dModel.addColumn("Tỉ lệ thắng");
		dModel.addColumn("Điểm");
		
		
		JTable table = new JTable(dModel);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.MAGENTA);
		table.setEnabled(false);
		table.setFont(new Font("Arial", Font.BOLD, 20));
		table.setRowHeight(50);
		table.setGridColor(Color.BLACK);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JScrollPane sccn =new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(sccn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.CYAN);
		panel_1.setBackground(Color.GRAY);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client.closeView("BXH");
	            Client.openView("HOMEPAGE");
			}
		});
		panel_1.add(btnNewButton);
		
		UserData us = new UserData();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = us.con.prepareStatement("SELECT username,nickname,(NumberOfWin/NumberOfGame)*100,(user.NumberOfGame*3+user.numberOfDraw*1+user.NumberOfWin*10 -(user.NumberOfGame-user.numberOfDraw-user.NumberOfWin)*9) AS `diem` FROM `user` ORDER BY diem DESC;");
		        ResultSet rs = preparedStatement.executeQuery();
		        int top = 0;
		        while (rs.next()) {
		        	top++;
		        	int Diem ;
		        	if(rs.getInt(4) > 0) {
		        		Diem = rs.getInt(4);
		        	} else Diem = 0;
		        	dModel.addRow(new String[] {top+"",rs.getString(1),rs.getString(2),rs.getInt(3)+"",Diem+""
		    		});
		        	
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
