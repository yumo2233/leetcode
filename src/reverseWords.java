/**
 * @author Pzr
 * @create 2022/5/25 - 21:34
 */
//https://leetcode.cn/submissions/detail/317991006/
class Solution {
    public String reverseWords(String s) {
        String[] word = s.split(" ");//两个空格会有一个为null的元素个体
        int len = word.length;
        StringBuffer buffer=new StringBuffer();
        while(len-->0){
            System.out.print(word[len]+"1");
            if(!word[len].isEmpty()){
                if(buffer.length() > 0){
                    buffer.append(" ");
                }
                buffer.append(word[len]);

            }
        }
        return buffer.toString();
    }
}
