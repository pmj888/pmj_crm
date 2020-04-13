package com.pmj.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pmj.crm.entity.Employee;
import com.pmj.crm.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 庞明杰
 * @since 2020-03-24
 */
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {

    IPage<Department> selectList(Page<Department> departmentPage);

    int insertDepartment( Department department);
}
