package dajie;

public class CrAssessmentSubjectVo {
	private String id;
	private String corpId;
	private String assessmengOrgId;
	public String getAssessmengOrgId() {
		return assessmengOrgId;
	}
	public void setAssessmengOrgId(String assessmengOrgId) {
		this.assessmengOrgId = assessmengOrgId;
	}
	private String subjectId;
	private String subjectName;
	private String isUsed;
	private String memo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "CrAssessmentSubjectVo{" +
				"id='" + id + '\'' +
				", corpId='" + corpId + '\'' +
				", assessmengOrgId='" + assessmengOrgId + '\'' +
				", subjectId='" + subjectId + '\'' +
				", subjectName='" + subjectName + '\'' +
				", isUsed='" + isUsed + '\'' +
				", memo='" + memo + '\'' +
				'}';
	}
}
