### ðº è§é¢é¢è§£  
![122. ä¹°åè¡ç¥¨çæä½³æ¶æºII.mp4](12582e43-022d-4ed9-834b-2d1142e3a901)

### ð æå­é¢è§£
#### æ¹æ³ä¸ï¼å¨æè§å

èèå°ãä¸è½åæ¶åä¸å¤ç¬äº¤æãï¼å æ­¤æ¯å¤©äº¤æç»æååªå¯è½å­å¨æéæä¸æ¯è¡ç¥¨æèæ²¡æè¡ç¥¨çç¶æã

å®ä¹ç¶æ ![\textit{dp}\[i\]\[0\] ](./p__textit{dp}_i__0__.png)  è¡¨ç¤ºç¬¬ *i* å¤©äº¤æå®åæéæ²¡æè¡ç¥¨çæå¤§å©æ¶¦ï¼![\textit{dp}\[i\]\[1\] ](./p__textit{dp}_i__1__.png)  è¡¨ç¤ºç¬¬ *i* å¤©äº¤æå®åæéææä¸æ¯è¡ç¥¨çæå¤§å©æ¶¦ï¼*i* ä» *0* å¼å§ï¼ã

èè ![\textit{dp}\[i\]\[0\] ](./p__textit{dp}_i__0__.png)  çè½¬ç§»æ¹ç¨ï¼å¦æè¿ä¸å¤©äº¤æå®åæéæ²¡æè¡ç¥¨ï¼é£ä¹å¯è½çè½¬ç§»ç¶æä¸ºåä¸å¤©å·²ç»æ²¡æè¡ç¥¨ï¼å³ ![\textit{dp}\[i-1\]\[0\] ](./p__textit{dp}_i-1__0__.png) ï¼æèåä¸å¤©ç»æçæ¶åæéææä¸æ¯è¡ç¥¨ï¼å³ ![\textit{dp}\[i-1\]\[1\] ](./p__textit{dp}_i-1__1__.png) ï¼è¿æ¶åæä»¬è¦å°å¶ååºï¼å¹¶è·å¾ ![\textit{prices}\[i\] ](./p__textit{prices}_i__.png)  çæ¶çãå æ­¤ä¸ºäºæ¶çæå¤§åï¼æä»¬ååºå¦ä¸çè½¬ç§»æ¹ç¨ï¼

![\textit{dp}\[i\]\[0\]=\max\{\textit{dp}\[i-1\]\[0\],\textit{dp}\[i-1\]\[1\]+\textit{prices}\[i\]\} ](./p___textit{dp}_i__0_=max{textit{dp}_i-1__0_,textit{dp}_i-1__1_+textit{prices}_i_}__.png) 

åæ¥èè ![\textit{dp}\[i\]\[1\] ](./p__textit{dp}_i__1__.png) ï¼æç§åæ ·çæ¹å¼èèè½¬ç§»ç¶æï¼é£ä¹å¯è½çè½¬ç§»ç¶æä¸ºåä¸å¤©å·²ç»ææä¸æ¯è¡ç¥¨ï¼å³ ![\textit{dp}\[i-1\]\[1\] ](./p__textit{dp}_i-1__1__.png) ï¼æèåä¸å¤©ç»ææ¶è¿æ²¡æè¡ç¥¨ï¼å³ ![\textit{dp}\[i-1\]\[0\] ](./p__textit{dp}_i-1__0__.png) ï¼è¿æ¶åæä»¬è¦å°å¶ä¹°å¥ï¼å¹¶åå° ![\textit{prices}\[i\] ](./p__textit{prices}_i__.png)  çæ¶çãå¯ä»¥ååºå¦ä¸çè½¬ç§»æ¹ç¨ï¼

![\textit{dp}\[i\]\[1\]=\max\{\textit{dp}\[i-1\]\[1\],\textit{dp}\[i-1\]\[0\]-\textit{prices}\[i\]\} ](./p___textit{dp}_i__1_=max{textit{dp}_i-1__1_,textit{dp}_i-1__0_-textit{prices}_i_}__.png) 

å¯¹äºåå§ç¶æï¼æ ¹æ®ç¶æå®ä¹æä»¬å¯ä»¥ç¥éç¬¬ *0* å¤©äº¤æç»æçæ¶å ![\textit{dp}\[0\]\[0\]=0 ](./p__textit{dp}_0__0_=0_.png) ï¼![\textit{dp}\[0\]\[1\]=-\textit{prices}\[0\] ](./p__textit{dp}_0__1_=-textit{prices}_0__.png) ã

å æ­¤ï¼æä»¬åªè¦ä»åå¾åä¾æ¬¡è®¡ç®ç¶æå³å¯ãç±äºå¨é¨äº¤æç»æåï¼ææè¡ç¥¨çæ¶çä¸å®ä½äºä¸ææè¡ç¥¨çæ¶çï¼å æ­¤è¿æ¶å ![\textit{dp}\[n-1\]\[0\] ](./p__textit{dp}_n-1__0__.png)  çæ¶çå¿ç¶æ¯å¤§äº ![\textit{dp}\[n-1\]\[1\] ](./p__textit{dp}_n-1__1__.png)  çï¼æåçç­æ¡å³ä¸º ![\textit{dp}\[n-1\]\[0\] ](./p__textit{dp}_n-1__0__.png) ã

