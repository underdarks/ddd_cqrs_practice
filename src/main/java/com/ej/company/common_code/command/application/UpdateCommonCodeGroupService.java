package com.ej.company.common_code.command.application;

import com.ej.company.common_code.query.dto.CommonCodeGroupResDto;
import com.ej.company.common_code.command.domain.dto.CommonCodeGroupUpdateDto;
import com.ej.company.common_code.command.domain.entity.CommonCodeGroup;
import com.ej.company.common_code.command.domain.repo.CommonCodeGroupRepo;
import com.ej.company.commons.exception.exception_handler.ExceptionType;
import com.ej.company.commons.exception.exceptions.CommonApiExceptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UpdateCommonCodeGroupService {

    private final CommonCodeGroupRepo commonCodeGroupRepo;

    public CommonCodeGroupResDto update(Long id, CommonCodeGroupUpdateDto dto) {
        CommonCodeGroup commonCodeGroup = commonCodeGroupRepo.findById(id).orElseThrow(
            () -> CommonApiExceptions.of(ExceptionType.ENTITY_NOT_FOUND_EXCEPTION,
                "엔티티를 찾을 수 없습니다."));

        commonCodeGroup.updateEntity(dto.getCodeValue(), dto.getCodeName());
        log.info("공통코드 그룹 수정 완료");

        return CommonCodeGroupResDto.of(commonCodeGroup.getId(),
            commonCodeGroup.getCommonCodeValue().getValue(),
            commonCodeGroup.getCommonCodeValue().getName()
        );
    }

}
