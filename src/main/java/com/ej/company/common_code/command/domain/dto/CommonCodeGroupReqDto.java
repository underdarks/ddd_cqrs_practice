package com.ej.company.common_code.command.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeGroupReqDto {

    @ApiModelProperty(value = "코드값", required = true)
    @NotEmpty(message = "코드값은 필수값입니다!")
    private String codeValue;

    @ApiModelProperty(value = "코드명", required = true)
    @NotEmpty(message = "코드명은 필수값입니다!")
    private String codeName;
}
