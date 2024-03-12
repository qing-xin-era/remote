package com.qing.Dao;

import com.qing.pojo.Order;
import com.qing.pojo.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaskMapper {
    //增加
    int addTask(Task task);
    //删除
    int deleteTaskById(@Param("taskID") int id);
    //更新
    int updateTask(Task task );
    //单查询
    Task queryTaskById(@Param("taskID") int id);
    //多查询通过名称
    List<Task> queryTaskByName(@Param("taskName") String taskName);
    //查询全部
    List<Task> queryAllTask();
}
