package com.capgemini.databases.jdbc.service;

public interface TablePrintService {
	public void printTable(String tableName, int fromRowIdx, int toRowIdx) throws Exception;
}
