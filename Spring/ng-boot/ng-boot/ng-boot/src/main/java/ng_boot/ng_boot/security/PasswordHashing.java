package ng_boot.ng_boot.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class PasswordHashing {
	 private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	    // Hash a password
	    public static String hashPassword(String password) {
	        return passwordEncoder.encode(password);
	    }

	    // Verify a password
	    public static boolean verifyPassword(String password, String hashedPassword) {
	        return passwordEncoder.matches(password, hashedPassword);
	    }
}
