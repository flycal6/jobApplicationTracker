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

import data.ResponseDAO;
import entities.Response;


@RestController
public class ResponseController implements ResponseControllerI {
	
	@Autowired
	private ResponseDAO resDao;

	@Override
	@RequestMapping(path="user/{uid}/res", method=RequestMethod.GET)
	public Collection<Response> index(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
		res.setStatus(202);
		return resDao.index(uid);
	}

	@Override
	@RequestMapping(path="user/{uid}/res/{rid}", method=RequestMethod.GET)
	public Response show(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int rid) {
		res.setStatus(202);
		return resDao.show(uid, rid);
	}

	@Override
	@RequestMapping(path = "user/{uid}/app/{aid}/res", method = RequestMethod.POST)
	public Response create(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid,
			@PathVariable int aid, @RequestBody String responseJson) {
		res.setStatus(201);
		return resDao.create(uid, aid, responseJson);
	}

	@Override
	@RequestMapping(path="user/{uid}/app/{aid}/res/{rid}", method=RequestMethod.PUT)
	public Response update(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int aid, @PathVariable int rid,
			@RequestBody String responseJson) {
		res.setStatus(204);
		return resDao.update(uid, aid, rid, responseJson);
	}

	@Override
	@RequestMapping(path="user/{uid}/res/{rid}", method=RequestMethod.DELETE)
	public Boolean destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int rid) {
		res.setStatus(202);
		return resDao.destroy(uid, rid);
	}

}
