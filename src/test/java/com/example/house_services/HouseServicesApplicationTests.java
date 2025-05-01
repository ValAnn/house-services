package com.example.house_services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.house_services.models.User;
import com.example.house_services.repositories.UserRepository;

@SpringBootTest
class HouseServicesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
    private UserRepository userRepository;
    
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("Test");
        user.setEmail("test@example.com");
        
        User saved = userRepository.save(user);
        assertNotNull(saved.getId());
    }

}
