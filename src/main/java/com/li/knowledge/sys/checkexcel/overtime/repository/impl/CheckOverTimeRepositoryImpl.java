package com.li.knowledge.sys.checkexcel.overtime.repository.impl;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.util.JdbcConstants;
import com.li.knowledge.sys.checkexcel.overtime.model.dto.CheckOverTimeDTO;
import com.li.knowledge.sys.checkexcel.overtime.model.vo.CheckOverTimeVO;
import com.li.knowledge.sys.checkexcel.overtime.repository.CheckOverTimeRepositoryCustomr;
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
 * @description: 核对加班持久层实现类
 * @author: lifh
 * @create: 2020-09-04 14:31
 **/
@Repository
public class CheckOverTimeRepositoryImpl implements CheckOverTimeRepositoryCustomr {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CheckOverTimeVO> search(CheckOverTimeDTO checkOverTimeDTO) {
        StringBuffer sql = new StringBuffer("select * from li_check_overtime lc where 1=1");
        sql.append(createWhereClauseForTable(checkOverTimeDTO));
        SqlParameterSource params = new BeanPropertySqlParameterSource(checkOverTimeDTO);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String limitSql = PagerUtils.limit(sql.toString(), JdbcConstants.MYSQL, checkOverTimeDTO.getOffset(), checkOverTimeDTO.getSize());
        return namedParameterJdbcTemplate.query(limitSql, params, new BeanPropertyRowMapper<>(CheckOverTimeVO.class));
    }

    @Override
    public int countByModel(CheckOverTimeDTO checkOverTimeDTO) {
        StringBuffer sql = new StringBuffer("select * from li_check_overtime lc where 1=1");
        sql.append(createWhereClauseForTable(checkOverTimeDTO));
        SqlParameterSource params = new BeanPropertySqlParameterSource(checkOverTimeDTO);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String countSql = PagerUtils.count(sql.toString(), JdbcConstants.MYSQL);
        return namedParameterJdbcTemplate.queryForObject(countSql, params, Integer.class);
    }

    private String createWhereClauseForTable(CheckOverTimeDTO checkOverTimeDTO) {
        String sql = "";
        //查询条件在这里拼接
        if (null != checkOverTimeDTO) {

        }
        sql = sql + " ORDER BY lc.seq asc";//排序字段排序
        return sql;
    }
}
