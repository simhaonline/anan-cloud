package com.github.fosin.cdp.platform.service.inter;

import com.github.fosin.cdp.platform.dto.request.CdpSysPayCreateDto;
import com.github.fosin.cdp.platform.dto.request.CdpSysPayRetrieveDto;
import com.github.fosin.cdp.platform.dto.request.CdpSysPayUpdateDto;
import com.github.fosin.cdp.platform.entity.CdpSysPayEntity;
import com.github.fosin.cdp.jpa.service.ISimpleJpaService;

/**
 * 系统支付表(cdp_sys_pay)表服务接口
 *
 * @author fosin
 * @date 2018-11-18 17:26:40
 */
public interface ICdpSysPayService extends ISimpleJpaService<CdpSysPayEntity, Long, CdpSysPayCreateDto, CdpSysPayRetrieveDto, CdpSysPayUpdateDto> {
}