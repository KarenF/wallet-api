package com.wallet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;
import com.wallet.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";

	@Autowired
	UserRepository repository;
	
	@Before
	public void setUp() {
		User user = new User();
		user.setName("Teste setUp");
		user.setPassword("654321");
		user.setEmail(EMAIL);
		
		repository.save(user);
	}
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void testSave() {
		User user = new User();
		user.setName("Pessoa");
		user.setPassword("123456");
		user.setEmail("email@email.com");
		
		User response = repository.save(user);
		
		assertNotNull(response);
	}
	
	public void testFindByEmail() {
		Optional<User> response = repository.findByEmailEquals(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}
}
