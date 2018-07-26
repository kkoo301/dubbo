package com.asia.core.dao.mybatis;

import com.asia.core.pagination.GroupPropertyFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018-07-27.
 */
public interface MyBatisDao {
    <E> List<E> findList(String namespace, String statementId, Map<String, Object> parameters);

    <E> List<E> findLimitList(String namespace, String statementId, Map<String, Object> parameters, Integer top);

    <E> List<E> findSortList(String namespace, String statementId, GroupPropertyFilter groupPropertyFilter, Sort sort);

    <E> List<E> findSortList(String namespace, String statementId, Map<String, Object> parameters, Sort sort);

    <E> Page<E> findPage(String namespace, String statementId, Map<String, Object> parameters, Pageable pageable);

    <E> Page<E> findPage(String namespace, String statementId, GroupPropertyFilter groupPropertyFilter, Pageable pageable);

    <V> Map<String, V> findMap(String namespace, String statementId, Map<String, Object> parameters, String mapKey);

    <V> Map<String, V> findMap(String namespace, String statementId, Map<String, Object> parameter, String mapKey, Integer top);
}
