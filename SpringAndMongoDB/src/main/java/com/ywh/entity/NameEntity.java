package com.ywh.entity;

public class NameEntity {

	private String username;  
	  
    private String nickname;  
  
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getNickname() {  
        return nickname;  
    }  
  
    public void setNickname(String nickname) {  
        this.nickname = nickname;  
    }

	public NameEntity(String username, String nickname) {
		super();
		this.username = username;
		this.nickname = nickname;
	}  
    
    
}
