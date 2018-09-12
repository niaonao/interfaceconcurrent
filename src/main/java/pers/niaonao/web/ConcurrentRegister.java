package pers.niaonao.web;

import org.json.JSONObject;
import pers.niaonao.entity.TreasureEntity;
import pers.niaonao.util.TransObjectByHttp;

/**
 * @Description :注册接口测试
 * @Date: 2018/9/12 14:11
 */
public class ConcurrentRegister {

    // 接口 Url
    private static String interfaceUrl;

    // JSON 格式请求数据
    private static String objectToJson;

    // 并发数
    private final static int NUM_10 = 10;

    public static void main(String args[]) {

        initData();

        requestUrl();
    }

    /**
     * 初始化接口请求数据
     */
    private static void initData() {
        interfaceUrl = "http://localhost:8080/manage/app/user/register";

        // 初始化请求参数
        String treasureID = "402216352";
        String treasureData = "{\"userPhone\":\"15738539120\",\"userPassword\":\"1357ac90\",\"phoneCode\":\"666666\"}";
        String treasureDESKey = "u+p50xk3Ak0sdCP2OfB144Vi/sBPl/UbXE0qVyYOoWopjky9Cj2TbfptQuFRAno8LrREdL43JQTI6IZR1bGT/tRBTAEySbMaSCqAKBMplRPCnJoF6hsux0oJ2o/dJW+q9MRmtdwOCVWjfsp25nrkCwt6TTbiYAmULWrkC/8Mwlk=";

        TreasureEntity treasureEntity = new TreasureEntity(treasureID, treasureData, treasureDESKey, interfaceUrl);

        // JSON 格式处理
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("treasureID", treasureEntity.getTreasureID());
        jsonObject.put("treasureData", treasureEntity.getTreasureData());
        jsonObject.put("treasureDESKey", treasureEntity.getTreasureDESKey());

        objectToJson = jsonObject.toString();
    }

    /**
     * 请求接口方法
     */
    private static void requestUrl() {
        final Runnable runnable = new Runnable() {
            public void run() {
                TransObjectByHttp.sendToWeb(objectToJson, interfaceUrl);
            }
        };

        // 开启多线程并行测试
        for (int i = 0; i < NUM_10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}