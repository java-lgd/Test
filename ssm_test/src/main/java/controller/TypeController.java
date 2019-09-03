package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import model.Type;
import service.Type_service;

@Controller
@RequestMapping("Type")
public class TypeController {
	@Autowired
	Type_service service;

	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}

	@RequestMapping("index")
	public String index(String txt, ModelMap m) {
		String where = "";
		if (txt != null)
			where = " where name like '%" + txt + "%'";
		m.put("typeList", service.select(where));
		return "Type/index";
	}

	@RequestMapping("add")
	public String add(ModelMap m) {
		return "Type/edit";
	}

	@RequestMapping("edit")
	public String edit(int id, ModelMap m) {
		m.put("info", service.selectById(id));
		return add(m);
	}

	@RequestMapping("insert")
	public String insert(Type b, ModelMap m) {
		service.insert(b);
		return index("", m);
	}

	@RequestMapping("update")
	public String update(Type b, ModelMap m) {
		service.update(b);
		return index("", m);
	}

	@RequestMapping("delete")
	public String delete(int id, ModelMap m) {
		service.delete(id);
		return index("", m);
	}

}
