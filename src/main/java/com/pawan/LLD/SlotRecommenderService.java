package com.pawan.LLD;

import com.pawan.LLD.dto.Slot;

import java.util.List;
import java.util.Optional;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */
public class SlotRecommenderService {

    private SlotRecommendationStrategy strategy;

    public void setStrategy(SlotRecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public Optional<Slot> recommendSlot(List<Slot> slots, String userId) {
        return strategy.recommend(slots, userId);
    }
}
