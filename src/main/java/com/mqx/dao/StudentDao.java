package com.mqx.dao;

import com.mqx.po.Student;

import java.util.List;

/**
 * @authordell
 * @Create2019-11-21-11:00
 */
public interface StudentDao {


    /**
     * 查询
     * @return
     */
    List<Student>selectAll();
}
