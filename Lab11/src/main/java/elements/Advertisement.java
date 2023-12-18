package elements;

public class Advertisement extends AbstractElement {
    private String addBlock = "//div[@class='b51cee81']/h3/following-sibling::div/following-sibling::button";

    public boolean isAddBlockExist() {
        return !getElements(addBlock).isEmpty();
    }
}
