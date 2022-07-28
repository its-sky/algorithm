#include <stdio.h>

void		rHanoi(int n, int from, int aux, int to);
long long	ft_count(int n);
void	ft_print_bigint(int n);

void	Hanoi(int n)
{
	rHanoi(n, 1, 2, 3);
	return ;
}

void	rHanoi(int n, int from, int aux, int to)
{
	if (n == 1)
	{
		printf("%d %d\n", from, to);
		return ;
	}
	rHanoi(n - 1, from, to, aux);
	printf("%d %d\n", from, to);
	rHanoi(n - 1, aux, from, to);
	return ;
}

void	ft_print_bigint(int n)
{
	int		i, j, k;
	int next_sum = 0, temp_num, idx = 0;
	int data[1000] = {0};
	data[0] = 2;
	for (i = 1; i < n; i++)
	{
		temp_num = 0;
		next_sum = 0;
		for (j = idx; j >= 0; j--)
		{
			temp_num = data[j] * 2 + next_sum;
			next_sum = 0;
			
			if (temp_num > 9)
			{
				data[j] = temp_num % 10;
				if (j == 0)
				{
					for (k = idx; k >= 0; k--)
					{
						data[k + 1] = data[k];
					}
					data[0] = temp_num / 10;
					++idx;
				}
				else
					next_sum = temp_num / 10;
			}
			else
				data[j] = temp_num;
		}
	}
	for (i = 0; i < idx; i++)
		printf("%d", data[i]);
	printf("%d\n", data[idx] - 1);
}

int	main(void)
{
	int		n;
	int		*p;
	
	scanf("%d", &n);
	ft_print_bigint(n);
	if (n <= 20)
		Hanoi(n);
	return (0);
}