#include <stdio.h>
#include <stdlib.h>

int		H[100] = { 0, };
int		n = 0;

void	upHeap(int i)
{
	int		tmp;

	if (i == 1)
		return ;
	if (H[i] <= H[i / 2])
		return ;
	tmp = H[i];
	H[i] = H[i / 2];
	H[i / 2] = tmp;
	upHeap(i / 2);
}

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

void	insertItem(int key)
{
	++n;
	H[n] = key;
	upHeap(n);
}

int		removeMax()
{
	int		key;

	key = H[1];
	H[1] = H[n];
	H[n] = 0;
	--n;
	downHeap(1);
	return (key);
}

int	main()
{
	char	cmd;
	int		key;

	cmd = '\0';
	while (cmd != 'q')
	{
		scanf("%c", &cmd);
		if (cmd == 'i')
		{
			scanf("%d", &key);
			getchar();
			insertItem(key);
			printf("0\n");
		}
		else if (cmd == 'd')
		{
			key = removeMax();
			printf("%d\n", key);
		}
		else if (cmd == 'p')
		{
			if (n >= 1)
				printHeap();
		}
		else if (cmd == 'q')
			break ;
	}

	return (0);
}