package com.ej.company.common_code.infra;

import static com.ej.company.common_code.command.domain.entity.QCommonCodeGroup.*;
import static org.springframework.util.StringUtils.*;

import com.ej.company.common_code.command.domain.entity.CommonCode;
import com.ej.company.common_code.command.domain.entity.CommonCodeGroup;
import com.ej.company.common_code.command.domain.entity.QCommonCodeGroup;
import com.ej.company.common_code.command.domain.repo.CommonCodeGroupRepoCustom;
import com.ej.company.common_code.command.domain.repo.CommonCodeRepoCustom;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
@RequiredArgsConstructor
public class CommonCodeGroupRepoImpl implements CommonCodeGroupRepoCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<CommonCodeGroup> findByCodeValue(String codeValue) {
        return Optional.ofNullable(
            queryFactory.selectFrom(commonCodeGroup)
                .where(codeValueEq(codeValue))
                .fetchOne()
        );
    }

    @Override
    public Optional<CommonCodeGroup> findByCodeName(String codeName) {
        return Optional.ofNullable(
            queryFactory.selectFrom(commonCodeGroup)
                .where(codeNameEq(codeName))
                .fetchOne()
        );
    }

    @Override
    public Optional<CommonCodeGroup> findByCodeValueOrName(String codeValue, String codeName) {
        return Optional.ofNullable(
            queryFactory.selectFrom(commonCodeGroup)
                .where(allOr(codeValue,codeName))
                .fetchOne()
        );
    }

    private BooleanExpression codeNameEq(String codeName){
        return Objects.nonNull(codeName) ? commonCodeGroup.commonCodeValue.name.eq(codeName) : null;
    }

    private BooleanExpression codeValueEq(String codeValue){
        return Objects.nonNull(codeValue) ? commonCodeGroup.commonCodeValue.value.eq(codeValue) : null;
    }

    private BooleanExpression allOr(String codeValue, String codeName){
        return codeValueEq(codeValue).or(codeNameEq(codeName));
    }
}
