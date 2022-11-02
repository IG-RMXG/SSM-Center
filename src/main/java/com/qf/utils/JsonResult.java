package com.qf.utils;

import lombok.Data;

/**
 * @author yangl
 * @version 1.0
 * @date 2022/10/31 18:03
 *
 * 封装方法的返回类型
 */

@Data
public class JsonResult<T> {

    private Integer code;
    private String msg;
    private Long count;
    private T data;

    /**
     * 成功返回
     * @return
     */
    public static JsonResult ok(){

        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setMsg("success");

        return jsonResult;
    }

    /**
     * 失败返回
     * @return
     */
    public static JsonResult fail(){

        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(-1);
        jsonResult.setMsg("error");

        return jsonResult;
    }
}
