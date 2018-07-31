package com.ybm.hotdog.board.mating.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ybm.hotdog.board.domain.ArticleDTO;

import oracle.net.aso.a;
/**
 * BoardMatingDAO 인터페이스를 구현하는 클래스
 * 
 * @Package : com.ybm.hotdog.board.mating.dao
 * @FileName : BoardMatingDAOImpl.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */
@Repository
public class BoardMatingDAOImpl implements BoardMatingDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.ybm.hotdog.mappers.MatingBoardMapper";

	/** 게시글 목록 전체 조회 */
	@Override
	public List<ArticleDTO> listAll() {
		return sqlSession.selectList(namespace + ".boardMatingListAll");
	}

	/** 게시글 상세 조회 */
	@Override
	public ArticleDTO getArticle(int articleNo) {
		return sqlSession.selectOne(namespace + ".articleDetail", articleNo);
	}

	/** 게시글 등록 */
	@Override
	public void regist (ArticleDTO article) {
		sqlSession.insert(namespace + ".registMating", article);
	}

	/** 게시글 삭제 */
	@Override
	public void delete(int articleNo) {
		sqlSession.delete(namespace + ".deleteMating", articleNo);
	}

	/** 게시글 수정 */
	@Override
	public void edit (ArticleDTO article) {
		sqlSession.update(namespace + ".updateMating", article);
	}

}
