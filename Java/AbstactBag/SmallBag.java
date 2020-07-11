package lab7;

public class SmallBag extends AbstractBag {
    protected boolean hasBelt = true;

    public SmallBag() {
        super(5, 2);
    }

    @Override
    public String toString() {
        String message = "Small bag:\n";
        message += "Max size: " + content.length + "\n";
        message += "Weight: " + getTotalWeight() + "\n";
        message += "Has belt: " + hasBelt + "\n";
        message += "Contains: \n";
        boolean flag = false;
        int counter = 0;
        for (int i = 0; i < content.length; i++) {
            if (content[i] != null) {
                counter++;
                flag = true;
                message += content[i].toString();
                message += "\n";
            }
        }
        if (!flag) {
            message += "empty\n";
        } else {
            message += counter;
            message += " elements\n";
        }
        return message;
    }

    @Override
    public void removeProduct(Products toRemove) {
        for (int i = 0; i < content.length; i++) {
            if (content[i] != null && content[i].type == toRemove) {
                content[i] = null;
            }
        }
    }

    public void setHasBelt(boolean belt) {
        hasBelt = belt;
    }
}
