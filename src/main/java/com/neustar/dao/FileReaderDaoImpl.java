package com.neustar.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class FileReaderDaoImpl {

	// Method gets file name from service method and reads line by line and all
	// the lines are added into
	// Set<String> collection

	@SuppressWarnings("finally")
	public Set<String> readFile(String fileName) throws Exception {

		BufferedReader br = null;
		String line = "";
		Set<String> fileLines = new HashSet<String>();
		InputStream is = getClass().getClassLoader().getResourceAsStream("/" + fileName);
		br = new BufferedReader(new InputStreamReader(is));
		try {
			while ((line = br.readLine()) != null) {
				String fileLine = line.trim();
				if (!fileLine.equalsIgnoreCase(""))
					fileLines.add(fileLine);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			br.close();
			System.out.println("Size of arraylist " + fileLines.size());
			return fileLines;
		}
	}
}
