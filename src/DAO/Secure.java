/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author ADMIN
 */
public class Secure {
    public String securceSql(String sqlQuery, String[] params) {
        for(int i = 1; i <= params.length; i ++) {
            String replaceChars = params[i-1].replaceAll("[,'`\"\";<>=]", "");
            sqlQuery = sqlQuery.replace("{$"+i+"}", "'" + replaceChars + "'");
        }
        
        return sqlQuery;
    }
    
    public String securceSql(String sqlQuery, String value) {
        String replaceChars = value.replaceAll("[,'`\"\";<>=]", "");
        sqlQuery = sqlQuery.replace("{$}", "'" + replaceChars + "'");
        return sqlQuery;
    }
}
