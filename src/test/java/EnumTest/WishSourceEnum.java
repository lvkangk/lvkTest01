package EnumTest;

/**
 * 志愿来源
 * 1~10 来自大街网服务
 * 11开始是第三方合作来源
 *
 * 此字段在数据库是tinyint类型,所以code不要设置太大
 *
 * @author: kangkang.lv
 * @date: 17-8-31 下午3:47
 */
public enum WishSourceEnum{

    PC(1),
    APP(2),
    M(3),
    WZ(4),
    WZP(5),
    BM_FASTAPPLY(6),   //报名_闪投
    QD_FASTAPPLY(7),   //签到_闪投

    ALI_SCHOOL(11);     //阿里校园



    private final int code;

    private WishSourceEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static WishSourceEnum parse(int code) {
        for (WishSourceEnum type : WishSourceEnum.values()) {
            if (code == type.getCode()) {
                return type;
            }
        }
        return null;
    }
}
