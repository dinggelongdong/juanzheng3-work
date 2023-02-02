package xyz.gyfjuly.service;

import java.util.List;

import xyz.gyfjuly.domain.Materials;

public interface IMaterialsService {
	/**/
	int selectMaterialsCheck_0(String uId);
	/**/
	int selectMaterialsCheck_1(String uId);
	/**/
	int selectMaterialsCheck_2(String uId);
	/**/
	int selectMaterialsCheck_3(String uId);
	/**/
	Materials selectMaterialsDonateSuccess(String uId);
	/**/
	int addMaterials(Materials materials);
	/**/
	List<Materials> getDonationMaterialsByUserId(String uId);
	/**/
	List<Materials> getMaterialsCheck_0(String uId);
	/**/
	List<Materials> getMaterialsCheck_1(String uId);
	/**/
	List<Materials> getMaterialsCheck_2(String uId);
	/**/
	void deleteCheck0(String mId);
	/**/
	Materials getMaterialsCheck0(String mId);
	/**/
	void editMaterialsInfo(Materials materials);
	/**/
	List<Materials> adminGetMaterialsCheck_0();
	/**/
	List<Materials> adminGetMaterialsCheck_1();
	/**/
	List<Materials> adminGetMaterialsCheck_2();
	/**/
	void adminCheck_0Success(String mId);
	/**/
	void adminCheck_3Success(String mId);
	/**/
	void adminCheckNo(String mId);
	/**/
	List<Materials> getDonationMaterials();

}
