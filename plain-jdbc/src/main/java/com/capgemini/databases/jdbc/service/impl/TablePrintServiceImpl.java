package com.capgemini.databases.jdbc.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.databases.jdbc.service.TablePrintService;

public class TablePrintServiceImpl implements TablePrintService {

	public void printTable(String tableName, int fromRowIdx, int toRowIdx) throws Exception {
//		Connection connection = getConnectionToH2Database();
		Connection connection = getConnectionToMysqlDatabase();
		
		Statement statement = connection.createStatement();
		//TODO RSmolka only needed for the Mysql DB; consider merging with Mysql connection method
		statement.executeQuery("USE evilcompany_db");

		String queryToPrint = "SELECT * FROM " + tableName;
		int offset = fromRowIdx-1;
		int limit = toRowIdx - fromRowIdx + 1;;
		queryToPrint += " LIMIT " + limit + " OFFSET " + offset;
		
		ResultSet rs = statement.executeQuery(queryToPrint);
		
		
//		printFromH2Database(tableName, rs);
		printFromMysqlDatabase(tableName, rs);
		
		
		rs.close();
		statement.close();

		connection.close();
	}

	private void printFromMysqlDatabase(String tableName, ResultSet rs)  throws SQLException{
		 while (rs.next()) {
			System.out.println("     " + rs.getLong("PESEL"));
		}
	}

	private void printFromH2Database(String tableName, ResultSet rs) throws SQLException {
		//TODO RSmolka change printing
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("table: " +tableName); 
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("ID       |        NAME     |     AGE");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");

		 while (rs.next()) {
			System.out.println("     " + rs.getInt("ID") + "   |     " + rs.getString("NAME") +  "   |     " + rs.getInt("AGE") +  "     |");
		}
	}

	private Connection getConnectionToMysqlDatabase() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "Haslo.Mysql");
	}

	private Connection getConnectionToH2Database() throws Exception {
		Class.forName("org.h2.Driver");
		return DriverManager.getConnection("jdbc:h2:tcp://localhost/C:\\projects\\starterkit\\databases\\javaee-todo", "sa", "");
	}

}