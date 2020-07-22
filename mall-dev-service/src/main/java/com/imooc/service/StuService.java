package com.imooc.service;

import com.imooc.pojo.Stu;

public interface StuService {
    public Stu getStu(int id);

    public void saveStu();

    public void updateStu(Long id);

    public void deleteStu(Long id);
}
