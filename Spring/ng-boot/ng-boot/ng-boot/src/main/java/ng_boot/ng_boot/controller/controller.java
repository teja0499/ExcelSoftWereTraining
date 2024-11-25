package ng_boot.ng_boot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import ng_boot.ng_boot.dto.User;
import ng_boot.ng_boot.security.JwtUtil;
import ng_boot.ng_boot.security.PasswordHashing;
import ng_boot.ng_boot.service.CSVService;
import ng_boot.ng_boot.service.UserService;

@RestController
public class controller {

	@Autowired
	private UserService service;

	@Autowired
	private CSVService csvService;
//	
//	@Autowired
//	private PasswordHashing hashing;
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user,@RequestHeader("Authorization") String token
//		,	BindingResult bindingResult
			) {
	    // Check for validation errors
//	    if (bindingResult.hasErrors()) {
//	        StringBuilder errorMessage = new StringBuilder();
//	        bindingResult.getAllErrors().forEach(error -> {
//	            errorMessage.append(error.getDefaultMessage()).append("\n");
//	        });
//	        return ResponseEntity.badRequest().body(errorMessage.toString());  // Return validation errors with a Bad Request status
//	    }

	    // Validate JWT token
	    if (JwtUtil.validateToken(token) == null) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
	    }

	    // Save the user data if validation passes
	    return ResponseEntity.ok(service.saveUser(user));  // Assuming `saveUser` returns a User or a success response
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestHeader("Authorization") String token, @Valid @RequestBody User user) {

		if (JwtUtil.validateToken(token) == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		System.out.println(user);
		return ResponseEntity.ok(service.updateUser(user));
	}

	@GetMapping("/find_all")
	public ResponseEntity<?> getAllUser(@RequestHeader("authorization") String token) {
		System.out.println("token -------------------------" + token);
		System.out.println(JwtUtil.validateToken(token) == null);
		Claims c = JwtUtil.validateToken(token);
		System.out.println(c);
		if (JwtUtil.validateToken(token) == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		System.out.println("token = " + token);
		System.out.println("getall user");
		return ResponseEntity.ok(service.getAllUser());
	}

	@PostMapping("/search")
	public ResponseEntity<?> search(@RequestHeader("Authorization") String token, @RequestParam("name") String name) {
		System.out.println("token = " + token);
		System.out.println("getall user");
		if (JwtUtil.validateToken(token) == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return ResponseEntity.ok(service.getByName(name));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@RequestHeader("Authorization") String token, @PathVariable int id) {
		System.out.println("delete ");
		if (JwtUtil.validateToken(token) == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return ResponseEntity.ok(service.deleteById(id));
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("password") String password) {
		System.out.println("email = " + email);
		System.out.println("password = " + password);
		User user = service.login(email, password);
		String token = JwtUtil.generateToken(email);

		// Return a Map with the user and token
		Map<String, Object> response = new HashMap<>();
		response.put("user", user);
		response.put("token", token);

		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/csv")
	public  ResponseEntity<?> file(@RequestParam("file") MultipartFile file) throws IOException
	{
		System.out.println("csv");
		String result = null;
//		try {
//			result = service.processCSVFile(file);
//		
//		System.out.println(result); 
	    return ResponseEntity.ok( csvService.processCSVFile(file));
	}
	
	

	@GetMapping("/test") 
	public Map test(@RequestParam("email") String email, @RequestParam("password") String password) {
		System.out.println("working");
		Map map = new LinkedHashMap();

		// token
		String token = JwtUtil.generateToken(email);
		Claims b = JwtUtil.validateToken(token);
//		
//		
//		//password hashing
//		
		String hashPass = PasswordHashing.hashPassword(password);
		boolean flag = PasswordHashing.verifyPassword(password + "1", hashPass);
//		
//		
		map.put("email password", email + " " + password);
		map.put("token", token);
		map.put("validate", b);
		map.put("hash password", hashPass);
		map.put("check hash", flag);
////		
//		
		for (Object key : map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}

		return map;
	}

	@GetMapping("/")
	public void exceptionTest() {
		int b = 10 / 0;
		System.out.println(b);
	}
}
