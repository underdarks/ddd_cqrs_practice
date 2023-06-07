package com.ej.company.common_code.command.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommonCodeGroupUpdateDto {

    @ApiModelProperty(value = "코드값", required = true)
    private String codeValue;

    @ApiModelProperty(value = "코드명", required = true)
    private String codeName;
}
