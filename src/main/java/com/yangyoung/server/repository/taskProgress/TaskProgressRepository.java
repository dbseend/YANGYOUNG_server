package com.yangyoung.server.repository.taskProgress;

import com.yangyoung.server.entity.taskProgress.TaskProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskProgressRepository extends JpaRepository<TaskProgress, Long> {
}
