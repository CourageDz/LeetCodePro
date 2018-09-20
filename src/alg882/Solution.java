package alg882;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Map<Integer,Integer>> graph=new HashMap<>();
        for (int[]edge :edges) {
            int u=edge[0];int v=edge[1];int w=edge[2];
            graph.computeIfAbsent(u,x->new HashMap<Integer,Integer>()).put(v,w);
            graph.computeIfAbsent(v,x->new HashMap<Integer,Integer>()).put(u,w);
        }
        PriorityQueue<ANode> pq=new PriorityQueue<ANode>((p,q)->Integer.compare(p.dist,q.dist));
        pq.offer(new ANode(0,0));

        Map<Integer,Integer> dist=new HashMap<>();
        dist.put(0,0);
        Map<Integer,Integer>used=new HashMap<>();
        int ans=0;
        while (!pq.isEmpty()){
            ANode anode=pq.poll();
            int node=anode.node;
            int d= anode.dist;

            if(d>dist.getOrDefault(node,0))
                continue;
            ans++;
            if(!graph.containsKey(node))
                continue;
            for (int nei:graph.get(node).keySet()) {
                int weight=graph.get(node).get(nei);
                int v=Math.min(weight,M-d);
                used.put(N*node+nei,v);

                int d2=d+weight+1;
                if(d2<dist.getOrDefault(nei,M+1)){
                    pq.offer(new ANode(nei,d2));
                    dist.put(nei,d2);
                }
            }
        }
        for (int[]edge: edges) {
            ans+=Math.min(edge[2],used.getOrDefault(edge[0]*N+edge[1],0)+used.getOrDefault(edge[1]*N+edge[0],0));
        }
        return ans;
    }

    class ANode {
    int node;
    int dist;
        public ANode(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        int [][]edges={
                {0,1,10},
                {0,2,1},
                {1,2,2},
        };
        int result=sol.reachableNodes(edges,6,3);
        System.out.println(result);
    }
}
