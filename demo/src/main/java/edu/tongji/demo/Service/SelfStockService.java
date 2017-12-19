package edu.tongji.demo.Service;

import javax.servlet.http.HttpServletRequest;

public interface SelfStockService {

    boolean addStockByCode(String code, HttpServletRequest request);

    boolean deleteStockByCode(String code, HttpServletRequest request);
}
