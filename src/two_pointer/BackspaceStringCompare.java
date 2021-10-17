package two_pointer;

/*
    给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。

    如果相等，返回 true ；否则，返回 false 。

    注意：如果对空文本输入退格字符，文本继续为空。

    示例 1：

    输入：s = "ab#c", t = "ad#c"
    输出：true
    解释：S 和 T 都会变成 “ac”。
 */
public class BackspaceStringCompare {
}

class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        char[] ss = S.toCharArray();
        char[] tt = T.toCharArray();
        int skips = 0;
        int skipt = 0;
        int i = ss.length - 1, j = tt.length - 1;
        while (i >= 0 || j >= 0){
            while (i >= 0){
                if(ss[i] == '#') {
                    i--;
                    skips++;
                }else if(skips > 0){
                    i--;
                    skips--;
                } else break;
            }
            while (j >= 0){
                if(tt[j] == '#') {
                    j--;
                    skipt++;
                }else if(skipt > 0){
                    j--;
                    skipt--;
                } else break;
            }
            if(i >= 0 && j >= 0) {
                if(ss[i] != tt[j]) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}

