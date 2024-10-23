package com.pawan.LLD.lld.reviewsystem.manager;

import com.pawan.LLD.lld.reviewsystem.dto.ReviewDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ReviewCommunicationManager implements CommunicationManager {

    @Override
    public void sendCommForReviewUpdate(ReviewDTO reviewDTO) {
        log.info("Sending communication of review update with status: {}, for product: {}, review: {}", reviewDTO.getStatus(), reviewDTO.getProductId(), reviewDTO);
    }
}
