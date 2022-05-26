package com.example.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {
    private long Id;
    private String resourceTitle;
    private Collection<StartDTO> starts;
}
