package com.blog.service;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.User;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.BlogDao;
import com.blog.domain.BlogList;
import com.blog.domain.BlogShow;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;

@Transactional
public class BlogServiceImpl implements BlogService {
	@Resource
	List<BlogList> blogLists;
	@Resource
	BlogDao blogDao;

	@Override
	public Integer insertBlog(BlogList blogList) {
		ActionContext ac = ActionContext.getContext();
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		blogList.setBlogTime(timestamp);

		if (ac.getSession().get("friend") != null) {// �жϵ�ǰ�Ƿ���������û���ҳ
			// ��session�л�ȡ��ǰuser����Ϣ
			// ΪBlog����û�ID
			TUser user1 = (TUser) ac.getSession().get("friend");
			blogList.setTUser(user1);
			return blogDao.insertBlog(blogList);
		} else {
			TUser user1 = (TUser) ac.getSession().get("user");
			blogList.setTUser(user1);
			return blogDao.insertBlog(blogList);
		}

	}

	@Override
	public List researchBlog(Integer userID, int maxResult, int firstResult) {
		blogLists = blogDao.researchBlog(userID, maxResult, firstResult);
		System.out.println("-*---------------");
		System.out.println("changing");
		System.out.println("-*---------------");
		// �Ѵ����ݿ���ȡ��blogListsת��Ϊ����չʾ�����blogShowList
		List<BlogShow> blogShowList = new ArrayList<BlogShow>(); // һ������չʾ�ڽ����blog����List

		Iterator it = blogLists.iterator();
		while (it.hasNext()) {
			BlogShow blogShow = new BlogShow();
			BlogList blogList = (BlogList) it.next();
			blogShow.setBlogcommentId(blogList.getBlogcommentId());
			blogShow.setBlogComments(blogList.getBlogComments());
			blogShow.setBlogId(blogList.getBlogId());
			blogShow.setBlogTime(blogList.getBlogTime());
			blogShow.setTUser(blogList.getTUser());
			String content = blogList.getContent();
			int index = content.indexOf("|_z!5)");
			blogShow.setTitle(content.substring(0, index));
			// System.out.println(content.indexOf("|_z!5)"));
			blogShow.setContent(content.substring(index + 6));
			// System.out.println(blogShow.toString());
			blogShowList.add(blogShow);
		}
		System.out.println("-*---------------");
		for (int i = 0; i < blogShowList.size(); i++) {
			System.out.println(blogShowList.toString());
		}
		System.out.println("-*---------------");
		return blogShowList;
	}

	@Override
	public int blogRows(int id) {
		return blogDao.blogRows(id);
	}

}
