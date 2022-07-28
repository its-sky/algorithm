#include <stdio.h>
#include <stdlib.h>

int		**spiral(int n, int m)
{
	int		**p;
	int		i, j;
	int		idx = 0;
	int		val = 1;

	p = (int **)malloc(n * sizeof(int *));
	if (!p)
	{
		free(p);
		return (0);
	}
	for (i = 0; i < n; i++)
	{
		p[i] = (int *)malloc(m * sizeof(int));
		if (!p[i])
		{
			for (j = 0; j <= i; j++)
				free(p[j]);
			free(p);
			return (0);
		}
	}

	while (n > 0 && m > 0)
	{
		// 왼쪽 -> 오른쪽
		for (i = idx; i < idx + m; i++)
			p[idx][i] = val++;
		// 위쪽 -> 아래쪽
		for (i = idx + 1; i < idx + n; i++)
			p[i][idx + m - 1] = val++;
		
		// 오른쪽 -> 왼쪽
		if (n > 1)
		{
			for (i = idx + m - 2; i >= idx; i--)
				p[idx + n - 1][i] = val++;
		}
		// 아래쪽 -> 위쪽
		if (m > 1)
		{
			for (i = idx + n - 2; i > idx; i--)
				p[i][idx] = val++;
		}

		++idx;
		n -= 2;
		m -= 2;
	}

	return (p);
}

int		main(void)
{
	int		**p;
	int		n, m;
	int		i, j;

	scanf("%d %d", &n, &m);
	p = spiral(n, m);

	for (i = 0; i < n; i++)
	{
		for (j = 0; j < m; j++)
			printf("%2d ", p[i][j]);
		printf("\n");
	}

	free(p);

	return (0);
}