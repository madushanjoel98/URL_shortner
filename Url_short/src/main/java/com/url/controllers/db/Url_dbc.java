package com.url.controllers.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class Url_dbc {
	public static String geturl(String url_id) throws SQLException {
		System.out.println("ID:"+url_id);

		java.sql.Connection conn = null;
		try {
			conn = DbConnection.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean updator = false;
		ResultSet rs = null;
		String urlid = "";
		PreparedStatement statement = null;

		String query = "SELECT url FROM url_sh where url_id ='" + url_id + "'";

		System.out.println(query);

		try {
			statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
			// statement.setString(1, name);
			rs = statement.executeQuery(query);

			while (rs.next()) {

				urlid = rs.getString("url");
				System.out.println("*" + urlid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-*" + urlid);
		return urlid;
	}

	public boolean insertData(String url_id, String url) {
		Connection conn = null;

		boolean isInserted = false;

		int row = 0;

		try {
			conn = DbConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		boolean updator = false;
		ResultSet rs = null;
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date date = new java.util.Date();*/
		/*String de = date.toString();
		System.out.println(dateFormat.format(date));*/
		PreparedStatement statement = null;
int i=0;
		String query = "INSERT INTO `url_sh`(`url_id`,`url`,`add_date`) VALUES (?,?,now())";
		
		

		try {
			statement = (PreparedStatement) conn.prepareStatement(query);
			statement.setString(1, url_id);
			statement.setString(2, url);
			
			row = statement.executeUpdate();
			isInserted = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		}
		return isInserted;

	}
	
	public static int geturfl(String url) throws SQLException {
		//System.out.println("ID:"+url_id);
		java.sql.Connection conn = null;
		try {
			conn = DbConnection.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean updator = false;
		ResultSet rs = null;
		String urlid = "";
		PreparedStatement statement = null;

		String query = "SELECT if(url='"+url+"',true,false) from url_sh";

		try {
			statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
			// statement.setString(1, name);
			rs = statement.executeQuery(query);

			if (rs.next()) {

				urlid = rs.getString("if(url='"+url+"',true,false)");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (urlid=="") {
			return 0;
		}
		return  Integer.parseInt(urlid);
	}
	
	
	public static String geturlid(String url) throws SQLException {
		
		java.sql.Connection conn = null;
		try {
			conn = DbConnection.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean updator = false;
		ResultSet rs = null;
		String urlid = "";
		PreparedStatement statement = null;

		String query = "SELECT url_id FROM url_sh where url ='" + url + "'";

		System.out.println(query);

		try {
			statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
			// statement.setString(1, name);
			rs = statement.executeQuery(query);

			while (rs.next()) {

				urlid = rs.getString("url_id");
				System.out.println("*" + url);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-*" + urlid);
		return urlid;
	}

	

}
