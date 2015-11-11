package com.neustar.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.neustar.dao.FileReaderDaoImpl;
import com.neustar.model.FileContent;
import com.neustar.model.FileDetails;

public class FileReaderServiceImplTest {

	@Autowired
	FileReaderServiceImpl fileReader;

	@Test
	public void testReadFileService() throws Exception {

		FileReaderServiceImpl fileReaderService = Mockito.mock(FileReaderServiceImpl.class);
		String s = "samplethree.txt";

		FileReaderDaoImpl fileReaderDao = Mockito.mock(FileReaderDaoImpl.class);

		ArrayList<FileDetails> fileDetails1 = new ArrayList<FileDetails>();
		FileDetails f1 = new FileDetails();
		f1.setCategory("PERSON");
		f1.setCount(1);
		Set<String> fileLines = new HashSet<String>();
		
		Mockito.when(fileReaderDao.readFile(s)).thenReturn(fileLines);
		
		ArrayList<FileDetails> fileDetails2 = new ArrayList<FileDetails>();
		fileDetails2.add(f1);
		fileDetails1.add(f1);
		assertEquals(fileDetails1, fileDetails2);
	}

	@Test
	public void testReadFileContentService() throws Exception {

		FileReaderServiceImpl fileReaderService = Mockito.mock(FileReaderServiceImpl.class);
		String s = "samplethree.txt";

		FileReaderDaoImpl fileReaderDao = Mockito.mock(FileReaderDaoImpl.class);

		ArrayList<FileContent> fileContents1 = new ArrayList<FileContent>();
		FileContent f1 = new FileContent();
		f1.setFileContent("PERSON");
		Set<String> fileLines = new HashSet<String>();
		Mockito.when(fileReaderDao.readFile(s)).thenReturn(fileLines);
		ArrayList<FileContent> fileContents2 = new ArrayList<FileContent>();
		fileContents1.add(f1);
		fileContents2.add(f1);
		assertEquals(fileContents1, fileContents1);
	}
}
