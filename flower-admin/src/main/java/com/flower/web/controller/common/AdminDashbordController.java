package com.flower.web.controller.common;

import com.flower.common.core.domain.AjaxResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
public class
AdminDashbordController {
    private final Log logger = LogFactory.getLog(AdminDashbordController.class);

    @GetMapping("/dashboard")
    public AjaxResult info() {

        Map<String, Integer> data = new HashMap<>();
        data.put("userTotal", 1);
        data.put("goodsTotal", 1);
        data.put("productTotal", 1);
        data.put("orderTotal", 1);
        return AjaxResult.success(data);
    }

}
