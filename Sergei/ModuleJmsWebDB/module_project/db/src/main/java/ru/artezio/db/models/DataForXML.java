package ru.artezio.db.models;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class DataForXML {

    @XmlElement(name = "client")
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @XmlElement(name = "branch")
    private List<TreeBranch> branches;

    public List<TreeBranch> getBranches() {
        return branches;
    }

    public void setBranches(List<TreeBranch> branches) {
        this.branches = branches;
    }
}
