package hei.school;

import java.util.ArrayList;
import java.util.List;

public class Promotion {
    private List<String> groupes;

    public Promotion() {
        this.groupes = new ArrayList<>();
    }

    public void addGroup(String group) {
        this.groupes.add(group);
    }

    public List<String> getGroupes() {
        return groupes;
    }

    public void setGroupes(List<String> groupes) {
        this.groupes = groupes;
    }
}
