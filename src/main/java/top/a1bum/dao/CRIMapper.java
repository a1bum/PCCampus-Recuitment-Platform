package top.a1bum.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.a1bum.entity.CRI;


public interface CRIMapper {
	public abstract Integer click(String id);
	public abstract Boolean addCRI(CRI paramCRI);
	public abstract List<CRI> getWXAll(@Param("today")String today, @Param("current")String time);
	public abstract List<CRI> getByKeyword(@Param("keyword") String keyword, @Param("date") String today);
	public abstract Boolean isExist(String campus_name);
	public abstract List<CRI> getByDate(String date);
	public abstract List<CRI> getByCampusAndIsExpired(@Param("admin_university")String admin_university,
			@Param("isExpired")Integer isExpired, @Param("today")String today, @Param("time") String time);
	public abstract CRI getById(String id);
	public abstract Boolean modify(CRI cri);
	public abstract Boolean deleteByIds(@Param("ids")Integer[] ids);
	public abstract List<CRI> getAll();
	public abstract List<CRI> getTop5();
}