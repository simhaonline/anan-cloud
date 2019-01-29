package com.github.fosin.cdp.platform.controller;

import com.github.fosin.cdp.mvc.controller.ISimpleController;
import com.github.fosin.cdp.mvc.service.ISimpleService;
import com.github.fosin.cdp.platform.dto.request.CdpSysPayInvoiceCreateDto;
import com.github.fosin.cdp.platform.dto.request.CdpSysPayInvoiceRetrieveDto;
import com.github.fosin.cdp.platform.dto.request.CdpSysPayInvoiceUpdateDto;
import com.github.fosin.cdp.platform.entity.CdpSysPayInvoiceEntity;
import com.github.fosin.cdp.platform.service.inter.ICdpSysPayInvoiceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统支付发票表(table:cdp_sys_pay_invoice)表控制层
 *
 * @author fosin
 * @date 2018-11-18 17:50:28
 */
@RestController
@RequestMapping("v1/invoice")
@Api(value = "v1/invoice", tags = "系统支付发票表接入层API", description = "系统支付发票表(cdp_sys_pay_invoice)接入层API")
public class CdpSysPayInvoiceController implements ISimpleController<CdpSysPayInvoiceEntity, Long, CdpSysPayInvoiceCreateDto, CdpSysPayInvoiceRetrieveDto, CdpSysPayInvoiceUpdateDto> {
    /**
     * 服务对象
     */
    @Autowired
    private ICdpSysPayInvoiceService cdpSysPayInvoiceService;

    @Override
    public ISimpleService<CdpSysPayInvoiceEntity, Long, CdpSysPayInvoiceCreateDto, CdpSysPayInvoiceRetrieveDto, CdpSysPayInvoiceUpdateDto> getService() {
        return cdpSysPayInvoiceService;
    }
}