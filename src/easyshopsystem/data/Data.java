package easyshopsystem.data;

import static easyshopsystem.data.Customer.setCustInfo;
import static easyshopsystem.data.Customer.setCustomer;
import static easyshopsystem.data.Goods.setGOODS;
import static easyshopsystem.data.Manager.setManager;

public final class Data {
    public static final String start = """
            Welcome to SMS!
            ----------------
            1.客 户 登 陆
            2.管 理 员 登 陆
            3.退 出
            ----------------
            请选择:""";
    public static final String custHome = """
            -------------
            1.购 物 结 算
            2.真 情 回 馈
            3.注 销
            -------------
            请选择:""";
    public static final String managerHome = """
            --------------
            1.信 息 管 理
            --------------
            请选择,按'n'返回:""";
    public static final String custInfoManage = """
            ------------------------
            1.显 示 所 有 会 员 信 息
            2.显 示 所 有 商 品 信 息
            3.添 加 会 员 信 息
            4.添 加 商 品 信 息
            5.修 改 会 员 信 息
            6.修 改 商 品 信 息
            7.查 询 会 员 信 息
            8.查 询 商 品 信 息
            9.跳 转 到 源 码
            ------------------------
            请选择,按'n'返回:""";
    public static final String title = """
            会员号     生日     积分
            -------|-------|-------|""";
    public static final String fun = """
            ----------------
            1.幸 运 大 放 送
            2.幸 运 抽 奖
            3.生 日 问 候
            ----------------
            请选择,按'n'返回:""";
    public static final String list = """
            -------------------消费清单-------------------
                   物品      单价      个数     金额""";
    public static final String modify = """
            -------------------
            1.修 改 会 员 生 日
            2.修 改 会 员 积 分
             -------------------
            请选择:""";
    public static final String modifyGOODS = """
            -------------------
            1.修 改 商 品 名 称
            2.修 改 商 品 单 价
             -------------------
            请选择,按'n'返回:""";
    public static final String line = "-----------------------------";
    public static final String thank = "Thanks!";
    public static final String cName = "用户名(4位数):";
    public static final String cPw = "密码(同用户名):";
    public static final String Mname = "管理员名:";
    public static final String custNo = "会员号:";
    public static final String birth = "生日(月/日<2位>):";
    public static final String cust = "会员";
    public static final String score = "积分";
    public static final String price = "价格:";
    public static final String Gnm = "名称:";
    public static final String GN = "编号:";
    public static final String password = "密码:";
    public static final String back = "按'n'返回:";
    public static final String backup = "返回上层菜单(y/n):";
    public static final String sus = "添加成功\n继续添加(y/n):";
    public static final String mod = "修改其他(y/n):";
    public static final String got = "获";
    public static final String curr = "Current Date:";
    public static final String greet = " :Happy Birthday!";
    public static final String wait = "waiting for exiting process\n.....................3";
    public static final String err = "error!";
    public static final String exi = "exit!";
    public static final String wr = "wrong!";
    public static final String done = "done!";
    public static final String no = "none!";

    public static void init() {
        setManager("manager", "1234");
        setCustomer("1900", "1900");
        setCustomer("1711", "1711");
        setCustomer("1623", "1623");
        setCustomer("1545", "1545");
        setCustomer("1464", "1464");
        setCustomer("1372", "1372");
        setCustomer("1286", "1286");
        setCustInfo("1900", new String[]{"08/05", "2000"});
        setCustInfo("1711", new String[]{"07/03", "4000"});
        setCustInfo("1623", new String[]{"06/26", "5000"});
        setCustInfo("1545", new String[]{"04/08", "2200"});
        setCustInfo("1464", new String[]{"08/16", "1000"});
        setCustInfo("1372", new String[]{"12/23", "3000"});
        setCustInfo("1286", new String[]{"12/21", "10080"});
        setGOODS(1, new String[]{"addidas 运动鞋", "420.78"});
        setGOODS(2, new String[]{"Kappa 网球裙", "200"});
        setGOODS(3, new String[]{"网球拍", "780"});
        setGOODS(4, new String[]{"addidas T恤", "880"});
        setGOODS(5, new String[]{"Nike 运动鞋", "900"});
        setGOODS(6, new String[]{"Kappa 网球", "45"});
        setGOODS(7, new String[]{"Kappa T恤", "245"});
    }
}
