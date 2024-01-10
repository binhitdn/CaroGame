/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Client;

import java.io.IOException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class RoomList extends javax.swing.JFrame {
    private Vector<String> listRoom;
    private Vector<String> listPassword;
    private boolean isPlayThread;
    private final boolean isFiltered;
    DefaultTableModel defaultTableModel;
    
    private javax.swing.JLabel frameLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable roomTextArea;

    /**
     * Creates new form RoomListFrm
     */
    public RoomList() {
        initComponents();
        this.setTitle("Caro Game");
        this.setIconImage(new ImageIcon("assets/image/caroicon.png").getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        defaultTableModel = (DefaultTableModel) roomTextArea.getModel();
        isPlayThread = true;
        isFiltered = false;
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (Client.roomList.isDisplayable() && isPlayThread && !isFiltered) {
                    try {
                        Client.threadClient.write("view-room-list,");
                        Thread.sleep(500);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }
                }
            }
        };
        thread.start();
    }

    public void updateRoomList(Vector<String> listData, Vector<String> listPassword) {
        this.listRoom = listData;
        this.listPassword = listPassword;
        defaultTableModel.setRowCount(0);
        ImageIcon imageIcon;
        for (int i = 0; i < listRoom.size(); i++) {
            if (listPassword.get(i).equals(" "))
                imageIcon = new ImageIcon("assets/icon/swords-1-mini.png");
            else
                imageIcon = new ImageIcon("assets/icon/swords-1-lock-mini.png");
            defaultTableModel.addRow(new Object[]{
                    listRoom.get(i),
                    imageIcon
            });
        }
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        frameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Object[][] rows = {
        };
        String[] columns = {"Tên phòng",""};
        DefaultTableModel model = new DefaultTableModel(rows, columns){
            @Override
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0: return String.class;
                    case 1: return ImageIcon.class;
                    default: return Object.class;
                }
            }
        };
        roomTextArea = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        frameLabel.setBackground(new java.awt.Color(255, 255, 255));
        frameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        frameLabel.setForeground(new java.awt.Color(255, 255, 255));
        frameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frameLabel.setText("Danh sách phòng trống");

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        roomTextArea.setFont(new java.awt.Font("Tekton Pro", 1, 36)); // NOI18N
        roomTextArea.setModel(model);
        roomTextArea.setFillsViewportHeight(true);
        roomTextArea.setRowHeight(60);
        roomTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomTextAreaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(roomTextArea);
        if (roomTextArea.getColumnModel().getColumnCount() > 0) {
            roomTextArea.getColumnModel().getColumn(0).setMinWidth(240);
            roomTextArea.getColumnModel().getColumn(0).setPreferredWidth(240);
            roomTextArea.getColumnModel().getColumn(0).setMaxWidth(240);
            roomTextArea.getColumnModel().getColumn(1).setMinWidth(120);
            roomTextArea.getColumnModel().getColumn(1).setPreferredWidth(120);
            roomTextArea.getColumnModel().getColumn(1).setMaxWidth(120);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(frameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(frameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Client.closeView("ROOM_LIST");
        Client.openView("HOMEPAGE");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void roomTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomTextAreaMouseClicked
        if (roomTextArea.getSelectedRow() == -1) {
        } else {
            try {
                isPlayThread = false;
                int index = roomTextArea.getSelectedRow();
                int room = Integer.parseInt(listRoom.get(index).split(" ")[1]);
                String password = listPassword.get(index);
                if (password.equals(" ")) {
                    Client.threadClient.write("join-room," + room);
                    Client.closeView("ROOM_LIST");
                } else {
                    Client.closeView("ROOM_LIST");
                    Client.openView("JOIN_ROOM_PASSWORD", room, password);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
    }
}