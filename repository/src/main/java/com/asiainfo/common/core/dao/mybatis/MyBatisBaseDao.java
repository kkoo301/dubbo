package com.asiainfo.common.core.dao.mybatis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018-07-27.
 */
public interface MyBatisBaseDao {
    <E> List<E> findList(String namespace, String statementId, Map<String, Object> parameters);

    <E> List<E> findLimitList(String namespace, String statementId, Map<String, Object> parameters, Integer top);

    <E> Page<E> findPage(String namespace, String statementId, Map<String, Object> parameters, Pageable pageable);

    <V> Map<String, V> findMap(String namespace, String statementId, Map<String, Object> parameters, String mapKey);

    <V> Map<String, V> findMap(String namespace, String statementId, Map<String, Object> parameter, String mapKey, Integer top);
}
