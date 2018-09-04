package com.asiainfo.common.core.dao.mybatis;

import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018-08-09.
 */
public class MyBatisGenerialDaoImpl implements MyBatisBaseDao {

    private SqlSession sqlSession;

    public static final String SQLNAME_SEPARATOR = ".";

    @Override
    public <E> List<E> findList(String namespace, String statementId, Map<String, Object> parameters) {
        return this.findLimitList(namespace,statementId,parameters,null);
    }

    @Override
    public <E> List<E> findLimitList(String namespace, String statementId, Map<String, Object> parameters, Integer top) {
        if (top != null) {
            PageRowBounds rowBounds = new PageRowBounds(0, top);
            return sqlSession.selectList(getSqlName(namespace,statementId), parameters, rowBounds);
        } else {
            return sqlSession.selectList(getSqlName(namespace,statementId), parameters);
        }
    }

    @Override
    public <E> Page<E> findPage(String namespace, String statementId, Map<String, Object> parameters, Pageable pageable) {
        PageRowBounds rowBounds = new PageRowBounds(pageable.getOffset(), pageable.getPageSize());
        List<E> rows = sqlSession.selectList(getSqlName(namespace, statementId),parameters,rowBounds);
        return new PageImpl<E>(rows, pageable, rowBounds.getTotal());
    }

    @Override
    public <V> Map<String, V> findMap(String namespace, String statementId, Map<String, Object> parameters, String mapKey, Integer top) {
        if (top != null) {
            PageRowBounds rowBounds = new PageRowBounds(0, top);
            return sqlSession.selectMap(getSqlName(namespace,statementId), parameters, mapKey, rowBounds);
        } else {
            return sqlSession.selectMap(getSqlName(namespace,statementId), parameters, mapKey);
        }
    }

    @Override
    public <V> Map<String, V> findMap(String namespace, String statementId, Map<String, Object> parameters, String mapKey) {
        return findMap(namespace, statementId, parameters, mapKey, null);
    }

    private String getSqlName(String namespace, String statementId){
        return namespace + SQLNAME_SEPARATOR + statementId;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
}
