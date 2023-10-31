package org.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskmanager.model.TaskStatus;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Integer>{

}
