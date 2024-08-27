package com.pawan.LLD.lld.reviewsystem.service;

import com.pawan.LLD.lld.reviewsystem.dao.ReviewDao;
import com.pawan.LLD.lld.reviewsystem.dto.FeatureDTO;
import com.pawan.LLD.lld.reviewsystem.dto.ReviewDTO;
import com.pawan.LLD.lld.reviewsystem.dto.ReviewSummeryDTO;
import com.pawan.LLD.lld.reviewsystem.enums.ReviewStatus;
import com.pawan.LLD.lld.reviewsystem.manager.ReviewCommunicationManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Pawan Saini
 * Created on 25/08/24.
 */
@Slf4j
@Service
public class ReviewService {

    private final ReviewDao reviewDao;
    private final ReviewCommunicationManager communicationManager;

    @Autowired
    private ReviewService(ReviewDao reviewDao,
                          ReviewCommunicationManager communicationManager) {
        this.reviewDao = reviewDao;
        this.communicationManager = communicationManager;
    }

    public void addReview(ReviewDTO reviewDTO) {
        reviewDTO.setReviewDate(new Date().getTime());
        reviewDTO.setStatus(ReviewStatus.NEW);
        reviewDao.addReview(reviewDTO);
        log.info("Added review by user: {}, for product: {}, review: {}", reviewDTO.getUserId(), reviewDTO.getProductId(), reviewDTO);
    }

    public ReviewSummeryDTO getReviewSummery(Long productId) {
        List<ReviewDTO> reviewDTOS =  reviewDao.getReviewsByProductId(productId);
        Map<String, FeatureDTO> featureReviews = new HashMap<>();
        int totalReview = reviewDTOS.size();
        int sumRating = 0;
        for(ReviewDTO review : reviewDTOS) {
            sumRating+=review.getRating();
            if(!CollectionUtils.isEmpty(review.getFeatures())) {
                for(FeatureDTO featureDTO : review.getFeatures()) {
                    if(!featureReviews.containsKey(featureDTO.getName())) {
                        featureReviews.put(featureDTO.getName(), new FeatureDTO(featureDTO.getName(), 0D, 0));
                    }
                    FeatureDTO featureType = featureReviews.get(featureDTO.getName());
                    featureType.setCount(featureType.getCount()+1);
                    featureType.setRating(featureType.getRating()+featureDTO.getRating());
                }
            }
        }
        List<FeatureDTO> featureDTOList = featureReviews.values().stream()
                .map(featureDTO -> {
                    double featureRating = (double) featureDTO.getRating() / featureDTO.getCount();
                    featureDTO.setRating(featureRating);
                    featureDTO.setCount(null);
                    return featureDTO;
                })
                .toList();
        return ReviewSummeryDTO.builder()
                .totalReview(totalReview)
                .totalRating((double) sumRating/totalReview)
                .featureReview(featureDTOList)
                .build();
    }

    public List<ReviewDTO> getUserReviews(Long userId, Long productId) {
        return reviewDao.getRatingByUserIdOrProductId(userId, productId);
    }

    public List<ReviewDTO> getUserReviewsByFeature(Long productId, String featureName) {
        List<ReviewDTO> reviewDTOS = reviewDao.getRatingByUserIdOrProductId(null, productId);
        return reviewDTOS.stream()
                .filter(reviewDTO -> {
                    if (!CollectionUtils.isEmpty(reviewDTO.getFeatures())) {
                        for(FeatureDTO featureDTO : reviewDTO.getFeatures()) {
                            if(featureDTO.getName().equals(featureName)) {
                                return true;
                            }
                        }
                    }
                    return false;
                })
                .toList();
    }

    public List<ReviewDTO> getTopReviews(Long productId) {
        List<ReviewDTO> reviewDTOS = reviewDao.getRatingByUserIdOrProductId(null, productId);
        return reviewDTOS.stream()
                .filter(reviewDTO -> reviewDTO.getRating() >= 4)
                .toList();
    }

    public List<ReviewDTO> getReviewsByDate(Long productId, Long date, Boolean asc) {
        List<ReviewDTO> reviewDTOS = reviewDao.getRatingByUserIdOrProductId(null, productId);
        List<ReviewDTO> result = new java.util.ArrayList<>(reviewDTOS.stream()
                .filter(reviewDTO -> reviewDTO.getReviewDate() >= date)
                .toList());
        if(Boolean.TRUE.equals(asc)) {
            result.sort(Comparator.comparing(ReviewDTO::getReviewDate));
            return result;
        }
        result.sort(Comparator.comparing(ReviewDTO::getReviewDate).reversed());
        return result;
    }

    public List<ReviewDTO> getCertifiedReviews(Long productId) {
        List<ReviewDTO> reviewDTOS = reviewDao.getRatingByUserIdOrProductId(null, productId);
        return reviewDTOS.stream()
                .filter(reviewDTO -> reviewDTO.getStatus() == ReviewStatus.APPROVED)
                .toList();
    }

    public List<ReviewDTO> getReviewsHavingImages(Long productId) {
        List<ReviewDTO> reviewDTOS = reviewDao.getRatingByUserIdOrProductId(null, productId);
        return reviewDTOS.stream()
                .filter(reviewDTO -> !CollectionUtils.isEmpty(reviewDTO.getImages()))
                .toList();
    }

    public void updateReviewStatus(Long reviewId, ReviewStatus status) {
        ReviewDTO reviewDTO = reviewDao.getReviewById(reviewId);
        if(Objects.isNull(reviewId)) {
            throw new RuntimeException("Review not exist in the system with this id.");
        }
        reviewDTO.setStatus(status);
        reviewDao.updateReview(reviewDTO);
        communicationManager.sendCommForReviewUpdate(reviewDTO);
        log.info("Updated review with status: {}, for product: {}, review: {}", status, reviewDTO.getProductId(), reviewDTO);
    }
}
