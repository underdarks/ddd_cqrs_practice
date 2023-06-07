package com.ej.company.common_code.query.dto;

import com.ej.company.common_code.command.domain.entity.CommonCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommonCodeResDto {

    @ApiModelProperty(value = "PK")
    private Long id;

    @ApiModelProperty(value = "코드값")
    private String codeValue;

    @ApiModelProperty(value = "코드명")
    private String codeName;


    public static CommonCodeResDto toDto(CommonCode commonCode){
        CommonCodeResDto commonCodeResDto = new CommonCodeResDto();

        commonCodeResDto.id=commonCode.getId();
        commonCodeResDto.codeName=commonCode.getCommonCodeValue().getName();
        commonCodeResDto.codeValue=commonCode.getCommonCodeValue().getValue();

        return commonCodeResDto;
    }
}
