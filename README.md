# interfaceconcurrent
&nbsp;&nbsp;Spring Boot 接口并发测试，开启多线程使用Http 请求并行测试接口来测试并发。<br/>

# 测试接口说明
&nbsp;&nbsp;此处测试注册接口<br>
&nbsp;&nbsp;http://localhost:8080/manage/app/user/register<br>
&nbsp;&nbsp;测试项目代码未提交到Github，下面简单说明一下注册接口。<br>
``` java
    /**
     * 用户注册
     * @param baseResult
     * @return
     */
    @RequestMapping(value = "user/register" , produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult UserRegister(@RequestBody BaseResult baseResult){
        customFile.info( "appId:"+ baseResult.getTreasureID()+"用户注册访问:" + baseResult.toString() );
        return appUserService.userRegister(baseResult);
    }
```

&nbsp;&nbsp;请求参数封装<br>
``` java
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 3401781428101852075L;

    private String ip;

    /**
     * appId
     */
    private String treasureID;

    /**
     * 请求响应加密数据
     */
    private String treasureData;

    /**
     * desKey
     */
    private String treasureDESKey;
    ...
}
```
## 测试方式
&nbsp;&nbsp;开启多线程通过Http 请求并行访问接口。
## 测试结果
```
TransObjectByHttp: 请求数据 - {"treasureID":"402216352","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk=","treasureData":"{\"userPhone\":\"15738539120\",\"userPassword\":\"1357ac90\",\"phoneCode\":\"666666\"}"}
TransObjectByHttp: 请求数据 - {"treasureID":"402216352","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk=","treasureData":"{\"userPhone\":\"15738539120\",\"userPassword\":\"1357ac90\",\"phoneCode\":\"666666\"}"}
TransObjectByHttp: 请求数据 - {"treasureID":"402216352","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk=","treasureData":"{\"userPhone\":\"15738539120\",\"userPassword\":\"1357ac90\",\"phoneCode\":\"666666\"}"}
TransObjectByHttp: 请求数据 - {"treasureID":"402216352","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk=","treasureData":"{\"userPhone\":\"15738539120\",\"userPassword\":\"1357ac90\",\"phoneCode\":\"666666\"}"}
TransObjectByHttp: 请求数据 - {"treasureID":"402216352","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk=","treasureData":"{\"userPhone\":\"15738539120\",\"userPassword\":\"1357ac90\",\"phoneCode\":\"666666\"}"}
TransObjectByHttp: 请求数据 - {"treasureID":"402216352","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk=","treasureData":"{\"userPhone\":\"15738539120\",\"userPassword\":\"1357ac90\",\"phoneCode\":\"666666\"}"}
TransObjectByHttp: 请求数据 - {"treasureID":"402216352","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk=","treasureData":"{\"userPhone\":\"15738539120\",\"userPassword\":\"1357ac90\",\"phoneCode\":\"666666\"}"}
TransObjectByHttp: 请求数据 - {"treasureID":"402216352","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk=","treasureData":"{\"userPhone\":\"15738539120\",\"userPassword\":\"1357ac90\",\"phoneCode\":\"666666\"}"}
TransObjectByHttp: 请求数据 - {"treasureID":"402216352","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk=","treasureData":"{\"userPhone\":\"15738539120\",\"userPassword\":\"1357ac90\",\"phoneCode\":\"666666\"}"}
TransObjectByHttp: 请求数据 - {"treasureID":"402216352","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk=","treasureData":"{\"userPhone\":\"15738539120\",\"userPassword\":\"1357ac90\",\"phoneCode\":\"666666\"}"}
TransObjectByHttp: 返回数据 - {"ip":null,"treasureID":"402216352","treasureData":"{\"errCode\":\"100188\",\"errMsg\":\"当前用户已经注册过\",\"responseTime\":\"1536737371\",\"result\":{\"flag\":false}}","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk="}
TransObjectByHttp: 返回数据 - {"ip":null,"treasureID":"402216352","treasureData":"{\"errCode\":\"100188\",\"errMsg\":\"当前用户已经注册过\",\"responseTime\":\"1536737371\",\"result\":{\"flag\":false}}","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk="}
TransObjectByHttp: 返回数据 - {"ip":null,"treasureID":"402216352","treasureData":"{\"errCode\":\"100188\",\"errMsg\":\"当前用户已经注册过\",\"responseTime\":\"1536737371\",\"result\":{\"flag\":false}}","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk="}
TransObjectByHttp: 返回数据 - {"ip":null,"treasureID":"402216352","treasureData":"{\"errCode\":\"100188\",\"errMsg\":\"当前用户已经注册过\",\"responseTime\":\"1536737371\",\"result\":{\"flag\":false}}","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk="}
TransObjectByHttp: 返回数据 - {"ip":null,"treasureID":"402216352","treasureData":"{\"errCode\":\"100188\",\"errMsg\":\"当前用户已经注册过\",\"responseTime\":\"1536737371\",\"result\":{\"flag\":false}}","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk="}
TransObjectByHttp: 返回数据 - {"ip":null,"treasureID":"402216352","treasureData":"{\"errCode\":\"100188\",\"errMsg\":\"当前用户已经注册过\",\"responseTime\":\"1536737371\",\"result\":{\"flag\":false}}","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk="}
TransObjectByHttp: 返回数据 - {"ip":null,"treasureID":"402216352","treasureData":"{\"errCode\":\"100188\",\"errMsg\":\"当前用户已经注册过\",\"responseTime\":\"1536737371\",\"result\":{\"flag\":false}}","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk="}
TransObjectByHttp: 返回数据 - {"ip":null,"treasureID":"402216352","treasureData":"{\"errCode\":\"100188\",\"errMsg\":\"当前用户已经注册过\",\"responseTime\":\"1536737371\",\"result\":{\"flag\":false}}","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk="}
TransObjectByHttp: 返回数据 - {"ip":null,"treasureID":"402216352","treasureData":"{\"errCode\":\"100188\",\"errMsg\":\"当前用户已经注册过\",\"responseTime\":\"1536737371\",\"result\":{\"flag\":false}}","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk="}
TransObjectByHttp: 返回数据 - {"ip":null,"treasureID":"402216352","treasureData":"{\"errCode\":\"100188\",\"errMsg\":\"当前用户已经注册过\",\"responseTime\":\"1536737371\",\"result\":{\"flag\":false}}","treasureDESKey":"u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk="}
```
