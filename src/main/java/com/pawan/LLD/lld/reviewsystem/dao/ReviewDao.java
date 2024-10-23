package com.pawan.LLD.lld.reviewsystem.dao;

import com.pawan.LLD.lld.reviewsystem.dto.FeatureDTO;
import com.pawan.LLD.lld.reviewsystem.dto.ReviewDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class ReviewDao {

    ConcurrentHashMap<Long, ReviewDTO> REVIEW_MAP = new ConcurrentHashMap<>();

    public void addReview(ReviewDTO reviewDTO) {
        Long id = new Random().nextLong(0, Long.MAX_VALUE);
        while(REVIEW_MAP.containsKey(id)) {
            id = new Random().nextLong(0, Long.MAX_VALUE);
        }
        reviewDTO.setId(id);
        REVIEW_MAP.put(id, reviewDTO);
    }

    public List<ReviewDTO> getReviewsByProductId(Long productId) {
        return REVIEW_MAP.values().stream()
                .filter(reviewDTO -> reviewDTO.getProductId() == productId)
                .toList();
    }

    public List<ReviewDTO> getRatingByUserIdOrProductId(Long userId, Long productId) {
        return REVIEW_MAP.values().stream()
                .filter(reviewDTO -> Objects.isNull(userId) || reviewDTO.getUserId() == userId)
                .filter(reviewDTO -> Objects.isNull(productId) || reviewDTO.getProductId() == productId)
                .toList();
    }

    public ReviewDTO getReviewById(Long reviewId) {
        return REVIEW_MAP.get(reviewId);
    }

    public void updateReview(ReviewDTO reviewDTO) {
        REVIEW_MAP.put(reviewDTO.getId(), reviewDTO);
    }
}
