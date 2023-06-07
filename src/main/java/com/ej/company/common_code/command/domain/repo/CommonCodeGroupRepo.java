package com.ej.company.common_code.command.domain.repo;

import com.ej.company.common_code.command.domain.entity.CommonCodeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonCodeGroupRepo extends JpaRepository<CommonCodeGroup,Long>, CommonCodeGroupRepoCustom {


}
