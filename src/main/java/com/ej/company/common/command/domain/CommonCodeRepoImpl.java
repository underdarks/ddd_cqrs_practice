package com.ej.company.common.command.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommonCodeRepoImpl implements CommonCodeRepoCustom {

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager em;



}
