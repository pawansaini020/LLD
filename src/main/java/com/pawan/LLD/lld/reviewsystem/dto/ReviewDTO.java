package com.pawan.LLD.lld.reviewsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pawan.LLD.lld.reviewsystem.enums.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 25/08/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewDTO extends BaseDTO {

    @NonNull
    private Long productId;
    @NonNull
    private Long userId;
    @NonNull
    private Integer rating;
    private String title;
    private String description;
    private Long reviewDate;
    private ReviewStatus status;
    private List<ImageDTO> images = new ArrayList<>();
    private List<FeatureDTO> features = new ArrayList<>();
}
