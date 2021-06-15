package com.msc.backend.controller;

import com.msc.backend.config.GeneralConfig;
import com.msc.backend.entity.ProgramC;
import com.msc.backend.entity.Task;
import com.msc.backend.manage.FileManage;
import com.msc.backend.manage.TaskManage;
import com.msc.backend.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileController {

    @Autowired
    private FileManage fileManage;


    @Autowired
    private TaskManage taskManage;

    @RequestMapping("/scanFiles")
    public void scanFiles(){
        System.out.println(GeneralConfig.getFileStorageAddress());
        System.out.println(fileManage.getClass());
        List<String> fileAddressList = fileManage.scanFile(GeneralConfig.getFileStorageAddress());
        System.out.println(fileAddressList);
        for (int i = 0; i< fileAddressList.size(); i++){
            String address = fileAddressList.get(i);
            if (!fileManage.checkFileExist(FileUtils.addressToName(address), address)){
                System.out.println(FileUtils.addressToName(address)+" "+address);
                fileManage.createFile(FileUtils.addressToName(address), address);
            }
        }
    }

    @RequestMapping("/getAllFiles")
    public List<ProgramC> getAllFiles() {
        scanFiles();
        List<ProgramC> list = fileManage.getAllFile();
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i).getFileName());
        }
        return list;
    }

    @RequestMapping(value = "/getTasksByFileID",method = RequestMethod.POST)
    private List<Task> getTasksByFileID(@RequestParam("fileID")String fileID){
        return taskManage.getTasksByFileID(Long.valueOf(fileID));
    }
}
