package com.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.blog.domain.BlogList;
import com.blog.domain.BlogShow;

public class ChangeBlogShowFormat {
	
	public List<BlogShow> change(List<BlogList> blogLists){
		System.out.println("-*---------------");
		System.out.println("changing");
		System.out.println("-*---------------");
		// 把从数据库提取的blogLists转换为用于展示界面的blogShowList
		List<BlogShow> blogShowList = new ArrayList<BlogShow>(); // 一个用于展示于界面的blog对象List
		
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
			//找出标题内容分点
			int index = content.indexOf("|_z!5)");
			blogShow.setTitle(content.substring(0, index));
			blogShow.setContent(content.substring(index + 6));

			String content1 = blogShow.getContent();
			content1 = content1.replace("\r\n", "!y9_!");	//找出换行符
			blogShow.setContent(content1);
			
			blogShowList.add(blogShow);
		}
		return blogShowList;

	}

}
