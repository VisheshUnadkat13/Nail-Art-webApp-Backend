package com.nailartistry.NailartistryBackendApplication.service;

import com.nailartistry.NailartistryBackendApplication.model.Booking;
import com.nailartistry.NailartistryBackendApplication.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepo repo;
    public Booking createBooking(Booking booking) throws IOException {
        return repo.save(booking);
    }

    public List<Booking> getAllBooking() {
        return  repo.findAll();
    }

    public Optional<Booking> getBookingById(long id) {
        return repo.findById(id);
    }

    public void deleteBooking(long id) {
         repo.deleteById(id);
    }
}
