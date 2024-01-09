package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Main.Date;
import Main.Message;
import Main.Room;
import Main.Server;

public class ThreadServer implements Runnable {
    
    private User user;
    private Socket socketOfServer;
    private int clientNumber;
    private BufferedReader is;
    private BufferedWriter os;
    private boolean isClosed;
    private Room room;
    private UserData userData;
    private String clientIP;
    
    public BufferedReader getIs() {
        return is;
    }
    
    public BufferedWriter getOs() {
        return os;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
    public int getClientNumber() {
        return clientNumber;
    }

    public User getUser() {
        return user;
    }


    public Room getRoom() {
        return room;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setUser(User userAM) {
        this.user = userAM;
    }
    
    public ThreadServer(Socket socketOfServer, int clientNumber) {
        this.socketOfServer = socketOfServer;
        this.clientNumber = clientNumber;
        userData = new UserData();
        isClosed = false;
        room = null;

        
    }
    public String getStringFromUser(User user1){
        return ""+user1.getID()+","+user1.getUsername()
                                +","+user1.getPassword()+","+user1.getNickname()+","+
                                user1.getAvatar()+","+user1.getNumberOfGame()+","+
                                user1.getNumberOfwin()+","+user1.getNumberOfDraw()+","+user1.getRank();
    }
    
    
    public void goToPartnerRoom() throws IOException{
        write("go-to-room," + room.getID()+","+room.getCompetitor(this.getClientNumber())+",0,"+getStringFromUser(room.getCompetitor(this.getClientNumber()).getUser()));
         room.getCompetitor(this.clientNumber).write("go-to-room,"+ room.getID()+","+this.clientIP+",1,"+getStringFromUser(user));
    }
    
    @Override
    public void run() {
        try {
       
            is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
            System.out.println("Khời động luông mới thành công, ID là: " + clientNumber);
            write("server-send-id" + "," + this.clientNumber);
            String message;
            while (!isClosed) {
                message = is.readLine();
                if (message == null) {
                    break;
                }
                String[] messageSplit = message.split(",");
                
                if(messageSplit[0].equals("client-verify")){
                	User dnUser = new User(messageSplit[1], messageSplit[2]); 
                	User user1 = userData.verifyUser(dnUser);
                    
                    if(user1==null)
                        write("wrong-user,"+messageSplit[1]+","+messageSplit[2]);
                    else if(userData.checkOnline(messageSplit[1])) {
                    	write("dupplicate-login,"+messageSplit[1]+","+messageSplit[2]);
                    } else 
                    	{
                    	System.out.println("login-success,"+getStringFromUser(user1));
                        write("login-success,"+getStringFromUser(user1));
                        this.user = user1;
                        userData.updateToOnline(this.user.getID());
                        Server.threadServers.boardCast(clientNumber, "chat-server,"+user1.getNickname()+" đang online");
                        Server.admin.addMessage("["+user1.getID()+"] "+user1.getNickname()+ " đang online");
                    }
                    
                }
                
             
                if(messageSplit[0].equals("register")){
                   boolean checkdup = userData.checkDuplicated(messageSplit[1]);
                   if(checkdup) write("duplicate-username,");
                   else{
                       User userRegister = new User(messageSplit[1], messageSplit[2], messageSplit[3], messageSplit[4]);
                       userData.addUser(userRegister);
                       User userRegistered = userData.verifyUser(userRegister);
                       this.user = userRegistered;
                       userData.updateToOnline(this.user.getID());
                       Server.threadServers.boardCast(clientNumber, "chat-server,"+this.user.getNickname()+" đang online");
                       write("login-success,"+getStringFromUser(this.user));
                   }
                }
                
                if(messageSplit[0].equals("offline")){
                    userData.updateToOffline(this.user.getID());
                    Server.admin.addMessage("["+user.getID()+"] "+user.getNickname()+" đã offline");
                    Server.threadServers.boardCast(clientNumber, "chat-server,"+this.user.getNickname()+" đã offline");
                    this.user=null;
                }
                
                if(messageSplit[0].equals("chat-server")){
                    Server.threadServers.boardCast(clientNumber,messageSplit[0]+","+ "("+(new Date()).time()+")"+user.getNickname()+" : "+ messageSplit[1]);
                    
                   Server.admin.addMessage("["+user.getID()+"] "+user.getNickname()+" : "+ messageSplit[1]);
                    

                   Message messagee = new Message(user.getID(), user.getNickname(), messageSplit[1]);
                   
                    
                   
                    
                }
                
                if(messageSplit[0].equals("go-to-room")){
                    int roomName = Integer.parseInt(messageSplit[1]);
                    boolean isFinded = false;
                    for (ThreadServer serverThread : Server.threadServers.getListServerThreads()) {
                        if(serverThread.getRoom()!=null&&serverThread.getRoom().getID()==roomName){
                            isFinded = true;
                            break;
                        }
                    }
                    if(!isFinded){
                        write("room-not-found,");
                    }
                }
                
                if (messageSplit[0].equals("quick-room")) {
                    boolean isFinded = false;
                    for (ThreadServer serverThread : Server.threadServers.getListServerThreads()) {
                        if (serverThread.room != null && serverThread.room.getNumberOfUser() == 1) {
                            serverThread.room.setUser2(this);
                            this.room = serverThread.room;
                            room.increaseNumberOfGame();                      
                            System.out.println("Đã vào phòng " + room.getID());
                            goToPartnerRoom();
                            userData.updateToPlaying(this.user.getID());
                            isFinded = true;                         
                            break;
                        }
                    }
                    
                    if (!isFinded) {
                        this.room = new Room(this);
                        userData.updateToPlaying(this.user.getID());
                    }
                }
                
                
                if(messageSplit[0].equals("caro")){
                    room.getCompetitor(clientNumber).write(message);
                }
                if(messageSplit[0].equals("caroendtime")){
                    room.getCompetitor(clientNumber).write(message);
                }
                
                if(messageSplit[0].equals("chat")){
                    room.getCompetitor(clientNumber).write(message);
                }
                if(messageSplit[0].equals("win")){
                    userData.addWinGame(this.user.getID());
                    room.increaseNumberOfGame();
                    room.boardCast("new-game,");
                }
                if(messageSplit[0].equals("lose")){
                    userData.addWinGame(room.getCompetitor(clientNumber).user.getID());
                    room.increaseNumberOfGame();
                    room.getCompetitor(clientNumber).write("competitor-time-out");
                    write("new-game,");
                }
                if(messageSplit[0].equals("draw-request")){
                    room.getCompetitor(clientNumber).write(message);
                }
                if(messageSplit[0].equals("draw-confirm")){
                    room.increaseNumberOfDraw();
                    room.increaseNumberOfGame();
                    room.boardCast("draw-game,");
                }
                if(messageSplit[0].equals("draw-refuse")){
                    room.getCompetitor(clientNumber).write("draw-refuse,");
                }
                if(messageSplit[0].equals("voice-message")){
                    room.getCompetitor(clientNumber).write(message);
                }
                if(messageSplit[0].equals("left-room")){
                    if (room != null) {
                        room.setUsersToNotPlaying();
                        room.decreaseNumberOfGame();
                        room.getCompetitor(clientNumber).write("left-room,");
                        room.getCompetitor(clientNumber).room = null;
                        this.room = null;
                    }
                }
            }
        } catch (IOException e) {
           
            isClosed = true;
            
            if(this.user!=null){
                userData.updateToOffline(this.user.getID());
                userData.updateToNotPlaying(this.user.getID());
                Server.threadServers.boardCast(clientNumber, "chat-server,"+this.user.getNickname()+" đã offline");
                Server.admin.addMessage("["+user.getID()+"] "+user.getNickname()+" đã offline");
            }
           
            Server.threadServers.remove(clientNumber);
            System.out.println(this.clientNumber + " đã thoát");
            if (room != null) {
                try {
                    if (room.getCompetitor(clientNumber) != null) {
                        room.decreaseNumberOfGame();
                        room.getCompetitor(clientNumber).write("left-room,");
                        room.getCompetitor(clientNumber).room = null;
                    }
                    this.room = null;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    public void write(String message) throws IOException {
        os.write(message);
        os.newLine();
        os.flush();
    }
}