package tml.ipmsg.xiaomi_soip_consumer_delivery_failed.Service;

import tml.ipmsg.xiaomi_soip_consumer_delivery_failed.model.DlrModel;
import tml.ipmsg.xiaomi_soip_consumer_delivery_failed.model.DlrModelFail;

public interface IDlrService {
	int save(DlrModel cpDlr);
	int save(DlrModelFail cpDlrFail);
}
