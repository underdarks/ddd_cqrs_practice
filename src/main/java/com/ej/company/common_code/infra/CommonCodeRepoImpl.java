package com.ej.company.common_code.infra;

import static com.ej.company.common_code.command.domain.entity.QCommonCode.*;
import static com.ej.company.common_code.command.domain.entity.QCommonCodeGroup.commonCodeGroup;

import com.ej.company.common_code.command.domain.repo.CommonCodeRepoCustom;
import com.ej.company.common_code.query.dto.CommonCodeResDto;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommonCodeRepoImpl implements CommonCodeRepoCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<CommonCodeResDto> findByCodeValueOrName(String codeValue,
        String codeName) {
        return Optional.ofNullable(queryFactory
            .select(getConstructor())
            .from(commonCode)
            .where(allOr(codeValue, codeName))
            .fetchOne()
        );
    }

    @Override
    public Page<CommonCodeResDto> findByGroupCode(Long groupCodeId, Pageable pageable) {
        List<CommonCodeResDto> content = queryFactory.select(getConstructor())
            .from(commonCode)
            .leftJoin(commonCode.commonCodeGroup, commonCodeGroup)
            .where(codeGroupIdEq(groupCodeId))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        JPAQuery<Long> countQuery = queryFactory
            .select(commonCode.count())
            .from(commonCode)
            .where(codeGroupIdEq(groupCodeId));

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private static BooleanExpression codeGroupIdEq(Long groupCodeId) {
        return commonCodeGroup.id.eq(groupCodeId);
    }

    private ConstructorExpression<CommonCodeResDto> getConstructor() {
        return Projections.constructor(CommonCodeResDto.class, commonCode.id.as("id"),
            commonCode.commonCodeValue.value.as("codeValue"),
            commonCode.commonCodeValue.name.as("codeName"));
    }

    private BooleanExpression codeNameEq(String codeName) {
        return Objects.nonNull(codeName) ? commonCode.commonCodeValue.name.eq(codeName) : null;
    }

    private BooleanExpression codeValueEq(String codeValue) {
        return Objects.nonNull(codeValue) ? commonCode.commonCodeValue.value.eq(codeValue)
            : null;
    }

    private BooleanExpression allOr(String codeValue, String codeName) {
        return codeValueEq(codeValue).or(codeNameEq(codeName));
    }
}
