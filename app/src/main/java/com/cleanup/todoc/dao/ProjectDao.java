package com.cleanup.todoc.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
        import androidx.room.Query;

        import com.cleanup.todoc.model.Project;

        import java.util.List;

@Dao
public interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Project project);

    @Query("SELECT * FROM project_table WHERE id = :projectId")
    LiveData<Project> getProject(long projectId);

    @Query("SELECT * FROM project_table")
    LiveData<List<Project>> getAllProjects();
}
