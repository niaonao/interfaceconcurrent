package pers.niaonao.entity;

/**
 * @Description :封装请求参数实体类
 * @Date: 2018/9/5 14:04
 */
public class TreasureEntity {

    // 请求标识
    private String treasureID;
    // 加密数据(此处未加密)
    private String treasureData;
    // 加密key
    private String treasureDESKey;
    // 接口的url
    private String interfaceUrl;

    public String getTreasureID() {
        return treasureID;
    }

    public void setTreasureID(String treasureID) {
        this.treasureID = treasureID;
    }

    public String getTreasureData() {
        return treasureData;
    }

    public void setTreasureData(String treasureData) {
        this.treasureData = treasureData;
    }

    public String getTreasureDESKey() {
        return treasureDESKey;
    }

    public void setTreasureDESKey(String treasureDESKey) {
        this.treasureDESKey = treasureDESKey;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    /**
     * 构造方法
     * @param treasureID
     * @param treasureData
     * @param treasureDESKey
     * @param interfaceUrl
     */
    public TreasureEntity(String treasureID, String treasureData, String treasureDESKey, String interfaceUrl) {
        this.treasureID = treasureID;
        this.treasureData = treasureData;
        this.treasureDESKey = treasureDESKey;
        this.interfaceUrl = interfaceUrl;
    }
}