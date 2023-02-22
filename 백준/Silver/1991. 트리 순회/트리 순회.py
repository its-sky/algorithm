import sys

class Node:
    def __init__(self, data, left, right):
        self.data = data
        self.left = left
        self.right = right

def pre_order(node):
    print(node.data, end='')
    if node.left:
        pre_order(tree[node.left])
    if node.right:
        pre_order(tree[node.right])
        
def in_order(node):
    if node.left:
        in_order(tree[node.left])
    print(node.data, end='')
    if node.right:
        in_order(tree[node.right])
    
def post_order(node):
    if node.left:
        post_order(tree[node.left])
    if node.right:
        post_order(tree[node.right])
    print(node.data, end='')
 
n = int(sys.stdin.readline())
tree = {}
for _ in range(n):
    root, l, r = sys.stdin.readline().split()
    if l == '.':
        l = None
    if r == '.':
        r = None
    tree[root] = Node(root, l, r)
    
pre_order(tree['A'])
print()
in_order(tree['A'])
print()
post_order(tree['A'])