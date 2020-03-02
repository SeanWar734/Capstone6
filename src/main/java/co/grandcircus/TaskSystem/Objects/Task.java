package co.grandcircus.TaskSystem.Objects;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String dueDate;
	private boolean complete;
	
	@ManyToOne
	private User user;
	
	public Task() {
		super();
	}
//	public Task(String name, String description, String dueDate, boolean complete, User user) {
//		super();
//		this.name = name;
//		this.description = description;
//		this.dueDate = dueDate;
//		this.complete = complete;
//		this.user = user;
//	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", dueDate=" + dueDate
				+ ", complete=" + complete + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
