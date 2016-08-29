package pers.wzs.springmvctest;

/**
 * @author wangzhongshan
 * @description
 * @created 2016-08-19 16:41
 */
public class NormalTest {
    public static void main(String[] args) {
        Integer aa = new Integer("1");
        Integer bb = new Integer("1");
        System.out.println(aa==1);


        String aaa = "http://img4.jiecaojingxuan.com/2016/8/19/593e6a8d-dbc9-4f70-b444-63540c4cc015.png";
        System.out.println(aaa.split("[?]")[0]);
    }
}
