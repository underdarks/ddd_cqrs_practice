package com.ej.company.common_code.command.domain.repo;

import com.ej.company.common_code.command.domain.entity.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonCodeRepo extends JpaRepository<CommonCode,Long>, CommonCodeRepoCustom {

}
