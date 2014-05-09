package edu.ycp.cs320.myYorkSpace.server.model.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.myYorkSpace.shared.Account;

public class InitialData {
	///////////////////////////////////////////////////////////////
	//Couldnt figure out how to use csv file to populate database//
	///////////////////////////////////////////////////////////////
	public static List<Account> getAccounts() throws IOException {
		List<Account> AccountList = new ArrayList<Account>();
		ReadCSV readAccounts = new ReadCSV("Accounts.csv");
		try {
			while (true) {
				List<String> tuple = readAccounts.next();
				if (tuple == null) {
					break;
				}
			}
			return AccountList;
		} finally {
			readAccounts.close();
		}
	}
}
