package com.sda.restdemo.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageDTO<T> {
    private int totalPages;
    private long totalElements;
    private boolean last;
    private boolean first;
    private boolean empty;
    private List<T> content;

    public void map(Page<T> page) {
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.last = page.isLast();
        this.first = page.isFirst();
        this.empty = page.isEmpty();
        this.content = page.getContent();
    }

}

