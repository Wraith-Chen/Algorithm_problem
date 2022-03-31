package 栈;

/**
 * @Time 2022-3-31
 * @Title interview03_01 三合一
 * @Difficulty_Level easy
 */
/*
    简单的创建栈，这里我们考虑用二维数组去创建。
    二维数组每一行代表一个栈，同时用一个标志数组，记录每个栈的待插入下标。
 */

public class interview03_01 {
    class TripleInOne{
        int N = 3;
        // 3 * n 的数组，每一行代表一个栈
        int[][] data;
        // 记录每个栈「待插入」位置
        int[] locations;

        public TripleInOne(int stackSize) {
            data = new int[N][stackSize];
            locations = new int[N];
        }

        public void push(int stackNum, int value) {
            int[] stk = data[stackNum];
            //根据所给下标创建一个新的数组栈
            int loc = locations[stackNum];
            //设置一个标志记录待插入位置
            if (loc < stk.length) {
                stk[loc] = value;
                //将数据存入数组栈
                locations[stackNum]++;
                //已经存入数据，则该位置标志加1
            }
        }

        public int pop(int stackNum) {
            int[] stk = data[stackNum];
            int loc = locations[stackNum];
            if (loc > 0) {
                int val = stk[loc - 1];
                locations[stackNum]--;
                //元素出栈标志数字减1
                return val;
            } else {
                return -1;
            }
        }

        public int peek(int stackNum) {
            int[] stk = data[stackNum];
            int loc = locations[stackNum];
            if (loc > 0) {
                return stk[loc - 1];
            } else {
                return -1;
            }
        }

        public boolean isEmpty(int stackNum) {
            return locations[stackNum] == 0;
        }
    }
}
