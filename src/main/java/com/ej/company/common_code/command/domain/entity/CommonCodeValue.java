package com.ej.company.common_code.command.domain.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 코드 명, 이름 공통 값 타임
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "of")
public class CommonCodeValue {

    @Column(name = "code_value")
    private String value;   //코드 값

    @Column(name = "code_name")
    private String name;    //코드 명


    public void changeValue(String value) {
        if (Objects.nonNull(value)) {
            this.value = value;
        }
    }

    public void changeName(String name) {
        if (Objects.nonNull(name)) {
            this.name = name;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonCodeValue that = (CommonCodeValue) o;
        return Objects.equals(value, that.value) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, name);
    }
}
