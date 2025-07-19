package com.nailartistry.NailartistryBackendApplication.service;

import com.nailartistry.NailartistryBackendApplication.model.Review;
import com.nailartistry.NailartistryBackendApplication.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    public Review savedReview(Review review) {
        return reviewRepo.save(review);
    }

    public void deleteReviewById(long id) {
        reviewRepo.deleteById(id);
    }

    public Optional<Review> getReviewById(long id) {
        return reviewRepo.findById(id);
    }
}
