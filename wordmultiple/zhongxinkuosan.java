package wordmultiple;

public class zhongxinkuosan {

    public static String zhongxin(String S) {
        if (S.length() < 2)
            return S;
        int left = 0;
        int right = 0;      //创建left，right作为子串的首尾下标；
        int Max = 0;
        //从头开始遍历字符串，将每个字符做为中心进行判断
        for (int i = 0; i < S.length(); i++) {
            int ji = Panduan(S, i, i);                 // 当当前字符作为奇数个的中心时
            int ou = Panduan(S, i, i + 1);       // 当当前字符作为偶数个的中心时
            int iMax = Math.max(ji, ou);
            if (iMax > Max) {                          // 判断当前返回的长度，是否比原长度大
                Max = iMax;
                left = i - ((Max-1) >> 1);             // 若返回的长度达，则记录目前最大长度是，子串的收尾位置
                right = i + (Max >> 1);
            }
        }
        return S.substring(left, right+1);             // 返回最大回文子串，注意substring左闭右开
    }
    //  Panduan 用于从left和right向两边遍历判断，返回第一次不相等的长度
    public static int Panduan(String S, int left, int right) {
        while (left >= 0 && right < S.length()&&S.charAt(left)==S.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }


    public static void main(String[] args) {
        System.out.println(zhongxin("abcbajkhasdfg"));
    }
}
