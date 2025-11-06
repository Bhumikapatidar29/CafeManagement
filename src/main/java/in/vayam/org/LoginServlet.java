package in.vayam.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("em");
		String password=request.getParameter("pa");
		PreparedStatement pst=null;
		Connection con=null;
		ResultSet rs=null;
		String query="select * from registration where email=? AND password=?";

		try {


					con=DBConnection.getConnection();
					pst=con.prepareStatement(query);
					pst.setString(1,email);
					pst.setString(2, password);


					rs=pst.executeQuery();

					if (rs.next()) {
						RequestDispatcher rd=request.getRequestDispatcher("in.html");
						response.setContentType("Text/Html");
						rd.include(request, response);


		            } else {
		            	PrintWriter out=response.getWriter();
						out.println("<h1 style='color:red'>Invalid Login</h1>");
						RequestDispatcher rd=request.getRequestDispatcher("log.html");
						response.setContentType("Text/Html");
						rd.include(request, response);

		            }


		}


		catch (Exception e) {
			e.printStackTrace();
		}








	}

}
