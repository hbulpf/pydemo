import java.util.*;

/**
 * 这题有两个前提
 * 1， 必须从JFK开始
 * 2， 解一定存在
 */

/**
 * 这题有两种解法：
 * 1， 常规是DFS暴力解法，面试能写出这种就行了
 * 2， 欧拉解法
 */
public class ReconstructItinerary {

    /**
     * 常规DFS暴力列出所有可能的路径，可以一次走遍所有的边
     */
    public List<List<String>> findItinerary(String[][] tickets) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(ticket[1]);
        }
        List<List<String>> result = new LinkedList<>();
        dfs("JFK", result, map, new LinkedList<>(Arrays.asList("JFK")), tickets.length);
        return result;
    }

    void dfs(String airport, List<List<String>> result, HashMap<String, ArrayList<String>> map, LinkedList<String> route, int n) {
        if (route.size() == n + 1) {
            result.add(new ArrayList<>(route));
            return;
        }
        if (!map.containsKey(airport) || map.get(airport).isEmpty()) {
            return;
        }
        ArrayList<String> list = map.get(airport);
        for (int i = 0; i < list.size(); i++) {
            String target = list.remove(i);

            route.add(target);
            dfs(target, result, map, route, n);
            route.removeLast();

            list.add(i, target);
        }
    }

    /**
     * 题目要求是列出字母顺序最小的
     */
    public List<String> findItinerary2(String[][] tickets) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(ticket[1]);
        }
        for (List<String> list : map.values()) {
            Collections.sort(list);
        }
        LinkedList<String> result = new LinkedList<>(Arrays.asList("JFK"));
        dfs("JFK", map, result, tickets.length);
        return result;
    }

    boolean dfs(String airport, HashMap<String, ArrayList<String>> map, LinkedList<String> route, int n) {
        if (route.size() == n + 1) {
            return true;
        }
        if (!map.containsKey(airport) || map.get(airport).isEmpty()) {
            return false;
        }
        ArrayList<String> list = map.get(airport);
        for (int i = 0; i < list.size(); i++) {
            String target = list.remove(i);

            route.add(target);
            if (dfs(target, map, route, n)) {
                return true;
            }
            route.removeLast();

            list.add(i, target);
        }
        return false;
    }

    /**
     * 欧拉递归解法如下
     */
    public List<String> findItinerary3(String[][] tickets) {
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        visit("JFK");
        return route;
    }

    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route = new LinkedList();

    void visit(String airport) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll());
        route.add(0, airport);
    }

    /**
     * 欧拉迭代写法
     */
    public List<String> findItinerary4(String[][] tickets) {
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);

        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        List<String> route = new LinkedList();

        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String s = stack.peek();
            while (targets.containsKey(s) && !targets.get(s).isEmpty())
                stack.push(targets.get(s).poll());
            route.add(0, stack.pop());
        }

        return route;
    }
}