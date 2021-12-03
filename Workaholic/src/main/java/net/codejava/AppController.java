package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.security.auth.login.LoginContext;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ManagerRepository managerRepo;
	@Autowired
	private TaskRepository taskRepo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/register")
	public String showRegistrationForm() {
		return "pick_roll";
	}


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register_user")
	public String registerUser(Model model){
		model.addAttribute("user", new User());
		return "signup_form_user";
	}

	@GetMapping("/register_manager")
	public String registerManager(Model model){
		model.addAttribute("manager", new Manager());
		return "signup_form_manager";
	}

	@PostMapping("/process_user_register")
	public String processUserRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		//-----
		userRepo.save(user);
		System.out.println("急了");
		//-----
		return "register_success";
	}

	@PostMapping("/process_manager_register")
	public String processManagerRegister(Manager manager) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(manager.getPassword());
		manager.setPassword(encodedPassword);
		manager.setIsManager(true);
		managerRepo.save(manager);

		return "register_success";
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}

	@GetMapping ("/viewTask")
	public String viewTask(Model model) {
		List<Task> listTasks = taskRepo.findAll();
		model.addAttribute("listTasks", listTasks);
		Object temp= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(temp instanceof User) {
			return "tasks_member";
		}else{
			return "tasks_manager";
		}
	}

	@GetMapping("/add_a_task")
	public String addATask(Model model) {
		System.out.println("下辈子不学cs");
		model.addAttribute("task", new Task());
		return "add_task";
	}

	@PostMapping("/process_add_task")
	public String processAddTask(Task task) {
		taskRepo.save(task);
		return "task_manager";
	}

}
