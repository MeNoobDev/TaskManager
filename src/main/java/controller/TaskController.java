package controller;

import entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    // GET All tasks from Database
    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    // GET Task by ID
    @GetMapping("/tasks/{taskId}")
    public Optional<Task> getCourse(@RequestParam("taskId")Integer taskId){
        return taskService.getTask(taskId);
    }

    // ADD new Task to Database
    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    // Update a Task
    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }
    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<HttpStatus> deleteCourse(@RequestParam("taskId") Integer taskId){
        try{
            taskService.deleteTask(taskId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
