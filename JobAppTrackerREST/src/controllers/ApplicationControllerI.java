package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Application;

public interface ApplicationControllerI {

//  GET /user/{uid}/app
  public Collection<Application> index(HttpServletRequest req, HttpServletResponse res, int uid);

//  GET /user/{uid}/app/{aid}
  public Application show(HttpServletRequest req, HttpServletResponse res, int uid, int aid);

//  POST /user/{uid}/app
  public Application create(HttpServletRequest req, HttpServletResponse res, int uid, String appJson);

//  PUT /user/{uid}/app/{aid}
  public Application update(HttpServletRequest req, HttpServletResponse res, int uid, int aid, String appJson);

//  DELETE /user/{uid}/app/{aid}
  public Boolean destroy(HttpServletRequest req, HttpServletResponse res, int uid,int aid);
}
