package com.cleanup.todoc.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Query("DELETE FROM task_table WHERE id = :taskId")
    void deleteTask(long taskId);

    @Query("SELECT * FROM task_table WHERE id = :taskId")
    LiveData<Task> getTask(long taskId);

    @Query("SELECT * FROM task_table")
    LiveData<List<Task>> getAllTasks();
}
