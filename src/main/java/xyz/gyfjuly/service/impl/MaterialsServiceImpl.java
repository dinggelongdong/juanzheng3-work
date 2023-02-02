package xyz.gyfjuly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.gyfjuly.mapper.IMaterialsMapper;
import xyz.gyfjuly.domain.Materials;
import xyz.gyfjuly.service.IMaterialsService;

@Service("MaterialsService")
public class MaterialsServiceImpl implements IMaterialsService {
	@Resource
	private IMaterialsMapper MaterialsDao;
	
	@Override
	public int selectMaterialsCheck_0(String uId) {
		return MaterialsDao.selectmaterialsCheck_0(uId);
	}

	@Override
	public int selectMaterialsCheck_1(String uId) {
		return MaterialsDao.selectmaterialsCheck_1(uId);
	}

	@Override
	public int selectMaterialsCheck_2(String uId) {
		return MaterialsDao.selectmaterialsCheck_2(uId);
	}

	@Override
	public int selectMaterialsCheck_3(String uId) {
		return MaterialsDao.selectmaterialsCheck_3(uId);
	}

	@Override
	public Materials selectMaterialsDonateSuccess(String uId) {
		return MaterialsDao.selectmaterialsDonateSuccess(uId);
	}

	@Override
	public int addMaterials(Materials materials) {
		return MaterialsDao.addmaterials(materials);
	}

	@Override
	public List<Materials> getDonationMaterialsByUserId(String uId) {
		return MaterialsDao.getDonationmaterialsByUserId(uId);
	}

	@Override
	public List<Materials> getMaterialsCheck_0(String uId) {
		return MaterialsDao.getmaterialsCheck_0(uId);
	}

	@Override
	public List<Materials> getMaterialsCheck_1(String uId) {
		return MaterialsDao.getmaterialsCheck_1(uId);
	}

	@Override
	public List<Materials> getMaterialsCheck_2(String uId) {
		return MaterialsDao.getmaterialsCheck_2(uId);
	}

	@Override
	public void deleteCheck0(String mId) {
		MaterialsDao.deleteCheck0(mId);
	}

	@Override
	public Materials getMaterialsCheck0(String mId) {
		return MaterialsDao.getmaterialsCheck0(mId);
	}

	@Override
	public void editMaterialsInfo(Materials materials) {
		MaterialsDao.editmaterialsInfo(materials);
	}

	@Override
	public List<Materials> adminGetMaterialsCheck_0() {
		return MaterialsDao.adminGetmaterialsCheck_0();
	}

	@Override
	public List<Materials> adminGetMaterialsCheck_1() {
		return MaterialsDao.adminGetmaterialsCheck_1();
	}

	@Override
	public List<Materials> adminGetMaterialsCheck_2() {
		return MaterialsDao.adminGetmaterialsCheck_2();
	}

	@Override
	public void adminCheck_0Success(String mId) {
		MaterialsDao.adminCheck_0Success(mId);
	}

	@Override
	public void adminCheck_3Success(String mId) {
		MaterialsDao.adminCheck_3Success(mId);
	}

	@Override
	public void adminCheckNo(String mId) {
		MaterialsDao.adminCheckNo(mId);
	}

	@Override
	public List<Materials> getDonationMaterials() {
		return MaterialsDao.getDonationmaterials();
	}

}
