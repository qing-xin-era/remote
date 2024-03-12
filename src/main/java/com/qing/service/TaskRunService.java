package com.qing.service;

import com.qing.pojo.Task;
import com.qing.pojo.TaskRun;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskRunService {

    //增加
    int addTaskRun(TaskRun taskRun);
    //删除
    int deleteTaskRunById(@Param("runID") int id);
    //更新
    int updateTaskRun(TaskRun taskRun );
    //单查询
    TaskRun queryTaskRunByRunId(@Param("runID") int id);
    //多查询通过进行项目名称
    List<TaskRun> queryTaskRunByTaskName(@Param("runTaskName") String runTaskName);
    //多查询通过负责人ID
    List<TaskRun> queryTaskRunByHeadId(@Param("runHeadID") String id);

    //查询全部
    List<TaskRun> queryAllTaskRun();
}
