package com.pawan.LLD.lld.reviewsystem.validation;

import com.pawan.LLD.lld.reviewsystem.dto.ReviewDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Slf4j
@Component
public class ReviewValidation {

    public Boolean validateReviewRequest(ReviewDTO reviewDTO) {
        if(Objects.isNull(reviewDTO.getProductId()) || Objects.isNull(reviewDTO.getUserId()) || Objects.isNull(reviewDTO.getRating())) {
            throw new RuntimeException("ProductId, UserId or Rating can not be empty.");
        }
        return true;
    }
}
