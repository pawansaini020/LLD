package com.pawan.LLD.lld.reviewsystem.controller;

import com.pawan.LLD.lld.reviewsystem.dto.ReviewDTO;
import com.pawan.LLD.lld.reviewsystem.enums.ReviewStatus;
import com.pawan.LLD.lld.reviewsystem.service.ReviewService;
import com.pawan.LLD.lld.reviewsystem.validation.ReviewValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author Pawan Saini
 * Created on 25/08/24.
 */
@RestController
@RequestMapping(value = "/review-system/api/v1/review")
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewValidation reviewValidation;

    @Autowired
    private ReviewController(ReviewService reviewService,
                             ReviewValidation reviewValidation) {
        this.reviewService = reviewService;
        this.reviewValidation = reviewValidation;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addReview(@RequestBody ReviewDTO reviewDTO) {
        reviewValidation.validateReviewRequest(reviewDTO);
        reviewService.addReview(reviewDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/get/summery")
    public ResponseEntity<?> getReviewSummery(@RequestParam(value = "product_id") Long productId) {
        return new ResponseEntity<>(reviewService.getReviewSummery(productId), HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<?> getUserReviews(@RequestParam(value = "user_id", required = false) Long userId,
                                            @RequestParam(value = "product_id", required = false) Long productId) {
        if(Objects.isNull(userId) && Objects.isNull(productId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(reviewService.getUserReviews(userId, productId), HttpStatus.OK);
    }

    @GetMapping(value = "/get/feature")
    public ResponseEntity<?> getUserReviewsByFeature(@RequestParam(value = "product_id") Long productId,
                                            @RequestParam(value = "feature_name") String featureName) {
        return new ResponseEntity<>(reviewService.getUserReviewsByFeature(productId, featureName), HttpStatus.OK);
    }

    @GetMapping(value = "/get/top-review")
    public ResponseEntity<?> getTopReviews(@RequestParam(value = "product_id") Long productId) {
        return new ResponseEntity<>(reviewService.getTopReviews(productId), HttpStatus.OK);
    }

    @GetMapping(value = "/get/review-by-date")
    public ResponseEntity<?> getReviewsByDate(@RequestParam(value = "product_id") Long productId,
                                              @RequestParam(value = "date") Long date,
                                              @RequestParam(value = "asc") Boolean asc) {
        return new ResponseEntity<>(reviewService.getReviewsByDate(productId, date, asc), HttpStatus.OK);
    }

    @GetMapping(value = "/get/certified-review")
    public ResponseEntity<?> getCertifiedReviews(@RequestParam(value = "product_id") Long productId) {
        return new ResponseEntity<>(reviewService.getCertifiedReviews(productId), HttpStatus.OK);
    }

    @GetMapping(value = "/get/review-having-image")
    public ResponseEntity<?> getReviewsHavingImages(@RequestParam(value = "product_id") Long productId) {
        return new ResponseEntity<>(reviewService.getReviewsHavingImages(productId), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{review_id}")
    public ResponseEntity<?> updateReviewStatus(@PathVariable(value = "review_id") Long reviewId,
                                                @RequestParam(value = "status") ReviewStatus status) {
        reviewService.updateReviewStatus(reviewId, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
