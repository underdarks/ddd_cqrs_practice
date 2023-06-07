package com.ej.company.common_code.query.dto;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class CommonCodeGroupResDto {

    @ApiModelProperty(value = "PK")
    private Long id;

    @ApiModelProperty(value = "코드값")
    private String codeValue;

    @ApiModelProperty(value = "코드명")
    private String codeName;

}
