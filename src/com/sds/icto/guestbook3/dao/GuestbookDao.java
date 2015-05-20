package com.sds.icto.guestbook3.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;


import com.sds.icto.guestbook3.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	public void add(GuestbookVo vo) {
		sqlMapClientTemplate.insert("guestbook3.insert", vo);

	}

	
	public List<GuestbookVo> fetchList() {

		List<GuestbookVo> list = new ArrayList<GuestbookVo> ();
		list =sqlMapClientTemplate.queryForList("guestbook3.list");
		
		return list;
	}

	public void delete(GuestbookVo vo) {
		sqlMapClientTemplate.delete("guestbook3.delete", vo);

	}
}
