class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        dummy = Node(-1)
        dummy.next = head
        curr = head
        while curr:
            tmp = Node(curr.val)
            tmp.next = curr.next
            curr.next = tmp
            curr = tmp.next

        curr = head
        while curr:
            curr.next.random = curr.random.next if curr.random else None
            curr = curr.next.next

        curr, nxt = dummy, head
        while nxt:
            curr.next = nxt.next
            curr = nxt
            nxt = curr.next

        return dummy.next


# [[7,null],[13,0],[11,4],[10,2],[1,0]]
if __name__ == '__main__':
    sol = Solution()
    nodes = [Node(0) for _ in range(5)]
    nodes[0].val = 7
    nodes[1].val = 13
    nodes[2].val = 11
    nodes[3].val = 10
    nodes[4].val = 1

    nodes[0].next = nodes[1]
    nodes[0].random = None
    nodes[1].next = nodes[2]
    nodes[1].random = nodes[0]
    nodes[2].next = nodes[3]
    nodes[2].random = nodes[4]
    nodes[3].next = nodes[4]
    nodes[3].random = nodes[2]
    nodes[4].next = None
    nodes[4].random = nodes[0]

    new_head = sol.copyRandomList(nodes[0])
    while new_head:
        print(new_head.val, new_head.next.val if new_head.next else None, new_head.random.val if new_head.random else None)
        new_head = new_head.next