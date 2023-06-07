package com.ej.company.common_code.command.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 엔티티 공통 필드 추상 클래스
 */
@MappedSuperclass
@Getter
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "REG_DATE", updatable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime regDate; //등록시간

    @LastModifiedDate
    @Column(name = "MOD_DATE")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime modDate; //수정시간

}
