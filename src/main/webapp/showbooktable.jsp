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
<h2>Table Booking list</h2>
<%
String url="jdbc:mysql://localhost:3306/vayam";
String user="root";
String pass="root";
Connection con=null;

String s="select * from booktable";

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url,user,pass);
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(s);

%>

<table style="border-collapse: separate; border-spacing:30px;"> 
<tr><th>Id</th><th>Name</th><th>Date</th><th>Time</th><th>People</th></tr>

<%
while(rs.next())
{
	int id=rs.getInt("id");
	String name=rs.getString("name");
	 Date  date=rs.getDate("date");
	Time time=rs.getTime("time");
	int people=rs.getInt("people");



%>


<tr><td><%=id %></td><td><%=name %></td><td><%=date %></td><td><%=time %></td><td><%=people%></td></tr>
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