package com.ej.company.common_code.command.application;


import com.ej.company.common_code.command.domain.dto.CommonCodeReqDto;
import com.ej.company.common_code.command.domain.entity.CommonCode;
import com.ej.company.common_code.command.domain.entity.CommonCodeGroup;
import com.ej.company.common_code.command.domain.entity.CommonCodeValue;
import com.ej.company.common_code.command.domain.repo.CommonCodeGroupRepo;
import com.ej.company.common_code.command.domain.repo.CommonCodeRepo;
import com.ej.company.common_code.query.dto.CommonCodeResDto;
import com.ej.company.commons.exception.exception_handler.ExceptionType;
import com.ej.company.commons.exception.exceptions.CommonApiExceptions;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class SaveCommonCodeService {

    private final CommonCodeRepo commonCodeRepo;
    private final CommonCodeGroupRepo commonCodeGroupRepo;

    public void saveCommonCode(CommonCodeReqDto dto) {
        CommonCodeGroup commonCodeGroup = commonCodeGroupRepo.findById(dto.getCommonCodeGroupId())
            .orElseThrow(EntityNotFoundException::new);
        CommonCodeValue commonCodeValue = CommonCodeValue.of(dto.getCodeValue(), dto.getCodeName());

        validateCommonCode(dto);
        CommonCode commonCode = CommonCode.of(commonCodeValue, commonCodeGroup);
        commonCodeRepo.save(commonCode);
    }

    /**
     * 예상 기능 요구 사항 : 코드값, 코드명 중복체크
     */
    private void validateCommonCode(CommonCodeReqDto dto) {
        Optional<CommonCodeResDto> byCodeValueOrName = commonCodeRepo.findByCodeValueOrName(
            dto.getCodeValue(),
            dto.getCodeName());

        byCodeValueOrName
            .ifPresent(v -> {
                throw CommonApiExceptions.of(ExceptionType.DUPLICATE_VALUE_EXCEPTION,
                    "중복 코드값이 존재합니다!");
            });
    }


}
