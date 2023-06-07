package com.ej.company.common_code.query.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class CommonCodeGroupSearchDto {

    @ApiModelProperty(value = "코드값")
    private String codeValue;

    @ApiModelProperty(value = "코드명")
    private String codeName;
}
