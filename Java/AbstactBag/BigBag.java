package lab7;

public class BigBag extends AbstractBag {
    protected boolean hasRolls = false;

    public BigBag() {
        super(15, 20);
    }

    @Override
    public String toString() {
        String message = "Big bag:\n";
        message += "Max size: " + content.length + "\n";
        message += "Weight: " + getTotalWeight() + "\n";
        message += "Has rolls: " + hasRolls + "\n";
        message += "Contains: \n";
        boolean flag = false;
        int counter = 0;
        for (int i = 0; i < content.length; i++) {
            if (content[i] != null) {
                flag = true;
                counter++;
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

    public void setHasRolls(boolean rolls) {
        hasRolls = rolls;
    }
}