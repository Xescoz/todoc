package com.cleanup.todoc.repositories;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.dao.ProjectDao;
import com.cleanup.todoc.model.Project;

import java.util.List;

public class ProjectRepository {

    private final ProjectDao projectDao;

    public ProjectRepository (ProjectDao projectDao){this.projectDao = projectDao;}

    public LiveData<Project> getProject(long projectId){return this.projectDao.getProject(projectId);}

    public LiveData<List<Project>> getAllProjects(){return projectDao.getAllProjects();}
}
