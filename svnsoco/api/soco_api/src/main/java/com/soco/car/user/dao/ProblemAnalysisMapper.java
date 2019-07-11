package com.soco.car.user.dao;

import com.soco.car.user.entity.ProblemAnalysis;
import com.soco.car.user.entity.ProblemAnalysisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProblemAnalysisMapper {
    long countByExample(ProblemAnalysisExample example);

    int deleteByExample(ProblemAnalysisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProblemAnalysis record);

    int insertSelective(ProblemAnalysis record);

    List<ProblemAnalysis> selectByExample(ProblemAnalysisExample example);

    ProblemAnalysis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProblemAnalysis record, @Param("example") ProblemAnalysisExample example);

    int updateByExample(@Param("record") ProblemAnalysis record, @Param("example") ProblemAnalysisExample example);

    int updateByPrimaryKeySelective(ProblemAnalysis record);

    int updateByPrimaryKey(ProblemAnalysis record);

    /**
     * 以下是新增加的方法
     */

    List<ProblemAnalysis> listAllProblem();
}