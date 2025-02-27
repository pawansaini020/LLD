package com.pawan.LLD;

import com.pawan.LLD.dto.Slot;

import java.util.List;
import java.util.Optional;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */
public interface SlotRecommendationStrategy {

    Optional<Slot> recommend(List<Slot> slots, String userId);
}
