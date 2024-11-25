package ng_boot.ng_boot.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.persistence.EntityNotFoundException;
import ng_boot.ng_boot.dto.User;
import ng_boot.ng_boot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	 @Autowired
	    private Validator validator; 

	public User saveUser(User user) {
		System.out.println(user);
		if (repository.existsByEmail(user.getEmail())) {
			throw new DuplicateKeyException("Email  Already exist");
		} else if (repository.existsByMobile(user.getMobile())) {
			throw new DuplicateKeyException("Mobile Number Already exist");
		} else {
			return repository.save(user);
//			return getAllUser();
		}
	}

	public List<User> getAllUser() {
		System.out.println("getall user");
		return repository.findAll();
	}

	public List<User> getByName(String name) {
		System.out.println("getall user");
		return repository.findByNameContainingIgnoreCase(name);
	}

	public List<User> deleteById(int id) {
		System.out.println("delete ");
		repository.deleteById(id);
		return getAllUser();
	}

	public User updateUser(User updatedUser) {
		User existingUser = repository.findById(updatedUser.getId());
//		System.out.println("---------------------------------------------------------------------------------"+(repository.existsByEmail(updatedUser.getEmail())) +"  &&  "+ (existingUser.getId() != updatedUser.getId()));
//		
//		System.out.println(("---------------------------------------------------------------------------------")+repository.existsByMobile(updatedUser.getMobile()) +" && "+ (existingUser.getId() != updatedUser.getId())) ;
		
		if ( repository.existsByEmailAndIdNot(updatedUser.getEmail(),updatedUser.getId())) {
			throw new DuplicateKeyException("Email  Already exist");
		} else if (repository.existsByMobileAndIdNot(updatedUser.getMobile(),updatedUser.getId()) ){
			throw new DuplicateKeyException("Mobile Number Already exist");
		}

		existingUser.setName(updatedUser.getName());
		existingUser.setDob(updatedUser.getDob()); 
		existingUser.setGender(updatedUser.getGender());
		existingUser.setPassword(updatedUser.getPassword());
		existingUser.setEmail(updatedUser.getEmail());
		existingUser.setMobile(updatedUser.getMobile());
		existingUser.setQualification(updatedUser.getQualification());
		return repository.save(existingUser);
	}

	public User login(String email, String password) {
		User user = null;
		if (email != null) {
			user = repository.findByEmailAndPassword(email, password);
			System.out.println(user);
		}
		if (user == null) {
			throw new EntityNotFoundException("Credential missmatch");
		}
		return user;
	}
	
	
	
}
 