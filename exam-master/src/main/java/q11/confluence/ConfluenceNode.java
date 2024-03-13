package q11.confluence;

import java.util.List;

public interface ConfluenceNode {
    public int getNumPages();

    public List<ConfluencePage> getAllLeafNodes(List<ConfluencePage> leafNodes);
}