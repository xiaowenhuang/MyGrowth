package com.sven.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Ine=Income and expenses 亦即收支
 * @author Sven
 *
 */
@Controller
@RequestMapping(value="toIne")
public class Ine {
	@RequestMapping(value="ine")
	public String initPage(){
		return "front/Ine";
	}
}
