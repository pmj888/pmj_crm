package com.pmj.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Role;
import com.pmj.crm.mapper.RoleMapper;
import com.pmj.crm.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 庞明杰
 * @since 2020-03-24
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectRoleList() {
        return roleMapper.selectRoleList();
    }

    @Override
    public IPage<Role> selectRolePage(Page<Role> page) {
        return roleMapper.selectRolePage(page);
    }

    @Override
    public int insertRole(Role role) {
        return roleMapper.insertRole(role);
    }


}
