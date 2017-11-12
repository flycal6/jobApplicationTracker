package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.ApplicationDAO;
import entities.Application;

@RestController
public class ApplicationController implements ApplicationControllerI {
	
	@Autowired
	private ApplicationDAO appDao;

	@RequestMapping(path="/ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@Override
	@RequestMapping(path="user/{uid}/app")
	public Collection<Application> index(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
		// TODO Auto-generated method stub
		return appDao.index(uid);
	}

	@Override
	public Application show(HttpServletRequest req, HttpServletResponse res, int uid, int aid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application create(HttpServletRequest req, HttpServletResponse res, int uid, String appJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application update(HttpServletRequest req, HttpServletResponse res, int uid, int aid, String appJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean destroy(HttpServletRequest req, HttpServletResponse res, int uid, int aid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
