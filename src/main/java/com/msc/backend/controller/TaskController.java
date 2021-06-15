package com.msc.backend.controller;

import com.msc.backend.entity.Task;
import com.msc.backend.manage.TaskManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("/task")
public class TaskController {

    @Autowired
    private TaskManage taskManage;

    @RequestMapping(value = "/getTasksByFileID",method = RequestMethod.POST)
    private List<Task> getTasksByFileID(@RequestParam("fileID")String fileID){
        return taskManage.getTasksByFileID(Long.valueOf(fileID));
    }
}
