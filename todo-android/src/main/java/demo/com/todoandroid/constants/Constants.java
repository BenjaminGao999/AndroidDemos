package demo.com.todoandroid.constants;

/**
 * @auth zzc
 * @date 2017/12/7
 * @desc ${desc}
 */

public interface Constants {
    int PHONE_TYPE = 2;
    int APP_TYPE = 2;
    String APP_ID_WECHAT = "wx2128905807725f0b";
    String PHONE_SERVICE = "phone 4009262121";
    //net key start
    String NET_KEY_DEVICE_TYPE = "device_type";
    String NET_KEY_DEVICE_NAME = "device_name";
    String NET_KEY_PHONE_MODEL = "phone_model";
    String NET_KEY_SYSTEM_VERSION = "system_version";
    String NET_KEY_APP_VERSION = "app_version";
    String NET_KEY_DEVICE_ID = "device_id";
    String NET_KEY_TIME_STAMP = "timestamp";
    String NET_KEY_SIGN = "sign";
    String NET_KEY_LOGIN_TOKEN = "login_token";
    //net key end

    //key for intent end
    String INTENT_KEY_STRING = "keyString";
    String INTENT_KEY_STRING_A = "keyStringA";
    String INTENT_KEY_URI = "keyUri";
    String INTENT_KEY_INT = "keyInt";
    String INTENT_KEY_INT_A = "keyIntA";
    String INTENT_KEY_INT_LIST = "keyArray";
    String INTENT_KEY_FLOAT = "keyFloat";
    String INTENT_KEY_DOUBLE = "keyDouble";
    String INTENT_KEY_LONG = "keyLong";
    String INTENT_KEY_BOOLEAN = "keyBoolean";
    String INTENT_KEY_PARCEL = "keyParcel";
    String INTENT_KEY_PARCEL_A = "keyParcelA";
    String INTENT_KEY_PARCEL_LIST = "keyParcelList";
    String INTENT_KEY_STRING_LIST = "keyStringList";
    String INTENT_KEY_HASHMAP = "keyHashMap";
    String INTENT_KEY_SERIALIZE = "keySerialize";
    String INTENT_KEY_BUNDLE = "keyBundle";
    //key for intent end


    //request code for start activity
    int INTENT_REQ_CAMERA = 0x10;
    int INTENT_REQ_GALLEY = 0x11;
    int INTENT_REQ_CROP = 0x12;
    int INTENT_REQ_SCAN = 0x13;
    int INTENT_REQ_H5 = 0x14;
    int INTENT_REQ_PAY = 0x15;
    int INTENT_REQ_EDIT_NAME = 0x16;
    int INTENT_REQ_LOGIN = 0x17;
    int INTENT_REQ_PERMISSION_LOCATION = 0x18;
    int INTENT_REQ_EDIT_TOILET = 0x19;
    int INTENT_REQ_MATISSE = 0x20;
    int INTENT_REQ_SELECT_TOILET = 0x21;

    //file provider
    String FILE_PROVIDER_AUTHORITY = "com.liuxiaobai.store.paperoperations";

    //result code for activity
    int INTENT_RES_ERROR = 0x10;
    int INTENT_RES_ORDER_SEND = 0x11;
    int INTENT_RES_SCAN_TIMEOUT = 0x12;

    //file about
    String FILE_DIR_GLIDE_CACHE = "glideCache";
    String FILE_DIR_NET_CACHE = "netcache";
    String FILE_DIR_NET_ERROR = "netError";
    String FILE_REGION = "region.json";

    int REGION_VERION_DEFAULT = 2;

    int CODE_FALSE = 0;
    int CODE_TRUE = 1;

    //不同任务分类
    int TASK_MODE_RECOVER = 1;//发现
    int TASK_MODE_NEW = 2;//新任务
    int TASK_MODE_ORDER = 3;//工单
    int TASK_MODE_4CHECK = 4;//待审核列表
    int TASK_MODE_MORE = 5;//更多

