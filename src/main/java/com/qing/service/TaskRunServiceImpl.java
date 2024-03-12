package com.qing.service;

import com.qing.Dao.TaskMapper;
import com.qing.Dao.TaskRunMapper;
import com.qing.pojo.Task;
import com.qing.pojo.TaskRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class TaskRunServiceImpl implements TaskRunService{

    @Autowired
    TaskRunMapper taskRunMapper;

    @Override
    public int addTaskRun(TaskRun taskRun) {
        return taskRunMapper.addTaskRun(taskRun);
    }

    @Override
    public int deleteTaskRunById(int id) {
        return taskRunMapper.deleteTaskRunById(id);
    }

    @Override
    public int updateTaskRun(TaskRun taskRun) {
        return taskRunMapper.updateTaskRun(taskRun);
    }

    @Override
    public TaskRun queryTaskRunByRunId(int id) {
        return taskRunMapper.queryTaskRunByRunId(id);
    }

    @Override
    public List<TaskRun> queryTaskRunByTaskName(String runTaskName) {
        return taskRunMapper.queryTaskRunByTaskName(runTaskName);
    }

    @Override
    public List<TaskRun> queryTaskRunByHeadId(String runHeadID) {
        return taskRunMapper.queryTaskRunByHeadId(runHeadID);
    }

    @Override
    public List<TaskRun> queryAllTaskRun() {
        return taskRunMapper.queryAllTaskRun();
    }


}
