package com.oracle.springMVCBoard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.oracle.springMVCBoard.dao.BDao;
import com.oracle.springMVCBoard.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String bId=request.getParameter("bId");
		
		BDao dao=new BDao();
		BDto board=dao.contentView(bId);			
		model.addAttribute("mvc_board", board);

	}

}
