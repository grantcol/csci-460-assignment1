##Search Algorithms 
The program will run BFS, DFS and UCS algorithms on the given input (for the purposes of the assignment this is the egypt map). The Program reads in and parses the formatted data and builds a SearchGraph filled with nodes. Each node has has a list of successors which it references during expansion. Distances (costs) are recorded with these successors. The actual implementations are simply queueing variations on the general search function included in main. DFS queues at the front, BFS at the back and UCS queues arbitrarily and reorders every time (PQ). 

##Use
Just uncomment the correct lines (37-39)
<pre>
	sq.queueDFS(next.expand());
	sq.queueBFS(next.expand());
	sq.queueUCS(next, next.expand());
</pre>
inside the general search function. 