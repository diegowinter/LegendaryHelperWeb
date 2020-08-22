package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.SpotifyUser;

public class DAOSpotify {
	
	public void addSpotifyUser(SpotifyUser spotifyUser) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(System.getenv("DB_URL"), System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"));
		
		if(search(spotifyUser, connection) == false) {
			PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO users(id, spotify_code)"
					+ "values (?, ?)");
			prepStatement.setString(1, spotifyUser.getUserId());
			prepStatement.setString(2, spotifyUser.getSpotifyCode());
			prepStatement.execute();
			prepStatement.close();
			
			connection.close();
		} else {
			PreparedStatement prepStatement = connection.prepareStatement("UPDATE users SET spotify_code = ? WHERE id = " + spotifyUser.getUserId() +";");
			prepStatement.setString(1, spotifyUser.getSpotifyCode());
			prepStatement.execute();
			prepStatement.close();
			
			connection.close();
		}
	}
	
	private boolean search(SpotifyUser spotifyUser, Connection connection) throws SQLException {
		PreparedStatement prepStatement = connection.prepareStatement("SELECT * FROM " 
				+ System.getenv("DB_NAME") + ".users WHERE id = ?");
		prepStatement.setString(1, spotifyUser.getUserId());
		
		ResultSet rs = prepStatement.executeQuery();
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
	}

}
