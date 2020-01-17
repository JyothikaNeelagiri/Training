package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.pojo.AgentDetails;
import com.mindgate.service.AgentServiceImpl;

@RestController
@RequestMapping("/agent")
public class AgentController {
	@Autowired
	private AgentServiceImpl agentServiceImpl;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public boolean addAgent(@RequestBody AgentDetails agentDetails) {
		System.out.println(agentDetails);
		return agentServiceImpl.addAgent(agentDetails);

	}

	@RequestMapping(value = "/{agentId}", method = RequestMethod.PUT)
	public boolean updateAgent(@PathVariable("agentId") int agentId, @RequestBody AgentDetails agentDetails) {
		System.out.println(agentDetails);
		return agentServiceImpl.updateAgent(agentId, agentDetails);

	}

	@RequestMapping(value = "/{agentId}", method = RequestMethod.DELETE)
	public boolean deleteAgent(@PathVariable("agentId") int agentId) {
		return agentServiceImpl.deleteAgent(agentId);

	}

	@RequestMapping(value = "/{agentId}", method = RequestMethod.GET)
	public AgentDetails getAgent(@PathVariable("agentId") int agentId) {
		System.out.println("Hello get Agent");
		System.out.println("Bye");
		return agentServiceImpl.getAgent(agentId);

	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<AgentDetails> getAllAgents() {
		System.out.println("in getAllAgents");
		return agentServiceImpl.getAllAgents();
	}
}
