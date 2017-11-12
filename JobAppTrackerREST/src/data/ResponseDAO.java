package data;

import java.util.Set;

import entities.Response;

public interface ResponseDAO {
	public Set<Response> index(int uid);
	public Response show(int uid, int rid);
	public Response create(int uid, int aid, String responseJson);
	public Response update(int uid, int aid, int rid, String responseJson);
	public Boolean destroy(int uid, int rid);
}
