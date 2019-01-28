package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;



@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
/*	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, 
				new CustomDateEditor(dateFormat, false));
	}
	*/
	
	
	@RequestMapping("")
	public void basic() {
		
		log.info("basic..................");
	}
	
	
	/*@RequestMapping ==> @GetMapping  줄여서 쓰일수 있다.
	 * GET, POST 방식을 모두 지원해야 하는 경우에 배열로 처리해서 지정이 가능
	 * @GerMapping은 GET방식에만 사용이 가능하면 기능에 대한 제한은 많은 편이다
	 * */
	
	@RequestMapping(value =  "/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		
		
		log.info("basic get..................");
	}
	
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		
		log.info("basic get only get.................");
		
	}
	
	
	@GetMapping("/ex01")
	public String ex1(SampleDTO dto) {
		
		
		log.info(""+ dto);
		
		return "ex01";
	}
	
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		/*@RequestParam은 파라미터로 사용된 변수의 이름과 전달되는 파라미터의 이름이 다른 경우에 유용하게 사용된다 */
		
		
		log.info("name : " + name);
		log.info("age : "+ age);
		
		return "ex02";
		
	}
	
	
	@GetMapping("/ex2List")
		public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		/*스프링은 파라미터의 탑을 보고 객체를 생성하므로 파라미터의 타입은 
		*List<>와 같이 인터페이스 타입이 아닌 실제적인 클래스 타입으로 지정된다.*/
		log.info("ids : "+ ids);
		
		return "ex02List";
		
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		
		log.info("Array ids : "+ Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		
		
		log.info("list dtos : " + list);
		
		return "ex02Bean";
	}
	
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		
		log.info("todo: " + todo);

		return "ex03";
	}
	
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto,@ModelAttribute("page") int page) {
		
		log.info("dto: "+dto);
		log.info("page: "+page);
		
		return "/sample/ex04";
	}
	
	/*Controller의 리턴 타입
	 * void: 호출하는 url과 도일한 이름의 jsp를 의미합니다.
	 * String : jsp를 이용하는 경우에는 jsp 파일의 경로와 파일이름을 나타내기 위해서 사용됩니다.
	 * VO, DTO타입 : 주로 JSON타입의 데이터를 만들어서 반환하는 용도로 사용합니다.
	 * ResponseEntity: model로 데이터를 반환하거나 화면까지 같이 지정하는 경우에 사용합니다. 최근에 사용x
	 * HttpHeaders: 응답에 내용 없이 http 헤터 메시지만 전달하는 용도로 사용합니다.
	 * */
	
	/*VOID 타입*/
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05..............");
	}
	
	@GetMapping
	public @ResponseBody SampleDTO ex06() {
		
		log.info("/ex06................");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
		
	}
	
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		
		log.info("/ex07..............");
		
		//{"name" : "홍길동"}
		String msg ="{\"name\": \"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload.........................");
	}
	
	@PostMapping("/exloadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		files.forEach(file ->{
			log.info("----------------------------------");
			log.info("name : "+file.getOriginalFilename());
			log.info("size : "+file.getSize());
		});
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

