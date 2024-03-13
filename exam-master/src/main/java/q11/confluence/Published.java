package q11.confluence;

public class Published implements Status {
    private ConfluencePage c;

    public Published(ConfluencePage c) {
        this.c = c;
    }

    @Override
    public String interact(String using, ConfluenceAuthor interactor) {
        String result2 = "==== " + c.getTitle() + " === \n" +
                "By " + c.getContributors() + "\n" +
                "=============================\n" + c.getContent();
        return result2;
    }

}
