package com.nailartistry.NailartistryBackendApplication.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

    @Column(nullable = false)
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime time;

    @ElementCollection // This annotation tells JPA to store this collection in a separate table
    @CollectionTable(name = "booking_services", // Name of the new table for services
            joinColumns = @JoinColumn(name = "booking_id")) // Foreign key column in 'booking_services' table
    @Column(name = "service_name", nullable = false) // Column name for each service string in the new table
    private List<String> service;
}



//package com.nailartistry.NailartistryBackendApplication.model;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.List;
//
//@Data
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//  // Explicit table name for consistency
//public class Booking {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;  // Changed from primitive long to wrapper Long for better JPA handling
//
//    @Column(nullable = false, length = 100)
//    private String name;
//
//    @Column(nullable = false, length = 100)
//    private String email;
//
//    @Column(nullable = false, length = 20)
//    private String phone;
//
//    @Column(nullable = false)
//    @JsonFormat(pattern="yyyy-MM-dd")
//    private LocalDate date;
//
//    @Column(nullable = false)
//    @JsonFormat(pattern="HH:mm")
//    private LocalTime time;  // Changed pattern to "HH:mm" as seconds are rarely needed
//
//    @ElementCollection
//    @CollectionTable(name = "booking_services",
//            joinColumns = @JoinColumn(name = "booking_id"))
//    @Column(name = "service_name", nullable = false, length = 100)
//    private List<String> services;  // Renamed from 'service' to 'services' for clarity
//
//    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
//    private Boolean confirmed = false;  // New field to track confirmation status
//
//    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
//    private Boolean notificationSent = false;  // New field to track email notification status
//
//    // Custom toString() for email content generation
//    public String toEmailString() {
//        return String.format(
//                "Booking Details:\n\n" +
//                        "Client: %s\n" +
//                        "Email: %s\n" +
//                        "Phone: %s\n" +
//                        "Date: %s\n" +
//                        "Time: %s\n" +
//                        "Services: %s\n",
//                name, email, phone, date, time, String.join(", ", services)
//        );
//    }
//
//
//}