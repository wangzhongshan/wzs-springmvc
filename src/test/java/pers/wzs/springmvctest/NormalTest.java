package pers.wzs.springmvctest;

/**
 * @author wangzhongshan
 * @description
 * @created 2016-08-19 16:41
 */
public class NormalTest {
    public static void main(String[] args) {
        Integer aa = new Integer("47");
        Integer bb = new Integer("46");
        System.out.println(aa.compareTo(bb)<0);
    }
}
