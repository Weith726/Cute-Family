package com.opt.model;

import java.util.*;

public interface OptDAO_interface {
    public void insert(OptVO optVO);
    public void update(OptVO optVO);
    public void delete(String sessionNo);
    public OptVO findByPrimaryKey(String sessionNo);
    public List<OptVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 

}
