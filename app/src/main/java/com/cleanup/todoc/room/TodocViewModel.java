package com.cleanup.todoc.room;

import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.ProjectRepository;
import com.cleanup.todoc.repositories.TaskRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class TodocViewModel extends ViewModel {

    private final ProjectRepository projectDataSource;
    private final TaskRepository taskDataSource;
    private final Executor executor;

    public TodocViewModel(ProjectRepository projectDataSource,TaskRepository taskDataSource,Executor executor){
        this.projectDataSource = projectDataSource;
        this.taskDataSource = taskDataSource;
        this.executor = executor;
    }


    public LiveData<Project> getProject(long projectId){return projectDataSource.getProject(projectId);}

    public LiveData<List<Project>> getAllProjects(){return projectDataSource.getAllProjects();}

    public LiveData<Task> getTask(long taskId){return taskDataSource.getTask(taskId);}

    public LiveData<List<Task>> getAllTasks(){return taskDataSource.getAllTasks();}

    public void createTask(final Task task){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                taskDataSource.createTask(task);
            }
        });
    }

    public void deleteTask(final long taskId){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                taskDataSource.deleteTask(taskId);
            }
        });
    }

}
