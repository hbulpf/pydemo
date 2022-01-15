from collections import deque
def Brother(root, node1,node2):
    if not root:
        return False
    queue=deque([(1,root,None)])
    dict_={}
    while queue:
        depth,node,parent=queue.popleft()
        if node.val==node1:
            dict_[node1]=depth
            node1_parent=parent
        if node.val==node2:
            node2_depth=depth
            node2_parent=parent  
        if node.left:
            queue.append((depth+1,node.left,node))
        if node.right:
            queue.append((depth+1,node.right,node))
        if node1_parent and node2_parent:
            break
    return node1_depth==node2_depth and node1_parent！=node2_parent
