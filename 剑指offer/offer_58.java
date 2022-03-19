package 剑指offer;
/**
 * @Time 2022-03-19
 * @Title 剑指offer_57 II.左旋转字符串
 * @Difficulty_Level easy
 */
/*
    较为简单的一道题，方法较多，这里介绍三种效率较高的方法。
    方法一:字符串切片
    用String的substring()方法，两个参数为左开右闭区间[0,5)。
    方法二：列表遍历拼接
    1.新建一个StringBuilder记为res；
    2.先向res添加“第n+1位至末位的字符”；
    3.再向res添加“首位至第n位的字符”；
    4.将res转化为字符串并返回。
    其中，利用求余运算可以简化代码
    方法三：字符串遍历拼接
    与方法二思路大概一致，不过这里只采用String去操作字符串。同样可以采用求余运算简化代码。
 */
public class offer_58 {
    public String reverseLeftWords_1(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
    public String reverseLeftWords_2_1(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }
    public String reverseLeftWords_2_2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }
    public String reverseLeftWords_3_1(String s, int n) {
        String res = "";
        for(int i = n; i < s.length(); i++)
            res += s.charAt(i);
        for(int i = 0; i < n; i++)
            res += s.charAt(i);
        return res;
    }
    public String reverseLeftWords_3_2(String s, int n) {
        String res = "";
        for(int i = n; i < n + s.length(); i++)
            res += s.charAt(i % s.length());
        return res;
    }
}
