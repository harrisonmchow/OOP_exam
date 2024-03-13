package q11.confluence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConfluencePage implements ConfluenceNode {
    private String content;
    private String title;
    private Status status;
    private List<ConfluenceAuthor> contributors = new ArrayList<>();

    public ConfluencePage() {
        this.status = new Editing(this);
    }

    public String interact(String using, ConfluenceAuthor interactor) {
        return status == null ? null : status.interact(using, interactor);
    }

    public void updateStatus(String status) {
        switch (status) {
            case "Editing":
                this.status = new Editing(this);
                break;
            case "Publishing":
                this.status = new Publishing(this);
                break;
            case "Published":
                this.status = new Published(this);
                break;
            case "Viewing":
                this.status = new Viewing(this);
                break;
            default:
                this.status = null;
        }

    }

    public String getContributors() {
        return contributors.stream().map(ConfluenceAuthor::getName).collect(Collectors.joining(", "));
    }

    public List<ConfluenceAuthor> getContributorsList() {
        return contributors;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int getNumPages() {
        return 1;
    }

    @Override
    public List<ConfluencePage> getAllLeafNodes(List<ConfluencePage> leafNodes) {
        leafNodes.add(this);
        return leafNodes;

    }
}