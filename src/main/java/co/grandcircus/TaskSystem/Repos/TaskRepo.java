package co.grandcircus.TaskSystem.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.TaskSystem.Objects.Task;

public interface TaskRepo extends JpaRepository<Task, Long>{

}
