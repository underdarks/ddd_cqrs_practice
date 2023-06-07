package com.ej.company.common_code.command.domain.repo;

import com.ej.company.common_code.command.domain.entity.CommonCode;
import com.ej.company.common_code.query.dto.CommonCodeGroupResDto;
import com.ej.company.common_code.query.dto.CommonCodeResDto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommonCodeRepoCustom {

    /**
     * 1. 페이징 쿼리
     * 2. 조회 쿼리
     * 3.
     */


    Optional<CommonCodeResDto> findByCodeValueOrName(String codeValue, String codeName);

    Page<CommonCodeResDto> findByGroupCode(Long groupCodeId, Pageable pageable);
}
