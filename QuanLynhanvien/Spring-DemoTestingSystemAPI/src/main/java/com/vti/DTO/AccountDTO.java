package com.vti.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class AccountDTO {

	private short id;

	private String email;

	private String userName;

	private String fullName;

	private String departmentName;

	private String positionName;

	private  String role;



	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;


}
