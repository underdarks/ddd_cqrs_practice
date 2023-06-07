package com.ej.company.common_code.command.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommonCodeReqDto {

    @ApiModelProperty(value = "공통 코드 그룹 ID", required = true)
    @NotNull(message = "공통 코드 그룹 ID값은 필수입니다.")
    private Long commonCodeGroupId;

    @ApiModelProperty(value = "코드값", required = true)
    @NotEmpty(message = "코드값은 필수값입니다!")
    private String codeValue;

    @ApiModelProperty(value = "코드명", required = true)
    @NotEmpty(message = "코드명은 필수값입니다!")
    private String codeName;
}
