package com.pmj.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pmj.crm.entity.Role;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 庞明杰
 * @since 2020-03-24
 */
public interface IDepartmentService extends IService<Department> {

    IPage<Department> selectList(Page<Department> departmentPage);

    int insertDepartment( Department department);

}
