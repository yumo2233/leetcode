/**
 * @author Pzr
 * @create 2022/5/30 - 19:34
 */
//https://leetcode.cn/leetbook/read/array-and-string/cm5e2/
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){return 0;}
        int m  = haystack.length(),i = 0;
        int n  = needle.length(),j = 0;
        int[] next = next(needle);
        while(i<m && j<n){
            if(j < 0 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j==n){
            return i-j;
        }else{
            return -1;
        }
    }




    private int[] next(String needle){
    /*next[]作用：直接让模式串的指针回到需要比较的位置
    //这个next[]数组的手动求法：欲求next[j]，看0到j-1组成的字符串,找到字符串前后缀的重合字符数
    /next[0]规定为-1，next[1]为0
     */
        int m = needle.length();
        int[] next = new int[m];
        next[0] = -1;
        int t = -1,j = 0;//注意这里j比t大
        while(j<m-1){//j比t大，所以只要J小于字符串的最大长度即可
            if(t<0 || needle.charAt(t) == needle.charAt(j)){
                /*
                J值的增加必然伴随着next[j]的值已经被附上了
                t<0，t只可能为-1，
                对应两种情况：
                1.在经历不断的看门盘之后，仍然没有重合的字符数，那么此时t = next[0]=-1，那么J所指的元素所对应的
                next[j]就为0
                2.比较特殊的是一开始给第二个元素所对应的值赋0

                一旦满足needle.charAt(t) == needle.charAt(j)则代表t的前面的值和j后面的值是一样的

                p下标 代表其模式串的元素
                本质上的方法还是找到next[j-1]-1，然后拿Pnext[j-1]和Pj比较,相等就是最理想的情况
                直接加1即为next[j]的值。

                Why找到next[j-1]-1？由求next[]的方法知，next[]的值还可以代表字串前后缀重合的字符数，也就是前缀和后缀相等
                的字符数！所以就不用再比较了，直接看相等的两个子串后面的那一位是否相等即可

                代码也很讨巧，每次进了if之后，再进，就代表比较此时刻的两个字串的后一位是否相等，如果不等，就让子串变小
                （t = next[t];）比较小子串后面的值是否相等。同理，小子串的部分肯定也是相等的。所以本质就是再不断变化字串的
                情况下（不断变小）找到和Pj-1相等的值，最坏的情况就是为0，即一个也没有。意味着如果主串和模式串在这个位置不相等时
                那么只能让模式串从头开始和此时的主串指针所指的字符进行比较
                 */
                t++;
                j++;
                next[j] = t;
            }else{
                t = next[t];
            }
        }
        return next;
    }
}