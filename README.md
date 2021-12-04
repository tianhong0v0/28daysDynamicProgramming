# 28 day sLeetcode
- **Objective**: Deep understanding dynamic programming
- **Method**: Solving Problems with "Dynamic Programming" Tag on Leetcode
- **Duration**: 28 days

# When to Use Dynamic Programming?: 

There are two key attributes that a problem must have in order for dynamic programming to be applicable: **optimal substructure** and **overlapping sub-problems**. In contrast with "divide and conquer" strategy. 

# What Are the Two Approaches?
1. Top-down approach: This is the direct fall-out of the recursive formulation of any problem. If the solution to any problem can be formulated recursively using the solution to its sub-problems, and if its sub-problems are overlapping, then one can easily memoize or store the solutions to the sub-problems in a table. _Whenever we attempt to solve a new sub-problem, we first check the table to see if it is already solved._ If a solution has been recorded, we can use it directly, otherwise we solve the sub-problem and add its solution to the table.

2. Bottom-up approach: Once we formulate the solution to a problem recursively as in terms of its sub-problems, we can try reformulating the problem in a bottom-up fashion: try solving the sub-problems first and use their solutions to build-on and arrive at solutions to bigger sub-problems. This is also usually done in a tabular form by iteratively generating solutions to bigger and bigger sub-problems by using the solutions to small sub-problems. For example, if we already know the values of F41 and F40, we can directly calculate the value of F42.

# Project Summary and Reflection? 
- Day 10: (unfinishing)
- Day 20:
- Day 28:
