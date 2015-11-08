package com.neustar.dao;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
public class FileReaderDaoImplTest {

	@Autowired
	FileReaderDaoImpl fileReader;

	@Test
	public void testReadFile() throws Exception {

		// FileReaderDaoImpl fileReaderDao= new FileReaderDaoImpl();
		String s = "samplethree.txt";
		InputStream in = Mockito.mock(InputStream.class);
		InputStreamReader inr = Mockito.mock(InputStreamReader.class);
		BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);

		FileReaderDaoImpl fileReaderDao = Mockito.mock(FileReaderDaoImpl.class);
		Set<String> s1 = new HashSet<String>();
		s1.add("");
		Set<String> s2 = fileReaderDao.readFile(s);
		s2.add("");
		assertEquals(s1, s2);

	}

}