    //上传图片限制
    int PIC_NUM_MIN = 2;
    int PIC_NUM_MAX = 6;

    //上传的厕所的状态
    int STATE_TOILET_NORMAL = 0;//正常，通过
    int STATE_TOILET_WAIT = 1;//等待审核
    int STATE_TOILET_REFUSE = 2;//拒绝

    float VALID_DISTANCE_M = 1000f;
    int VALID_DISTANCE_KM = 1;


    // 任务类型
    int TASK_TYPE_NONE = -1;//
    int TASK_TYPE_INSTALL = 1;//安装任务
    int TASK_TYPE_PLAN = 2;//计划巡检
    int TASK_TYPE_REPAIR = 3;//设备维修
    int TASK_TYPE_CHECK = 4;//数据核实
    int TASK_TYPE_MAINTAIN = 5;//设备维护

    int MACHINE_TYPE_HOST = 1;// 设备类型  主机
    int MACHINE_TYPE_SLAVE = 2;// 设备类型  从机


    // 搜索时间类型
    int SEARCH_TYPE_NEARBY_TOILETS = 1;
    int SEARCH_TYPE_NEARBY_DEVICES = 2;
    int SEARCH_TYPE_NAME = 3;


    // toilet java bean
    String BEAN_TOILET = "bean_toilet";


    // toilet device
    String BEAN_SEARCH_DEVICE = "bean_toilet_pre_device";

    // toilet info perfect 完善toilet信息
    String BEAN_TOILET_INFO_PERFECT = "bean_toilet_info_perfect";
    //设备安装码
    String INSTALLING_DEVICE_CODE = "installing_device_code";


    // 注册相关
    String REGISTER_ACCOUNT = "register_account";
    String REGISTER_CONFIRM_CODE = "register_confirm_code";
    String REGISTER_PSD = "register_psd";
    String REGISTER_PSD_CONFIRM = "register_psd_confirm";

    // photo picker 相关
    String EXTRA_SELECTED_PHOTOS = "EXTRA_SELECTED_PHOTOS";

    // 设备安装， 提交坑位ID
    String TOILET_DEVICE_INSTALLING_PIT_ID = "TOILET_DEVICE_INSTALLING_PIT_ID";

    // toilet id
    String TOILET_ID = "TOILET_ID";
    // task id 巡检意见需要
    String CHECKING_DEVICE_TASK_ID = "CHECKING_DEVICE_TASK_ID";
    // 配送任务detail
    String TASK_DELIVERY_DETAIL = "TASK_DELIVERY_DETAIL";
    // 维修任务 - 维修内容
    String TASK_REPAIR_CONTENT_JSON = "TASK_REPAIR_CONTENT_JSON";
    //
    String TASK_REPORT_DEVICE_ID = "TASK_REPORT_DEVICE_ID";
    //
    String FLAG_TASK_REPORT_DEVICE_ID = "FLAG_TASK_REPORT_DEVICE_ID";

    // 维护
    String TASK_MAINTAIN = "TASK_MAINTAIN";
    // 紧急任务
    String TASK_EMERGENCY_DETAIL = "TASK_EMERGENCY_DETAIL";

    // 自营人员
    CharSequence USR_TYPE_SELF = "2";
    // 第三方运维主管
    CharSequence USR_TYPE_3ND_MANAGER = "3";
    CharSequence USR_TYPE_3ND_EMPLOYEE = "4";

    // 下属
    String EMPLOYEE_JSON = "EMPLOYEE_JSON";

    // 标记, true: 添加下属； false: 修改下属
    String FLAG_MINE_EMPLOYEE_ADD = "FLAG_MINE_EMPLOYEE_ADD";


    // 设备正常
    String FLAG_DEVICE_STATUS_OK = "0";

    // 设备异常
    String FLAG_DEVICE_STATUS_ERROR = "1";


    // 设备ID
    String DEVICE_ID = "DEVICE_ID";
}
