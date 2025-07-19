package com.nailartistry.NailartistryBackendApplication.repo;

import com.nailartistry.NailartistryBackendApplication.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {
}
