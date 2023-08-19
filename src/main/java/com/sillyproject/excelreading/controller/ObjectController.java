package com.sillyproject.excelreading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sillyproject.excelreading.model.User;
import com.sillyproject.excelreading.service.ObjectService;

@RestController
public class ObjectController {
	
	@Autowired
	private ObjectService objectService; 

	@PostMapping("/import")
	public ResponseEntity<List<User>> importFile(@RequestParam("file") MultipartFile file) {
		return ResponseEntity.ok(objectService.importFile(file));
	}
}
