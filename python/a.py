''' Implementation of A* Algorithm '''



class Node:
    def __init__(self, name, parent=None):
        self.name = name
        self.parent = parent
        self.g = 0
        self.h = 0
        self.f = 0

def a_star_search(graph, start_node, end_node, heuristic):
    
    open_list = []
    closed_list = []

    
    start_node_obj = Node(start_node)
    open_list.append(start_node_obj)

    
    while len(open_list) > 0:
        
        current_node = open_list[0]
        current_index = 0

        for index, item in enumerate(open_list):
            if item.f < current_node.f:
                current_node = item
                current_index = index

        
        open_list.pop(current_index)
        closed_list.append(current_node)

        
        if current_node.name == end_node:
            path = []
            total_g = current_node.g
            while current_node is not None:
                path.append(current_node.name)
                current_node = current_node.parent
            
            return (path[::-1], total_g)

        
        children = []
        for key, value in graph[current_node.name].items():
            
            new_node = Node(key, current_node)
            new_node.g = current_node.g + graph[current_node.name][key]

            
            if key not in heuristic:
                raise ValueError("Heuristic value not provided for node:", key)
            new_node.h = heuristic[key]

            new_node.f = new_node.g + new_node.h

            
            children.append(new_node)

        
        for child in children:
            
            if any(closed_child.name == child.name for closed_child in closed_list):
                continue

            if any(open_node.name == child.name and child.g > open_node.g for open_node in open_list):
                continue

            
            open_list.append(child)

    return None  

graph = {
    'A': {'B': 5, 'D': 9, 'E': 2},
    'B': {'A': 5, 'C': 2},
    'C': {'B': 2, 'F': 3},
    'D': {'A': 9, 'E': 3, 'F': 2},
    'E': {'A': 2, 'D': 3, 'F': 4},
    'F': {'C': 3, 'D': 2, 'E': 4}
}

start_node = 'A'
goal_node = 'F'
heuristic = {'A': 8, 'B': 4, 'C': 2, 'D': 5, 'E': 4, 'F': 0}  

path = a_star_search(graph, start_node, goal_node, heuristic)

if path:
    print("Shortest path:", path)
else:
    print("No path found.")