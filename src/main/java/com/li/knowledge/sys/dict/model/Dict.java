package com.li.knowledge.sys.dict.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @program: knowledge
 * @description: 字典实体，用于接收数据库数据
 * @author: lifh
 * @create: 2020-08-07 15:37
 **/
@Data
@Entity
@Table(name = "li_dictionary")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Dict {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;//主键

    private Date createdAt;//创建时间
    private String modifiedBy;//修改人
    private Date modifiedAt;//修改时间

}
