class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, val);
            graph.get(v).put(u, 1.0 / val);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                result[i] = -1.0;
            } else {
                result[i] = dfs(src, dest, 1.0, new HashSet<>(), graph);
            }
        }

        return result;
    }

    private double dfs(String curr, String target, double product,
                       Set<String> visited,
                       Map<String, Map<String, Double>> graph) {

        if (curr.equals(target)) return product;

        visited.add(curr);

        for (String nei : graph.get(curr).keySet()) {
            if (!visited.contains(nei)) {
                double res = dfs(nei, target,
                        product * graph.get(curr).get(nei),
                        visited, graph);

                if (res != -1.0) return res;
            }
        }

        return -1.0;
    }
}