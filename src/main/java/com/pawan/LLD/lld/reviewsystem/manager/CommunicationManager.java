package com.pawan.LLD.lld.reviewsystem.manager;

import com.pawan.LLD.lld.reviewsystem.dto.ReviewDTO;


public interface CommunicationManager {

    public void sendCommForReviewUpdate(ReviewDTO reviewDTO);
}
