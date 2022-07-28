#include <stdio.h>
#include <stdlib.h>

int		**zigzag(int n)
{
	int		i, j;
	int		value = 1;
	int		**p;

	p = (int **)malloc(n * sizeof(int *));
	if (!p)
		return (0);
	for(i = 0; i < n; i++)
	{
		p[i] = (int *)malloc(n * sizeof(int));
		if (!p[i])
			return (0);
		if (i % 2 == 0)
		{
			for (j = 0; j < n; j++)
				p[i][j] = (value++);
		}
		else
		{
			for (j = n - 1; j >= 0; j--)
				p[i][j] = (value++);
		}
	}
	return (p);
}

int		main(void)
{
	int		**p;
	int		n;

	scanf("%d", &n);
	p = zigzag(n);
	for (int i = 0; i < n; i++)
	{
		for(int j = 0; j < n; j++)
			printf("%2d ", p[i][j]);
		printf("\n");
	}
	free(p);
}