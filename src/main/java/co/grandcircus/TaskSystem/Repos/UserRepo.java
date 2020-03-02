package co.grandcircus.TaskSystem.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.TaskSystem.Objects.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	User findByNameIgnoreCase(String name);
}
