#include <stdio.h>
#include <stdlib.h>

int main()
{
    int     *p;
    int     n, i, j, tmp;

    scanf("%d", &n);
    p = (int *)malloc(n * sizeof(int));
    if (!p)
        return (-1);
    for (i = 0; i < n; i++)
    {
        scanf("%d", &tmp);
        p[i] = tmp;
    }
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n - i - 1; j++)
        {
            if (p[j] > p[j + 1])
            {
                tmp = p[j + 1];
                p[j + 1] = p[j];
                p[j] = tmp;
            }
        }
    }
    for (i = 0; i < n; i++)
    {
        printf(" %d", p[i]);
    }
    return (0);
}