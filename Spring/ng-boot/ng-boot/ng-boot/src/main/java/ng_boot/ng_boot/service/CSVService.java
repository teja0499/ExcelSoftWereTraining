package ng_boot.ng_boot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import ng_boot.ng_boot.dto.User;
import ng_boot.ng_boot.repository.UserRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CSVService {

	private final UserRepository repository;
	private final Validator validator;

	public CSVService(UserRepository repository, Validator validator) {
		this.repository = repository;
		this.validator = validator;
	}

	@Transactional
	public Map<String, Object> processCSVFile(MultipartFile file) throws IOException {
		List<User> validUsers = new ArrayList<>();
		List<String> validationErrors = new ArrayList<>();
		List<Integer>errorsRowNum= new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			String[] tempArr;
			int i = 1;
			while ((line = br.readLine()) != null) {
				tempArr = line.split(",");
				if (tempArr[0].equals("name"))
					continue; // Skip header row

				User user = new User();
				user.setName(tempArr[0]);
				user.setEmail(tempArr[1]);
				user.setGender(tempArr[2]);
				user.setMobile(tempArr[3]);
				user.setDob(tempArr[4]);
				user.setQualification(tempArr[5]);
				user.setPassword(tempArr[6]);
				i++;

				boolean isEmailPresent = repository.existsByEmail(user.getEmail());
				boolean isMobileNumberPresent = repository.existsByMobile(user.getMobile());

				Set<ConstraintViolation<User>> violations = validator.validate(user);
				if (!violations.isEmpty() || isMobileNumberPresent || isEmailPresent) {
//					if(validationErrors.size()==0) {validationErrors.add("Errors");errorsRowNum.add(0);}
					if (isEmailPresent) {
						errorsRowNum.add(i);
						validationErrors.add("email already register for user: " + user.getName() );
					}
					if (isMobileNumberPresent) {
						errorsRowNum.add(i);
						validationErrors
								.add("Mobile number already register for user: " + user.getName() );
					}

					for (ConstraintViolation<User> violation : violations) {
						errorsRowNum.add(i);
						validationErrors.add(violation.getMessage() + " for user: " + user.getName());
					}
					
				} else {

					validUsers.add(user);
					System.out.println(user);
					repository.save(user);
				}
			}
		}
//        if(validUsers.size()!=0)repository.saveAll(validUsers);

		Map<String, Object> result = new HashMap<>();
		result.put("validUsers", repository.findAll());
		result.put("errors", validationErrors);
		result.put("errorsRowNum", errorsRowNum);

		return result;
	}
}
