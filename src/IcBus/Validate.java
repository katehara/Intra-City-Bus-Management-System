package labProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;


public class Validate {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	// manager login validation
	int manager(int id , String pass) throws SQLException{
		con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		stmt=con.prepareStatement("select id , pass from manager where id  = ?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		int b = 0;
		if(rs.next()) {
			b++;
			if(rs.getString("pass").equals(pass)) b++;	
		}

		con.close();
		stmt.close();
		rs.close();
		return b;
	}
	// user login validation
	int user(int id , String pass) throws SQLException{
		int b = 0;
		con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		stmt=con.prepareStatement("select id , pass from user where id  = ?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		if(rs.next()) {
			b++;
			if(rs.getString("pass").equals(pass)) b++;	
		}

		con.close();
		stmt.close();
		rs.close();
		return b;
	}
}
