package com.pawan.LLD;

import com.pawan.LLD.dto.Slot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class LldApplication {

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {

		FitnessCenterRepository repository = new FitnessCenterRepository();
		BookingService bookingService = new BookingService(repository);
		UserManager userService = new UserManager();

		// Using ThreadPoolExecutor for concurrent operations
		ExecutorService executor = Executors.newFixedThreadPool(5);

		// Add Fitness Center with closed days and slots
		System.out.println("Adding fitness center...");
		repository.addCenter("bellandur", "bangalore", Arrays.asList("monday", "sunday"), 5);

		// Add Workout Types
		System.out.println("Adding workout types...");
		repository.addWorkOutType("bellandur", "weights");
		repository.addWorkOutType("bellandur", "cardio");
		repository.addWorkOutType("bellandur", "yoga");

		// Add Slots
		repository.addSlots("bellandur", "weights", LocalTime.of(6, 0), 2);
		repository.addSlots("bellandur", "yoga", LocalTime.of(8, 0), 1);

		// Register Users
		userService.registerUser("1","vivek", 16, "bangalore");
		userService.registerUser("1","pawan", 20, "bangalore");
		userService.registerUser("1","varun", 22, "bangalore");

		// Get Available Slots
		System.out.println("\nAvailable Slots on 28-05-2021:");
		List<Slot> availableSlots = bookingService.getAvailableSlots("bellandur", "28-05-2021");
		for (Slot slot : availableSlots) {
			System.out.println(slot.getSlotId() + ", bellandur, " + slot.getBookedSeats() + ", " + slot.getStartTime() + ", " + slot.getCapacity());
		}

		// Simulating concurrent bookings using threads
		Runnable bookVivek = () -> {
			boolean booked = bookingService.bookSlot("bellandur", "vivek", WorkoutType.WEIGHTS, LocalTime.of(6, 0));
			System.out.println("Vivek booking status: " + booked);
		};

		Runnable bookPavan = () -> {
			boolean booked = bookingService.bookSlot("bellandur", "pavan", WorkoutType.WEIGHTS, LocalTime.of(6, 0));
			System.out.println("Pavan booking status: " + booked);
		};

		// Execute booking in parallel
		executor.execute(bookVivek);
		executor.execute(bookPavan);

		// Wait for all tasks to complete
		executor.shutdown();
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Cancel a booking (should promote waitlisted user)
		bookingService.cancelSlot("bellandur", "vivek", WorkoutType.WEIGHTS, LocalTime.of(6, 0));

		// Display Varun's updated bookings
		List<Slot> varunBookings = bookingService.viewUserBookings("varun", "28-05-2021");
		System.out.println("Varun's bookings after Vivek's cancellation:");
		for (Slot slot : varunBookings) {
			System.out.println(slot.getSlotId() + ", bellandur, " + slot.getStartTime());
		}
	}

}
