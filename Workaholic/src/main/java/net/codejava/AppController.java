package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
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
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	/*
	@GetMapping("/login")
	public String showLoginPage(Model model) {
		model.addAttribute("loginform",new LoginForm());
		return "login";
	}

	@PostMapping("/process_login")
	public String processLogin(LoginForm loginform){
		String username=loginform.getKey();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password= passwordEncoder.encode(loginform.getValue());
		User temp = userRepo.findByEmail(username);
		if(temp!=null&&temp.getPassword()==password){
			System.out.print("user found");

			return "users";
		}
		else{
			return "index";
		}
	}*/

	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}

}
