package com.ej.company.common_code.presentation;

import com.ej.company.common_code.query.application.FindCommonCodeService;
import com.ej.company.common_code.query.dto.CommonCodeResDto;
import com.ej.company.common_code.query.dto.PageResDto;
import com.ej.company.commons.response.CommonResEntity;
import com.ej.company.commons.response.CommonResMessage;
import com.ej.company.commons.response.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "공통 코드")
@RestController
@RequestMapping("api/v1/common-codes")
@RequiredArgsConstructor
public class FindCommonCodeController {

    private final FindCommonCodeService findCommonCodeService;

    @ApiOperation(value = "공통 코드 단일 조회", notes = "id 값으로 공통 코드를 단일 조회한다")
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<CommonResEntity> findCommonCodeGroup(
        @PathVariable(value = "id") Long id) {

        CommonCodeResDto resDto = findCommonCodeService.getCommonCodeById(id);

        return new ResponseEntity<>(
            CommonResEntity.createResponse(StatusCode.OK,
                CommonResMessage.FIND_COMMON_CODE_SUCCESS, resDto),
            HttpStatus.OK
        );
    }

    @ApiOperation(value = "특정 그룹의 코드 리스트 조회", notes = "특정 그룹의 코드를 조회한다.")
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
    })
    @GetMapping()
    public ResponseEntity<PageResDto> findCommonCodeGroups(
        @RequestParam(value = "codeGroupId") Long id, Pageable pageable) {

        PageResDto resDto = findCommonCodeService.getCommonCodesByGroupCodeId(id,
            pageable);

        return new ResponseEntity<>(resDto,HttpStatus.OK);
    }

}
