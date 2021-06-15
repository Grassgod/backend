package com.msc.backend.manage;

import com.msc.backend.entity.ProgramC;
import com.msc.backend.repository.ProgramCRepository;
import com.msc.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileManage {

    @Autowired
    private ProgramCRepository programCRepository;

    @Autowired
    private TaskManage taskManage;

    @Autowired
    private TaskRepository taskRepository;

    private static ArrayList<String> scanFiles = new ArrayList<String>();

    public ArrayList<String> scanFile(String filePath){
        ArrayList<String> dirctorys = new ArrayList<String>();
        File directory = new File(filePath);
        if(directory.isDirectory()){
            File[] filelist = directory.listFiles();
            for(int i = 0; i < filelist.length; i ++){
                if(filelist[i].isDirectory()){
                    dirctorys.add(filelist[i].getAbsolutePath());
                    scanFile(filelist[i].getAbsolutePath());
                }
                else{
                    if (filelist[i].getName().endsWith(".c")) {
                        scanFiles.add(filelist[i].getAbsolutePath());
                    }
                }
            }
        }
        return scanFiles;
    }

    public void createFile(String fileName, String filePath){
        ProgramC programC = new ProgramC(fileName,filePath);
        programCRepository.save(programC);
        taskManage.fileToTasks(programCRepository.findByFileName(fileName).getFileID(),fileName,filePath);
    }

    public List<ProgramC> getAllFile(){
        return programCRepository.findAll();
    }

    public boolean checkFileExist(String fileName, String fileAddress){
        return programCRepository.existsByFileName(fileName);
    }
}
