package cn.zouyang.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestService {
	public void test(){
		System.out.println("-------------this is a test----------------");
	}
}
