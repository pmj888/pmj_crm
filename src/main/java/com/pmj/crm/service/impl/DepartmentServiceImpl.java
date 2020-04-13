package com.pmj.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Department;
import com.pmj.crm.entity.Role;
import com.pmj.crm.mapper.DepartmentMapper;
import com.pmj.crm.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 庞明杰
 * @since 2020-03-24
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public IPage<Department> selectList(Page<Department> departmentPage) {
        return departmentMapper.selectList(departmentPage);
    }

    @Override
    public int insertDepartment(Department department) {
        return departmentMapper.insertDepartment(department);
    }


}
