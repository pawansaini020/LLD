package com.pawan.LLD.lld.reviewsystem.manager;

import com.pawan.LLD.lld.reviewsystem.dto.ReviewDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Pawan Saini
 * Created on 27/08/24.
 */
@Slf4j
@Component
public class ReviewCommunicationManager implements CommunicationManager {

    @Override
    public void sendCommForReviewUpdate(ReviewDTO reviewDTO) {
        log.info("Sending communication of review update with status: {}, for product: {}, review: {}", reviewDTO.getStatus(), reviewDTO.getProductId(), reviewDTO);
    }
}
