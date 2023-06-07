package com.ej.company.common_code.command.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Table(name = "group_common_code", schema = "ejm_db")
@DynamicUpdate
@NoArgsConstructor
public class CommonCodeGroup extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CommonCodeValue commonCodeValue;

    @OneToMany(mappedBy = "commonCodeGroup", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CommonCode> commonCodes = new ArrayList<>();

    /**
     * 양방향 매핑
     */
    public void setCommonCode(CommonCode commonCode) {
        if (Objects.nonNull(commonCode)) {
            this.commonCodes.add(commonCode);
        }
    }

    public static CommonCodeGroup of(CommonCodeValue commonCodeValue) {
        CommonCodeGroup commonCodeGroup = new CommonCodeGroup();
        commonCodeGroup.commonCodeValue = commonCodeValue;

        return commonCodeGroup;
    }

    public void updateEntity(String value,String name){
        this.commonCodeValue.changeValue(value);
        this.commonCodeValue.changeName(name);
    }
}
