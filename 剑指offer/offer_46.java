package 剑指offer;
/**
 * @Time 2022-5-5
 * @Title 剑指offer-46 把数字翻译成字符串
 * @Difficulty_Level middle
 */
/*
    动态规划，建立状态转移方程：记数字 num 第 i 位数字为 xi，数字 num 的位数为 n ；
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    状态定义：设动态规划列表 dp ，dp[i]代表以xi为结尾的数字的翻译方案数量
    转移方程：若xi和xi-1组成的两位数字可以被翻译，则dp[i]=dp[i-1]+dp[i-2];否则dp[i]=dp[i-1]。
            注意：当xi-1=0时，组成的两位数字是不被翻译的(00,01,02....)所以区间为[10,25]
            dp[i]=dp[i-1]+dp[i-2] xi-1xi-[10,25]
            dp[i]=dp[i-1] xi-1xi-[0,10),(25,99]
    初始状态：
        dp[0] = dp[1] = 1,没有数字和第一位数字的数字量都是1。
    返回值：
        返回dp[n],即此数字的翻译方案数量
 */
public class offer_46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
