package data;

import java.util.Set;

import entities.Application;

public interface ApplicationDAO {

	public Set<Application> index(int uid);
	public Application show(int uid, int aid);
	public Application create(int uid, String appJson);
	public Application update(int uid, int aid, String appJson);
	public Boolean destroy(int uid, int aid);
}
