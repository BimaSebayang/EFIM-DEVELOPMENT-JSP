package id.co.roxas.efim.entity.owner.stream;


public class TblPictureFrontEnd {
	private String pictureId;
	private String pictureName;
	private byte[] picturePath;
	private String projectCode;

	public String getPictureId() {
		return pictureId;
	}
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public byte[] getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(byte[] picturePath) {
		this.picturePath = picturePath;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

}
