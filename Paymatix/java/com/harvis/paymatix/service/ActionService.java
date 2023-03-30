package com.harvis.paymatix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvis.paymatix.model.Actions;
import com.harvis.paymatix.repository.ActionRepository;

@Service
public class ActionService {

	@Autowired
	private ActionRepository actionRepository;

	public Iterable <Actions> getAllUserAction() {
		return actionRepository.findAll();
	}

}
