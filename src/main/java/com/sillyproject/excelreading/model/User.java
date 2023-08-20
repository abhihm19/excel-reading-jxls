package com.sillyproject.excelreading.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private int serialNumber;
	private String name;
	private int score;
	private long mobileNumber;
}
