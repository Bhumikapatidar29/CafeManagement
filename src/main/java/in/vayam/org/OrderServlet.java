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
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-gene rated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        // Getting parameters from the HTML form
	        String name = request.getParameter("name");
	        String address = request.getParameter("address");
	        String totalStr = request.getParameter("total");
	        String items = request.getParameter("items");

	        try {
	            double total = Double.parseDouble(totalStr);

	            // Establish connection using your existing DBConnection class
	            Connection con = DBConnection.getConnection();

	            // SQL query to insert order details
	            String sql = "INSERT INTO orders (name, address, items, total) VALUES (?, ?, ?, ?)";
	            PreparedStatement pst = con.prepareStatement(sql);
	            pst.setString(1, name);
	            pst.setString(2, address);
	            pst.setString(3, items);  // Storing ordered items
	            pst.setDouble(4, total);

	            int rows = pst.executeUpdate();

	            if (rows > 0) {
	                out.println("<h3>Order placed successfully!</h3>");
	                out.println("<p>Thank you, " + name + "! Your order of " + items + " totaling ₹" + total + " will be delivered to: " + address + "</p>");
	            } else {
	                out.println("<h3>Order failed. Please try again.</h3>");
	            }

	            // Close resources
	            pst.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            out.println("<h3>Error: " + e.getMessage() + "</h3>");
	        }
	}

}
