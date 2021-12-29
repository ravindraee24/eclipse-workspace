package tml.ipmsg.xiaomi_soip_consumer_delivery_failed.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tml.ipmsg.xiaomi_soip_consumer_delivery_failed.model.DlrModel;
import tml.ipmsg.xiaomi_soip_consumer_delivery_failed.model.DlrModelFail;
import tml.ipmsg.xiaomi_soip_consumer_delivery_failed.Repository.*;

@Service
public class DlrServiceImpl implements IDlrService{

	@Autowired
	private IDlrRepo dlrRepo;
	
	@Autowired
	private IDlrFailRepo dlrFailRepo;
	
	@Override
	public int save(DlrModel cpDlr) {
		// TODO Auto-generated method stub
		try {
			dlrRepo.save(cpDlr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	@Override
	public int save(DlrModelFail cpDlrFail) {
		// TODO Auto-generated method stub
				try {
					dlrFailRepo.save(cpDlrFail);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return -1;
				}
				return 1;
	}
	
}
