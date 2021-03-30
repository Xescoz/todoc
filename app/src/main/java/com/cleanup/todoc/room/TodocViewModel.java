package com.cleanup.todoc.room;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.ProjectRepository;
import com.cleanup.todoc.repositories.TaskRepository;

import java.util.List;

public class TodocViewModel extends AndroidViewModel {

    private final ProjectRepository projectDataSource;
    private final TaskRepository taskDataSource;

    public TodocViewModel(Application application) {
        super(application);
        projectDataSource = new ProjectRepository(application);
        taskDataSource = new TaskRepository(application);
    }


    public LiveData<Project> getProject(long projectId) {
        return projectDataSource.getProject(projectId);
    }

    public LiveData<List<Project>> getAllProjects() {
        return projectDataSource.getAllProjects();
    }

    public LiveData<Task> getTask(long taskId) {
        return taskDataSource.getTask(taskId);
    }

    public LiveData<List<Task>> getAllTasks() {
        return taskDataSource.getAllTasks();
    }

    public void createTask(final Task task) {
        taskDataSource.createTask(task);
    }

    public void deleteTask(final long taskId) {
        taskDataSource.deleteTask(taskId);

    }

}
