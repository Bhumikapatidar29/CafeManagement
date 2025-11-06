package in.vayam.org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ADDContact
 */
@WebServlet("/Contact")
public class ADDContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADDContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n=request.getParameter("na");
		String e=request.getParameter("em");
		String m=request.getParameter("msg");

		PreparedStatement pst=null;
		Connection con=null;

		try {


					con=DBConnection.getConnection();

		} catch (Exception em) {
			em.printStackTrace();
		}
		String query="insert into contact(name,email,message) values(?,?,?)";
		try {

			pst=con.prepareStatement(query);

			pst.setString(1,n);
			pst.setString(2,e);
			pst.setString(3,m);

			pst.executeUpdate();

		} catch (Exception en) {
			en.printStackTrace();

		}
		response.sendRedirect("Thankyou.html");

		}

}
