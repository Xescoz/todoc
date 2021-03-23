package com.cleanup.todoc.repositories;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.dao.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskRepository {
    private final TaskDao taskDao;

    public TaskRepository (TaskDao taskDao){this.taskDao = taskDao;}

    public LiveData<Task> getTask(long taskId){return this.taskDao.getTask(taskId);}

    public void createTask(Task task){taskDao.insert(task);}

    public void deleteTask(long taskId){taskDao.deleteTask(taskId);}

    public LiveData<List<Task>> getAllTasks(){return taskDao.getAllTasks();}
}
