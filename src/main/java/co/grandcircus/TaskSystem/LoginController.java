package co.grandcircus.TaskSystem;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.TaskSystem.Objects.User;
import co.grandcircus.TaskSystem.Repos.UserRepo;

@Controller
public class LoginController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private HttpSession sesh;

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login-form");
	}

	@PostMapping("/login")
	public ModelAndView loginTest(
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			RedirectAttributes redir) {
		User user = userRepo.findByNameIgnoreCase(name);
		
		if(user == null || !password.equals(user.getPassword())) {
			ModelAndView mav = new ModelAndView("login-form");
			mav.addObject("message", "Incorrect username or password.");
			return mav;
		}

		sesh.setAttribute("user", user);
		redir.addFlashAttribute("message", "Successfully logged you in, " + user.getName());
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(RedirectAttributes redir) {
		sesh.invalidate();
		redir.addAttribute("message", "Successfully logged out");
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/addUser")
	public ModelAndView addUser() {
		return new ModelAndView("user-add");
	}
	
	@PostMapping("/addUser")
	public ModelAndView confirmAdd(User user) {
		userRepo.save(user);
		return new ModelAndView("redirect:/");
	}
	

}
