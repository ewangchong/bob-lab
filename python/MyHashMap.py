class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.map_size = 2069
        self.bucket_array = [Bucket() for i in range(self.map_size)]

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = key % self.map_size
        self.bucket_array[index].put(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = key % self.map_size
        return self.bucket_array[index].get(key)

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = key % self.map_size
        self.bucket_array[index].remove(key)


class Node:
    def __init__(self, key, value):
        self.val = (key, value)
        self.next = None


class Bucket:

    def __init__(self):
        self.head = Node(-1, -1)

    def put(self, key: int, value: int) -> None:
        node = Node(key, value)
        node.next = self.head.next
        self.head.next = node

    def get(self, key: int) -> int:
        node = self.head
        while node:
            (k, v) = node.val
            if k == key:
                return v
            node = node.next
        return -1

    def remove(self, key: int) -> None:
        prev = None
        curr = self.head
        while curr:
            (k, v) = curr.val
            if k == key:
                if curr == self.head:
                    self.head = curr.next
                else:
                    prev.next = curr.next
                    curr.next = None
                return
            else:
                prev = curr
                curr = curr.next

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
# ["MyHashMap","put","put","get","get","put","get", "remove", "get"]
# [[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]
obj.put(1,1)
obj.put(2,2)
print(obj.get(1))
print(obj.get(3))
obj.put(2,2)
print(obj.get(2))
obj.remove(2)
print(obj.get(2))