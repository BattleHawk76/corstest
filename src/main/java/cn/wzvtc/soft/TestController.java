package cn.wzvtc.soft;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin//跨域，去掉其他人不能访问,只能在本域值访问
@RestController("/" )
public class TestController {

    @RequestMapping(value="/userInfo")
    public Map<String,String> userInfo(HttpSession httpSession){
        Map<String,String> resultMap=new HashMap<>();
        if(httpSession.getAttribute("loginid")!=null){
            resultMap.put("myname","梁强强" +
                    "");
            resultMap.put("mynumber","18002090219");
        }
        return resultMap;
    }
    @RequestMapping(value="/data1.json")
    public Map<String,String> bookById1(){
        Map<String,String> resultMap=new HashMap<>();
        resultMap.put("myname","练书含" +
                "");
        resultMap.put("mynumber","18002090119");
        return resultMap;
    }
    @RequestMapping(value="/login")
    public Map<String,String> login(@RequestBody Map<String,String>map, HttpSession httpSession){
        String id=map.get("id");
        String password=map.get("password");
        Map<String,String>resultMap=new HashMap<>();
        if("18002090219".equals(id) && "18002090219".equals(password)){
            httpSession.setAttribute("loginid",id);
            resultMap.put("result","success");
        }
        return resultMap;
    }
}