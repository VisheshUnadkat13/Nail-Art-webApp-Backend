package com.nailartistry.NailartistryBackendApplication.controller;

import com.nailartistry.NailartistryBackendApplication.model.Booking;
import com.nailartistry.NailartistryBackendApplication.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {
    @Autowired
    private  BookingService service;

//    @Autowired
//    private EmailService emailService;
//
//
//    @PostMapping
//    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) throws IOException {
//        Booking savedBooking = service.createBooking(booking);
//
//        // Send email notification using the model's built-in method
//        String adminEmail = "unadkatvishesh@gmail.com";
//        String subject = "New Booking Notification - ID: " + savedBooking.getId();
//        String body = savedBooking.toEmailString();
//
//        emailService.sendBookingConfirmation(adminEmail, subject, body);
//
//        return new ResponseEntity<>(savedBooking, HttpStatus.OK);
//    }


//    @PostMapping
//    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) throws IOException {
//        Booking savedBooking = service.createBooking(booking);
//
//        // Send email notification
//        String adminEmail = "unadkatvishesh@gmail.com"; // Replace with actual admin email
//        String subject = "New Booking Notification - Booking ID: " + savedBooking.getId();
//        String body = "New booking details:\n\n" +
//                "Client Name: " + savedBooking.getName() + "\n" +
//                "Booking Date: " + savedBooking.getDate() + "\n" +
//                "Services: " + String.join(", ", savedBooking.getServices()) + "\n" +
//                "Contact: " + savedBooking.getEmail() + "\n\n" +
//                "Please check the system for more details.";
//
//        emailService.sendBookingConfirmation(adminEmail, subject, body);
//
//        return new ResponseEntity<>(savedBooking, HttpStatus.OK);
//    }


    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) throws IOException {
     Booking saveBooking=service.createBooking(booking);
     return new ResponseEntity<>(saveBooking,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBooking()
    {
      return  new ResponseEntity<>(service.getAllBooking(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Booking>> getBookingById(@PathVariable long id)
    {
        Optional<Booking> booking=service.getBookingById(id);

        if(booking.isPresent())
        {
            return new ResponseEntity<>(booking,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable long id)
    {
        Optional<Booking> booking=service.getBookingById(id);

        if(booking.isPresent())
        {
            service.deleteBooking(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
