package com.asiainfo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by admin on 2018-07-27.
 */
@Data
@Entity
@ToString
@Table(name = "t_order_item")
public class OrderItem {

    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderItemId;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "user_id")
    private int userId;

}
