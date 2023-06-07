package com.ej.company.common_code.command.domain.repo;

import com.ej.company.common_code.command.domain.entity.CommonCodeGroup;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommonCodeGroupRepoCustom {

    Optional<CommonCodeGroup> findByCodeValue(String codeValue);
    Optional<CommonCodeGroup> findByCodeName(String codeName);

    Optional<CommonCodeGroup> findByCodeValueOrName(String codeValue,String codeName);
}
