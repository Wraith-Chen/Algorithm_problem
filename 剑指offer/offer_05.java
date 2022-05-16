package 剑指offer;
/**
 * @Time 2022-05-16
 * @Title offer_05 替换空格
 * @Difficulty_Level easy
 */
/*
    StringBuilder类秒题。
*/
public class offer_05 {
    public String replaceSpace(String s) {
       StringBuilder sb = new StringBuilder("");
       for (int i =0 ;i<s.length();i++){
           if(s.charAt(i)==' '){
               sb.append("%20");
           }else
               sb.append(s.charAt(i));
       }
       return sb.toString();
    }
}
