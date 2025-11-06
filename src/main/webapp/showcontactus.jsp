<%@page import="java.sql.Time"%>
<%@page import="java.sql.Date"%>
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
margin-left: 430px;
margin-right:360px;
margin-top:100px;
padding-top:20px;
padding-bottom:20px;

}

</style>
</head>
<body>
<h2>Contacts</h2>
<%
String url="jdbc:mysql://localhost:3306/vayam";
String user="root";
String pass="root";
Connection con=null;

String s="select * from contact";

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url,user,pass);
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(s);

%>

<table style="border-collapse: separate; border-spacing:30px;"> 
<tr><th>Name</th><th>Email</th><th>Message</th></tr>

<%
while(rs.next())
{
	
	String name=rs.getString("name");
	 String email=rs.getString("email");
	 String message=rs.getString("message");



%>


<tr><td><%=name %></td><td><%=email %></td><td><%=message %></td></tr>
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