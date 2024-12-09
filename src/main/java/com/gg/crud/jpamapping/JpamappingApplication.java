package com.gg.crud.jpamapping;

import com.gg.crud.jpamapping.dao.AppDAO;
import com.gg.crud.jpamapping.entity.Instructor;
import com.gg.crud.jpamapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpamappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpamappingApplication.class, args);
	}

	@Bean
	CommandLineRunner coommandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");

	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associate instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//
//		// Create the instructor
//		Instructor tempInstructor =
//				new Instructor("Chad", "Darby", "chad@darby@gmail.com");
//
//
//		// Create the instructor detail
//		InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.gg.com/youtube",
//												"Love to code");

		// Create the instructor
		Instructor tempInstructor =
				new Instructor("Madu", "Patel", "madu@patel@gmail.com");


		// Create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.gg.com/youtube",
				"Playing guitar");

		// Associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// Save the instructor
		// NOTE: This will also save the deatils object because of CascadeType.all
		System.out.println("Saving instrucltor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
