package com.nailartistry.NailartistryBackendApplication.repo;

import com.nailartistry.NailartistryBackendApplication.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
}
