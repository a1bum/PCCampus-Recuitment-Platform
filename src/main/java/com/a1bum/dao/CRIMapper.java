package com.a1bum.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.a1bum.entity.CRI;

public interface CRIMapper {
	public abstract Boolean addCRI(CRI paramCRI);
	public abstract List<CRI> getAll();
	public abstract List<CRI> getByKeyword(@Param("keyword") String keyword, @Param("today") String today);
	public abstract Boolean isExist(String campus_name);
	public abstract List<CRI> getByDate(String date);
}