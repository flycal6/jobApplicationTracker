package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Response;

public interface ResponseControllerI {


//  GET /user/{uid}/res/
  public Collection<Response> index(HttpServletRequest req, HttpServletResponse res, int uid);

//  GET /user/{uid}/res/{rid}
  public Response show(HttpServletRequest req, HttpServletResponse res, int uid, int rid);

//  POST /user/{uid}/app/{aid}/res
  public Response create(HttpServletRequest req, HttpServletResponse res, int uid, int aid, String responseJson);

//  PUT /user/{uid}/app/{aid}/res/{rid}
  public Response update(HttpServletRequest req, HttpServletResponse res, int uid, int aid, int rid, String responseJson);

//  DELETE /user/{uid}/res/{rid}
  public Boolean destroy(HttpServletRequest req, HttpServletResponse res, int uid,int rid);
}
