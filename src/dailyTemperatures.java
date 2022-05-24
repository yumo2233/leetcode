import java.util.Stack;

/**
 * @author Pzr
 * @create 2022/5/20 - 20:02
 */
//每日温度 https://leetcode.cn/leetbook/read/queue-stack/genw3/
public class dailyTemperatures (int[] temperatures){
    int[] a = new int[temperatures.length];
    Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
        while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
            int index = stack.pop();
            a[index] = i - index;
        }

        stack.push(i);
    }
        return a;
}
}
//