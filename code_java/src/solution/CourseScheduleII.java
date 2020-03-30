import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Set<Integer>[] sets = new HashSet[numCourses];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<>();
        }
        for (int[] pre : prerequisites) {
            if (sets[pre[1]].add(pre[0])) {
                indegree[pre[0]]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            Integer n = queue.poll();
            result[count++] = n;
            for (Integer k : sets[n]) {
                if (--indegree[k] == 0) {
                    queue.add(k);
                }
            }
        }
        return count == numCourses ? result : new int[0];
    }
}
