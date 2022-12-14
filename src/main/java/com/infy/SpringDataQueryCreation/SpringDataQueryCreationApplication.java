package com.infy.SpringDataQueryCreation;

import com.infy.SpringDataQueryCreation.dto.CustomerDTO;
import com.infy.SpringDataQueryCreation.repository.CustomerRepository;
import com.infy.SpringDataQueryCreation.repository.CustomerServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringDataQueryCreationApplication implements CommandLineRunner {

	private static final Log LOGGER = LogFactory.getLog(SpringDataQueryCreationApplication.class);

	@Autowired
	CustomerServiceImpl customerService;

	@Autowired
	Environment environment;
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataQueryCreationApplication.class, args);
	}

	public void run(String... args){
		findByEmailId();
		findByEmailIdAndName();
		findByEmailIdOrName();
		findByDateOfBirthBetween();
		findByDateOfBirthLessThan();
		findByDateOfBirthGreaterThan();
		findByDateOfBirthAfter();
		findByDateOfBirthBefore();
		findByEmailIdNull();
		findByNameLike();
		findByNameOrderByDateOfBirth();
		findByNameOrderByDateOfBirthDesc();
	}

	public void findByEmailId(){
		try {
			CustomerDTO customerDTO = customerService.findByEmailId("buhari@infy.com");
			LOGGER.info(customerDTO);
			LOGGER.info("\n");
		} catch(Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
			}
		}
	}


	public void findByEmailIdAndName(){
		try {
			CustomerDTO customerDTO = customerService.findByEmailIdAndName("buhari@infy.com", "Buhari");
			LOGGER.info(customerDTO);
			LOGGER.info("\n");
		} catch(Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
			}
		}
	}

	public void findByEmailIdOrName(){
		try {
			List<CustomerDTO> customerDTOs = customerService.findByEmailIdOrName("buhari@infy.com", "Buhari");
			customerDTOs.forEach(customerDTO -> {
				LOGGER.info(customerDTO);
			});
			LOGGER.info("\n");
		} catch(Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
			}
		}
	}

	public void findByDateOfBirthBetween(){
		try {
			LocalDate fromDate = LocalDate.of(1995, 1, 1);
			LocalDate toDate = LocalDate.of(2000, 12, 31);
			List<CustomerDTO> customerDTOs = customerService.findByDateOfBirthBetween(fromDate, toDate);
			customerDTOs.forEach(customerDTO -> {
				LOGGER.info(customerDTO);
			});
			LOGGER.info("\n");
		} catch(Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
			}
		}
	}

	public void findByDateOfBirthLessThan(){
		try {
			LocalDate dateOfBirth= LocalDate.of(2000, 12, 31);
			List<CustomerDTO> customerDTOs = customerService.findByDateOfBirthLessThan(dateOfBirth);
			customerDTOs.forEach(customerDTO -> {
				LOGGER.info(customerDTO);
			});
			LOGGER.info("\n");
		} catch(Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
			}
		}
	}

	public void findByDateOfBirthGreaterThan(){
		try {
			LocalDate dateOfBirth = LocalDate.of(1995, 12, 31);
			List<CustomerDTO> customerDTOs = customerService.findByDateOfBirthGreaterThan(dateOfBirth);
			customerDTOs.forEach(customerDTO -> {
				LOGGER.info(customerDTO);
			});
			LOGGER.info("\n");
		} catch(Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
			}
		}
	}

	public void findByDateOfBirthAfter(){
		try {
			LocalDate dateOfBirth = LocalDate.of(1995, 12, 31);
			List<CustomerDTO> customerDTOs = customerService.findByDateOfBirthAfter(dateOfBirth);
			customerDTOs.forEach(customerDTO -> {
				LOGGER.info(customerDTO);
			});
			LOGGER.info("\n");
		} catch(Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
			}
		}
	}

	public void findByDateOfBirthBefore(){
		try {
			LocalDate dateOfBirth = LocalDate.of(2000, 12, 31);
			List<CustomerDTO> customerDTOs = customerService.findByDateOfBirthAfter(dateOfBirth);
			customerDTOs.forEach(customerDTO -> {
				LOGGER.info(customerDTO);
			});
			LOGGER.info("\n");
		} catch(Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
			}
		}
	}

	public void findByEmailIdNull(){
		try {
			List<CustomerDTO> customerDTOs = customerService.findByEmailIdNull();
			customerDTOs.forEach(customerDTO -> {
				LOGGER.info(customerDTO);
			});
			LOGGER.info("\n");
		} catch(Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
			}
		}
	}

	public void findByNameLike(){
		try {
			List<CustomerDTO> customerDTOs = customerService.findByNameLike("%j");
			customerDTOs.forEach(customerDTO -> {
				LOGGER.info(customerDTO);
			});
			LOGGER.info("\n");
		} catch(Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
			}
		}
	}

	public void findByNameOrderByDateOfBirth(){
		try {
			List<CustomerDTO> customerDTOs = customerService.findByNameOrderByDateOfBirth("Buhari");
			customerDTOs.forEach(customerDTO -> {
				LOGGER.info(customerDTO);
			});
			LOGGER.info("\n");
		} catch(Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
			}
		}
	}

	public void findByNameOrderByDateOfBirthDesc(){
		try {
			List<CustomerDTO> customerDTOs = customerService.findByNameOrderByDateOfBirthDesc("Buhari");
			customerDTOs.forEach(customerDTO -> {
				LOGGER.info(customerDTO);
			});
			LOGGER.info("\n");
		} catch(Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
			}
		}
	}

}
