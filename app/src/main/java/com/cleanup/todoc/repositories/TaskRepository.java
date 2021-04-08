package com.cleanup.todoc.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.dao.TaskDao;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.room.TodocDatabase;
import com.cleanup.todoc.room.TodocViewModel;

import java.util.List;

public class TaskRepository {
    private final TaskDao taskDao;

    public TaskRepository(Application application) {
        TodocDatabase db = TodocDatabase.getDatabase(application);
        taskDao = db.taskDao();
    }
    public LiveData<Task> getTask(long taskId){return this.taskDao.getTask(taskId);}

    public void createTask(Task task){TodocDatabase.databaseWriteExecutor.execute(() -> {
        taskDao.insert(task);
    });}

    public void deleteTask(long taskId){TodocDatabase.databaseWriteExecutor.execute(() -> {
        taskDao.deleteTask(taskId);
    });}

    public LiveData<List<Task>> getAllTasks(){return taskDao.getAllTasks();}

    public void deleteAllTasks(){taskDao.deleteAllTasks();}
}
