package com.ej.company.common_code.presentation;

import com.ej.company.common_code.command.application.SaveCommonCodeGroupService;
import com.ej.company.common_code.command.application.UpdateCommonCodeGroupService;
import com.ej.company.common_code.query.dto.CommonCodeGroupResDto;
import com.ej.company.common_code.command.domain.dto.CommonCodeGroupReqDto;
import com.ej.company.common_code.command.domain.dto.CommonCodeGroupUpdateDto;
import com.ej.company.commons.response.CommonResEntity;
import com.ej.company.commons.response.CommonResMessage;
import com.ej.company.commons.response.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "공통 코드 그룹")
@RestController
@RequestMapping("api/v1/common-code-group")
@RequiredArgsConstructor
public class CommonCodeGroupController {

    private final SaveCommonCodeGroupService saveCommonCodeGroupService;

    private final UpdateCommonCodeGroupService updateCommonCodeGroupService;

    @ApiOperation(value = "공통 코드 그룹 저장", notes = "공통 코드 그룹을 저장한다")
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
    })
    @PostMapping
    public ResponseEntity<CommonResEntity> saveCommonGroupCode(
        @RequestBody @Valid CommonCodeGroupReqDto dto) {
        saveCommonCodeGroupService.save(dto);

        return new ResponseEntity<>(
            CommonResEntity.createResponse(StatusCode.CREATED,
                CommonResMessage.CREATED_COMMON_CODE_GROUP_SUCCESS),
            HttpStatus.CREATED
        );
    }

    @ApiOperation(value = "공통 코드 그룹 수정", notes = "공통 코드 그룹을 수정한다.")
    @ApiResponses({
        @ApiResponse(code = 201, message = "성공"),
    })
    @PatchMapping("/{id}")
    public ResponseEntity<CommonResEntity> updateCommonGroupCode(
        @PathVariable(value = "id") Long id, CommonCodeGroupUpdateDto dto) {
        CommonCodeGroupResDto resDto = updateCommonCodeGroupService.update(id, dto);

        return new ResponseEntity<>(
            CommonResEntity.createResponse(StatusCode.OK, CommonResMessage.UPDATE_COMMON_CODE_GROUP_SUCCESS, resDto),
            HttpStatus.OK
        );
    }

}
