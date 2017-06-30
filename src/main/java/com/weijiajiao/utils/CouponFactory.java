package com.weijiajiao.utils;

import java.util.Date;

import com.weijiajiao.model.enum_type.CouponSourceType;
import com.weijiajiao.model.enum_type.CouponType;
import com.weijiajiao.model.table.Coupon;
import com.weijiajiao.model.table.UserInfo;

public class CouponFactory {
	private final static int SHARE = 0;
	
	public static Coupon createCouponViaShare(Long userId,int method){
		switch (method) {
		case SHARE:{
			Date now = new Date();
			Coupon coupon =  new Coupon();
			coupon.setType(CouponType.free);
			coupon.setSourceType(CouponSourceType.Share);
			coupon.setTitle("免费劵");
			coupon.setDetail("分享获得免费劵");
			coupon.setUser(new UserInfo(userId));
			coupon.setBeginTime(now);
			coupon.setUpdateTime(now);
			//暂时不设定过期时间
//			coupon.setExpiredTime(expiredTime);
			return coupon;
		}
		default:
			return null;
		}
		
	}

}
