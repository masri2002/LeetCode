Solving 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit by using deque by declare two dequeue's one for increasing 
sequence and one for decreasing sequence for increasing I always check the queue is not empty and the last element in this dequeue must less than 
the current checking element if the element is grater than current checking element we will remove last element in this dequeue, adding the current checking element , 
for decreasing dequeue will check it not empty and the last element on it less than the checking element will be removed form this dequeue , 
last will check the decreasing dequeue is not empty and will check if first element in the decreasing dequeue subtract by first element in increasing dequeue is grater than limit then that mean this subarray invalid and inside this loop first will check if the element in left is equal the first element on increasing and decreasing will remove
it form each increasing or decreasing dequeue and shift the left pointer to left , last we will store on res the maximum between the res and the length between the right pointer (i) and left pointer (j) added by one ;
