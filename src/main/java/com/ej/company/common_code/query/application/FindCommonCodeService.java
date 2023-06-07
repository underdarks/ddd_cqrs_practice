package com.ej.company.common_code.query.application;

import com.ej.company.common_code.command.domain.entity.CommonCode;
import com.ej.company.common_code.command.domain.repo.CommonCodeRepo;
import com.ej.company.common_code.query.dto.CommonCodeResDto;
import com.ej.company.common_code.query.dto.PageResDto;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FindCommonCodeService {

    private final CommonCodeRepo commonCodeRepo;

    public CommonCodeResDto getCommonCodeById(Long id) {
        CommonCode commonCode = commonCodeRepo.findById(id)
            .orElseThrow(EntityNotFoundException::new);

        //dto<-> entity 변환에서 mapstruct는 의존성이 생겨서 사용하지 않음
        return CommonCodeResDto.toDto(commonCode);
    }

    public PageResDto getCommonCodesByGroupCodeId(Long groupCodeId, Pageable pageable) {
        Page<CommonCodeResDto> page = commonCodeRepo.findByGroupCode(groupCodeId, pageable);

        return new PageResDto(page);
    }


}
