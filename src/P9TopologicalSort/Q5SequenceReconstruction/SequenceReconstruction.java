package P9TopologicalSort.Q5SequenceReconstruction;

/**
 * 🔹 Problem: Sequence Reconstruction
 *
 * You are given:
 * - An integer array `nums` of length n, which is a permutation of [1...n].
 * - A list of sequences, where each sequence is a subsequence of `nums`.
 *
 * Task:
 * Check whether `nums` is the only shortest supersequence.
 * (i.e., the shortest sequence such that all given sequences are subsequences of it).
 *
 * Definitions:
 * - Subsequence: obtained by deleting some (possibly none) elements without changing order.
 * - Supersequence: A sequence `s` is a supersequence of `seq` if `seq` is a subsequence of `s`.
 *
 * Return:
 * - true  → if `nums` is the only shortest supersequence.
 * - false → otherwise.
 *
 * 🔹 Example 1:
 * Input: nums = [1,2,3], sequences = [[1,2],[1,3]]
 * Output: false
 * Explanation: Sequences suggest orderings 1→2 and 1→3.
 * Possible supersequences: [1,2,3] and [1,3,2].
 * Since more than one valid order exists → return false.
 *
 * 🔹 Example 2:
 * Input: nums = [1,2,3], sequences = [[1,2]]
 * Output: false
 * Explanation: Only enforces 1→2. Many supersequences exist:
 * [1,2,3], [3,1,2], etc. Not unique → return false.
 *
 * 🔹 Example 3:
 * Input: nums = [1,2,3], sequences = [[1,2],[1,3],[2,3]]
 * Output: true
 * Explanation: Sequences enforce 1→2→3.
 * Only possible shortest supersequence is [1,2,3].
 * Hence return true.
 *
 * 🔹 Constraints:
 * - n == nums.length
 * - 1 <= n <= 10^4
 * - nums is a permutation of [1...n]
 * - 1 <= sequences.length <= 10^4
 * - 1 <= sequences[i].length <= 10^4
 * - Sum of all sequence lengths <= 10^5
 */

/**
 * 🟢 Core Idea
 *
 * You are given:
 *   - A final sequence `nums` → This is like the "answer key".
 *   - A bunch of subsequences `sequences` → These are hints about the order.
 *
 * 👉 Task:
 *   Check if these subsequences are enough to uniquely reconstruct the original sequence `nums`.
 *
 * 🧩 Example 1:
 *   nums = [1,2,3], sequences = [[1,2],[1,3]]
 *   - [1,2] → 1 comes before 2
 *   - [1,3] → 1 comes before 3
 *   - But nothing says whether 2 comes before 3 or 3 before 2
 *   - Possible valid orders: [1,2,3] and [1,3,2]
 *   ✅ Since not unique → return false
 *
 * 🧩 Example 2:
 *   nums = [1,2,3], sequences = [[1,2],[1,3],[2,3]]
 *   - [1,2] → 1 before 2
 *   - [1,3] → 1 before 3
 *   - [2,3] → 2 before 3
 *   - All relations covered → only valid order is [1,2,3]
 *   ✅ Matches nums → return true
 *
 * 🟠 What the problem is really asking:
 *   1) Is there exactly ONE valid ordering? (unique topological sort)
 *        - If multiple orders exist → return f*
 **/
public class SequenceReconstruction {
}
