package com.graphQl.learn.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDtoRequest {
    private String name;
    private String author;
    private float price;
    private int page;
}
