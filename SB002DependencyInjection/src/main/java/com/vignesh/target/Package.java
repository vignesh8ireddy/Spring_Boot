package com.vignesh.target;

import com.vignesh.dependant.ICourier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "package")
public class Package {

    @Autowired
    @Qualifier("courier")
    private ICourier courierService;

    public String packageInfo() {
        return courierService.info();
    }
}
