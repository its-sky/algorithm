#include <stdio.h>

int		H[100] = { 0, };
int		n = 0;

void	downHeap(int i)
{
	int		bigger;
	int		tmp;

	if (H[2*i] == 0 && H[2*i + 1] == 0)
		return ;
	bigger = 2*i;
	if (H[2*i + 1] != 0)
	{
		if (H[2*i + 1] > H[bigger])
			bigger = 2*i + 1;
	}
	if (H[i] > H[bigger])
		return ;
	tmp = H[bigger];
	H[bigger] = H[i];
	H[i] = tmp;
	downHeap(bigger);
}

void	printHeap()
{
	int		i;

	for (i = 1; i <= n; i++)
		printf(" %d", H[i]);
	printf("\n");
}

void	rBuildHeap(int i)
{
	if (i > n)
		return ;
	rBuildHeap(2*i);
	rBuildHeap(2*i + 1);
	downHeap(i);
}

int	main()
{
	int		i, key;

	scanf("%d", &n);
	for (i = 1; i <= n; i++)
		scanf("%d", &H[i]);
	rBuildHeap(1);
	printHeap();
	return (0);
}