package com.pmj.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Business;
import com.pmj.crm.mapper.BusinessMapper;
import com.pmj.crm.service.IBusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 庞明杰
 * @since 2020-04-12
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public IPage<Business> queryBusiness(Page<Business> page) {
        return businessMapper.queryBusiness(page);
    }
}
