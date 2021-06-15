package com.msc.backend.manage;

import com.msc.backend.constant.encodeConstant;
import com.msc.backend.constant.solverConstant;
import com.msc.backend.constant.verificateConstant;
import com.msc.backend.entity.Task;
import com.msc.backend.repository.ProgramCRepository;
import com.msc.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskManage {

    @Autowired
    private TaskManage taskManage;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProgramCRepository programCRepository;

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public List<Task> getTasksByFileID(Long fileID){
        return taskRepository.findAllByFileID(fileID);
    }

    public void createTask(Long fileId, String solver, String encode, String verificate,int k){
        Task task = new Task(fileId,solver,encode,verificate,k);
        taskRepository.save(task);
    }

    public void deleteTask(){
    }

    public void fileToTasks(Long fileId, String fileName, String filePath){
        for (int k = 10; k<60; k+=10){
            for (solverConstant solver : solverConstant.values()){
                for (encodeConstant encode : encodeConstant.values()){
                    for (verificateConstant verificate : verificateConstant.values()){
                        createTask(fileId,solver.name(),encode.name(),verificate.name(),k);
                    }
                }
            }
        }
    }

    public void checkTaskStatus(){

    }

    public void startTask(){

    }

}
