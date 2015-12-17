package com.capgemini.databases.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import org.apache.log4j.Logger;
import org.h2.table.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.databases.jdbc.service.TablePrintService;
import com.capgemini.databases.jdbc.service.impl.TablePrintServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger logger = Logger.getLogger(App.class);
	private static TablePrintServiceImpl tablePrintService = new TablePrintServiceImpl();
	
    public static void main( String[] args ) throws Exception
    {
    	String tableName;
    	int fromRowIdx = 2;
    	int toRowIdx = 3;
    	
//    	for H2 Database
    	tableName = "myTab";
    	
//    	for Mysql Database
//    	tableName = "employees";
    	
		tablePrintService.printTable(tableName , fromRowIdx, toRowIdx);
    }
}
