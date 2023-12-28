import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;



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
    
    
    public Client() {
    }

 
    public void initView(){
        
        loginFrm = new DangNhap();
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
                
                	
            }
        }
    }
    
    public static void openView(String viewName, User competitor, int room_ID, int isStart){
        if(viewName != null){
            switch(viewName){
                case "GAMECLIENT":
                    gameFrame = new GameFrame(competitor, room_ID, isStart);
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
    }
    
  
    public static void main(String[] args) {
        new Client().initView();
    }
}
