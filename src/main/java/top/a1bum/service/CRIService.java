package top.a1bum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.a1bum.dao.CRIMapper;
import top.a1bum.entity.CRI;


@Service
public class CRIService {

	@Autowired
	CRIMapper crimapper;
	
	public Boolean click(String id) {
		return crimapper.click(id);
	}
	
	public boolean addCRI(CRI paramCRI) {
		return crimapper.addCRI(paramCRI);
	}
	
	public List<CRI> getAll(){
		return crimapper.getAll();
	}

	public List<CRI> getByKeyword(String keyword, String today) {
		return crimapper.getByKeyword(keyword, today);
	}
	
	public List<CRI> getByDate(String date){
		return crimapper.getByDate(date);
	}

	public List<CRI> getByCampusAndIsExpired(String admin_university, Integer isExpired, String today, String time) {
		return crimapper.getByCampusAndIsExpired(admin_university, isExpired, today, time);
	}

	public CRI getById(String id) {
		return crimapper.getById(id);
	}

	public Boolean modify(CRI cri) {
		return crimapper.modify(cri);
	}

	public Boolean deleteByIds(Integer[] ids) {
		return crimapper.deleteByIds(ids);
	}
}
