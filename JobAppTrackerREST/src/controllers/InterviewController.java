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

import data.InterviewDAO;
import entities.Interview;

@RestController
public class InterviewController implements InterviewControllerI {

	@Autowired
	private InterviewDAO interviewDao;

	@Override
	@RequestMapping(path = "user/{uid}/interview", method = RequestMethod.GET)
	public Collection<Interview> index(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
		res.setStatus(202);
		return interviewDao.index(uid);
	}

	@Override
	@RequestMapping(path="user/{uid}/interview/{iId}", method=RequestMethod.GET)
	public Interview show(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid,
			@PathVariable int iId) {
		res.setStatus(202);
		return interviewDao.show(uid, iId);
	}

	
	@Override
	@RequestMapping(path = "user/{uid}/app/{aid}/interview", method = RequestMethod.POST)
	public Interview create(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid,
			@PathVariable int aid, @PathVariable int iId, @RequestBody String interviewJson) {
		res.setStatus(201);
		return interviewDao.create(uid, aid, iId, interviewJson);
	}

	@Override
	@RequestMapping(path="user/{uid}/app/{aid}/interview/{iId}", method=RequestMethod.PUT)
	public Interview update(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid,
			@PathVariable int aid, @PathVariable int iId, @RequestBody String interviewJson) {
		res.setStatus(204);
		return interviewDao.update(uid, aid, iId, interviewJson);
	}

	@Override
	@RequestMapping(path="user/{uid}/interview/{iId}", method=RequestMethod.DELETE)
	public Boolean destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid,
			@PathVariable int iId) {
		res.setStatus(202);
		return interviewDao.destroy(uid, iId);
	}

}
