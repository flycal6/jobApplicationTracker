package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	@RequestMapping(path="user/{uid}/app", method=RequestMethod.GET)
	public Collection<Application> index(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
		res.setStatus(202);
		return appDao.index(uid);
	}

	@Override
	@RequestMapping(path="user/{uid}/app/{aid}", method=RequestMethod.GET)
	public Application show(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int aid) {
		res.setStatus(202);
		return appDao.show(uid, aid);
	}

	@Override
	@RequestMapping(path="user/{uid}/app", method=RequestMethod.POST)
	public Application create(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @RequestBody String appJson) {
		res.setStatus(201);
		return appDao.create(uid, appJson);
	}

	@Override
	@RequestMapping(path="user/{uid}/app/{aid}", method=RequestMethod.PUT)
	public Application update(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int aid, @RequestBody String appJson) {
		res.setStatus(204);
		return appDao.update(uid, aid, appJson);
	}

	@Override
	@RequestMapping(path="user/{uid}/app/{aid}", method=RequestMethod.DELETE)
	public Boolean destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int aid) {
		res.setStatus(202);
		return appDao.destroy(uid, aid);
	}
	
}
