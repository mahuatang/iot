package com.soco.car.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.soco.car.user.api.ProblemAnalysisApi;
import com.soco.car.user.dao.ProblemAnalysisMapper;
import com.soco.car.user.entity.ProblemAnalysis;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(interfaceClass = ProblemAnalysisApi.class, timeout = 30000)
public class ProblemAnalysisService implements ProblemAnalysisApi{

    @Autowired
    private ProblemAnalysisMapper problemAnalysisMapper;

    @Override
    public List<ProblemAnalysis> listAllProblem() {
        return problemAnalysisMapper.listAllProblem();
    }
}
