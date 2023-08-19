package com.sillyproject.excelreading.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.ReaderConfig;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sillyproject.excelreading.model.User;

@Service
public class ObjectService {

	@SuppressWarnings("unchecked")
	public List<User> importFile(MultipartFile file) {
		
		List<User> userObjects = new ArrayList<>();

		InputStream inputStream = null;
		try {
			inputStream = file.getInputStream();
			ReaderConfig.getInstance().setSkipErrors(true);

			// Load the Excel template and the XML mapping
			InputStream xmlConfig = getClass().getResourceAsStream("/object-mapping.xml");

			// file
			XLSReader xlsReader = ReaderBuilder.buildFromXML(xmlConfig);

			// Prepare the data to be filled in the template
			Map<String, Object> beans = new HashMap<>();
			beans.put("userObjects", userObjects);
		

			// Read the Excel file
			XLSReadStatus status = xlsReader.read(inputStream, beans);

			if (status.isStatusOK()) {
				return (List<User>)beans.get("userObjects");			
			} else return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	}

}
