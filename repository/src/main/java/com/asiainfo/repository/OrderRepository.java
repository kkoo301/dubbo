package com.asiainfo.repository;

import com.asiainfo.common.core.dao.jpa.JpaBaseDao;
import com.asiainfo.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2018-07-27.
 */
@Repository
public interface OrderRepository extends JpaBaseDao<Order,Long> {
}
