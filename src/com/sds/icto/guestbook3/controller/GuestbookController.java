package com.sds.icto.guestbook3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sds.icto.guestbook3.dao.GuestbookDao;
import com.sds.icto.guestbook3.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	GuestbookDao guestbookdao;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookdao.fetchList();
		model.addAttribute("list", list);
		return "index";

	}

	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute GuestbookVo vo) {
		guestbookdao.add(vo);
		return "redirect:/index";

	}

	@RequestMapping(value = "/delete/{no}")
	public String deleteForm(@PathVariable Long no, Model model) {
		model.addAttribute("no", no);
		return "deleteform";
	}

	/*@RequestMapping(value = "/delete/{no}", method = RequestMethod.POST)
	public String delete(@ModelAttribute GuestbookVo vo) {
		guestbookdao.delete(vo);
		return "redirect:/index";
	}*/

}
