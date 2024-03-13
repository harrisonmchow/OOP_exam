package q11.confluence;

public class Publishing implements Status {
    private ConfluencePage c;

    public Publishing(ConfluencePage c) {
        this.c = c;
    }

    @Override
    public String interact(String using, ConfluenceAuthor interactor) {
        String title = using;
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        } else if (title.length() > 50) {
            throw new IllegalArgumentException("Title cannot be > 50 characters long");
        }

        c.setTitle(title);
        return "";
    }

}
