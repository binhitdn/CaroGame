public class User {
    private int ID;
    private String username;
    private String password;
    private String nickname;
    private String avatar;
    private int numberOfGame;
    private int numberOfwin;
    private int numberOfDraw;
    private boolean isOnline;
    private boolean isPlaying;
    private int rank;
    private int rankn;
    private int diem;
    int thua;
    int MaxDiem;

    public User(int ID, String username, String password, String nickname, String avatar, int numberOfGame, int numberOfwin, int numberOfDraw, int rank) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.avatar = avatar;
        this.numberOfGame = numberOfGame;
        this.numberOfwin = numberOfwin;
        this.numberOfDraw = numberOfDraw;
        this.rank = rank;
        thua = numberOfGame-numberOfDraw-numberOfwin ;
    }

    

    public void setRank(int rank) {
        this.rank = rank;
    }

    
    
    public User(int ID, String username, String password, String nickname, String avatar, int numberOfGame, int numberOfwin, int numberOfDraw, boolean isOnline, boolean isPlaying) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.avatar = avatar;
        this.numberOfGame = numberOfGame;
        this.numberOfwin = numberOfwin;
        this.numberOfDraw = numberOfDraw;
        this.isOnline = isOnline;
        this.isPlaying = isPlaying;
    }

    public User(int ID, String username, String password, String nickname, String avatar, int numberOfGame, int numberOfwin, int numberOfDraw) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.avatar = avatar;
        this.numberOfGame = numberOfGame;
        this.numberOfwin = numberOfwin;
        this.numberOfDraw = numberOfDraw;
    }
    public User(int ID, String username, String password, String nickname, String avatar, int numberOfGame, int numberOfwin, int numberOfDraw, boolean isOnline, boolean isPlaying, int rank) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.avatar = avatar;
        this.numberOfGame = numberOfGame;
        this.numberOfwin = numberOfwin;
        this.numberOfDraw = numberOfDraw;
        this.isOnline = isOnline;
        this.isPlaying = isPlaying;
        this.rank = rank;
    }

    public User(int ID, String nickname) {
        this.ID = ID;
        this.nickname = nickname;
    }

    

    public User(int ID, String nickname, boolean isOnline, boolean isPlaying) {
        this.ID = ID;
        this.nickname = nickname;
        this.isOnline = isOnline;
        this.isPlaying = isPlaying;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String nickname, String avatar) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.avatar = avatar;
    }
   

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getNumberOfGame() {
        return numberOfGame;
    }

    public int getNumberOfwin() {
        return numberOfwin;
    }

    public boolean isIsOnline() {
        return isOnline;
    }

    public boolean isIsPlaying() {
        return isPlaying;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setNumberOfGame(int numberOfGame) {
        this.numberOfGame = numberOfGame;
    }

    public void setNumberOfwin(int numberOfwin) {
        this.numberOfwin = numberOfwin;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public User(int ID, String nickname, int numberOfGame, int numberOfDraw) {
        this.ID = ID;
        this.nickname = nickname;
        this.numberOfGame = numberOfGame;
        this.numberOfDraw = numberOfDraw;
    }

    public int getNumberOfDraw() {
        return numberOfDraw;
    }

    public void setNumberOfDraw(int numberOfDraw) {
        this.numberOfDraw = numberOfDraw;
    }
    public int getTiLeThang() {
    	float x = (float)getNumberOfGame();
    	float y = (float)getNumberOfwin();
    	return (int)((y/x)*100);
    }
    public int getDiem() {
    	
    	diem = numberOfGame*3+numberOfwin * 10+numberOfDraw *1 -(thua*9);
	    if(diem <0) {
	    	diem = 0;
	    }
	    return diem;
    }
    public int getRank() {
    	UserData data= new UserData();
	    MaxDiem = data.getTopDiem();
//    	float TrongSo = ((float)diem)/((float)MaxDiem);
//	    if(TrongSo > 0.6) {
//			rank = 6;
//		} else if(TrongSo > 0.4) {
//			rank = 5;
//		} else if(TrongSo > 0.25) {
//			rank = 4;
//		}  else if(TrongSo > 0.1) {
//			rank = 3;
//		} else if(TrongSo > 0.05) {
//			rank = 2;
//		} else {
//			rank =  1;
//		} 
	    if(diem <= 50) {
	    	rank = 1;
	    } else if(diem <= 90) {
	    	rank = 2;
	    } else if(diem <= 180) {
	    	rank = 3;
	    } else if(diem <= 280) {
	    	rank = 4;
	    }else if(diem <= 480) {
	    	rank = 5;
	    }else  {
	    	rank = 6;
	    	
	    }
	    return rank;
    }
    public String getRankChu() {
    	
    	switch(getRank()) {
    	case 1: return "Đồng";
    	case 2: return "Bạc";  
    	case 3: return "Vàng";
    	case 4: return "Bạch Kim";
    	case 5: return "Kim Cương";
    	case 6: return "Cao Thủ";
    	}
    	return null;
    	}
    
    
    
}