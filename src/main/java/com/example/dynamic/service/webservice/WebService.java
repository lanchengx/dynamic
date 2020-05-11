package com.example.dynamic.service.webservice;

import com.example.dynamic.util.ServiceException;

/**
 * @Author: lanchengx
 * @Date: 2020/5/10 0010
 */
public interface WebService {
    /**
     * 多条保存事务
     * @throws ServiceException
     */
    void testSaveTransactional() throws ServiceException;

    /**
     * 先插入后查询有事务注解
     * @throws ServiceException
     */
    void testSaveAndGetTransactional(String name) throws ServiceException;

    /**
     * 先插入后查询
     * @throws ServiceException
     */
    void testSaveAndGet(String name) throws ServiceException;

    /**
     * 先插入后查询
     * @throws ServiceException
     */
    void testGetAndSave(Integer getId, String saveName) throws ServiceException;

    /**
     * 先插入后查询
     * @throws ServiceException
     */
    void testGetAndSaveTransactional(Integer getId, String saveName) throws ServiceException;


    /**
     * 先插入后查询
     * @throws ServiceException
     */
    void listGetAndSaveTransactional(Integer getId, String saveName) throws ServiceException;
}
