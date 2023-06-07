package com.ej.company.common_code.command.domain;

import static org.assertj.core.api.Assertions.*;

import com.ej.company.common_code.command.domain.entity.CommonCode;
import com.ej.company.common_code.command.domain.entity.CommonCodeGroup;
import com.ej.company.common_code.command.domain.entity.CommonCodeValue;
import com.ej.company.common_code.command.domain.repo.CommonCodeGroupRepo;
import com.ej.company.common_code.command.domain.repo.CommonCodeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class CommonCodeGroupTest {

    @Autowired
    private CommonCodeRepo commonCodeRepo;

    @Autowired
    private CommonCodeGroupRepo commonCodeGroupRepo;


    public CommonCodeValue getCommonCodeValue(String value,String name){
        return CommonCodeValue.of(value, name);
    }


    @Commit
    @Test
    public void 공통코드_저장() {
        //given
        CommonCodeValue groupCodeValue = getCommonCodeValue("GROUP_CODE1", "그룹코드명1");
        CommonCodeValue codeValue = getCommonCodeValue("CODE1", "코드명1");

        CommonCodeGroup commonCodeGroup = CommonCodeGroup.of(groupCodeValue);

        //when
        CommonCodeGroup saveEntityGroup = commonCodeGroupRepo.save(commonCodeGroup);

        CommonCode commonCode = CommonCode.of(codeValue, saveEntityGroup);
        CommonCode saveEntityCode = commonCodeRepo.save(commonCode);

        //then
        assertThat(saveEntityCode.getCommonCodeValue().getName()).isEqualTo("코드명1");
    }


    @Test
    public void 공통코드_조회_테스트() {
        //given
        //when
        CommonCode commonCode = commonCodeRepo.findById(1L).orElseThrow();

        //then
        assertThat(commonCode.getCommonCodeValue().getValue()).isEqualTo("CODE1");
    }

    @Commit
    @Test
    public void 공통코드_수정_테스트() {
        //given
        //when
        CommonCode commonCode = commonCodeRepo.findById(1L).orElseThrow();

        //then
        commonCode.getCommonCodeValue().changeName("코드명변경!");
    }

}