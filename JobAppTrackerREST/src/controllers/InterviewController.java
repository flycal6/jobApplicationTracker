package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.InterviewDAO;
import entities.Interview;

@RestController
public class InterviewController implements InterviewControllerI {

	@Autowired
	private InterviewDAO interDao;
	
	@Override
	@RequestMapping(path="user/{uid}/interviews", method=RequestMethod.GET)
	public Collection<Interview> index(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
		res.setStatus(202);
		return interDao.index(uid);
	}

}
