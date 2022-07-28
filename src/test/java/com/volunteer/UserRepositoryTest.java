package com.volunteer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		
		User user= new User();
		user.setName("John");
		user.setEmail("john@gmail.com");
		user.setPassword("john22");
		
		User savedUser = repo.save(user);
		User existUser= entityManager.find(User.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	} 

}
