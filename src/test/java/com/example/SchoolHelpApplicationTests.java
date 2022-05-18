package com.example;

import com.example.domain.entity.Task;
import com.example.service.TaskService;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SchoolHelpApplicationTests {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        List<Task> latestTask = taskService.getLatestTask();
        latestTask.forEach(System.out::println);

    }

    @Test
    void userTest(){
        Task task = new Task();
        task
                .setTaskName("帮我取个快递")
                .setTaskPlace("菜鸟驿站")
                .setTaskContent("今天下午4点左右帮我去取")
                .setClassifyId(1);
        taskService.save(task);
    }

}
