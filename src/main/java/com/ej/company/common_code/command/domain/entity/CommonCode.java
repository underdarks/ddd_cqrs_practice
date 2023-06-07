package com.ej.company.common_code.command.domain.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Table(name = "common_code", schema = "ejm_db")
@DynamicUpdate
@NoArgsConstructor
public class CommonCode extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CommonCodeValue commonCodeValue;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_common_code_id")
    private CommonCodeGroup commonCodeGroup;


    /**
     * 양방향 매핑
     */
    private void addCommonCodeGroup(CommonCodeGroup commonCodeGroup){
        this.commonCodeGroup=commonCodeGroup;
        commonCodeGroup.setCommonCode(this);
    }

    public static CommonCode of(CommonCodeValue commonCodeValue, CommonCodeGroup commonCodeGroup) {
        CommonCode commonCode = new CommonCode();
        commonCode.commonCodeValue = commonCodeValue;
        commonCode.addCommonCodeGroup(commonCodeGroup);

        return commonCode;
    }


}
