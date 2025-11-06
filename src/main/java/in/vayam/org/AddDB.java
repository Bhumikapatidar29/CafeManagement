package in.vayam.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AddDB")
public class AddDB extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u=request.getParameter("ui");
		int user=Integer.parseInt(u);
		String n=request.getParameter("na");
		String a=request.getParameter("ad");
		String ee=request.getParameter("em");
		String p=request.getParameter("pa");


		PreparedStatement pst=null;
		Connection con=null;

		try {


					con=DBConnection.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
		String query="insert into registration(userid,username,address,email,password) values(?,?,?,?,?)";
		try {

			pst=con.prepareStatement(query);
			pst.setInt(1,user);
			pst.setString(2,n);
			pst.setString(3,a);
			pst.setString(4,ee);
			pst.setString(5,p);
			String msg="sucess";
			boolean b=pst.execute();
			if(!b)
			{
				PrintWriter out=response.getWriter();
				out.println("<h1 style='color:green'>Record Added Succesfully</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				response.setContentType("Text/Html");
				rd.include(request, response);
			}
			else {

				PrintWriter out=response.getWriter();
				out.println("<h1 style='color:red'>Record Not found</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("firstt.html");
				response.setContentType("Text/Html");
				rd.include(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

			}



	}


