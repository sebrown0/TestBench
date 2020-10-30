package persistence.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import database.enity.application.Application;
import database.repository.ApplicationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationRepoTest {
	@Autowired
	private ApplicationRepository appRepo;
	
	@Test
	void test() {
		Application app = appRepo.findByName("TestSystem");
		assertEquals("", app.getName());
	}

}
