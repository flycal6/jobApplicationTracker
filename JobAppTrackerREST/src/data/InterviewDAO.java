package data;

import java.util.Set;

import entities.Interview;

public interface InterviewDAO {
	public Set<Interview> index(int uid);
//	public Interview show(int uid, int rid);
	public Interview create(int uid, int aid, int rid, String interviewJson);
//	public Interview update(int uid, int aid, int rid, String responseJson);
//	public Boolean destroy(int uid, int rid);
}
