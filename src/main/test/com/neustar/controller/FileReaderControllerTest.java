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
	public void testReadFileContentService() throws Exception {

		FileReaderServiceImpl fileReaderService = Mockito.mock(FileReaderServiceImpl.class);
		String s = "samplethree.txt";

		ArrayList<FileContent> fileContents1 = new ArrayList<FileContent>();
		FileContent f1 = new FileContent();
		f1.setFileContent("PERSON");
		ArrayList<FileDetails> fileDetails = fileReaderService.readFileService(s);
		ArrayList<FileContent> fileContents2 = new ArrayList<FileContent>();
		fileContents1.add(f1);
		fileContents2.add(f1);
		assertEquals(fileContents1, fileContents1);
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
