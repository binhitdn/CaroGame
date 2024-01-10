package Main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import Model.ThreadClient;
import Model.User;



public class Client {
    public static User user;
    public static DangNhap loginFrm;
    public static DangKi registerFrm;
    public static Home homePageFrm;
    public static FindCompetitor findRoomFrm;
    public static GameFrame gameFrame;
    
    public static InfoCompetitor competitorInfoFrm;
    public static Notice notice;
   
    public static ThreadClient threadClient;
    public static Info info;
    public static InfoCompetitor infoc;
    public static BangXepHang bxh;
    public static CreateRoomPassword createRoomPassword;
    public static WaitingRoom waitingRoom;
    public static RoomList roomList;
    public static RoomName roomName;
    public static JoinRoomPassword joinRoomPassword;
    public static FindRoom findRoom;
    
    
    
    
    
    public Client() {
    }
    public static JFrame getVisibleJFrame() {
        if (roomList != null && roomList.isVisible())
            return roomList;
        
        if (createRoomPassword != null && createRoomPassword.isVisible()) {
            return createRoomPassword;
        }
        if (joinRoomPassword != null && joinRoomPassword.isVisible()) {
            return joinRoomPassword;
        }
//        if (rankFrm != null && rank.isVisible()) {
//            return rank;
//        }
        return homePageFrm;
    }

 
    public void initView(){
        
        loginFrm = new DangNhap();
        loginFrm.setTitle("Cờ Caro");
        loginFrm.setVisible(true);
        threadClient = new ThreadClient();
        threadClient.run();
    }
    
    public static void openView(String viewName){
        if(viewName != null){
            switch(viewName){
                case "LOGIN":
                    loginFrm = new DangNhap();
                    loginFrm.setVisible(true);
                    break;
                case "REGISTER":
                    registerFrm = new DangKi();
                    registerFrm.setVisible(true);
                    break;
                case "HOMEPAGE":
                    homePageFrm = new Home();
                    homePageFrm.setVisible(true);
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
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    Message m = new Message();
                    Client.homePageFrm.textArea.append(m.ReadMessage(user));
                    break;
                
                
                case "FINDROOM":
                    findRoomFrm = new FindCompetitor();
                    findRoomFrm.setVisible(true);
                    break;
                
                
                
                case "INFOUSER":
                	info = new Info();
                	info.setVisible(true);
                
                	break;
                case "BXH":
                	bxh = new BangXepHang();
                	bxh.setVisible(true);
                	break;
                case "CREATE_ROOM_PASSWORD":
                	createRoomPassword = new CreateRoomPassword();
                    createRoomPassword.setVisible(true);
                    break;
                case "WAITING_ROOM":
                    waitingRoom = new WaitingRoom();
                    waitingRoom.setVisible(true);
                    break;
                case "ROOM_LIST":
                    roomList = new RoomList();
                    roomList.setVisible(true);
                    break;
                case "ROOM_NAME":
                	roomName = new RoomName();
                	roomName.setVisible(true);
                	break;
                
               
                      
                	
            }
        }
    }
    
    public static void openView(String viewName, User competitor, int room_ID, int isStart,String competitorIP) {
        if(viewName != null){
            switch(viewName){
                case "GAMECLIENT":
                    gameFrame = new GameFrame(competitor, room_ID, isStart, competitorIP);
                    gameFrame.setVisible(true);
                    break;
            }
        }
    }

    public static void openView(String viewName, User User){
        if(viewName != null){
            switch(viewName){
                case "INFOC":
                	infoc = new InfoCompetitor(User);
                	infoc.setVisible(true);
                    break;
            }
        }
    }
    public static void openView(String viewName, String arg1, String arg2){
        if(viewName != null){
            switch(viewName){
                case "GAMENOTICE":
                    notice = new Notice(arg1, arg2);
                    notice.setVisible(true);
                    break;
                case "LOGIN":
                    loginFrm = new DangNhap(arg1, arg2);
                    loginFrm.setVisible(true);
            }
            
        }
    }
    public static void openView(String viewName, int arg1, String arg2) {
        if (viewName != null) {
            switch (viewName) {
                case "JOIN_ROOM_PASSWORD":
                    joinRoomPassword = new JoinRoomPassword(arg1, arg2);
                    joinRoomPassword.setVisible(true);
                    break;
            
            }
        }
    }
    public static void closeView(String viewName){
        if(viewName != null){
            switch(viewName){
                case "LOGIN":
                    loginFrm.dispose();
                    break;
                case "REGISTER":
                    registerFrm.dispose();
                    break;
                case "HOMEPAGE":
                    homePageFrm.dispose();
                    break;
               
                
                    
                case "FINDROOM":
                    findRoomFrm.stopAllThread();
                    findRoomFrm.dispose();
                    break;
                
                case "GAMECLIENT":
                    gameFrame.stopAllThread();
                    gameFrame.dispose();
                    break;
                
                case "COMPETITORINFO":
                    competitorInfoFrm.dispose();
                    break;
                
                case "GAMENOTICE":
                    notice.dispose();
                    break;
               
               
                
                case "INFOUSER":
                	info.dispose();
                	break;
                case "BXH":
                	bxh.dispose();
                	break;
                case "INFOC":
                	infoc.dispose();
                	break;
                case "CREATE_ROOM_PASSWORD":
                    createRoomPassword.dispose();
                    break;
                case "WAITING_ROOM":
                    waitingRoom.dispose();
                    break;
                case "ROOM_LIST":
                    roomList.dispose();
                    break;
                case "ROOM_NAME":
                    roomName.dispose();
                	break;                
                    
                    

            }
            
        }
    }
    
    public static void closeAllViews(){
        if(loginFrm!=null) loginFrm.dispose();
        if(registerFrm!=null) registerFrm.dispose();
        if(homePageFrm!=null) homePageFrm.dispose();
        
       
        if(findRoomFrm!=null){
            findRoomFrm.stopAllThread();
            findRoomFrm.dispose();
        } 
      
        if(gameFrame!=null){
            gameFrame.stopAllThread();
            gameFrame.dispose();
        } 
       
        if(competitorInfoFrm!=null) competitorInfoFrm.dispose();

        if(notice!=null) notice.dispose();
       
    
        if(info!=null) info.dispose();
        if(infoc!=null) infoc.dispose();
        if(bxh!=null) bxh.dispose();
        if(createRoomPassword!=null) createRoomPassword.dispose();
        if(waitingRoom!=null) waitingRoom.dispose();
        if(roomList!=null) roomList.dispose();
        if(roomName!=null) roomName.dispose();
        if(joinRoomPassword!=null) joinRoomPassword.dispose();
        if(findRoom!=null) findRoom.dispose();
        
        
    }
    
  
    public static void main(String[] args) {
        new Client().initView();
    }
}
