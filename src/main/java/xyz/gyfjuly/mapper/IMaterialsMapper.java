package xyz.gyfjuly.mapper;

import java.util.List;

import xyz.gyfjuly.domain.Materials;

public interface IMaterialsMapper {
	/**/
	int selectmaterialsCheck_0(String uId);
	/**/
	int selectmaterialsCheck_1(String uId);
	/**/
	int selectmaterialsCheck_2(String uId);
	/**/
	int selectmaterialsCheck_3(String uId);
	/**/
	Materials selectmaterialsDonateSuccess(String uId);
	/**/
	int addmaterials(Materials materials);
	/**/
	List<Materials> getDonationmaterialsByUserId(String uId);
	/**/
	List<Materials> getmaterialsCheck_0(String uId);
	/**/
	List<Materials> getmaterialsCheck_1(String uId);
	/**/
	List<Materials>getmaterialsCheck_2(String uId);
	/**/
	void deleteCheck0(String mId);
	/**/
	Materials getmaterialsCheck0(String mId);
	/**/
	void editmaterialsInfo(Materials materials);
	/**/
	List<Materials> adminGetmaterialsCheck_0();
	/**/
	List<Materials> adminGetmaterialsCheck_1();
	/**/
	List<Materials> adminGetmaterialsCheck_2();
	/**/
	void adminCheck_0Success(String mId);
	/**/
	void adminCheck_3Success(String mId);
	/**/
	void adminCheckNo(String mId);
	/**/
	List<Materials> getDonationmaterials();

}
