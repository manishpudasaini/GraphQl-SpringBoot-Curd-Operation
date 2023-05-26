package com.graphQl.learn.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class BookDtoResponse {
    private String name;
    private String author;
    private float price;
    private int page;
}
