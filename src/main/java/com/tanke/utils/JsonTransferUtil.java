package com.tanke.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;


/**
 * @author chenyongren
 * @Description json转换
 * @date 2019-03-17
 */
// 确保序列化JSON时，如果是null对象，其key也会消失。
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//// 生成无参构造，确保在RPC调用时，不会出现反序列失败
//@NoArgsConstructor
public class JsonTransferUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonTransferUtil.class);

    /**
     * @Author 陈永任
     * @Description 对象转换成json
     * @Return 字符串
     * @Date 2019/3/30 16:18
     */
    public static String objToJson(Object obj)  {
        ObjectMapper mapper = new ObjectMapper();
        String s="";
        try {
             s = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static Map<String,Object> jsonToObj(String str)  {
        ObjectMapper objectMapper = new ObjectMapper();
        // 转换为格式化的json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Map<String,Object> multiValueMap = null;
        try {
            multiValueMap = objectMapper.readValue(str, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return multiValueMap;
    }
    public static void main(String[] args) {
        String a="{\n" +
                "\t\"acceptDate\": \"2021年01月05日\",\n" +
                "\t\"expData\": null,\n" +
                "\t\"trialOpinion\": null,\n" +
                "\t\"companyName\": \"重庆火锅麻辣烫有限责任\n" +
                "\t公司 \",\"\n" +
                "\tmaterialList \":[\"\n" +
                "\t1： 长沙市城市管理和综合执法局行政许可申请表（ 延续行政许可有效期） 电子 原件（ 1） \"],\"\n" +
                "\tchannel \":\"\n" +
                "\tONLINE \",\"\n" +
                "\tcorretTime \":null,\"\n" +
                "\tanticipateDay \":\"\n" +
                "\t20 \",\"\n" +
                "\toperator \":\"\n" +
                "\t管理员账号 \",\"\n" +
                "\tepilogRemark \":\"\n" +
                "\t\",\"\n" +
                "\ttrialName \":\"\n" +
                "\t\",\"\n" +
                "\tapply\n" +
                "\tYDate \":\"\n" +
                "\t2020 年12月28日 \",\"\n" +
                "\tworkorderId \":1343481220213903361,\"\n" +
                "\tqrCode \":\"\n" +
                "\thttp: //test-changsha.0x5f81.cn/ping/admin/rating-dynamic/?msg=hallHcp-001-50133357127815168-11430100006127280M30001170140000220201228001i-11430100006127280M3000\n" +
                "\t\t11701400002 - 1000110000061272801201228 X422 - 重庆火锅麻辣烫有限责任公司 \",\"\n" +
                "\ttaskCode \":\"\n" +
                "\t11430100006127280 M300011701400002 \",\"\n" +
                "\tareaName \":\"\n" +
                "\t长沙市直 \",\"\n" +
                "\toperatorTime \":\"\n" +
                "\t2021 年01月05日 \",\"\n" +
                "\tmaterialNum \":1,\"\n" +
                "\twindowPhone \":null,\"\n" +
                "\tagentAddress \":\"\n" +
                "\t北京市市辖区东城区创意园 \",\"\n" +
                "\torderNo \":null,\"\n" +
                "\torgName \":\"\n" +
                "\t长沙市城市管理和综合执法局 \",\"\n" +
                "\tsignTime \":\"\n" +
                "\t2021 年01月05日 \",\"\n" +
                "\torderDetail\n" +
                "\tItems \":null,\"\n" +
                "\tagentName \":\"\n" +
                "\t谭岳鑫 \",\"\n" +
                "\ttelephone \":\"\n" +
                "\t0731 - 88665142 \",\"\n" +
                "\ttrialDate \":\"\n" +
                "\t\",\"\n" +
                "\tapplyMatters \":\"\n" +
                "\t关于重庆火锅麻辣烫有限责任公司（ 延期） 城市建筑垃圾处置核准 \",\"\n" +
                "\tareaCode \":\"\n" +
                "\t430101000000 \",\"\n" +
                "\torderPayQrCode \":null,\"\n" +
                "\tmaterials \":null,\"\n" +
                "\torderBussi\n" +
                "\tnesTime \":null,\"\n" +
                "\tacceptOpinion \":\"\n" +
                "\t同意 \",\"\n" +
                "\ttaskName \":\"（\n" +
                "\t延期） 城市建筑垃圾处置核准 \",\"\n" +
                "\tprojectName \":\"\n" +
                "\t\",\"\n" +
                "\toutTime \":null,\"\n" +
                "\treviewOpinion \":null,\"\n" +
                "\tlegalRepName \":\"\n" +
                "\t张经理 \",\"\n" +
                "\tcertCategory \":\"\n" +
                "\t49 \",\"\n" +
                "\treasons \":\"\n" +
                "\t同意 \",\"\n" +
                "\tcertCode \":\"\n" +
                "\t91430105 MA4L5U4Y6R \",\"\n" +
                "\tap\n" +
                "\tprovalType \":null,\"\n" +
                "\tserverCategory \":\"\n" +
                "\tLEGAL \",\"\n" +
                "\tcorrectMaterialList \":[],\"\n" +
                "\torderAmount \":null,\"\n" +
                "\treviewDate \":null,\"\n" +
                "\torgCode \":\n" +
                "\t\"006127280\",\n" +
                "\t\"workorderBookIssueVoList\": [],\n" +
                "\t\"class\": \"com.tencent.gaio.apis.workorder.vo.WorkorderBookMarkVo\",\n" +
                "\t\"legalR\n" +
                "\tepAddress \":\"\n" +
                "\t北京市市辖区东城区创意园 \",\"\n" +
                "\tcorrectRemark \":null,\"\n" +
                "\temail \":null,\"\n" +
                "\tauditDate \":null,\"\n" +
                "\tcorrectMaterials \":\"\n" +
                "\t\",\"\n" +
                "\tad\n" +
                "\tdress \":\"\n" +
                "\t北京市 市辖区 东城区 创意园 \",\"\n" +
                "\tprojectNumber \":null,\"\n" +
                "\tmobile \":\"\n" +
                "\t16603410128 \",\"\n" +
                "\tacceptName \":\"\n" +
                "\t管理员账号 \",\"\n" +
                "\tlegalRepMobile \":\"\n" +
                "\t16603410128 \",\"\n" +
                "\tagentCertCode \":\"\n" +
                "\t430111196401133333 \",\"\n" +
                "\tissueOrgName \":\"\n" +
                "\t\",\"\n" +
                "\tsettingBase \":\"《\n" +
                "\t国务院对确需保留的\n" +
                "\t行政审批项目设定行政许可的决定》（ 2004 年6月29日国务院令第412号， 2009 年1月29日予以修改） 附件第101项： 城市建筑垃圾处\n" +
                "\t置核准， 实施机关： 城市人民政府市容环境卫生行政主管部门。 \",\"\n" +
                "\tagentMobile \":\"\n" +
                "\t16603410128 \",\"\n" +
                "\tpersonName \":\"\n" +
                "\t重庆火锅麻辣烫\n" +
                "\t有限责任公司 \",\"\n" +
                "\tspecialRemark \":null,\"\n" +
                "\tcomplaintTelephone \":\"\n" +
                "\t0731 - 12319 \",\"\n" +
                "\tworkorderCode \":\"\n" +
                "\t1000110000061272801201228 X42\n" +
                "\t2 \",\"\n" +
                "\tform \":{\"\n" +
                "\tjob \":\"\n" +
                "\t阿萨德 \",\"\n" +
                "\tshape \":\"\n" +
                "\t阿萨德 \",\"\n" +
                "\taddress \":\"\n" +
                "\t阿萨德 \",\"\n" +
                "\tlicense \":\"\n" +
                "\t长沙市建筑垃圾处置许可证 \",\"\n" +
                "\tnowDate \":\"\n" +
                "\t2020 - 12 - 28 16: 58: 19 \",\"\n" +
                "\ttrustee \":\"\n" +
                "\t阿萨德 \",\"\n" +
                "\taddress2 \":\"\n" +
                "\t阿萨德 \",\"\n" +
                "\tunitName \":\"\n" +
                "\t重庆火锅麻辣烫有限责任公司 \",\"\n" +
                "\tworkName \":\"\n" +
                "\t城市建\n" +
                "\t筑垃圾处置核准（ 延期） \",\"\n" +
                "\tlegalName \":\"\n" +
                "\t阿萨德 \",\"\n" +
                "\ttrustAuth \":\"\n" +
                "\t代理人根据授权， 以我方名义提交申请资料， 签收法律文书及相\n" +
                "\t关资料， 配合现场稽查， 进行陈述和申辩事项， 其法律后果由我公司承担 \",\"\n" +
                "\ttrustTerm \":\"\n" +
                "\t2020 年12月29日至2021年01月19日 \",\"\n" +
                "\tl\n" +
                "\tegalPhone \":\"\n" +
                "\t阿萨德 \",\"\n" +
                "\tsocialCode \":\"\n" +
                "\t91430105 MA4L5U4Y6R \",\"\n" +
                "\tcertCategory \":\"\n" +
                "\t港澳居民来往内地通行证 \",\"\n" +
                "\ttrusteePhone \":\"\n" +
                "\t阿萨\n" +
                "\t德 \",\"\n" +
                "\tlicensePeriod \":\"\n" +
                "\t2020 年12月05日至2021年01月04日 \",\"\n" +
                "\tapplyDelayReson \":\"\n" +
                "\t阿萨德 \",\"\n" +
                "\tcorpCertCategory \":\"\n" +
                "\t民办非企业单位登记证书 \",\"\n" +
                "\tlegalCertificate \":\"\n" +
                "\t阿萨德 \",\"\n" +
                "\toriginalSetPlace \":\"\n" +
                "\t阿萨德 \",\"\n" +
                "\ttrusteeCertificate \":\"\n" +
                "\t阿萨德 \",\"\n" +
                "\tspecificationNumb\n" +
                "\ter \":24,\"\n" +
                "\toriginalLicenseNumber \":\"\n" +
                "\t阿萨德 \"},\"\n" +
                "\toperatorCategory \":\"\n" +
                "\t\",\"\n" +
                "\tpromiseDay \":\"\n" +
                "\t6 \",\"\n" +
                "\tepilogRemarkTime \":\"\n" +
                "\t\",\"\n" +
                "\tprojectAddress \":\"\n" +
                "\t\",\"\n" +
                "\tendTime \":null,\"\n" +
                "\treviewName \":null,\"\n" +
                "\tapplyDate \":\"\n" +
                "\t2020 年12月28日16时 \",\"\n" +
                "\torderPayersName \":null,\"\n" +
                "\tcontactNo \":null\n" +
                "}";
        String b="{\n" +
                "\t\"B12Operator\": \"管理员账号\",\n" +
                "\t\"C50EndTime\": \"\",\n" +
                "\t\"B12Remark\": \"同意\",\n" +
                "\t\"B12EndTime\": \"2021-01-05 21:05:32\",\n" +
                "\t\"C40EndTime\": \"\",\n" +
                "\t\"C50Operator\": \"\",\n" +
                "\t\"A10EndTime\": \"2021-01-05 21:05:18\",\n" +
                "\t\"title\": \"\",\n" +
                "\t\"correctOperator\": \"\",\n" +
                "\t\"correctEndTime\": \"\",\n" +
                "\t\"A10Remark\": \"同意\",\n" +
                "\t\"C40Operator\": \"管理员账号\",\n" +
                "\t\"C50Remark\": \"\",\n" +
                "\t\"A10Operator\": \"管理员账号\",\n" +
                "\t\"correctRemark\": \"\",\n" +
                "\t\"C40Remark\": \"\"\n" +
                "}";
        Map<String,Object> mapA =  JSONObject.parseObject(a);
        Map<String,Object> mapB =  JSONObject.parseObject(b);
        mapA.putAll(mapB);
        System.out.println(objToJson(mapA));
    }
    private static final long serialVersionUID = 1L;
}
