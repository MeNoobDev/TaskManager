package service;

import entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // Gets all tasks
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    // Gets task by Id
    public Optional<Task> getTask(int TaskId) {
        return taskRepository.findById(TaskId);
    }

    // Saves the new Task
    public Task addTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    // Update the Task
    public Task updateTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    public void deleteTask(int parseLong) {
        Optional<Task> entity = taskRepository.findById(parseLong);
        // Check if the entity exists in the database
        if (entity.isPresent()) {
            // Extract the Task from Optional
            Task task = entity.get();
            // Delete the entity using the CrudRepository's delete method
            taskRepository.delete(task);
            // Optionally, you can perform additional actions after deletion
            // For example, logging, notifying, etc.
        }
    }


}
