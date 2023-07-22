package BOJ.c_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class b1068 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class NodeInfo {
        private Integer parent;
        private List<Integer> children;
        
        public NodeInfo(Integer parent, List<Integer> children) {
            this.parent = parent;
            this.children = children;
        }
    }

    private static Map<Integer, NodeInfo> initNodeInfoMap(int[] parentOfEachIndex) {
        HashMap<Integer, NodeInfo> map = new HashMap<>();
        for(int i=0;i<parentOfEachIndex.length; i++) {
            int target = i;
            map.put(i, new NodeInfo(parentOfEachIndex[i], IntStream.range(0, parentOfEachIndex.length)
                    .filter(p -> parentOfEachIndex[p] == target).boxed().collect(Collectors.toList())));
        }
        return map;
    }

    private static Map<Integer, NodeInfo> removeNode(Map<Integer, NodeInfo> map, int removeNode) {
        if (map.get(removeNode).parent == -1) map.clear();
        else {
            removeAllChildNode(map, removeNode);
            NodeInfo targetNode = map.get(removeNode);
            map.get(targetNode.parent).children.remove(Integer.valueOf(removeNode));
            map.remove(removeNode);
        }
        return map;
    }

    private static void removeAllChildNode(Map<Integer, NodeInfo> map, Integer root) {
        if (map.get(root) == null) return;
        for (int child: map.get(root).children) {
            removeAllChildNode(map, child);
            map.remove(child);
        }
    }

    private static int countLeafNode(Map<Integer, NodeInfo> map) {
        int count = 0;
        for (Map.Entry<Integer, NodeInfo> entry : map.entrySet()) {
            if(entry.getValue().children.size() == 0) count++;
        }
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] parentOfEachIndex = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, NodeInfo> nodeInfoMap = initNodeInfoMap(parentOfEachIndex);

        int remove = Integer.parseInt(br.readLine());
        Map<Integer, NodeInfo> nodeInfoMapWithRemovedNode = removeNode(nodeInfoMap, remove);
        System.out.println(countLeafNode(nodeInfoMapWithRemovedNode));
    }
    
}
