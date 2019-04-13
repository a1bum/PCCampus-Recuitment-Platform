package com.a1bum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a1bum.dao.CRIMapper;
import com.a1bum.entity.CRI;

@Service
public class CRIService {

	@Autowired
	CRIMapper crimapper;
	
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
}
