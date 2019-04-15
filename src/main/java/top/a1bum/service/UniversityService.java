package top.a1bum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.a1bum.dao.UniversityMapper;
import top.a1bum.entity.University;

@Service
public class UniversityService {
	@Autowired
	UniversityMapper universityMapper;
	
	public Boolean isExist(String university_name) {
		University university = universityMapper.getByUniversityName(university_name);
		return university!=null?true:false;
	}
	
	public List<University> getAll(){
		return universityMapper.getAll();
	}
	
	public List<University> getByKeyword(String keyword){
		return universityMapper.getByKeyword(keyword);
	}
}