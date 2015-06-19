package com.huihui.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/6 0006.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
