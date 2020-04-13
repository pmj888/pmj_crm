package com.pmj.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 庞明杰
 * @since 2020-03-24
 */
public interface IEmployeeService extends IService<Employee> {

    IPage<Employee> selectList(Page<Employee> page);

    Employee selectByName(String empName);

    Integer add(Employee employee,Integer roleId);

    Integer update(Employee employee,Integer roleId);
}
