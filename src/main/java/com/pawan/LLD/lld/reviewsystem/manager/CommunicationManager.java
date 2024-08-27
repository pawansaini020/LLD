package com.pawan.LLD.lld.reviewsystem.manager;

import com.pawan.LLD.lld.reviewsystem.dto.ReviewDTO;

/**
 * @author Pawan Saini
 * Created on 27/08/24.
 */
public interface CommunicationManager {

    public void sendCommForReviewUpdate(ReviewDTO reviewDTO);
}
