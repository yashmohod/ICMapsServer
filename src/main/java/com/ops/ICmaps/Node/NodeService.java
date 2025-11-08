package com.ops.ICmaps.Node;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeService {

    private NodeRepository nr;
    public NodeService(NodeRepository nr){
        this.nr = nr;
    }

    public List<Node> getAllNodes(){
        return nr.findAll();
    }

    public Node getNode(String id){
        return nr.getReferenceById(id);
    }

    public void setNodeLat(String id,Double lat){
        nr.getReferenceById(id).setLat(lat);
    }
    public void setNodeLng(String id,Double lng){
        nr.getReferenceById(id).setLng(lng);
    }

}
