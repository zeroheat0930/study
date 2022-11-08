package study;

import com.sun.org.apache.xpath.internal.operations.String;
import com.sun.xml.internal.ws.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class camel {

    private Map<String, Object> toCameCaseMap(Map<String, Object> orgMap){
        Map<String, Object> rtnMap;
        if(orgMap != null){
            rtnMap = new HashMap<String, Object>();
            orgMap.forEach((k, v) -> rtnMap.put(toCamelCase(k), v));
        }else {
            rtnMap = null;
        }
        return rtnMap;
    }


    private List<Map<String, Object>> toCameCaseMapList(List<Map<String, Object>>orgList) {
        return orgList == null? orgList : orgList.stream().map(e-> toCameCaseMap(e)).collect(Collectors.toList());
    }

    private String toCamelCase(String target){
        StringBuffer buffer = new StringBuffer();
        for(String token : target.toLowerCase().split("_")){
            buffer.append(StringUtils.capitalize(token));
        }
        return StringUtils.uncapitalize(buffer.toString());
    }
}
