package com.soco.car.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soco.car.user.api.RepairstationApi;
import com.soco.car.user.dao.RepairstationMapper;
import com.soco.car.user.entity.Repairstation;

@Service(interfaceClass = RepairstationApi.class, timeout = 30000)
public class RepairstationService implements RepairstationApi {
    @Autowired
    private RepairstationMapper repairstationMapper;

    @Override
    public PageInfo<Repairstation> nearbyList(Double currLng, Double currLat, Integer distance, Integer pageNo, Integer pageSize) {
        Assert.notNull(currLng, "经度信息不能为空");
        Assert.notNull(currLat, "纬度信息不能为空");
        Assert.notNull(distance, "距离信息不能为空");
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<Repairstation> result = new PageInfo<Repairstation>(repairstationMapper.nearbyList(currLng, currLat, distance));
        return result;
    }
    
}
