package com.oracle.sBootMybatis03.controller;

import java.util.List;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.sBootMybatis03.model.Dept;
import com.oracle.sBootMybatis03.model.DeptVo;
import com.oracle.sBootMybatis03.model.Emp;
import com.oracle.sBootMybatis03.model.EmpDept;
import com.oracle.sBootMybatis03.service.EmpService;
import com.oracle.sBootMybatis03.service.Paging;


@Controller
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private EmpService es;
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "empList")
	public String empList(Emp emp, String currentPage, Model model) {
		System.out.println("EmpController Start list...");
		int total = es.total();
		System.out.println("EmpController total=>" + total);
		// Paging
		Paging pg = new Paging(total, currentPage);
		
		emp.setStart(pg.getStart());
		emp.setEnd(pg.getEnd());
		System.out.println("EmpController empList Start...");
		List<Emp> listEmp = es.listEmp(emp);
		System.out.println("EmpController listEmp.size()->"+listEmp.size());
		
		model.addAttribute("total", total);
		model.addAttribute("listEmp", listEmp);
		model.addAttribute("pg", pg);
		
		return "list";
	}
	
	@GetMapping(value = "detail")
	public String detail(int empno, Model model) {
		
		System.out.println("EmpController Start detail...");
		Emp emp = es.detail(empno);
		model.addAttribute("emp", emp);
		
		return "detail";
	}
	
	@GetMapping("updateForm")
	public String updateForm(int empno, Model model) {
		
		System.out.println("EmpController Start updateForm...");
		Emp emp = es.detail(empno);
		model.addAttribute("emp", emp);
		
		return "updateForm";
	}
	
	@PostMapping("update")
	public String update(Emp emp ,Model model) {
		
		int k = es.update(emp);
		System.out.println("es.update(emp) k-->"+k);
		model.addAttribute("kkk", k);
		model.addAttribute("kk3", "Message Test");
		
		return "forward:empList";
	}
	
	@RequestMapping(value = "writeForm")
	public String writeForm(Model model) {
		
		System.out.println("EmpController writeForm Start...");
		List<Emp> list = es.listManager();
		model.addAttribute("empMngList", list);
		List<Dept> deptList = es.deptSelect();
		model.addAttribute("deptList", deptList);
		
		return "writeForm";
	}
	
	@PostMapping("write")
	public String write(Emp emp, Model model) {
		
		System.out.println("EmpController write Start...");
		int result = es.insert(emp);
		String returnStr ="";
		
		if(result > 0) {
			returnStr = "redirect:empList";
		}
		else {
			model.addAttribute("msg", "입력 실패 확인해 보세요");
			returnStr = "forward:writeForm";
		}
		
		return returnStr;
	}
	
	@RequestMapping("confirm")
	public String confirm(int empno, Model model) {
		
		System.out.println("EmpController write Start...");
		Emp emp = es.detail(empno);
		model.addAttribute("empno", empno);
		
		if(emp !=null) {
			model.addAttribute("msg", "중복된 사번입니다");
		} else {
			model.addAttribute("msg", "사용 가능한 사번입니다");
		}
		
		return "forward:writeForm";
	}
	
	@GetMapping("delete")
	public String delete(int empno, Model model) {
		
		System.out.println("EmpController delete Start...");
		int result = es.delete(empno);
		String msg = null;
		if(result > 0)
			msg = result+"건의 회원 정보가 삭제 되었습니다";
		else
			msg = "데이터 삭제에 실패하였습니다";
		model.addAttribute("kkk", msg);
		
		return "forward:empList";
	}
	
	@GetMapping("listEmpDept")
	public String listEmpDept(Model model) {
		
		System.out.println("EmpController listEmpDept Start...");
		EmpDept empDept = null;
		List<EmpDept> listEmpDept = es.listEmpDept();
		model.addAttribute("listEmpDept", listEmpDept);
		
		return "listEmpDept";
	}
	
	@RequestMapping("mailTransport")
	public String mailTransport(Model model) {
		
		System.out.println("EmpController mailTransport mailSending...");
		String tomail = "dmstn1812@naver.com";		// 받는 사람 이메일
		System.out.println("tomail");
		String setfrom = "dmstn18120@gmailcom";		// 받는사람 이메일
		String title = "mailTransport Test 입니다";	// 제목
		
		try {
			// Mime 전자우편 Internet 표준  Format
			MimeMessage message = mailSender.createMimeMessage();
																			// true는 멀티 파트 메세지를 사용
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setfrom);		// 보내는 사람 생략하면 정상작동 안함
			messageHelper.setTo(tomail);		// 받는사람 이메일
			messageHelper.setSubject(title);	// 메일제목은 생략이 가능하다
			String tempPassword = (int) (Math.random() * 999999) + 1 + "";
			messageHelper.setText("임시 비밀번호입니다 : "+tempPassword);	// 메일 내용
			System.out.println("임시 비밀번호입니다 : "+tempPassword);
			DataSource dataSource = new FileDataSource("c:\\log\\jung1.jpg");
																					// B-->base64로 인코딩
			messageHelper.addAttachment(MimeUtility.encodeText("airport.png", "UTF-8", "B"), dataSource);
			mailSender.send(message);
			model.addAttribute("check", 1);	// 정상 전달
//			s.tempPw(u_id, tempPassword);	// db에 비밀번호를 임시 비밀번호로 업데이트
			
		} catch (Exception e) {
			System.out.println("EmpController mailTransport Exception->"+e.getMessage());
			model.addAttribute("check", 2);	// 메일 전달 실패
		}
		
		return "mailResult";
	}
	
	// Procedure Test 입력화면
	@RequestMapping("writeDeptIn")
	public String writeDeptIn(Model model) {
		
		System.out.println("EmpController writeDeptIn Start...");
		
		return "writeDept3";
	}
	
	// Procedure Test 입력 후 VO 전달
	@PostMapping("writeDept")
	public String writeDept(DeptVo deptVo, Model model) {
		
//		DeptVo deptVo = es.insertDept(deptVo); 일반 Service
		es.insertDept(deptVo);	// Procedure Call
		
		if(deptVo == null) {
			System.out.println("deptVo NULL");
		} else {
			System.out.println("deptVo.getOdeptno()->"+deptVo.getOdeptno());
			System.out.println("deptVo.getOdname()->"+deptVo.getOdname());
			System.out.println("deptVo.getOloc()->"+deptVo.getOloc());
			model.addAttribute("msg", "정상 입력 되었습니다");
			model.addAttribute("dept", deptVo);
		}
		
		return "writeDept3";
	}
	
	// interCeptor 시작화면
	@RequestMapping(value = "interCeptorForm", method = RequestMethod.GET)
	public String interCeptorForm(Model model) {
		
		System.out.println("EmpController interCeptorForm Start...");
		
		return "interCeptorForm";
	}
	
	// interCeptor 진행
	@RequestMapping(value = "interCeptor")
	public String interCeptor(String id, Model model) {
		
		System.out.println("interCeptor Test Start...");
		System.out.println("interCeptor id->"+id);
		int memCnt = es.memCount(id);
		
		System.out.println("memCnt->"+memCnt);
		
		model.addAttribute("id", id);
		model.addAttribute("memCnt", memCnt);
		System.out.println("interCeptor Test End...");
		
		return "interCeptor";	// User 존재하면 User 이용조회 Page
	}
	
	// Ajax List Test
	@RequestMapping("listEmpAjax")
	public String listEmpAjax(Model model) {
		
		EmpDept empDept = null;
		System.out.println("EmpController listEmpAjax Start");
		List<EmpDept> listEmp = es.listEmp(empDept);
		System.out.println("EmpController listEmpAjax listEmp.size()"+listEmp.size());
		model.addAttribute("result", "kkk");
		model.addAttribute("listEmp", listEmp);
		
		return "listEmpAjax";
	}
	
	@ResponseBody
	@RequestMapping(value = "getDeptName", produces = "application/text;charset=UTF-8")
	public String getDeptName(int deptno) {
		
		System.out.println("deptno->"+deptno);
		String sdeptName = es.deptName(deptno);
		System.out.println(sdeptName);
		return sdeptName;
	}
	
	// Ajax List Test
	@RequestMapping("listEmpAjax2")
	public String listEmpAjax2(Model model) {
		
		EmpDept empDept = null;
		System.out.println("EmpController listEmpAjax2  Start");
		List<EmpDept> listEmp = es.listEmp(empDept);
		System.out.println("EmpController listEmpAjax2 listEmp.size()"+listEmp.size());
		model.addAttribute("result", "kkk");
		model.addAttribute("listEmp", listEmp);
		
		return "listEmpAjax2";
	}
	
}
