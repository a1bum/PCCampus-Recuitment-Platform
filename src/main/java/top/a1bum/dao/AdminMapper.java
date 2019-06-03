package top.a1bum.dao;

import org.apache.ibatis.annotations.Param;

import top.a1bum.entity.Admin;

public interface AdminMapper
{
  public abstract Boolean addAdmin(Admin admin);
  public abstract Boolean modifyAdmin(Admin admin);
  public abstract Boolean deleteAdmin(Admin admin);
  public abstract Admin login(@Param("account")String account, @Param("password")String password);
  public abstract Integer getColleagues(String admin_univeristy);
}