```C++ [sol11-C++]
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int dp[n][2];
        dp[0][0] = 0, dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
};
```

```Java [sol11-Java]
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
```

```JavaScript [sol11-JavaScript]
var maxProfit = function(prices) {
    const n = prices.length;
    const dp = new Array(n).fill(0).map(v => new Array(2).fill(0));
    dp[0][0] = 0, dp[0][1] = -prices[0];
    for (let i = 1; i < n; ++i) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[n - 1][0];
};
```

```Golang [sol11-Golang]
func maxProfit(prices []int) int {
    n := len(prices)
    dp := make([][2]int, n)
    dp[0][1] = -prices[0]
    for i := 1; i < n; i++ {
        dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
        dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i])
    }
    return dp[n-1][0]
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

```C [sol11-C]
int maxProfit(int* prices, int pricesSize) {
    int dp[pricesSize][2];
    dp[0][0] = 0, dp[0][1] = -prices[0];
    for (int i = 1; i < pricesSize; ++i) {
        dp[i][0] = fmax(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = fmax(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[pricesSize - 1][0];
}
```

æ³¨æå°ä¸é¢çç¶æè½¬ç§»æ¹ç¨ä¸­ï¼æ¯ä¸å¤©çç¶æåªä¸åä¸å¤©çç¶ææå³ï¼èä¸æ´æ©çç¶æé½æ å³ï¼å æ­¤æä»¬ä¸å¿å­å¨è¿äºæ å³çç¶æï¼åªéè¦å° ![\textit{dp}\[i-1\]\[0\] ](./p__textit{dp}_i-1__0__.png)  å ![\textit{dp}\[i-1\]\[1\] ](./p__textit{dp}_i-1__1__.png)  å­æ¾å¨ä¸¤ä¸ªåéä¸­ï¼éè¿å®ä»¬è®¡ç®åº ![\textit{dp}\[i\]\[0\] ](./p__textit{dp}_i__0__.png)  å ![\textit{dp}\[i\]\[1\] ](./p__textit{dp}_i__1__.png)  å¹¶å­åå¯¹åºçåéï¼ä»¥ä¾¿äºç¬¬ *i+1* å¤©çç¶æè½¬ç§»å³å¯ã

```C++ [sol12-C++]
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = max(dp0, dp1 + prices[i]);
            int newDp1 = max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
};
```

```Java [sol12-Java]
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
```

```JavaScript [sol12-JavaScript]
var maxProfit = function(prices) {
    const n = prices.length;
    let dp0 = 0, dp1 = -prices[0];
    for (let i = 1; i < n; ++i) {
        let newDp0 = Math.max(dp0, dp1 + prices[i]);
        let newDp1 = Math.max(dp1, dp0 - prices[i]);
        dp0 = newDp0;
        dp1 = newDp1;
    }
    return dp0;
};
```

```Golang [sol12-Golang]
func maxProfit(prices []int) int {
    n := len(prices)
    dp0, dp1 := 0, -prices[0]
    for i := 1; i < n; i++ {
        dp0, dp1 = max(dp0, dp1+prices[i]), max(dp1, dp0-prices[i])
    }
    return dp0
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

```C [sol12-C]
int maxProfit(int* prices, int pricesSize) {
    int dp0 = 0, dp1 = -prices[0];
    for (int i = 1; i < pricesSize; ++i) {
        int newDp0 = fmax(dp0, dp1 + prices[i]);
        int newDp1 = fmax(dp1, dp0 - prices[i]);
        dp0 = newDp0;
        dp1 = newDp1;
    }
    return dp0;
}
```

**å¤æåº¦åæ**

- æ¶é´å¤æåº¦ï¼*O(n)*ï¼å¶ä¸­ *n* ä¸ºæ°ç»çé¿åº¦ãä¸å±æ *2n* ä¸ªç¶æï¼æ¯æ¬¡ç¶æè½¬ç§»çæ¶é´å¤æåº¦ä¸º *O(1)*ï¼å æ­¤æ¶é´å¤æåº¦ä¸º *O(2n)=O(n)*ã

- ç©ºé´å¤æåº¦ï¼*O(n)*ãæä»¬éè¦å¼è¾ *O(n)* ç©ºé´å­å¨å¨æè§åä¸­çææç¶æãå¦æä½¿ç¨ç©ºé´ä¼åï¼ç©ºé´å¤æåº¦å¯ä»¥ä¼åè³ *O(1)*ã

#### æ¹æ³äºï¼è´ªå¿

ç±äºè¡ç¥¨çè´­ä¹°æ²¡æéå¶ï¼å æ­¤æ´ä¸ªé®é¢ç­ä»·äºå¯»æ¾ *x* ä¸ª**ä¸ç¸äº¤**çåºé´ *(l_i,r_i]* ä½¿å¾å¦ä¸çç­å¼æå¤§å

![\sum_{i=1}^{x}a\[r_i\]-a\[l_i\] ](./p___sum_{i=1}^{x}_a_r_i_-a_l_i___.png) 

å¶ä¸­ *l_i* è¡¨ç¤ºå¨ç¬¬ *l_i* å¤©ä¹°å¥ï¼*r_i* è¡¨ç¤ºå¨ç¬¬ *r_i* å¤©ååºã

åæ¶æä»¬æ³¨æå°å¯¹äº *(l_i,r_i]* è¿ä¸ä¸ªåºé´è´¡ç®çä»·å¼ *a[r_i]-a[l_i]*ï¼å¶å®ç­ä»·äº ![(l_i,l_i+1\],(l_i+1,l_i+2\],\ldots,(r_i-1,r_i\] ](./p___l_i,l_i+1_,_l_i+1,l_i+2_,ldots,_r_i-1,r_i__.png)  è¿è¥å¹²ä¸ªåºé´é¿åº¦ä¸º *1* çåºé´çä»·å¼åï¼å³ 
![a\[r_i\]-a\[l_i\]=(a\[r_i\]-a\[r_i-1\])+(a\[r_i-1\]-a\[r_i-2\])+\ldots+(a\[l_i+1\]-a\[l_i\]) ](./p___a_r_i_-a_l_i_=_a_r_i_-a_r_i-1__+_a_r_i-1_-a_r_i-2__+ldots+_a_l_i+1_-a_l_i____.png) 
å æ­¤é®é¢å¯ä»¥ç®åä¸ºæ¾ *x* ä¸ªé¿åº¦ä¸º *1* çåºé´ *(l_i,l_i+1]* ä½¿å¾ ![\sum_{i=1}^{x}a\[l_i+1\]-a\[l_i\] ](./p__sum_{i=1}^{x}_a_l_i+1_-a_l_i__.png)  ä»·å¼æå¤§åã

è´ªå¿çè§åº¦èèæä»¬æ¯æ¬¡éæ©è´¡ç®å¤§äº *0* çåºé´å³è½ä½¿å¾ç­æ¡æå¤§åï¼å æ­¤æåç­æ¡ä¸º
![\textit{ans}=\sum_{i=1}^{n-1}\max\{0,a\[i\]-a\[i-1\]\} ](./p___textit{ans}=sum_{i=1}^{n-1}max{0,a_i_-a_i-1_}__.png) 
å¶ä¸­ *n* ä¸ºæ°ç»çé¿åº¦ã

éè¦è¯´æçæ¯ï¼è´ªå¿ç®æ³åªè½ç¨äºè®¡ç®æå¤§å©æ¶¦ï¼**è®¡ç®çè¿ç¨å¹¶ä¸æ¯å®éçäº¤æè¿ç¨**ã

èèé¢ç®ä¸­çä¾å­ *[1,2,3,4,5]*ï¼æ°ç»çé¿åº¦ *n=5*ï¼ç±äºå¯¹ææç ![1\lei<n ](./p__1_le_i___n_.png)  é½æ *a[i]>a[i-1]*ï¼å æ­¤ç­æ¡ä¸º
![\textit{ans}=\sum_{i=1}^{n-1}a\[i\]-a\[i-1\]=4 ](./p___textit{ans}=sum_{i=1}^{n-1}a_i_-a_i-1_=4__.png) 
ä½æ¯å®éçäº¤æè¿ç¨å¹¶ä¸æ¯è¿è¡ *4* æ¬¡ä¹°å¥å *4* æ¬¡ååºï¼èæ¯å¨ç¬¬ *1* å¤©ä¹°å¥ï¼ç¬¬ *5* å¤©ååºã

```C++ [sol2-C++]
class Solution {
public:
    int maxProfit(vector<int>& prices) {   
        int ans = 0;
        int n = prices.size();
        for (int i = 1; i < n; ++i) {
            ans += max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
};
```

```Java [sol2-Java]
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
```

```JavaScript [sol2-JavaScript]
var maxProfit = function(prices) {
    let ans = 0;
    let n = prices.length;
    for (let i = 1; i < n; ++i) {
        ans += Math.max(0, prices[i] - prices[i - 1]);
    }
    return ans;
};
```

```Golang [sol2-Golang]
func maxProfit(prices []int) (ans int) {
    for i := 1; i < len(prices); i++ {
        ans += max(0, prices[i]-prices[i-1])
    }
    return
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

```C [sol2-C]
int maxProfit(int* prices, int pricesSize) {
    int ans = 0;
    for (int i = 1; i < pricesSize; ++i) {
        ans += fmax(0, prices[i] - prices[i - 1]);
    }
    return ans;
}
```

**å¤æåº¦åæ**

- æ¶é´å¤æåº¦ï¼*O(n)*ï¼å¶ä¸­ *n* ä¸ºæ°ç»çé¿åº¦ãæä»¬åªéè¦éåä¸æ¬¡æ°ç»å³å¯ã

- ç©ºé´å¤æåº¦ï¼*O(1)*ãåªéè¦å¸¸æ°ç©ºé´å­æ¾è¥å¹²åéã