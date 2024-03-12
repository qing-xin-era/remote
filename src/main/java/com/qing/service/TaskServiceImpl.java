package com.qing.service;

import com.qing.Dao.TaskMapper;
import com.qing.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskMapper taskMapper;

    @Override
    public int addTask(Task task) {
        return taskMapper.addTask(task);
    }

    @Override
    public int deleteTaskById(int id) {
        return taskMapper.deleteTaskById(id);
    }

    @Override
    public int updateTask(Task task) {
        return taskMapper.updateTask(task);
    }

    @Override
    public Task queryTaskById(int id) {
        return taskMapper.queryTaskById(id);
    }

    @Override
    public List<Task> queryTaskByName(String taskName) {
        return taskMapper.queryTaskByName(taskName);
    }

    @Override
    public List<Task> queryAllTask() {
        return taskMapper.queryAllTask();
    }
}
