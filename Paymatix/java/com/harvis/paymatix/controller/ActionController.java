package com.harvis.paymatix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harvis.paymatix.model.Actions;

import com.harvis.paymatix.service.ActionService;


@RestController
@CrossOrigin
@RequestMapping("/paymatix")
public class ActionController {
	
	@Autowired
	ActionService actionService;
	
	@GetMapping("/actions")  
	private Iterable <Actions> getAllUserAction() {  
		return actionService.getAllUserAction();
	}
	
}
