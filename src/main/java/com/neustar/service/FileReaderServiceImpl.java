package com.neustar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.neustar.dao.FileReaderDaoImpl;
import com.neustar.model.FileContent;
import com.neustar.model.FileDetails;

public class FileReaderServiceImpl {

	@Autowired
	private FileReaderDaoImpl fileReaderDao;

	// Method manipulates data received from Dao method and prepares ArrayList
	// <FileDetails> to populate 1st datatable
	public ArrayList<FileDetails> readFileService(String fileName) throws Exception {

		ArrayList<String> fileSubLine = new ArrayList<String>();
		ArrayList<FileDetails> fileDetails = new ArrayList<FileDetails>();

		try {
			Set<String> fileLines = fileReaderDao.readFile(fileName);
			for (String line : fileLines) {
				System.out.println(line);
				String[] s = line.split("\\s");
				fileSubLine.add(s[0]);
			}

			int personCount = Collections.frequency(fileSubLine, "PERSON");
			int placeCount = Collections.frequency(fileSubLine, "PLACE");
			int animalCount = Collections.frequency(fileSubLine, "ANIMAL");
			int computerCount = Collections.frequency(fileSubLine, "COMPUTER");
			int otherCount = Collections.frequency(fileSubLine, "OTHER");

			FileDetails f1 = new FileDetails();
			f1.setCategory("PERSON");
			f1.setCount(personCount);
			FileDetails f2 = new FileDetails();
			f2.setCategory("PLACE");
			f2.setCount(placeCount);
			FileDetails f3 = new FileDetails();
			f3.setCategory("ANIMAL");
			f3.setCount(animalCount);
			FileDetails f4 = new FileDetails();
			f4.setCategory("COMPUTER");
			f4.setCount(computerCount);
			FileDetails f5 = new FileDetails();
			f5.setCategory("OTHER");
			f5.setCount(otherCount);

			fileDetails.add(f1);
			fileDetails.add(f2);
			fileDetails.add(f3);
			fileDetails.add(f4);
			fileDetails.add(f5);

			return fileDetails;

		} catch (Exception exception) {
			System.out.println(exception);
			throw exception;

		}
	}

	// Method manipulates data received from Dao method and prepares ArrayList
	// <FileContent> to populate 2nd datatable
	public ArrayList<FileContent> readFileContentService(String fileName) throws Exception {

		try {
			Set<String> fileLines = fileReaderDao.readFile(fileName);
			ArrayList<FileContent> fileContents = new ArrayList<FileContent>();

			for (String line : fileLines) {
				System.out.println(line);
				FileContent fileContent = new FileContent();
				String[] s = line.split("\\s");
				if (s[0].equalsIgnoreCase("PERSON") || s[0].equalsIgnoreCase("PLACE") || s[0].equalsIgnoreCase("ANIMAL")
						|| s[0].equalsIgnoreCase("COMPUTER") || s[0].equalsIgnoreCase("OTHER")) {
					fileContent.setFileContent(line);
					fileContents.add(fileContent);
				}
			}

			return fileContents;
		} catch (Exception exception) {
			System.out.println(exception);
			throw exception;
		}
	}

}
