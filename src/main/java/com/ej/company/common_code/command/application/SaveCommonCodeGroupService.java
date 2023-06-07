package com.ej.company.common_code.command.application;

import com.ej.company.common_code.command.domain.dto.CommonCodeGroupReqDto;
import com.ej.company.common_code.command.domain.entity.CommonCodeGroup;
import com.ej.company.common_code.command.domain.entity.CommonCodeValue;
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
public class SaveCommonCodeGroupService {

    private final CommonCodeGroupRepo commonCodeGroupRepo;

    public void save(CommonCodeGroupReqDto dto) {
        CommonCodeValue commonCodeValue = CommonCodeValue.of(dto.getCodeValue(), dto.getCodeName());
        CommonCodeGroup commonCodeGroup = CommonCodeGroup.of(commonCodeValue);

        validateCommonCodeGroup(commonCodeGroup);
        commonCodeGroupRepo.save(commonCodeGroup);
        log.info("공통코드 그룹 저장 완료");
    }


    /**
     * 예상 기능 요구 사항 : 코드값, 코드명 중복체크
     */
    private void validateCommonCodeGroup(CommonCodeGroup commonCodeGroup) {
        validateCodeValueDuplication(commonCodeGroup.getCommonCodeValue().getValue());
        validateCodeNameDuplication(commonCodeGroup.getCommonCodeValue().getName());
    }

    //코드값 중복 확인
    private void validateCodeValueDuplication(String codeValue) {
        commonCodeGroupRepo.findByCodeValue(codeValue)
            .ifPresent(v -> {
                throw CommonApiExceptions.of(ExceptionType.DUPLICATE_VALUE_EXCEPTION,
                    "중복 코드값이 존재합니다!");
            });
    }

    //코드명 중복 확인
    private void validateCodeNameDuplication(String codeName) {
        commonCodeGroupRepo.findByCodeName(codeName)
            .ifPresent(v -> {
                    throw CommonApiExceptions.of(ExceptionType.DUPLICATE_NAME_EXCEPTION,
                        "중복 코드명이 존재합니다!");
                }
            );
    }

}
