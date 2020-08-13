package com.li.knowledge.sys.user.repository.impl;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.util.JdbcConstants;
import com.li.knowledge.sys.user.model.dto.UserDTO;
import com.li.knowledge.sys.user.model.vo.UserVO;
import com.li.knowledge.sys.user.repository.UserRepositroyCustomr;
import com.li.knowledge.utils.date.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: knowledge
 * @description: 用户持久层实现类
 * @author: lifh
 * @create: 2020-08-07 15:50
 **/
@Repository
public class UserRepositroyImpl implements UserRepositroyCustomr {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserVO> search(UserDTO userDTO) {
        StringBuffer sql = new StringBuffer("select * from li_user lu where 1=1");
        sql.append(createWhereClauseForTable(userDTO));
        SqlParameterSource params = new BeanPropertySqlParameterSource(userDTO);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String limitSql = PagerUtils.limit(sql.toString(), JdbcConstants.MYSQL, userDTO.getOffset(), userDTO.getSize());
        return namedParameterJdbcTemplate.query(limitSql, params, new BeanPropertyRowMapper<>(UserVO.class));
    }

    @Override
    public int countByModel(UserDTO userDTO) {
        StringBuffer sql = new StringBuffer("select * from li_user lu where 1=1");
        sql.append(createWhereClauseForTable(userDTO));
        SqlParameterSource params = new BeanPropertySqlParameterSource(userDTO);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String countSql = PagerUtils.count(sql.toString(), JdbcConstants.MYSQL);
        return namedParameterJdbcTemplate.queryForObject(countSql, params, Integer.class);
    }

    private String createWhereClauseForTable(UserDTO userDTO) {
        String sql = "";
        //查询条件在这里拼接
        if (null != userDTO) {
            if(StringUtils.isNotBlank(userDTO.getLoginName())){
                sql += " and login_name = :loginName";
            }
            if(0 != userDTO.getStatus()){
                sql += " and status = :status";
            }
            if(null != userDTO.getStartDate()){
                sql += " and created_at >= :startDate";
            }
            if(null != userDTO.getEndDate()){
                sql += " and created_at <= :endDate";
            }
        }
        sql = sql + " ORDER BY lu.seq asc";//排序字段排序
        return sql;
    }
}
