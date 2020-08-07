package com.li.knowledge.sys.user.repository.impl;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.util.JdbcConstants;
import com.li.knowledge.sys.user.model.dto.UserDTO;
import com.li.knowledge.sys.user.model.vo.UserVO;
import com.li.knowledge.sys.user.repository.UserRepositroyCustomr;
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

        }
        sql = sql + " ORDER BY lu.modified_at desc";//更新时间倒叙
        return sql;
    }
}
