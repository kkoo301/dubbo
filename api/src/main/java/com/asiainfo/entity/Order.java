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
@Table(name = "t_order")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "status")
    private String status;

}
