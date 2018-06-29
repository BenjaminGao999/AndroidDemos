package demo.com.todoandroid.netApis;

/**
 * Author: benjamin
 * Time: 2018/6/13:下午4:32
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public interface APIs {

    //    https://dev-api-paper.lxbznkj.com/operate/machine/searchToilet
    String baseUrl = "http://test-api-paper.lxbznkj.com";

    //    搜索厕所
//    https://dev-api-paper.lxbznkj.com/operate/machine/searchToilet
    // 关键词搜索toilet
    String SEARCH_TOILETS_USING_KEYWORD = baseUrl + "/operate/machine/searchToilet";

    // 单个toilet的机器列表
    //http://test-api-paper.lxbznkj.com/operate/toilet/getToiletDetail
    String SEARCH_TOILET_DEVICES_LIST = baseUrl + "/operate/toilet/getToiletDetail";

    // 具体设备详情, 异常设备详情
//   http://xx.com/operate/machine/getAbnormalMachineDetail
    String SEARCH_TOILET_DEVICE_DETAIL_FIXED_NEED = baseUrl + "/operate/machine/getAbnormalMachineDetail";


    // 安装任务列表
    String TASK_DEVICE_INSTALL_LIST = baseUrl + "/operate/machine/useraddmachinetask";

    // 用户登陆接口
    String USR_LOGIN = baseUrl + "/operate/login/userLogin";

    // 提交注册信息
    //https://dev-api-paper.lxbznkj.com/operate/login/register
    String USR_REGISTER = baseUrl + "/operate/login/register";


    // 获取验证码接口
    //https://dev-api-paper.lxbznkj.com/operate/login/getCode
    String USR_REGISTER_MSG_CONFIRM_CODE = baseUrl + "/operate/login/getCode";


    // 修改密码
//    https://dev-api-paper.lxbznkj.com/operate/login/modifyPassword
    String USR_MODIFY_PSD = baseUrl + "/operate/login/modifyPassword";


    //完善toilet信息
    //http://xx.com/operate/toilet/edittoilet
    String TOILET_INFO_PREFECT = baseUrl + "/operate/toilet/edittoilet";


    //    运营端厕所设备开始安装接口
//    http://xx.com/operate/machine/beginAddMachine
    String DEVICE_INSTALLING_ADD_MACHINE = baseUrl + "/operate/machine/beginAddMachine";


    //    运营端卫生间设备列表
    //http://test-api-paper.lxbznkj.com/operate/toilet/getToiletDetail
    String DEVICE_INSTALLING_INSTALLED_DEVICES = baseUrl + "/operate/toilet/getToiletDetail";


    // 巡检任务
//    巡检意见提交
//    https://dev-api-paper.lxbznkj.com/operate/machine/checkList
    String TASK_CHECKING_ADVANTAGES = baseUrl + "/operate/machine/checkList";


    //    厕所列表
//    http://xx.com/operate/machine/userMachineAroundCheckToiletList
    String TASK_CHECKING_TOILETS_LIST = baseUrl + "/operate/machine/userMachineAroundCheckToiletList";


    //    设备列表
//    http://xx.com/operate/machine/userMachineAroundCheckList
    String TASK_CHECKING_DEVICES = baseUrl + "/operate/machine/userMachineAroundCheckList";


    //    配送任务列表
//    http://xx.com/operate/machine/sendPaperTask
    String TASK_DELIVERY_LIST = baseUrl + "/operate/machine/sendPaperTask";

    //    配送详情页面
//    http://xx.com/operate/machine/ackIsSend
    String TASK_DELIVERY_CONFIRMED = baseUrl + "/operate/machine/ackIsSend";


    //    维修任务列表
//    http://test-api-paper.lxbznkj.com/operate/machine/userFixMachineTask
    String TASK_UNREPAIRED_LIST = baseUrl + "/operate/machine/userFixMachineTask";

    //    维修详情提交
//    http://xx.com/operate/machine/addMachineDetail
    String TASK_REPAIR_DETAIL_COMMIT = baseUrl + "/operate/machine/addMachineDetail";


    //    故障上报
//    http://xx.com/operate/machine/failureReporting
    String TASK_REPORT = baseUrl + "/operate/machine/failureReporting";


    //    换纸换电池任务列表
//    http://xx.com/operate/machine/changePaperAndElectricTask
//    /operate/machine/changePaperAndElectricTask
    String TASK_MAINTAIN_ADD_PAPER_CHANGE_BATTERY = baseUrl + "/operate/machine/changePaperAndElectricTask";


    //    换纸换电详情提交
//    http://xx.com/operate/machine/changePaperAndEletricDetail
    String TASK_MAINTAIN_ADD_PAPER_CHANGE_BATTERY_DETAIL =
            baseUrl + "/operate/machine/changePaperAndEletricDetail";


    //    紧急任务列表
//    http://xx.com/api/operate/machine/emergentTask
    String TASK_EMERGENCY_LIST = baseUrl + "/operate/machine/emergentTask";


    //    确认支援任务
//    http://xx.com/operate/machine/ackEmergentTask
    String TASK_EMERGENCY_HANDLE = baseUrl + "/operate/machine/ackEmergentTask";

    //    运营端修改密码
//    https://dev-api-paper.lxbznkj.com/operate/login/editPassword
    String MINE_RESET_PSD = baseUrl + "/operate/login/editPassword";


    //    下属列表接口
//    http://xx.com/operate/user/subSetUserList
    String MINE_EMPLOYEE_LIST = baseUrl + "/operate/user/subSetUserList";

    //    添加下属接口
//    http://xx.com/operate/user/addSubSetUser
    String MINE_EMPLOYEE_ADD = baseUrl + "/operate/user/addSubSetUser";

    //    删除下属接口
//    http://xx.com/operate/user/delSubSetUser
    String MINE_EMPLOYEE_DELETE = baseUrl + "/operate/user/delSubSetUser";

    //    修改下属信息接口
//    http://xx.com/operate/user/updateSubSetUser
    String MINE_EMPLOYEE_UPDATE = baseUrl + "/operate/user/updateSubSetUser";


}
