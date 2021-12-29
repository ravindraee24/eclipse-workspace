package tml.ipmsg.xiaomi_soip_consumer_delivery_failed.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import tml.ipmsg.xiaomi_soip_consumer_delivery_failed.model.DlrModelFail;

public interface IDlrFailRepo extends JpaRepository<DlrModelFail, Integer>{

}
