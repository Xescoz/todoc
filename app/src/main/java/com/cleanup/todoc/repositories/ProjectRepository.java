package com.cleanup.todoc.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.dao.ProjectDao;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.room.TodocDatabase;

import java.util.List;

public class ProjectRepository {

    private final ProjectDao projectDao;

    public ProjectRepository(Application application) {
        TodocDatabase db = TodocDatabase.getDatabase(application);
        projectDao = db.projectDao();
    }

    public LiveData<Project> getProject(long projectId){return this.projectDao.getProject(projectId);}

    public LiveData<List<Project>> getAllProjects(){return projectDao.getAllProjects();}
}
