package com.board.dao;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.board.domain.Board;
import com.board.domain.MessageShow;

public class BoardDaoImpl implements BoardDao {
	@Resource
	private SessionFactory sessionFactory;
	List<MessageShow> boardList;

	@Override
	public Integer save(Board board) {
		Integer id = null;
		try {
			id = (Integer) sessionFactory.getCurrentSession().save(board);
			// System.out.println("idOfBoard====" + id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
		return id;
	}

	@Override
	public List showMessage(int id, int maxResult, int firstResult) {
		try {
			Query q = sessionFactory.getCurrentSession()
					.createSQLQuery(
							"select messageID,u_picture,username,speakID,message_detail,message_time from t_user a,board b where  b.userID=? and speakID=a.userID ORDER BY messageId DESC")
					.addEntity(MessageShow.class).setParameter(0, id);
			q.setFirstResult(firstResult);
			q.setMaxResults(maxResult);
			//
			boardList = q.list();
			// .addScalar("messageId",StandardBasicTypes.INTEGER)
			// .addScalar("UPicture", StandardBasicTypes.STRING)
			// .addScalar("username", StandardBasicTypes.STRING)
			// .addScalar("speakID",StandardBasicTypes.INTEGER)
			// .addScalar("messageDetail",StandardBasicTypes.STRING)
			// .addScalar("messageTime",StandardBasicTypes.TIMESTAMP)
			// .setResultTransformer(Transformers.aliasToBean(MessageShow.class))
			// while (results.hasNext())
			// {
			// Object[] rows = (Object[]) results.next();
			// String UPicture = (String) rows[0];
			// String username = (String) rows[1];
			// int speakID = (Integer) rows[2];
			// String messageDetail = (String) rows[3];
			// Timestamp messageTime = (Timestamp) rows[4];
			// }
			// boardList = (List<MessageShow>) results;
			// System.out.println("----5555"+boardList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
		return boardList;
	}

	@Override
	// 查询留言板总记录数（当前查看用户）
	public int getRows(int id) {
		long temp = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from  Board where userID=?")
				.setParameter(0, id).uniqueResult();
		int rows = (int) temp;
		return rows;
	}

}
