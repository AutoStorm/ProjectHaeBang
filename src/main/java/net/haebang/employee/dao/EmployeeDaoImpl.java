package net.haebang.employee.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.haebang.vo.CompanyVo;
import net.haebang.vo.EmployeeVo;
import net.haebang.vo.JoinEmployeeVo;
import net.haebang.vo.MemberVo;
import net.haebang.vo.NoticeBoardVo;
import net.haebang.vo.OrderEmployeeVo;


@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;	
	

	// ------------------------------------------- 창대 -------------------------------------
		@Override
		public CompanyVo selectByNo(int c_no) {
			CompanyVo companyVo = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectByNo", c_no);
			return companyVo;
		}
		
		@Override
		public List<EmployeeVo> selectByCNo(int c_no) {
			
			List<EmployeeVo> employeeVoList = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.selectByCNo", c_no);
			return employeeVoList;
			
		}
		
		
		
		
		
		
		@Override
		public CompanyVo selectByCode(String c_code) {
			CompanyVo companyVo = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectByCode", c_code);
			return companyVo;
		}
		
		@Override
		public CompanyVo selectByBizNo1(String c_bizNo) {
			CompanyVo companyVo = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectByBizNo1", c_bizNo);
			return companyVo;
		}
		
		@Override
		public CompanyVo selectByBizNo2(CompanyVo companyVo) {
			CompanyVo confirmVo = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectByBizNo2", companyVo);
			return confirmVo;
		}
		
		
		
		@Override
		public EmployeeVo selectById(String e_id) {
			EmployeeVo employeeVo = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectById", e_id);
			return employeeVo;
		}
		@Override
		public void insertCompany(JoinEmployeeVo joinEmployeeVo) {
			sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertCompany", joinEmployeeVo);
		}
		@Override
		public void insertEmployeeAnd(JoinEmployeeVo joinEmployeeVo) {
			sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertEmployeeAnd", joinEmployeeVo);
		}
		@Override
		public void insertEmployee(JoinEmployeeVo joinEmployeeVo) {
			sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertEmployee", joinEmployeeVo);
		}

		
		@Override
		public void updateEoC(HashMap<String, String> updateMap) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.updateEmployeeOr", updateMap);
			
		}
		
		@Override
		public void updateEmployeeCntP(JoinEmployeeVo joinEmployeeVo) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.updateEmployeeCntP", joinEmployeeVo);
			
		}
		@Override
		public void updateEmployeeCntM(EmployeeVo employeeVo) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.updateEmployeeCntM", employeeVo);
			
		}
		
		
		
		@Override
		public void deleteEmployeeByNo(int e_no) {
			sqlSession.delete("net.haebang.employee.dao.EmployeeDao.deleteEmployeeByNo", e_no);
			
		}
		
		@Override
		public void updateCompanyBizNo(CompanyVo companyVo) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.updateCompanyBizNo", companyVo);
			
		}
		
		
		@Override
		public void updateEmpPicture(EmployeeVo employeeVo) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.updateEmpPicture", employeeVo);
			
		}
		

		//	------------------------------------ 창대 11/25일 작업  ----------------------------------------------

		@Override
		public void updateCompanyAddress(CompanyVo companyVo) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.updateCompanyAddress", companyVo);
			
			
		}
		
		
		//	------------------------------------ 창대 11/25일 작업 종료! ----------------------------------------------
		
		//	------------------------------------ 창대 11/29일 작업(지도 주문관련)  ----------------------------------------------
		@Override
		public List<HashMap<String, Object>> selectAllmap(List<EmployeeVo> list) {	
			List<HashMap<String, Object>> mapList = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.selectAllmap", list); 
		
			return mapList;
		}
		
		@Override
		public void updateEOrderStatus(OrderEmployeeVo orderEmployeeVo) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.updateEOrderStatus", orderEmployeeVo);
			
		}
		
		@Override
		public OrderEmployeeVo selectEOrderByMoNo(OrderEmployeeVo orderEmployeeVo) {
			OrderEmployeeVo newOne = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectEOrderByMoNo", orderEmployeeVo); 
			return newOne;
		}
		
		
		//	------------------------------------ 창대 12/15,16,17일 콜 주문 가져오기  ----------------------------------------------
		
		@Override
		public List<HashMap<String, Object>> selectMyCall(EmployeeVo userVo) {
			List<HashMap<String, Object>> myCall = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.selectMyCall", userVo);
			
			return myCall;
		}

		@Override
		public List<HashMap<String, Object>> selectMyCompanyCall(EmployeeVo userVo) {
			List<HashMap<String, Object>> myCall = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.selectMyCompanyCall", userVo);
			
			return myCall;
		}
		
		
		
		@Override
		public void dropEvent(HashMap<String, Object> map) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.dropEvent", map);
			
		}

		@Override
		public void updateCallFlag(HashMap<String, Object> map) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.updateCallFlag", map);
			
		}
		
		@Override
		public List<HashMap<String, Object>> selectMoNoByOrderNo(HashMap<String, Object> map) {
			List<HashMap<String, Object>> mo_noList = 
					sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.selectMoNoByOrderNo", map);
			return mo_noList;
		}
		
		@Override
		public void insertEOrder(HashMap<String, Object> map) {
			sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertEOrder", map);
		}
		
		@Override
		public void deleteCancelCallByMoNo(HashMap<String, Object> map) {
			sqlSession.delete("net.haebang.employee.dao.EmployeeDao.deleteCancelCallByMoNo", map);
			
		}
		
		@Override
		public void insertCancelCall(HashMap<String, Object> map) {
			sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertCancelCall", map);
			
		}
		
		@Override
		public void updateMOrderENoFirst(HashMap<String, Object> map) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.updateMOrderENoFirst", map);
		}
		
		@Override
		public void reCreateEvent(HashMap<String, Object> map) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.reCreateEvent", map);
		}
		
		@Override
		public List<HashMap<String, Object>> selectAllStartTimes(String mo_orderNo) {
			
			List<HashMap<String,Object>> myStartTimes = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.selectAllStartTimes",mo_orderNo);
			
			return myStartTimes;
		}
		
		
		@Override
		public List<HashMap<String, Object>> selectNoOneEmployeeValidation(HashMap<String, Object> map) {
			List<HashMap<String,Object>> validation = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.selectNoOneEmployeeValidation",map);
			return validation;
		}
		//  ----------------------------------------------------------------------------------------------------------------------

	
	// -------------------------------------- 진화 ------------------------------------------
	@Override
	public EmployeeVo selectById(EmployeeVo employeeVo) {	
		
		EmployeeVo employeevo = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.login", employeeVo);
		
		
		return employeevo;
	}
	
	
	/****************************************************************************************************
	 **************************************************************************************************/

	
	@Override
	public List<NoticeBoardVo> getNoticeList(Map<String, Object> map) {
		System.out.println("impl map : " + map);
		List<NoticeBoardVo> getNoticeList = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.getNoticeList", map);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!"+getNoticeList+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return getNoticeList;
	}
	@Override
	public double selectTotalCount(Map<String, Object> map) {
		int totalPage = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectTotalCount",map); 
		return totalPage;
	}
	@Override
	public NoticeBoardVo getNoticeBoardByNo(NoticeBoardVo noticeBoardVo) {
		sqlSession.update("net.haebang.admin.dao.AdminDao.updateViewCnt",noticeBoardVo);
		NoticeBoardVo getNoticeBoardByNo = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectOneNDetailByNo",noticeBoardVo);
		return getNoticeBoardByNo;
	}

	@Override
	public List<NoticeBoardVo> getMainnoticelist() {
		List<NoticeBoardVo> mainNoticelist = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.selectmainnoticelist"); 
		System.out.println(mainNoticelist);
		return mainNoticelist;
	}
	
	
	
