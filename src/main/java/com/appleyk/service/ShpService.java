package com.appleyk.service;

import com.appleyk.geotools.ShpTools;
import com.appleyk.pojos.ShpDatas;
import com.appleyk.pojos.ShpInfo;
import com.appleyk.result.ResponseMessage;
import com.appleyk.result.ResponseResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>Shp业务逻辑类</p>
 * @author Appleyk
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 2018年10月24日17:17:46
 */
@Service
public class ShpService {

    public ResponseResult getShpDatas(String shpPath,Integer limit) throws  Exception{
        ShpDatas shpDatas = ShpTools.readShpByPath(shpPath, limit);
        return new ResponseResult(ResponseMessage.OK,shpDatas);
    }

    public void showShp(String shpPath,String imagePath,String color, HttpServletResponse response) throws  Exception{
        ShpTools.shp2Image(shpPath, imagePath ,color,response);
    }

    public ResponseResult writeShp(ShpInfo shpInfo) throws  Exception{
        return  ShpTools.writeShpByGeom(shpInfo);
    }
}
