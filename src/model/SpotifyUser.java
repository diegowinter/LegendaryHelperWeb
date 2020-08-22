package model;

public class SpotifyUser {
	
	private String userId;
	private String spotifyCode;
	
	public SpotifyUser(String userId, String spotifyCode) {
		this.userId = userId;
		this.spotifyCode = spotifyCode;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getSpotifyCode() {
		return spotifyCode;
	}
	
	public void setSpotifyCode(String spotifyCode) {
		this.spotifyCode = spotifyCode;
	}
	
}
