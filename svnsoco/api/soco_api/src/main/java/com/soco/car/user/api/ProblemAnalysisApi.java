package com.soco.car.user.api;

import com.soco.car.user.entity.ProblemAnalysis;

import java.util.List;

public interface ProblemAnalysisApi {
    /**
     * 查询故障分析列表
     * @return
     */
    public List<ProblemAnalysis> listAllProblem();
}
