package com.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Bean.User;

import net.sf.json.JSONObject;


@Controller
public class UserController {

	@RequestMapping("show")
	public ModelAndView show(Integer id) throws Exception {
		System.out.println(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "����");
		modelAndView.setViewName("ok.jsp");
		return modelAndView;
	}

	@RequestMapping("find")
	public String find(Model model, @RequestParam(name = "id", required = false,defaultValue="3") Integer sid) throws Exception {
		System.out.println(sid);
		model.addAttribute("name", "����");
		return "redirect:show.action";
	}

	// @RequestMapping("login")
	// public String login(Person person) throws Exception {
	// System.out.println(person.getUser().getName());
	// return "login.jsp";
	// }

	// @Validated ��pojo�����У��
	// @Validated��BindingResult �ǳɶԳ��ֵ�

	// @ModelAttribute("user")
	@RequestMapping("login")
	 public String login(Model model,@Validated User user,BindingResult result) throws Exception {
	if (result.hasErrors()) {
		List<ObjectError> allError = result.getAllErrors();
		for (ObjectError objectError : allError) {
			System.out.println(objectError.getDefaultMessage());
		}
			model.addAttribute("errors", allError);
			return "index.jsp";
	}
		return "login.jsp";
	}

	@RequestMapping("up")
	public String up(Model model, MultipartFile user_pic) throws Exception {
		if (user_pic != null) {
			// �ϴ��ļ�·��
			String pic_path = "E:\\photograph\\";
			// ԭʼ����
			String originalFilename = user_pic.getOriginalFilename();
			// �µ�ͼƬ����
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// �µ�ͼƬ
			File newFile = new File(pic_path + newFileName);
			// ���ڴ��е�����д�����
			user_pic.transferTo(newFile);
			model.addAttribute("aaa", newFileName);
		}
		System.out.println("up������");
		return "ok.jsp";
	}

	@RequestMapping("up1")
	@ResponseBody
	public  JSONObject  up1(Model model,@RequestBody MultipartFile file) throws Exception {
		String newFileName = null;
		String pic_path = null;
		System.out.println("��ȡ���ļ�"+file);
		if (file != null) {
			// �ϴ��ļ�·��
			pic_path = "E:\\photograph\\";
			// ԭʼ����
			String originalFilename = file.getOriginalFilename();
			// �µ�ͼƬ����
			newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// �µ�ͼƬ
			File newFile = new File(pic_path + newFileName);
			// ���ڴ��е�����д�����
			file.transferTo(newFile);
			
			JSONObject jsonObject = new JSONObject();
			JSONObject resUrl = new JSONObject();
			resUrl.put("src", newFile.getPath());
			jsonObject.put("code", 0);
			jsonObject.put("msg", "");
			jsonObject.put("data", resUrl);
			System.out.println(jsonObject);
			return jsonObject;
		}
		System.out.println("up������");
		return null;
	}
	
	@RequestMapping("aaa")
	public @ResponseBody List<User> showjson(@RequestBody User user) {
		System.out.println("aaa");
		System.out.println(user);
		List<User> userList = new ArrayList<User>();
		userList.add(new User("qwe","asd"));
		return userList;
	}
}
