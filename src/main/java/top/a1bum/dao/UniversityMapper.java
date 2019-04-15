package top.a1bum.dao;

import java.util.List;

import top.a1bum.entity.University;


public interface UniversityMapper {
	public abstract List<University> getAll();
	public abstract List<University> getByKeyword(String Keyword);
	public abstract University getByUniversityName(String university_name);
}
