package com.yuncheng.hivetable.config;

public class DatabaseContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static final String FIRST_DS = "first_datasource";
    public static final String SECOND_DS = "second_datasource";

    /**
     * 放入
     * @param type
     */
    public static void setDataBase(String type){
        contextHolder.set(type);
    }

    /**
     * 获取
     */
    public static String getDataBase(){
        return contextHolder.get();
    }

    /**
     * 清空
     */
    public static void clearDataSource(){
        contextHolder.remove();
    }
}
