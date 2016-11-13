/**
 * Created by fluff on 7/28/16.
 */
public class UserSolution {
    public static int stock_runs(int[] prices) {
        int longDec = 0;
        int longInc = 0;
        int flag = 0;
        int count = 0;

        for (int i=1; i< prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            count ++;

            if (((diff < 0) && (flag <0 ))||((diff > 0) && (flag > 0))) {

            } else {
                if(flag != 0) {
                    if (flag > 0) {
                        if (longInc < count) {
                            longInc = count;
                        }
                    } else {
                        if (longDec < count) {
                            longDec = count;
                        }
                    }
                    count = 0;
                } else {
                    if (diff == 0) {
                        count =0;
                    }
                }
                flag = diff;
            }

        }
        if (flag > 0) {
            if (longInc < count) {
                longInc = count;
            }
        } else {
            if (longDec < count) {
                longDec = count;
            }
        }
        return longDec > longInc ? longDec : longInc;
    }

    public static int stock_runs2(int[] prices) {
        int countInc = 0;
        int countDec = 0;
        int longDec = 0;
        int longInc = 0;

        for (int i=0; i< prices.length-1; i++) {
            if (prices[i + 1] > prices[i]) {
                countInc++;
            }
            else {
                if (longInc < countInc) {
                    longInc = countInc;
                }
                countInc = 0;
            }
            if (prices[i + 1] < prices[i]) {
                countDec++;
            } else {
                if (longDec < countDec) {
                    longDec = countDec;
                }
                countDec= 0;
            }
        }
        return longDec > longInc ? longDec +1 : longInc +1;
    }

    public static void main(String args []) {
        int [] test1 = {2, 3, 5, 1};
        int res;
        res = UserSolution.stock_runs2(test1);
        assert res == 3;

        int [] test2 = {6, 3, 5, 1};
        res = UserSolution.stock_runs2(test2);
        assert res == 2;

        int [] test3 = {1,1,2,2};
        res = UserSolution.stock_runs2(test3);
        assert res == 2;

        int [] test4 = {1,1,2,2,5, 4, 2, 1, 1};
        res = UserSolution.stock_runs2(test4);
        assert res == 4;
    }
}
