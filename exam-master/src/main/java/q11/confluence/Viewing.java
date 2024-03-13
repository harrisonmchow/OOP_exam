package q11.confluence;

public class Viewing implements Status {
    private ConfluencePage c;

    public Viewing(ConfluencePage c) {
        this.c = c;
    }

    @Override
    public String interact(String using, ConfluenceAuthor interactor) {
        String content = c.getContent();
        String result = "==== Draft in Progress === \n" +
                content.length() + " characters long \n" +
                "=============================\n" + content;
        return result;
    }

}
