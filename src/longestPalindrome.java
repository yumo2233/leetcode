/**
 * @author Pzr
 * @create 2022/5/25 - 21:32
 */
//https://leetcode.cn/submissions/detail/317980810/
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0 || s==null){
            return null;
        }
        int start = 0,end = 0;
        for(int i = 0;i <= s.length()-1;i++){
            //为奇数的情况
            int oddlength = 0;
            while((i-oddlength)>=0 && (i+oddlength)<s.length()){
                if(s.charAt(i-oddlength) == s.charAt(i+oddlength)){
                    oddlength++;
                }else{
                    break;
                }

            }
            oddlength--;
            //为偶数的情况
            int evenlength = 0;
            while((i-evenlength)>=0 && (i+evenlength+1)<s.length()){
                if(s.charAt(i-evenlength)== s.charAt(i+evenlength+1)){
                    evenlength++;
                }else{
                    break;
                }
            }
            evenlength--;
            if(Math.max(oddlength*2+1,evenlength*2+2) > (end-start+1)){
                if((oddlength*2+1 )>( evenlength*2+2)){
                    start = i-oddlength;
                    end = i+oddlength;
                }else {
                    start = i-evenlength;
                    end = i+evenlength+1;
                }
            }
        }
        return s.substring(start,end+1);
    }
}