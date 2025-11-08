package com.ops.ICmaps.NavMode;


import org.springframework.stereotype.Service;

@Service
public class NavModeService {

    private NavModeRepository nmr;
    public NavModeService(NavModeRepository nmr){
        this.nmr = nmr;
    }

}
