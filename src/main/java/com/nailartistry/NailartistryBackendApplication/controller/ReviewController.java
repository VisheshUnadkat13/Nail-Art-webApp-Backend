package com.nailartistry.NailartistryBackendApplication.controller;

import com.nailartistry.NailartistryBackendApplication.model.Review;
import com.nailartistry.NailartistryBackendApplication.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReview()
    {
        List<Review> reviews=reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> getReviewsById(@PathVariable long id)
    {
        Optional<Review> review=reviewService.getReviewById(id);

        if(review.isPresent())
        {
            return new ResponseEntity<>(review,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review)
    {
        Review savedReview=reviewService.savedReview(review);
        return new ResponseEntity<>(savedReview,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
   public ResponseEntity<HttpStatus> deleteReview(@PathVariable long id)
    {
        try{
            reviewService.deleteReviewById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
