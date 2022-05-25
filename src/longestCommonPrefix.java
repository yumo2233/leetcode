/**
 * @author Pzr
 * @create 2022/5/25 - 21:33
 */
https://leetcode.cn/submissions/detail/317950614/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int length = strs.length;
        String Prefix = strs[0];
        for(int i = 1;i < strs.length;i++){
            Prefix = calPrefix(Prefix,strs[i]);
            if(Prefix.length()==0){
                return Prefix;
            }
        }
        return Prefix;
    }
    public String calPrefix(String s1,String s2){
        int length = Math.min(s1.length(),s2.length());
        int index = 0;
        for(int i = 0;i < length;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                break;
            }
            index++;
        }
        return s1.substring(0,index);
    }

}
