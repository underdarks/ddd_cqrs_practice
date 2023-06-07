package com.ej.company.common_code.query.dto;

import com.ej.company.common_code.command.domain.entity.CommonCodeGroup;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class PageResDto<T>{

    private List<T> data;
    private int pageNumber;
    private int totalPages;
    private int totalCount;


    public PageResDto(Page<T> page) {
        this.data = page.getContent();
        this.pageNumber = page.getNumber();
        this.totalPages = page.getTotalPages();
        this.totalCount = page.getSize();
    }
}
