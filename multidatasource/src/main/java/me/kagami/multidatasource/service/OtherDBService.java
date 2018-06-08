package me.kagami.multidatasource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.kagami.multidatasource.dao.OtherDBDao;
import me.kagami.multidatasource.multidatasource.TargetDataSource;

@Service
public class OtherDBService {
	@Autowired
	private OtherDBDao otherDBDao;

	// 访问其他库的时候需要加入targetdatasource注解
	@TargetDataSource(name = "otherdb")
	public int count() {
		return otherDBDao.count();
	}
}