/****************************************************************************************************
	**************************************************************************************************/

	@Override
	public EmployeeVo getIdByPhone(Map<String, Object> map) {
		EmployeeVo getIdByPhone = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectIdByPhone", map);
		return getIdByPhone;
	}
	
	@Override
	public EmployeeVo getIdByBizNo(Map<String, Object> map) {
		EmployeeVo getIdByBizNo = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectIdByBizNo", map);
		return getIdByBizNo;
	}
	@Override
	public EmployeeVo getIdbyId(EmployeeVo employeeVo) {
		EmployeeVo checkIdbyId = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.getIdbyId", employeeVo);
		return checkIdbyId;
	}
	@Override
	public void changePassword(EmployeeVo employeeVo) {
		sqlSession.update("net.haebang.employee.dao.EmployeeDao.changepassword", employeeVo);		
	}
	
	@Override
	public MemberVo selectUserByInfo(Map<String, Object> map) {
		return sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectUserByInfo", map);
	}
	
	
	
	@Override
	public void insertScdToRegisteredMemberOnetime(Map<String, Object> map) {
		//기존멤버 추가
		//맵의 m_no로 t_m_order에 insert(우다다다)
			System.out.println("**********************dao 1회성 기존멤버 잘들어옴********************************");
		sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertScdByMNoOnetime", map);
		System.out.println("***********************dao:1회성 맵의 m_no로 t_m_order에 insert 완료*******************************");
		//orderNo로 mo_no 찾기
		Map<String, Object> mo_noMap = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectMoNoByOrderNoOnetime", map);
		//찾은 mo_no를 paramMap에 추가
			System.out.println("***********************dao:1회성 orderNo로 mo_no 찾기완료*******************************");
		Set<String> keys = mo_noMap.keySet();
		for(String key : keys) {
			System.out.println(key + " : "+ mo_noMap.get(key));
			map.put("mo_no", mo_noMap.get(key));
		}		
		//mo_no로 t_e_order에 insert
			System.out.println("***********************dao:1회성 mo_no로 t_e_order에 insert 실행전*******************************");
		sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertScdByOrderNoOnetime", map);
		
	}

	@Override
	public void insertScdToNewMemberOnetime(Map<String, Object> map) {
		//새멤버 추가
		//t_member에 새멤버 추가
			System.out.println("**********************dao 1회성 새멤버 잘들어옴********************************");
		sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertScdToNewMember", map);
		//M_no찾기
		MemberVo registeredMember = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectUserByInfo", map);
			System.out.println("**********************dao 1회성 새멤버 Mo_no찾기완료********************************");
		map.put("m_no", registeredMember.getM_no());
		//맵의 m_no로 t_m_order에 insert (고객정보로 select한 테이블에 insert)		
		sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertScdByMNoOnetime", map);
			System.out.println("***********************dao:1회성 맵의 m_no로 t_m_order에 insert 완료*******************************");
		//orderNo로 mo_no 찾기
		Map<String, Object> mo_noMap = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectMoNoByOrderNoOnetime", map);
		//찾은 mo_no를 paramMap에 추가
			System.out.println("***********************dao:1회성 orderNo로 mo_no 찾기완료*******************************");
		Set<String> keys = mo_noMap.keySet();
			for(String key : keys) {
				System.out.println(key + " : "+ mo_noMap.get(key));
				map.put("mo_no", mo_noMap.get(key));
			}		
		//mo_no로 t_e_order에 insert
			System.out.println("***********************dao:1회성 mo_no로 t_e_order에 insert 실행전*******************************");
		sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertScdByOrderNoOnetime", map);
			
		
	}	
	

	@Override
	public void insertScdToRegisteredMember(Map<String, Object> map) {
		//기존멤버 추가
		//맵의 m_no로 t_m_order에 insert(우다다다)
			System.out.println("**********************dao 정기성 기존멤버 잘들어옴********************************");
		sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertScdByMNo", map);
			System.out.println("***********************dao:정기성 맵의 m_no로 t_m_order에 insert 완료*******************************");
		//orderNo로 mo_no 찾기
		List<Map<String, Object>> mo_noList = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.selectMoNoByOrderNo", map);
			System.out.println("***********************dao:정기성 orderNo로 mo_no 찾기완료*******************************");
		//찾은 mo_no들 paramMap에 추가
		map.put("mo_noList", mo_noList);
		//mo_no로 t_e_order에 insert
			System.out.println("***********************dao:정기성 mo_no로 t_e_order에 insert 실행전*******************************");
		sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertScdByOrderNo", map);
	}

	@Override
	public void insertScdToNewMember(Map<String, Object> map) {
		//새멤버 추가
		//t_member에 새멤버 추가
			System.out.println("**********************dao 정기성 새멤버 잘들어옴********************************");
		sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertScdToNewMember", map);			
		//M_no찾기
		MemberVo registeredMember = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.selectUserByInfo", map);
			System.out.println("**********************dao 정기성 새멤버 Mo_no찾기완료********************************");
			System.out.println(registeredMember.getM_no());
			map.put("m_no", registeredMember.getM_no());
			Set<String> keys = map.keySet();
			for(String key : keys) {
				System.out.println(key + " : "+ map.get(key));				
			}
		//맵의 m_no로 t_m_order에 insert (고객정보로 select한 테이블에 insert)		
		sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertScdByMNo", map);
			System.out.println("***********************dao:정기성 맵의 m_no로 t_m_order에 insert 완료*******************************");
		//orderNo로 mo_no 찾기		
		List<Map<String, Object>> mo_noList = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.selectMoNoByOrderNo", map);
			System.out.println("***********************dao:정기성 orderNo로 mo_no 찾기완료*******************************");
		//찾은 mo_no들 paramMap에 추가
		map.put("mo_noList", mo_noList);
		//t_e_order에 mo_no로 insert
			System.out.println("***********************dao:정기성 mo_no로 t_e_order에 insert 실행전*******************************");
		sqlSession.insert("net.haebang.employee.dao.EmployeeDao.insertScdByOrderNo", map);
	}
	

	
	
	/*********************************************스케쥴****************************************/
	// 스케쥴 전체 리스트
	@Override
	public List<HashMap<String, Object>> getScheduleList(int c_no) {
		List<HashMap<String, Object>> getScheduleList = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.getScheduleList",c_no);
		System.out.println(getScheduleList);
		return getScheduleList;
	}
	// 스케쥴 디테일
	@Override
	public HashMap<String, Object> getScheduleByMONo(int mo_no) {
		HashMap<String, Object> getScheduleByMONo = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.getScheduleByMONo", mo_no);
		System.out.println(getScheduleByMONo);
		return getScheduleByMONo;
	}
	
	// 스케쥴 삭제 
		@Override
		public void deleteSchedule(int mo_no) {
			sqlSession.delete("net.haebang.employee.dao.EmployeeDao.deleteSchedule", mo_no);
		}

		
		@Override
		public String getMtypebyMONo(int mo_no) {
			String m_type= sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.getMtypebyMONo", mo_no);
			return m_type;
		}


	@Override
	public HashMap<String, Object> getScheduleByMONoByHB(int mo_no) {
		HashMap<String, Object> getScheduleByMONoByHB = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.getScheduleByMONoByHB", mo_no);
		System.out.println(getScheduleByMONoByHB);
		return getScheduleByMONoByHB;
	}
	
	@Override
	public List<HashMap<String, Object>> getmyScheduleList(Map<String, Object> map) {
		List<HashMap<String, Object>> getmyScheduleList = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.getmyScheduleList", map);
		System.out.println(getmyScheduleList);
		return getmyScheduleList;
	}


		
		
		
		// 수정 - 해당 스케쥴 정보
		@Override
		public HashMap<String, Object> getScheduleByOdNo(int mo_no) {
			HashMap<String, Object> getScheduleByOdNo = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.getScheduleByOdNo", mo_no);
			return getScheduleByOdNo;
		}
		@Override
		public HashMap<String, Object> getScheduleByOdNoTypeN(int mo_no) {
			HashMap<String, Object> getScheduleByOdNo = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.getScheduleByOdNoTypeN", mo_no);
			return getScheduleByOdNo;
		}
		
		// 수정 - 직원 조회 버튼
		@Override
		public List<HashMap<String, Object>> getEmployeeList(int e_no) {
			List<HashMap<String, Object>>  getEmployeeList = sqlSession.selectList("net.haebang.employee.dao.EmployeeDao.getEmployeeList", e_no);
			return getEmployeeList;
		}

		// 수정 - 노해방(스케쥴 case)
		@Override
		public void updateNoHaebangSch(HashMap<String, Object> map) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.updateNoHaebangSch", map);
		}
		
		// 수정 - 해방 case
		@Override
		public void updateHaebangSch(HashMap<String, Object> map) {
			sqlSession.update("net.haebang.employee.dao.EmployeeDao.updateHaebangSch", map);
			
		}

	/********************************************************************************************/
	
		// 주호 mono 로 회원정보 가져오기(t_member, t_m_order, t_e_order, t_employee, t_service)
		@Override
		public String checkTheMTypeByMono(int mo_no) {
			String m_type = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.checkTheMTypeByMono",mo_no);
			return m_type;
		}
		
		@Override
		public Map<String, Object> getMemberInfoByMono(int mo_no) {
			Map<String, Object> getMemberInfoByMono = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.getMemberInfoByMono", mo_no);
			return getMemberInfoByMono;
		}

		@Override
		public Map<String, Object> getMemberInfoByMonoNtype(int mo_no) {
			Map<String, Object> getMemberInfoByMono = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.getMemberInfoByMonoNtype", mo_no);
			return getMemberInfoByMono;
		}
		

		// update eo_status		
		@Override
		public void statusUpdate(Map<String, Object> map) {
			 sqlSession.update("net.haebang.employee.dao.EmployeeDao.statusUpdate",map);
		}
		
		@Override
		public Map<String, Object> statusUpdateResult(Map<String, Object> map) {
			Map<String, Object> result = sqlSession.selectOne("net.haebang.employee.dao.EmployeeDao.statusUpdateReturn", map);
			return result;
		}
	
		
	
	
	
}	