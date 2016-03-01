package ru.artezio.dbWithView.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "branches")
@XmlAccessorType(XmlAccessType.FIELD)
public class TreeBranches {

    @XmlElement(name = "branch")
    private List<TreeBranch> branches;

    public List<TreeBranch> getBranches() {
        return branches;
    }

    public void setBranches(List<TreeBranch> branches) {
        this.branches = branches;
    }
}
