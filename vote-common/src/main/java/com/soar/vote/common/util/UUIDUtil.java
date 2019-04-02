package com.soar.vote.common.util;

import java.util.UUID;

/**
 * <strong>功能描述</strong>
 * date: 2/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public class UUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static String getHashID(int length){
        //最大支持1-9个集群机器部署
        int machineId = 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {
            //有可能是负数
            hashCodeV = - hashCodeV;
        }
        return machineId + String.format("%0"+(length-1)+"d", hashCodeV);
    }
}
