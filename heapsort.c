#include <stdio.h>

int		H[100] = { 0, };
int		n = 0;

void	downHeap(int i, int last)
{
	int		bigger;
	int		tmp;

	if (2*i > last)
		return ;
	bigger = 2*i;
	if (2*i + 1 <= last)
	{
		if (H[2*i + 1] > H[bigger])
			bigger = 2*i + 1;
	}
	if (H[i] > H[bigger])
		return ;
	tmp = H[bigger];
	H[bigger] = H[i];
	H[i] = tmp;
	downHeap(bigger, last);
}

void	printArray()
{
	int		i;

	for (i = 1; i <= n; i++)
		printf("%d ", H[i]);
	printf("\n");
}

void	rBuildHeap(int i)
{
	if (i > n)
		return ;
	rBuildHeap(2*i);
	rBuildHeap(2*i + 1);
	downHeap(i, n);
}

void    inPlaceHeapSort()
{
	int		i, tmp;

	rBuildHeap(1);
	for (i = n; i >= 2; i--)
	{
		tmp = H[1];
		H[1] = H[i];
		H[i] = tmp;
		downHeap(1, i - 1);
	}
}

int	main()
{
	int		i, key;

	scanf("%d", &n);
	for (i = 1; i <= n; i++)
		scanf("%d", &H[i]);
	inPlaceHeapSort();
	printArray();
	return (0);
}