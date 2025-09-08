## Two Pointers

**Core Idea:** Use two pointers to scan the array from different ends or speeds.

**When to Use:** When you need to compare elements from both ends, remove duplicates, or find pairs.

**Must-Solve Problems:**

- Valid Palindrome
- Two Sum II - Input Array Is Sorted
- Remove Duplicates from Sorted Array
- Container With Most Water
- Trapping Rain Water

---

## Sliding Window

**Core Idea:** Maintain a window that moves across the array to track a subset of elements.

**When to Use:** When dealing with subarrays, substrings, or running calculations over a fixed/variable window.

**Must-Solve Problems:**

- Maximum Sum Subarray of Size K
- Longest Substring Without Repeating Characters
- Minimum Window Substring
- Permutation in String
- Sliding Window Maximum

---

## Fast and Slow Pointers

**Core Idea:** Use two pointers moving at different speeds to detect cycles or find midpoints.

**When to Use:** When detecting cycles in linked lists or arrays or finding middle nodes.

**Must-Solve Problems:**

- Linked List Cycle
- Happy Number
- Middle of the Linked List
- Start of Linked List Cycle
- Palindrome Linked List

---

## Depth First Search (DFS)

**Core Idea:** Explore all paths deeply before backtracking.

**When to Use:** When traversing or searching through trees, graphs, or grids recursively.

**Must-Solve Problems:**

- Number of Islands
- Clone Graph
- Path Sum
- All Paths From Source to Target
- Word Search

---

## Breadth First Search (BFS)

**Core Idea:** Explore nodes level-by-level using a queue.

**When to Use:** When finding the shortest path in unweighted graphs or level order traversal.

**Must-Solve Problems:**

- Binary Tree Level Order Traversal
- Minimum Depth of Binary Tree
- Word Ladder
- Perfect Squares
- Rotting Oranges

---

## Backtracking

**Core Idea:** Build solution step-by-step, undoing choices when needed.

**When to Use:** When solving permutations, combinations, or constraint-based problems.

**Must-Solve Problems:**

- Subsets
- Permutations
- Combination Sum
- N-Queens
- Sudoku Solver

---

## Heap / Priority Queue

**Core Idea:** Use a heap to access the smallest or largest element quickly.

**When to Use:** When working with Top K elements or merging sorted lists.

**Must-Solve Problems:**

- Kth Largest Element in an Array
- Top K Frequent Elements
- Merge K Sorted Lists
- Find Median from Data Stream
- Reorganize String

---

## Topological Sort

**Core Idea:** Linear ordering of vertices respecting the direction of dependencies.

**When to Use:** When you have prerequisite constraints or need to order tasks.

**Must-Solve Problems:**

- Course Schedule
- Course Schedule II
- Alien Dictionary
- Minimum Height Trees
- Sequence Reconstruction

---

## Union Find (Disjoint Set)

**Core Idea:** Track and merge connected components using union and find operations.

**When to Use:** When checking connectivity or merging disjoint sets.

**Must-Solve Problems:**

- Graph Valid Tree
- Number of Connected Components
- Redundant Connection
- Accounts Merge
- Smallest String With Swaps

---

## Matrix Manipulation

**Core Idea:** Use row-column logic to traverse and transform 2D grids.

**When to Use:** When working with 2D arrays, grids, or matrices.

**Must-Solve Problems:**

- Set Matrix Zeroes
- Rotate Image
- Spiral Matrix
- Word Search
- Search a 2D Matrix

---

## Prefix Sum

**Core Idea:** Precompute cumulative sums to answer range sum queries efficiently.

**When to Use:** When frequent range sum queries or subarray sums are involved.

**Must-Solve Problems:**

- Subarray Sum Equals K
- Range Sum Query - Immutable
- Minimum Size Subarray Sum
- Maximum Size Subarray Sum Equals K
- Binary Subarrays With Sum

---

## Monotonic Stack / Queue

**Core Idea:** Maintain increasing/decreasing stack or queue to solve next greater/smaller problems.

**When to Use:** When dealing with range-based comparisons like NGE or sliding windows.

**Must-Solve Problems:**

- Daily Temperatures
- Next Greater Element
- Largest Rectangle in Histogram
- Trapping Rain Water
- Sliding Window Maximum

---

## Greedy Algorithms

**Core Idea:** Always choose the local optimal solution hoping it leads to global optimum.

**When to Use:** When you can make a series of decisions greedily.

**Must-Solve Problems:**

- Jump Game
- Greedy Florist
- Activity Selection
- Minimum Number of Arrows to Burst Balloons
- Candy

# What is a Greedy Algorithm?

A **Greedy Algorithm** builds a solution step-by-step, always choosing the **locally optimal** choice at each step, **hoping** it leads to the **global optimum**.

## Key Points about Greedy:
- It makes the **best possible decision at the current step** without worrying about future consequences.
- **Does not backtrack.**
- Works only when **local optimal choices lead to global optimal solutions** (not always true).

### Examples in real life:
- Choosing the largest denomination while giving change.
- Selecting the next closest city in the Traveling Salesman (though not always optimal).


---

## Binary Search

**Core Idea:** Divide the search space in half each time to find a target efficiently.

**When to Use:** Sorted arrays or when answer lies in a numeric range.

**Must-Solve Problems:**

- Binary Search
- Search in Rotated Sorted Array
- Find Minimum in Rotated Sorted Array
- Koko Eating Bananas
- Median of Two Sorted Arrays

---

## Dynamic Programming (DP)

**Core Idea:** Break problem into overlapping subproblems and use memoization or tabulation.

**When to Use:** When optimal substructure and overlapping subproblems exist.

**Must-Solve Problems:**

- 0/1 Knapsack
- Longest Increasing Subsequence
- House Robber
- Coin Change
- Edit Distance

---

## Bit Manipulation

**Core Idea:** Use bitwise operations for toggling, checking, and optimizing space/time.

**When to Use:** When working with numbers, subsets, or flags using bits.

**Must-Solve Problems:**

- Single Number
- Counting Bits
- Missing Number
- Number of 1 Bits
- Subsets

---