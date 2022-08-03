#include <stdio.h>
#include <stdlib.h>

typedef struct	s_Node
{
	struct s_Node	*prev;
	char	elem;
	struct s_Node	*next;
}	Node;

typedef struct	List
{
	Node	*head;
	int		len;
}	list;

void	init(list *List)
{
	Node	*head;

	head = (Node *)malloc(sizeof(Node));
	if (!head)
		return ;
	List->head = head;
	head->prev = NULL;
	head->next = NULL;
	List->len = 0;
}

void	Node_add(list *List, int idx, char c)
{
	Node	*p;
	Node	*head;
	int		i;

	if (((List->len) + 1 < idx))
	{
		printf("invalid position\n");
		return ;
	}
	head = List->head;
	p = (Node *)malloc(sizeof(Node));
	if(!p)
		return ;
	p->elem = c;
	for (i = 1; i < idx; i++)
		head = head->next;
	p->prev = head;
	p->next = head->next;
	if(head->next)
		head->next->prev = p;
	head->next = p;
	List->len = List->len + 1;
}

void	Node_delete(list *List, int idx)
{
	Node	*p, *delete;
	int		i;

	if ((idx > List->len))
	{
		printf("invalid position\n");
		return ;
	}
	p = List->head;
	for (i = 1; i < idx; i++)
		p = p->next;
	delete = p->next;
	if (p->next->next)
		p->next->next->prev = p;
	p->next = p->next->next;
	free(delete);
	List->len = List->len - 1;
}

void	Node_print(list *List)
{
	Node 	*p;
	if (List->len <= 0)
		return ;
	p = List->head->next;
	while (p != NULL)
	{
		printf("%c", p->elem);
		p = p->next;
	}
	printf("\n");
}

void	Node_get(list *List, int idx)
{
	int		i;
	Node	*head;

	if (idx > List->len)
	{
		printf("invalid position\n");
		return ;
	}
	head = List->head;
	for (i = 0; i < idx; i++)
		head = head->next;
	printf("%c\n", head->elem);
}

int	main()
{
	int		n, i, idx;
	char	op, elem;
	list	*List;

	List = (list *)malloc(sizeof(list));
	if(!List)
		return (-1);
	init(List);
	scanf("%d", &n);
	if (n <= 0)
		return (0);
	for (i = 0; i < n; i++)
	{
		getchar();
		scanf("%c", &op);
		if (op == 'A')
		{
			scanf(" %d %c", &idx, &elem);
			Node_add(List, idx, elem);
			continue ;
		}
		else if (op == 'D')
		{
			scanf(" %d", &idx);
			Node_delete(List, idx);
			continue ;
		}
		else if (op == 'G')
		{
			scanf(" %d", &idx);
			Node_get(List, idx);
			continue ;
		}
		else if (op == 'P')
		{
			Node_print(List);
			continue ;
		}
	}
	return (0);
}