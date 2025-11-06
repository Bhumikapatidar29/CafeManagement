package in.vayam.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookTableServlet
 */
@WebServlet("/BookTable")
public class BookTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**

     * @see HttpServlet#HttpServlet()
     */
    public BookTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String i=request.getParameter("id");
		int id=Integer.parseInt(i);
		String name=request.getParameter("name");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String pp=request.getParameter("people");
		int people=Integer.parseInt(pp);

		PreparedStatement pst=null;
		Connection conn=null;

		try {
			 conn=DBConnection.getConnection();
			String query="insert into booktable(id, name, date, time, people) VALUES(?, ?, ?, ?, ?)";
			 pst=conn.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2,name);
			pst.setString(3, date);
			pst.setString(4,time);
			pst.setInt(5, people);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
		response.sendRedirect("Thankyou.html");

		}

}
