INSERT INTO `testingsystem`.`department` (`departmentname`) 
VALUES ('Dev'),
		('Test'),
        ('Scrum_Master'),
        ('PM');
--  Dev, Test, Scrum_Master, PM;
INSERT INTO `testingsystem`.`position` (`PositionName`) 
VALUES 	('Nhân Sự'),
		('Quản Lý'),
		('Giám Đốc'),
		('CEO'),
		('Tuyển Dụng'),
		('Bảo vệ'),
		('Hành Chính'),
		('Trợ lý'),
		('Phó Giám Đốc'),
		('Maketting');

INSERT INTO `testingsystem`.`account` (`CreateDate`, `Email`, `FullName`, `password`, `Username`, `DepartmentID`, `PositionID`) 
VALUES 	
		('2023-01-17 20:58:57.000000',	 'root@gmail.com', 				'ADMIN',			 '123', 	'root', 		1, 	2),
		('2023-01-17 20:58:57.000000',	 'thanhsong2000@gmail.com', 	'Trần Thanh Song',	 '123', 	'thanhsong', 	1, 	10),
		('2023-01-17 20:58:57.000000',	 'lehung@gmail.com', 			'Nguyễn Lê Hùng',	 '123', 	'lehung', 		2, 	9),
		('2023-01-17 20:58:57.000000',	 'trancong@gmail.com', 			'Trần Công',	 	 '123', 	'trancong', 	3, 	8),
		('2023-01-17 20:58:57.000000',	 'tranchien@gmail.com', 		'Phan Văn Chiến',	 '123', 	'tranchien', 	4, 	7),
		('2023-01-17 20:58:57.000000',	 'nguyennam@gmail.com', 		'Nguyễn Hoàng Nam',	 '123', 	'nguyennam', 	3, 	6),
		('2023-01-17 20:58:57.000000',	 'hoanganh@gmail.com', 			'Lê Hoàng Anh',	 	 '123', 	'hoanganh', 	4, 	5),
		('2023-01-17 20:58:57.000000',	 'quangminh@gmail.com', 		'Phan Quang Minh',	 '123', 	'phanminh', 	3, 	4),
		('2023-01-17 20:58:57.000000',	 'hongthanh@gmail.com', 		'Lê Hồng Thanh',	 '123', 	'lethanh', 		1, 	3),
		('2023-01-17 20:58:57.000000',	 'ducluong@gmail.com', 			'Trần Đức Lương',	 '123', 	'ducluong', 	2, 	2),
		('2023-01-17 20:58:57.000000',	 'vanthanh@gmail.com', 			'Vũ Văn Thanh',	  	 '123', 	'vanthanh', 	4, 	1),
		('2023-01-17 20:58:57.000000',	 'phanthanh@gmail.com', 		'Phan Văn Thành ',	 '123', 	'phanthanh', 	3, 	10);