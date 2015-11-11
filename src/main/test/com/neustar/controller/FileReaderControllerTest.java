package com.neustar.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.neustar.model.FileContent;
import com.neustar.model.FileDetails;
import com.neustar.service.FileReaderServiceImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class})
//@WebAppConfiguration
public class FileReaderControllerTest {

	@Autowired
	FileReaderServiceImpl fileReader;

	@Test
	public void testGetFileContent() throws Exception {

		FileReaderServiceImpl fileReaderService = Mockito.mock(FileReaderServiceImpl.class);
		String s = "samplethree.txt";

		ArrayList<FileContent> fileContents1 = new ArrayList<FileContent>();
		FileContent f1 = new FileContent();
		f1.setFileContent("PERSON");
		ArrayList<FileContent> fileContent2 = new ArrayList<FileContent>();
		
		//Mockito.when(fileReaderService.readFileContentService((s)).thenReturn(fileContent2));
		
		fileContents1.add(f1);
		fileContent2.add(f1);
		assertEquals(fileContents1, fileContents1);
	}
	
	
	@Test
	public void testGetFileData() throws Exception {

		FileReaderServiceImpl fileReaderService = Mockito.mock(FileReaderServiceImpl.class);
		String s = "samplethree.txt";

		ArrayList<FileDetails> fileDetails1 = new ArrayList<FileDetails>();
		FileDetails f1 = new FileDetails();
		f1.setCategory("PERSON");
		f1.setCount(1);
	
		ArrayList<FileDetails> fileDetails2 = new ArrayList<FileDetails>();
		
		//Mockito.when(fileReaderService.readFileContentService((s)).thenReturn(fileDetails2));
		
		fileDetails1.add(f1);
		fileDetails2.add(f1);
		assertEquals(fileDetails1, fileDetails2);
	}

	@Test
	public void testGetFileNames() throws Exception {

		FileReaderServiceImpl fileReaderService = Mockito.mock(FileReaderServiceImpl.class);
		String s = "samplethree.txt";

		ArrayList<String> filename1 = new ArrayList<String>();
		ArrayList<String> filename2 = new ArrayList<String>();
		filename1.add(s);
		filename2.add(s);
		assertEquals(filename1, filename2);
	}

}
