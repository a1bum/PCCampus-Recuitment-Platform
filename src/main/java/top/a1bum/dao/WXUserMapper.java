package top.a1bum.dao;

import top.a1bum.entity.WXUser;

public interface WXUserMapper {
	public abstract Boolean addWXUser(WXUser WXUser);
	public abstract WXUser getWXUser(String wx_id);
}
