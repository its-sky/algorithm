#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
	struct Node	*left;
	int			data;
	struct Node	*right;
}	Node;

void    init(Node *root)
{
	root->left = NULL;
	root->right = NULL;
}

Node	*ft_makenode(int data)
{
	Node	*p;

	if (data == 0)
		return (NULL);
	p = (Node *)malloc(sizeof(Node));
	if (!p)
		return (NULL);
	p->left = NULL;
	p->right = NULL;
	p->data = data;
	return (p);
}

Node	*ft_finddata(Node *p, int data)
{
	Node	*result;

	result = NULL;
	if(p->data == data)
		return (p);
	if (p->left && result == NULL)
		result = ft_finddata(p->left, data);
	if (p->right && result == NULL)
		result = ft_finddata(p->right, data);
	if (result)
		return (result);
	return (NULL);
}

int		ft_strlen(char *str)
{
	int		result;
	int		i;

	if (!str)
		return (-1);
	result = 0;
	i = 0;
	while (str[i++])
		++result;
	return (result);
}

void	ft_printdata(Node *p, char *str, int cnt)
{
	printf(" %d", p->data);
	if (cnt == 0)
		return ;
	if (*str == 'L')
	{
		ft_printdata(p->left, ++str, cnt - 1);
		return ;
	}
	if (*str == 'R')
	{
		ft_printdata(p->right, ++str, cnt - 1);
		return ;
	}
}

void	ft_maketree(Node *root)
{
	Node	*p;
	int		n;
	int		l, e, r;
	int		i;

	scanf("%d", &n);
	if (n > 0)
	{
		scanf("%d %d %d", &e, &l, &r);
		root->data = e;
		root->left = ft_makenode(l);
		root->right = ft_makenode(r);
		for (i = 1; i < n; i++)
		{
			scanf("%d %d %d", &e, &l, &r);
			p = ft_finddata(root, e);
			if (p)
			{
				p->left = ft_makenode(l);
				p->right = ft_makenode(r);
			}
		}
	}
}

int     main()
{
	Node	*root;
	char	str[100] = "";
	int		n, i;

	root = (Node *)malloc(sizeof(Node));
	if (!root)
		return (-1);
	init(root);
	ft_maketree(root);
	scanf("%d", &n);
	for (i = 0; i < n; i++)
	{
		scanf("%s", str);
		ft_printdata(root, str, ft_strlen(str));
		printf("\n");
	}
	return (0);
}