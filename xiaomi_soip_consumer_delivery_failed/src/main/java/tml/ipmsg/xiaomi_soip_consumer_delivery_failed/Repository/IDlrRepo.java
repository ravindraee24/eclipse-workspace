package tml.ipmsg.xiaomi_soip_consumer_delivery_failed.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import tml.ipmsg.xiaomi_soip_consumer_delivery_failed.model.DlrModel;

public interface IDlrRepo extends JpaRepository<DlrModel, Integer>{

}
