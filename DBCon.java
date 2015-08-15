package authentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class DBCon{
    private static Connection con;
public static Connection getCon()throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost/product_auth","root","root");
    return con;
}
public static String addProduct(String[] input,java.util.Date pdate)throws Exception{
    String msg="no";
    con = getCon();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select product_id from addproduct where product_id='"+input[0]+"'");
    if(rs.next()){
        msg = input[0]+" product id already exist";
    }else{
		PreparedStatement stat=con.prepareStatement("insert into addproduct values(?,?,?,?,?,?)");
		stat.setString(1,input[0]);
		stat.setString(2,input[1]);
		stat.setString(3,input[2]);
		stat.setString(4,input[3]);
		stat.setDate(5,new java.sql.Date(pdate.getTime()));
		stat.setString(6,input[4]);
		int i=stat.executeUpdate();
		if(i > 0)
			msg = "success";
	}
    return msg;
}
public static String authentication(String tag)throws Exception{
	StringBuilder sb = new StringBuilder();
	con = getCon();
	Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from addproduct where product_id='"+tag+"'");
    while(rs.next()){
        sb.append("Product ID	   : "+rs.getString(1)+"\n");
		sb.append("Product Name    : "+rs.getString(2)+"\n");
		sb.append("Product Cost    : "+rs.getString(3)+"\n");
		sb.append("Manufacturer	   : "+rs.getString(4)+"\n");
		sb.append("Production Date : "+rs.getString(5)+"\n");
		sb.append("Warranty Period : "+rs.getString(6)+"\n");
    }
	if(sb.length() == 0){
		sb.append(tag+" is a invalid tag\nProduct Not Found");
	}
	return sb.toString();
}
}
