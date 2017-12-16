package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Interview;

public interface InterviewControllerI {
	// GET /user/{uid}/interviews
	public Collection<Interview> index(HttpServletRequest req, HttpServletResponse res, int uid);

	// GET /user/{uid}/interviews/{iId}
	public Interview show(HttpServletRequest req, HttpServletResponse res, int uid, int iId);

	// POST /user/{uid}/app/{aid}/interviews
	public Interview create(HttpServletRequest req, HttpServletResponse res, int uid, int aid, int iId,
			String interviewJson);

	// PUT /user/{uid}/app/{aid}/interviews/{iId}
	public Interview update(HttpServletRequest req, HttpServletResponse res, int uid, int aid, int iId,
			String interviewJson);

	// DELETE /user/{uid}/interviews/{iId}
	public Boolean destroy(HttpServletRequest req, HttpServletResponse res, int uid, int iId);

}
