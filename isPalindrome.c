#include <stdio.h>
#include <stdbool.h>

bool	isPalindrome(char *A, int n)
{
	for (int i = 0; i < n / 2; i++)
	{
		if (A[i] != A[n - i - 1])
			return (false);
	}
	return (true);
}

int	main(void)
{
	if (isPalindrome("abbagb", 6) == true)
		printf("true\n");
	return (0);
}