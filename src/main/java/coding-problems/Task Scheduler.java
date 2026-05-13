class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
         * =========================
         * Task Scheduler – Intuition + Formula (with visuals)
         * =========================
         * 
         * Key idea:
         * Only the task(s) with the highest frequency determine the minimum length.
         * Everything else only helps fill gaps.
         * 
         * ------------------------------------------------------------
         * Step 1: Count frequencies
         * ------------------------------------------------------------
         * Let:
         * maxFreq = maximum frequency of any task
         * countMax = number of tasks with frequency == maxFreq
         * n = cooldown
         * 
         * Example:
         * A = 4, B = 4, C = 4
         * maxFreq = 4
         * countMax = 3 (A, B, C)
         * 
         * ------------------------------------------------------------
         * Step 2: Place ONE max-frequency task to create the skeleton
         * ------------------------------------------------------------
         * Take just A (freq = 4), cooldown n = 2.
         * 
         * To respect cooldown:
         * A _ _ A _ _ A _ _ A
         * 
         * There are:
         * - (maxFreq - 1) = 3 gaps
         * - each gap MUST have at least n = 2 slots
         * 
         * So:
         * gaps = (maxFreq - 1)
         * empty slots = (maxFreq - 1) * n = 3 * 2 = 6
         * 
         * If we group this into frames:
         * Each frame = [A + n cooldown slots] → size = (n + 1)
         * 
         * Skeleton (with only A):
         * [A _ _] [A _ _] [A _ _] A
         * 
         * ------------------------------------------------------------
         * Step 3: Extend skeleton when MULTIPLE tasks share maxFreq
         * ------------------------------------------------------------
         * Now we also have B and C with the SAME max frequency (4).
         * 
         * Important insight:
         * The LAST occurrences of max-frequency tasks do NOT need cooldown after them.
         * So instead of ending with just one A, we end with ALL max-frequency tasks.
         * 
         * Final skeleton length:
         * (maxFreq - 1) * (n + 1) + countMax
         * 
         * For A, B, C:
         * (4 - 1) * (2 + 1) + 3 = 3 * 3 + 3 = 12
         * 
         * Visual:
         * A B C _ _ A B C _ _ A B C _ _ A B C
         * | frame | | frame | | frame | last column
         * 
         * This diagram ALREADY counts:
         * - all A, B, C tasks
         * - all required cooldown spacing
         * 
         * ------------------------------------------------------------
         * Step 4: Why the “18 slots” calculation is WRONG
         * ------------------------------------------------------------
         * You might think:
         * "ABC has size 3, repeated 4 times = 12
         * plus 2 gaps per block, total = 18"
         * 
         * This double-counts.
         * 
         * Why?
         * Because cooldown slots are ALREADY INCLUDED inside:
         * (maxFreq - 1) * (n + 1)
         * 
         * That term counts:
         * - the task
         * - AND its cooldown space together as one frame
         * 
         * So:
         * We do NOT add extra gap math on top.
         * The 12 is the TOTAL required length imposed by A, B, C.
         * 
         * ------------------------------------------------------------
         * Step 5: What if another task also has max frequency?
         * ------------------------------------------------------------
         * If D also has frequency 4:
         * 
         * countMax = 4
         * 
         * A B C D _ _ A B C D _ _ A B C D _ _ A B C D
         * 
         * Formula still works:
         * (4 - 1) * (2 + 1) + 4 = 13
         * 
         * ------------------------------------------------------------
         * Step 6: Why smaller-frequency tasks never break the formula
         * ------------------------------------------------------------
         * Example smaller tasks:
         * D=3, E=2, F=2, G=1, H=1, I=1, J=1, K=1
         * 
         * One valid filling:
         * A B C D E F A B C D E F A B C D G H A B C I J K
         * 
         * Key property:
         * Only tasks with frequency == maxFreq can force NEW spacing.
         * Smaller-frequency tasks:
         * - fit inside the existing gaps, OR
         * - overflow AFTER the skeleton (which is fine)
         * 
         * Even if they overflow, they do NOT require extra cooldown frames,
         * so total time is just the number of tasks.
         * 
         * ------------------------------------------------------------
         * Step 7: Final answer
         * ------------------------------------------------------------
         * Two cases:
         * 1) Not enough tasks to fill cooldown gaps → idle needed
         * answer = skeletonLength
         * 
         * 2) Plenty of tasks fill all gaps → no idle
         * answer = totalTasks
         * 
         * So:
         * answer = max(totalTasks, (maxFreq - 1) * (n + 1) + countMax)
         * 
         * ------------------------------------------------------------
         * This is why the formula works.
         */

        // totalTasks
        int totalTasks = tasks.length;

        // freq calc
        int[] freqArr1 = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freqArr1[tasks[i] - 'A']++;
        }
        int maxFreq = 0;
        for (int i = 0; i < freqArr1.length; i++) {
            maxFreq = Math.max(maxFreq, freqArr1[i]);
        }
        int countMax = 0;
        for (int i = 0; i < freqArr1.length; i++) {
            if (freqArr1[i] == maxFreq)
                countMax++;
        }

        return Math.max(totalTasks, (maxFreq - 1) * (n + 1) + countMax);

    }
}
