package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DAOSpotify;
import model.SpotifyUser;

@WebServlet("/spotify/confirm")
public class SpotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOSpotify daoSpotify = new DAOSpotify();
       
    public SpotifyServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("state");
		String spotifyCode = request.getParameter("code");
		if(spotifyCode != null) {
			System.out.println(id);
			System.out.println(spotifyCode);
			
			SpotifyUser spotifyUser = new SpotifyUser(id, spotifyCode);
			
			try {
				daoSpotify.addSpotifyUser(spotifyUser);
				response.sendRedirect(request.getContextPath() + "/spotify/connect?status=success");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				response.sendRedirect(request.getContextPath() + "/spotify/connect?status=error&message=database_error");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/spotify/connect?status=error&message=unauthorized");
		}
		
	}

}
