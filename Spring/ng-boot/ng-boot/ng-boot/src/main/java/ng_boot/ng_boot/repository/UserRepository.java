package ng_boot.ng_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ng_boot.ng_boot.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
// void deleteById(int id);
	 User findById(int id);
	 List<User> findByNameContainingIgnoreCase(String namePart);
	 boolean existsByMobile(String mobile);
	 boolean existsByEmail(String Email);
	 boolean existsByMobileAndIdNot(String mobile, int id);
	 boolean existsByEmailAndIdNot(String email,int id);
	User findByEmailAndPassword(String email, String password);
	User findByMobileAndPassword(String email, String password);
	
	
	 
}
 