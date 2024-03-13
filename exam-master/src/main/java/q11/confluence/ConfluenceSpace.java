package q11.confluence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConfluenceSpace implements ConfluenceNode, Iterable<ConfluencePage> {
    List<ConfluenceNode> nodes = new ArrayList<>();

    public void addSubnode(ConfluenceNode node) {
        nodes.add(node);
    }

    @Override
    public int getNumPages() {
        int count = 0;
        for (ConfluenceNode n : nodes) {
            count += n.getNumPages();
        }
        return count;
    }

    @Override
    public Iterator<ConfluencePage> iterator() {
        List<ConfluencePage> allLeaf = new ArrayList<>();
        getAllLeafNodes(allLeaf);
        return allLeaf.iterator();
    }

    @Override
    public List<ConfluencePage> getAllLeafNodes(List<ConfluencePage> leafNodes) {
        for (ConfluenceNode n : nodes) {
            leafNodes = n.getAllLeafNodes(leafNodes);
        }

        return leafNodes;
    }
}