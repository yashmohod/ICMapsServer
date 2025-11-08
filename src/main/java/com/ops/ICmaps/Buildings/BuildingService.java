package com.ops.ICmaps.Buildings;

import org.springframework.stereotype.Service;

@Service
public class BuildingService {
    private BuildingRepository br;
    public BuildingService(BuildingRepository br){
        this.br = br;
    }
}
