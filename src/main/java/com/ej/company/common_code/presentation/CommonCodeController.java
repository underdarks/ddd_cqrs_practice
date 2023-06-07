package com.ej.company.common_code.presentation;

import com.ej.company.common_code.command.application.SaveCommonCodeService;
import com.ej.company.common_code.command.domain.dto.CommonCodeReqDto;
import com.ej.company.commons.response.CommonResEntity;
import com.ej.company.commons.response.CommonResMessage;
import com.ej.company.commons.response.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "공통 코드")
@RestController
@RequestMapping("api/v1/common-code")
@RequiredArgsConstructor
public class CommonCodeController {

    private final SaveCommonCodeService saveCommonCodeService;

    @ApiOperation(value = "공통 코드 엔티티 저장", notes = "공통 코드 엔티티를 저장한다.")
    @PostMapping
    public ResponseEntity<CommonResEntity> saveCommonCode(@RequestBody @Valid CommonCodeReqDto dto) {
        saveCommonCodeService.saveCommonCode(dto);

        return new ResponseEntity<>(
            CommonResEntity.createResponse(StatusCode.CREATED,
                CommonResMessage.CREATED_COMMON_CODE_SUCCESS),
            HttpStatus.CREATED
        );
    }

}
