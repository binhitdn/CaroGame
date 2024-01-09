package Model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

import Main.Client;
import Main.Message;


public class ThreadClient implements Runnable {
    private BufferedWriter os;
    private BufferedReader is;
    private Socket socketOfClient;
    private int ID_Server;

    
    @Override
    public void run() {
     try {
        
            socketOfClient = new Socket("localhost", 12340);
            System.out.println("Kết nối thành công!");
            
            os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
            String message;
            while (true) {
                message = is.readLine();
                if (message == null) {
                    break;
                }
                String[] messageSplit = message.split(",");

                
                if(messageSplit[0].equals("login-success")){
                    System.out.println("Đăng nhập thành công");
                    Client.closeAllViews();
                    User user= getUserFromString(1,messageSplit);
                    Client.user = user;
                    Client.openView("HOMEPAGE");
                    Message m = new Message();
                    FileReader fr;
    				try {
    					fr = new FileReader("file/noiquy.txt");
    					BufferedReader br = new BufferedReader(fr);
    		             
                        int i;
                        String j = "Server: ";
                        while ((i = br.read()) != -1) {
                            j+=(char) i;
                        }
                        j+="\n";
                        
                        br.close();
                        fr.close();
                        Client.homePageFrm.textArea.append(j);
    				}catch (Exception e) {
						e.printStackTrace();
					}
                    Client.homePageFrm.textArea.append(m.ReadMessage(user));
                }
                
                if(messageSplit[0].equals("wrong-user")){
                    System.out.println("Thông tin sai");
                    Client.closeView("GAMENOTICE");
                    Client.openView("LOGIN",messageSplit[1],messageSplit[2]);
                    Client.loginFrm.showError("Tài khoản hoặc mật khẩu không chính xác");
                }
                
                if(messageSplit[0].equals("dupplicate-login")){
                    System.out.println("Đã đăng nhập");
                    Client.closeView("GAMENOTICE");
                    Client.openView("LOGIN",messageSplit[1],messageSplit[2]);
                    Client.loginFrm.showError("Tài khoản đã đăng nhập ở nơi khác");
                }
               
               
                if(messageSplit[0].equals("duplicate-username")){
                	Client.closeAllViews();
                	Client.openView("REGISTER");
                    JOptionPane.showMessageDialog(Client.registerFrm, "Tên tài khoản đã được người khác sử dụng");
                }
               
                if(messageSplit[0].equals("chat-server")){
                    if(Client.homePageFrm!=null){
                    	Client.homePageFrm.addMessage(messageSplit[1]);
                    }
                }
               
                

                
               
                
                if(messageSplit[0].equals("go-to-room")){
           
                    int roomID = Integer.parseInt(messageSplit[1]);
                    String competitorIP = messageSplit[2];
                    int isStart = Integer.parseInt(messageSplit[3]);
                    
                    User competitor = getUserFromString(4, messageSplit);
                    if(Client.findRoomFrm!=null){
                    	Client.findRoomFrm.showFindedRoom();
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            JOptionPane.showMessageDialog(Client.findRoomFrm, "Lỗi khi sleep thread");
                        }
                    }
                    Client.closeAllViews();
                    Client.openView("GAMECLIENT"
                            , competitor
                            , roomID
                            ,isStart
                         );
                    Client.gameFrame.newgame();
                }
                if(messageSplit[0].equals("caro")){
                	Client.gameFrame.addCompetitorMove(messageSplit[1], messageSplit[2]);
                }
                
                if(messageSplit[0].equals("caroendtime")){
                	Client.gameFrame.userTurn();
                }
                if(messageSplit[0].equals("chat")){
                	Client.gameFrame.addMessage(messageSplit[1]);
                }
                if(messageSplit[0].equals("draw-request")){
                	Client.gameFrame.showDrawRequest();
                }
                
                if(messageSplit[0].equals("draw-refuse")){
                    if(Client.notice!=null) Client.closeView("GAMENOTICE");
                    Client.gameFrame.displayDrawRefuse();
                }
                
                if(messageSplit[0].equals("new-game")){
                    System.out.println("New game");
                    Thread.sleep(4000);
                    Client.gameFrame.updateNumberOfGame();
                    Client.closeView("GAMENOTICE");
                    Client.gameFrame.newgame();
                }
                if(messageSplit[0].equals("draw-game")){
                    System.out.println("Draw game");
                    Client.closeView("GAMENOTICE");

                    
                    Client.gameFrame.displayDrawGame();
                    Thread.sleep(4000);
                    Client.gameFrame.updateNumberOfGame();
                    Client.closeView("GAMENOTICE");
                }
                
                if(messageSplit[0].equals("left-room")){
                    Client.gameFrame.stopTimer();
                    Client.closeAllViews();
                    Client.openView("GAMENOTICE","Đối thủ đã thoát khỏi phòng","Đang trở về trang chủ");
                    Thread.sleep(3000);       
                    Client.closeAllViews();
                    Client.openView("HOMEPAGE");
                }             
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void write(String message) throws IOException{
        os.write(message);
        os.newLine();
        os.flush();
    }

    public Socket getSocketOfClient() {
        return socketOfClient;
    }
    public User getUserFromString(int start, String[] message){
        return new User(Integer.parseInt(message[start]),
                message[start+1],
                message[start+2],
                message[start+3],
                message[start+4],
                Integer.parseInt(message[start+5]),
                Integer.parseInt(message[start+6]),
                Integer.parseInt(message[start+7]),
                Integer.parseInt(message[start+8]));
    }

}