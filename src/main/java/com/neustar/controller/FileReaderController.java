package com.neustar.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.neustar.model.FileContent;
import com.neustar.model.FileDetails;
import com.neustar.service.FileReaderServiceImpl;

import net.sf.json.JSONObject;

@Controller
public class FileReaderController {

	@Autowired
	private FileReaderServiceImpl fileReaderService;

	private static final Logger logger = Logger.getLogger(FileReaderController.class);

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("/fileReader");
	}

	// Method for loading 1st datatable filedetails with count
	@RequestMapping(value = "/get_file_data", method = RequestMethod.GET)
	public @ResponseBody String getFileData(@RequestParam("fileName") String fileName) {

		try {
			System.out.println(fileName);
			ArrayList<FileDetails> fileDetails = fileReaderService.readFileService(fileName);

			JSONObject jsonResponse = new JSONObject();
			jsonResponse.put("sEcho", 10);
			jsonResponse.put("iTotalRecords", fileDetails.size());
			jsonResponse.put("iTotalDisplayRecords", fileDetails.size());
			jsonResponse.put("aaData", fileDetails);
			System.out.println(jsonResponse.toString());

			return (jsonResponse.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error(e);
			return (e.getMessage());
		}
	}

	// Methods for loading data for second datatable : File contents
	@RequestMapping(value = "/get_file_content", method = RequestMethod.GET)
	public @ResponseBody String getFileContent(@RequestParam("fileName") String fileName) {

		try {
			System.out.println(fileName);
			ArrayList<FileContent> fileContents = fileReaderService.readFileContentService(fileName);

			JSONObject jsonResponse = new JSONObject();
			jsonResponse.put("sEcho", 10);
			jsonResponse.put("iTotalRecords", fileContents.size());
			jsonResponse.put("iTotalDisplayRecords", fileContents.size());
			jsonResponse.put("aaData", fileContents);
			System.out.println(jsonResponse.toString());

			return (jsonResponse.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return (e.getMessage());
		}
	}

	// method for populating dropdown using Ajax
	@RequestMapping(value = "/get_file_list", method = RequestMethod.GET)
	public @ResponseBody String getFileNames() {
		List<String> list = new ArrayList<String>();
		list.add("sampleone.txt");
		list.add("sampletwo.txt");
		list.add("samplethree.txt");
		Gson gson = new Gson();
		return gson.toJson(list);

	}

}
