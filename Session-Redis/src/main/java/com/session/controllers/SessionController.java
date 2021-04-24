package com.session.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/")
	public String home(HttpSession session) {
		List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
		if (messages == null) {
			messages = new ArrayList<>();
		}
		return "Session id is: " + session.getId() + "<br>" + "My message: " + messages.toString();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/{msg}")
	public String persistMessage(@PathVariable("msg") String msg, HttpServletRequest request) {
		List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
		if (messages == null) {
			messages = new ArrayList<>();
		}
		messages.add(msg);
		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		return "Session id is: " + request.getRequestedSessionId() + "<br>" + " My message: " + messages.toString();
	}

	@RequestMapping("/destroy")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return request.getRequestedSessionId() + " is invalidated";
	}
}
