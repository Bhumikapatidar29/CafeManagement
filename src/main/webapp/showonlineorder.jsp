<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.DriverManager" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
background-color:black;
color:white;
text-align:center;

}
table{
border:1px solid white;
margin-left: 300px;
margin-right:280px;
margin-top:100px;
padding-top:20px;
padding-bottom:20px;

}

</style>
</head>
<body>
<h2>online orders</h2>
<%
String url="jdbc:mysql://localhost:3306/vayam";
String user="root";
String pass="root";
Connection con=null;

String s="select * from orders";

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url,user,pass);
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(s);

%>

<table style="border-collapse: separate; border-spacing:30px;"> 
<tr><th>Id</th><th>Name</th><th>Address</th><th>Items</th><th>total</th><th>order_time</th></tr>

<%
while(rs.next())
{
	int id=rs.getInt("id");
	String name=rs.getString("name");
	String address=rs.getString("address");
	String items=rs.getString("items");
	double  total=rs.getDouble("total");
Timestamp order_time=rs.getTimestamp("order_time");


%>


<tr><td><%=id %></td><td><%=name %></td><td><%=address %></td><td><%=items %></td><td><%=total %></td><td><%=order_time%></td></tr>
<% 
}
%>
</table>


 <%
}
catch(Exception e)
{
e.printStackTrace();
}


%>

</body>
</html>