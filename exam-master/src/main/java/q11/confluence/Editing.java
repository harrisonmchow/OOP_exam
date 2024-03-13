package q11.confluence;

import java.util.List;

public class Editing implements Status {
    private ConfluencePage c;

    public Editing(ConfluencePage c) {
        this.c = c;
    }

    @Override
    public String interact(String using, ConfluenceAuthor interactor) {
        String content = using;
        if (content.isEmpty()) {
            throw new IllegalArgumentException("Document content cannot be empty");
        }
        List<ConfluenceAuthor> contributors = c.getContributorsList();
        if (!contributors.contains(interactor)) {
            contributors.add(interactor);
        }

        c.setContent(content);
        return "";
    }

}
