package com.qing.controller;

import com.qing.Dao.FileSrcMapper;
import com.qing.pojo.*;
import com.qing.service.*;
import com.qing.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TaskController {
    @Autowired
    OrderService orderService;
    @Autowired
    Order order;
    @Autowired
    TaskService taskService;
    @Autowired
    TaskRunService taskRunService;
    @Autowired
    DiscountService discountService;
    @Autowired
    UserService userService;
    @Autowired
    FileSrcMapper  fileSrcMapper;




    @GetMapping("/allTask")

    public  String allTask(Model model){
        List<Task> tasks = taskService.queryAllTask();
        model.addAttribute("taskList",tasks);
        return "allTask";
    }

    @GetMapping("/queryTaskByName")

    public  String queryTaskByName(Model model,String taskName){
        List<Task> tasks = taskService.queryTaskByName(taskName);
        model.addAttribute("taskList",tasks);
        return "allTask";
    }

    @GetMapping("/toAddTask")

    public  String toAddTask(Model model ) throws ParseException {

        Task task = new Task();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("---------------------------");
        System.out.println(dateTime.format(formatter).getClass());
        System.out.println(dateTime.format(formatter));
        System.out.println(dateTime.format(formatter).getClass());
        System.out.println(dateTime.getClass());
        System.out.println(dateTime);
        System.out.println("---------------------------");

        task.setTaskTime(dateTime.format(formatter));
        model.addAttribute("task",task);
        return "addTask";
    }

    @PostMapping("/addTask")
    public  String addTask( Task task){

        System.out.println("taskRun========================================---------------"+task);
        if(task==null){
            return "addTask";
        }
        int i = taskService.addTask(task);
        if(i!=0) System.out.println("添加taskrun成功");
        return "redirect:/allTask";
    }

    //删除ID
    @GetMapping("/deleteTaskById")

    public  String deleteTaskById(Model model,int taskID,String userName){

        if(userName.equals("201451082408")){
            int i = taskService.deleteTaskById(taskID);

            System.out.println("stat"+i);
            return "redirect:allTask";
        }

        return "redirect:allTask";

    }






    @GetMapping("/toAddTaskRun")

    public  String toAddTaskRun(Model model ,int taskID ,String  taskName  ,String taskDetail  ,String taskTime,String taskSite ,String taskNumber){
        TaskRun taskRun = new TaskRun();

        taskRun.setRunTaskName(taskName);
        taskRun.setRunTime(taskTime);
        taskRun.setRunSite(taskSite);
        taskRun.setRunCommitment("本人完全承担后果");
        taskRun.setTaskNumber(taskNumber);
        model.addAttribute("taskRun",taskRun);
        return "addTaskRun";
    }

    @PostMapping("/addTaskRun")
    public  String addTaskRun( TaskRun taskRun){

        System.out.println("taskRun---------------"+taskRun);
        if(taskRun==null){
            return "addTaskRun";
        }
        int i = taskRunService.addTaskRun(taskRun);
        if(i!=0) System.out.println("添加taskrun成功");
        return "redirect:/allTaskRun";
    }



    @GetMapping("/allTaskRun")

    public  String allTaskRun(Model model){
        List<TaskRun> taskRuns = taskRunService.queryAllTaskRun();
        model.addAttribute("taskRunList",taskRuns);
        return "allTaskRun";
    }
    @GetMapping("/queryTaskRunByHeadId")

    public  String queryTaskRunByHeadId(Model model ,String runHeadID){
        List<TaskRun> taskRuns = taskRunService.queryTaskRunByHeadId(runHeadID);
        System.out.println("==========="+taskRuns);
        model.addAttribute("taskRunList",taskRuns);
        return "allTaskRun";
    }
    @GetMapping("/queryTaskRunByTaskName")

    public  String queryTaskRunByTaskName(Model model ,String runTaskName){
        List<TaskRun> taskRuns = taskRunService.queryTaskRunByTaskName(runTaskName);
        model.addAttribute("taskRunList",taskRuns);
        return "allTaskRun";
    }


    //删除ID
    @GetMapping("/deleteTaskRunById")

    public  String deleteTaskRunById(Model model,String userName,String runHeadID,int runID){

        if(userName.equals(runHeadID)){
            int i = taskRunService.deleteTaskRunById(runID);

            return "redirect:allTaskRun";
        }

        return "redirect:allTaskRun";

    }



    @PostMapping("/upFile")
    public String upImg(MultipartFile file, Model model, String userName) throws IOException {
        String retureFileSrc = UploadUtil.uploadImage(file);
        System.out.println("用户名----------------------------------" + userName);
        List<User> userList = userService.queryUserList();
        System.out.println("所有用户============"+userList);

        System.out.println(userList);
        //依据登录用户，存入图片
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            System.out.println("第一次遍历" + userList.size());
            System.out.println(user.getName());
            if (user.getName().equals(userName)) {
                System.out.println("正确匹配");
                fileSrc fileSrc = new fileSrc();
                fileSrc.setUserName(user.getName());
                fileSrc.setFileSrc(retureFileSrc);
                int i1 = fileSrcMapper.addfileSrc(fileSrc);


                // int i1 = imageSrcService.addImageSrc(imageSrc);
                System.out.println(user + "ok---------------------------------------------------------------"+i1 );
            }
        }
        return "redirect:/allDiscount";
    }


    @GetMapping("/testTaskRun")
    @ResponseBody
    public  String testTaskRun(){
        List<TaskRun> tasks = taskRunService.queryAllTaskRun();

        //TaskRun taskRun = taskRunService.queryTaskRunByRunId(2);
//        ArrayList<TaskRun> taskRuns = new ArrayList<>();
//        taskRuns.add(taskRun);

        // List<TaskRun> taskRuns = taskRunService.queryTaskRunByHeadId("201451082208");
       // List<TaskRun> taskRuns = taskRunService.queryTaskRunByTaskName("22");
//        int i = taskRunService.deleteTaskRunById(1);
        
//        TaskRun taskRun = new TaskRun();
//        taskRun.setRunID(3);
//        taskRun.setRunTaskName("拼团");
//        taskRun.setRunHeadName("刁庆欣");
//        int i = taskRunService.addTaskRun(taskRun);


//        TaskRun taskRun = taskRunService.queryTaskRunByRunId(3);
//        taskRun.setRunTaskName("就餐");
//        taskRun.setRunHeadName("胡黎明");
//        int i = taskRunService.updateTaskRun(taskRun);


        System.out.println("ddddddddd"+tasks);

        return "taskRun测试"+tasks;
    }

}
