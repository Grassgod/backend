package com.msc.backend.manage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskManageTest {

    @Autowired
    TaskManage taskManage;

    @Test
    public void testFiletoTask(){
        taskManage.fileToTasks(new Long(1),"text.c","JK/text.c");
    }

}