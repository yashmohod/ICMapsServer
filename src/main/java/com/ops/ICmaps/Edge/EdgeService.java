package com.ops.ICmaps.Edge;


import org.springframework.stereotype.Service;

@Service
public class EdgeService {

    private EdgeRepository er;
    public EdgeService(EdgeRepository er){
        this.er = er;
    }
}
