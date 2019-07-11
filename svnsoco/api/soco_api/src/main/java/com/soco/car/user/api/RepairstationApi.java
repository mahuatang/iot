package com.soco.car.user.api;

import com.github.pagehelper.PageInfo;
import com.soco.car.user.entity.Repairstation;

import java.util.List;

public interface RepairstationApi {

    PageInfo<Repairstation> nearbyList(Double currLng, Double currLat, Integer distance, Integer pageNo, Integer pageSize);
}
