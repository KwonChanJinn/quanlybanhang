package com.vti.controller;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.vti.form.FormLogin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.vti.DTO.AccountDTO;
import com.vti.entity.Account;
import com.vti.service.IService.IAccountService;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private IAccountService accountService;
//
//	@GetMapping()
//	public ResponseEntity<?> login(Principal principal) {
//
//		String username = principal.getName();
//		// Tim account tương ứng dựa vào username
//		Account accountLogin = accountService.getAccountByUsername(username);
//		AccountDTO accountDTO = mapper.map(accountLogin, AccountDTO.class);
//		accountDTO.setDepartmentName(accountLogin.getDepartment().getName());
//		accountDTO.setPositionName(accountLogin.getPosition().getName().toString());
//		return new ResponseEntity<>(accountDTO, HttpStatus.OK);
//
//
//	}

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping()
	public ResponseEntity<?> getAll(@RequestBody FormLogin form) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));

		Map<String, Object> claims = new HashMap<>();

		String token = Jwts.builder()
				.setClaims(claims)
				.setSubject(form.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 1000))
				.signWith(SignatureAlgorithm.HS512, "supersecret")
				.compact();

		return new ResponseEntity<>(token, HttpStatus.OK);
	}

}
