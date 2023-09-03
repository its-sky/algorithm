class Solution
{
    public int solution(int n, int a, int b)
    {
        int cnt = 1;
        
        if (a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        
        while (true) {
            if (a % 2 != 0 && (a + 1 == b || (a == b && b == 1)))
                break;
            ++cnt;
            if (a > 1) {
                if (a > 1 && a % 2 != 0)
                    a += 1;
                a /= 2;
            }
            if (b > 1) {
                if (b > 1 && b % 2 != 0)
                    b += 1;
                b /= 2;
            }
        }
        
        
        return cnt;
    }
}

// 1 4