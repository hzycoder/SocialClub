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
			//�ҳ��������ݷֵ�
			int index = content.indexOf("|_z!5)");
			blogShow.setTitle(content.substring(0, index));
			blogShow.setContent(content.substring(index + 6));

			String content1 = blogShow.getContent();
			content1 = content1.replace("\r\n", "!y9_!");	//�ҳ����з�
			blogShow.setContent(content1);
			
			blogShowList.add(blogShow);
		}
		return blogShowList;

	}

}
