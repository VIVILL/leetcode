package Graph;

/**
 * https://leetcode.cn/problems/valid-sudoku/
 * 36. 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *
 * 输入：board =
 * [['5','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * 输出：true
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[] char1 = {'5','3','.','.','7','.','.','.','.'};
        char[] char2 = {'6','.','.','1','9','5','.','.','.'};
        char[] char3 = {'.','9','8','.','.','.','.','6','.'};
        char[] char4 = {'8','.','.','.','6','.','.','.','3'};
        char[] char5 = {'4','.','.','8','.','3','.','.','1'};
        char[] char6 = {'7','.','.','.','2','.','.','.','6'};
        char[] char7 = {'.','6','.','.','.','.','2','8','.'};
        char[] char8 = {'.','.','.','4','1','9','.','.','5'};
        char[] char9 = {'.','.','.','.','8','.','.','7','9'};

        char[][] chars = {char1,char2,char3,char4,char5,char6,char7,char8,char9};
        System.out.println("isValidSudoku = " + isValidSudoku(chars) + " isValidSudoku1 = " + isValidSudoku1(chars)
                + " isValidSudoku2 = " + isValidSudoku2(chars));
    }

    // https://leetcode.cn/problems/valid-sudoku/solution/36-jiu-an-zhao-cong-zuo-wang-you-cong-shang-wang-x/450856
    // 2ms 版本
    public static boolean isValidSudoku(char[][] board) {
        int [][]row  =new int[9][10];
        int [][]col  =new int[9][10];
        int [][]box  =new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]=='.'){
                    continue;
                }
                int curNum = board[i][j]-'0';
                if (row[i][curNum]==1){
                    return false;
                }if (col[j][curNum]==1){
                    return false;
                }
                int[] box1 = box[j / 3 + (i / 3) * 3];
                if (box1[curNum]==1){
                    return false;
                }
                row[i][curNum]=1;
                col[j][curNum]=1;
                box1[curNum]=1;
            }
        }
        return true;
    }

    /*
由于board中的整数限定在1到9的范围内，因此可以分别建立哈希表来存储任一个数在相应维度上是否出现过。维度有3个：所在的行，所在的列，所在的box，注意box的下标也是从左往右、从上往下的。

遍历到每个数的时候，例如boar[i][j]，我们判断其是否满足三个条件：

在第 i 个行中是否出现过
在第 j 个列中是否出现过
在第 j/3 + (i/3)*3个box中是否出现过.为什么是j/3 + (i/3)*3呢？
关于从数组下标到box序号的变换
 重述一遍问题：给定i和j，如何判定board[i][j]在第几个box呢？
 显然属于第几个box由i和j的组合唯一确定，例如board[2][2]一定是第0个box，board[4][7]一定是第5个box，可以画出来看一下，但是规律在哪里呢？
我们可以考虑一种简单的情况： 一个3x9的矩阵，被分成3个3x3的box，如图：

    * */
    // https://leetcode.cn/problems/valid-sudoku/solution/36-jiu-an-zhao-cong-zuo-wang-you-cong-shang-wang-x/1317941
    // 1ms 版本
    public static boolean isValidSudoku1(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] boxes = new int[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.')  continue;
                int c = board[i][j] - '1';
                int index = j / 3 + (i / 3) * 3;
                if(rows[i][c] == 1 || columns[j][c] == 1 || boxes[index][c] == 1)   return false;
                rows[i][c] = 1;
                columns[j][c] = 1;
                boxes[index][c] = 1;
            }
        }
        return true;
    }

    // 1ms 版本  示例代码版本
    public static boolean isValidSudoku2(char[][] board) {

        int[] line = new int[9];
        int[] column = new int[9];
        int[] cell = new int[9];
        int shift = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.')
                    continue;
                shift = 1 << (board[i][j] - '0');
                int k = (i / 3) * 3 + j / 3;

                if ((column[i] & shift) > 0 || (line[j] & shift) > 0 || (cell[k] & shift) > 0)
                    return false;
                column[i] |= shift;
                line[j] |= shift;
                cell[k] |= shift;
            }
        }
        return true;
    }

}
