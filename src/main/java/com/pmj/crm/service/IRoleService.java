package com.pmj.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 庞明杰
 * @since 2020-03-24
 */
public interface IRoleService extends IService<Role> {

    List<Role> selectRoleList();

    IPage<Role> selectRolePage(Page<Role> page);


    int insertRole(Role role);
}
