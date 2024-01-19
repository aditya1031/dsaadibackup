def dfs(graph ,start):
    visited=set()
    stack=[start]

    while stack:
        vertex=stack.pop()
        if vertex not in visited:
            print(vertex,end=" ")
            visited.add(vertex)
            stack.extend(graph[vertex]-visited)

graph={
    'A':{'A','C'},
    'B':{'A','D','E'},
    'C':{'A','F'},
    'D':{'B'},
    'E':{'B','F'},
    'F':{'C','E'}

}

start_node='A'
dfs(graph,start_node)