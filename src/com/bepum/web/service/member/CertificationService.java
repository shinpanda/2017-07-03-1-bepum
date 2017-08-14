package com.bepum.web.service.member;

import java.util.List;

import com.bepum.web.entity.Certification;

public class CertificationService {

	// 화면이 로드될 때
	public List<Certification> getCertificationList() {
		return getCertificationList("");
	}
	
	public List<Certification> getCertificationList(String memId) {
		return getCertificationList(memId);
	}
	//상세정보
	public int getCertification(String type, String memId) {
		return getCertification(type, memId);
	}
	//신청서 제출&수정
	public int setApplication(String memId) {
		return 0;
	}
	// 건강진단서제출&수정
	public int setHc(String memId) {
		return 0;
	}
	//가족관계증명서제출&수정
	public int setFrc(String memId) {
		return 0;
	}

}
