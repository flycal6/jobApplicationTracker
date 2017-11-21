package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Interview;

public interface InterviewControllerI {
//  GET /user/{uid}/interviews
  public Collection<Interview> index(HttpServletRequest req, HttpServletResponse res, int uid);

}
