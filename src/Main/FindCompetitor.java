package Main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;

public class FindCompetitor extends JFrame {

	private JPanel contentPane;
	private Timer timer;
    private boolean isFinded;
    JLabel lblNewLabel_2;
    JLabel lblNewLabel;
    JButton btnNewButton;
	
	public FindCompetitor() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 234);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setIconImage(new ImageIcon("src/images/unnamed.png").getImage());
		
		lblNewLabel = new JLabel(" ...");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 19));

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnNewButton = new JButton("Tho\u00E1t");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isFinded)
		            return;
		        try {
		            Client.threadClient.write("cancel-room,");
		        } catch (IOException ex) {
		            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
		        }
		        timer.stop();
		        Client.closeView("FINDROOM");
		        Client.openView("HOMEPAGE");
			}
		});
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.MAGENTA);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		 ImageIcon loading = new ImageIcon();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(286, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(117)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(160, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addGap(21)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		isFinded = false;
        startFind();
        sendFindRequest();
	}
	
	
	public void stopAllThread(){
        timer.stop();
    }
    public void startFind(){
    	lblNewLabel.setText("Đang tìm đối thủ...");
        timer = new Timer(1000, new ActionListener() {
            int count = 50;

            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                if (count >= 0) {
                    if(count>=10)
                    	lblNewLabel_2.setText("00:" + count);
                    else
                    	lblNewLabel_2.setText("00:0" + count);
                } else {
                    ((Timer) (e.getSource())).stop();
//                    try {
//                        Client.threadClient.write("cancel-room,");
//                    } catch (IOException ex) {
//                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
//                    }
                    int res = JOptionPane.showConfirmDialog(rootPane, "Tìm kiếm thất bại, bạn muốn thử lại lần nữa chứ?");
                    if (res==JOptionPane.YES_OPTION){
                        startFind();
                        sendFindRequest();
                    }
                                    }
            }
        });
       
        timer.setInitialDelay(0);
        timer.start();
    }
    
    public void sendFindRequest(){
        try {
            Client.threadClient.write("quick-room,");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    public void showFindedRoom(){
    	lblNewLabel.setText("Đã Tìm kiếm Xong");
        isFinded = true;
        timer.stop();
        btnNewButton.setVisible(false);
       
        
    }
    
}
