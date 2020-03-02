package co.grandcircus.TaskSystem;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.TaskSystem.Objects.Task;
import co.grandcircus.TaskSystem.Objects.User;
import co.grandcircus.TaskSystem.Repos.TaskRepo;
import co.grandcircus.TaskSystem.Repos.UserRepo;

@Controller
public class TaskListController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TaskRepo taskRepo;
	
	@Autowired
	private HttpSession sesh;
	
	@RequestMapping("/")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject( "user", sesh.getAttribute("user"));
		mav.addObject("tasks", taskRepo.findAll());
		return mav;
	}
	
	@PostMapping("/")
	public ModelAndView loggedIn() {
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/addTask")
	public ModelAndView addTask() {
		return new ModelAndView("addTask", "users", userRepo.findAll());
	}
	
	@PostMapping("/addTask")
	public ModelAndView confirmTask(Task task) {
		taskRepo.save(task);
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/deleteTask")
	public ModelAndView delete(Task task) {
		taskRepo.delete(task);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/editTask")
	public ModelAndView editTask(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("editTask");
		mav.addObject("task", taskRepo.findById(id).orElse(null));
		mav.addObject("users", userRepo.findAll());
		return mav;
	}
	
	@PostMapping("/editTask/confirm")
	public ModelAndView editConfirm(Task task) {
		taskRepo.save(task);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/deleteTask")
	public ModelAndView delete(@RequestParam("id") Long id) {
		taskRepo.deleteById(id);
		return new ModelAndView("redirect:/");
	}
}
