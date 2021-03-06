package Share.Dto.HeadUser;

import java.io.Serializable;

import Share.Dto.Master.TblCodeDto;
import Share.Dto.Stream.TblEfimFileDbstorageDto;

public class TblEfimDbDto implements Serializable{

	private static final long serialVersionUID = -8131168631090955073L;
	private String fileIdReff;
	private String fileName;
	private Double fileSize;
	private String fileStrIdReff;
	private String fileOwner;
	private String hiddenFileCode;
	private String createdDate;
	private String createdBy;
	private String updatedDate;
	private String updatedBy;
	private TblCodeDto fileStatus;
	private TblCodeDto projectCode;
	private TblCodeDto fileType;
	private TblCodeDto fileTypeInBin;
	private TblEfimFileDbstorageDto tblEfimFileDbstorageDto;
	
	public String getFileIdReff() {
		return fileIdReff;
	}
	public void setFileIdReff(String fileIdReff) {
		this.fileIdReff = fileIdReff;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Double getFileSize() {
		return fileSize;
	}
	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileStrIdReff() {
		return fileStrIdReff;
	}
	public void setFileStrIdReff(String fileStrIdReff) {
		this.fileStrIdReff = fileStrIdReff;
	}
	public String getFileOwner() {
		return fileOwner;
	}
	public void setFileOwner(String fileOwner) {
		this.fileOwner = fileOwner;
	}
	public String getHiddenFileCode() {
		return hiddenFileCode;
	}
	public void setHiddenFileCode(String hiddenFileCode) {
		this.hiddenFileCode = hiddenFileCode;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public TblCodeDto getFileStatus() {
		return fileStatus;
	}
	public void setFileStatus(TblCodeDto fileStatus) {
		this.fileStatus = fileStatus;
	}
	public TblCodeDto getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(TblCodeDto projectCode) {
		this.projectCode = projectCode;
	}
	public TblCodeDto getFileType() {
		return fileType;
	}
	public void setFileType(TblCodeDto fileType) {
		this.fileType = fileType;
	}
	public TblCodeDto getFileTypeInBin() {
		return fileTypeInBin;
	}
	public void setFileTypeInBin(TblCodeDto fileTypeInBin) {
		this.fileTypeInBin = fileTypeInBin;
	}
	public TblEfimFileDbstorageDto getTblEfimFileDbstorageDto() {
		return tblEfimFileDbstorageDto;
	}
	public void setTblEfimFileDbstorageDto(TblEfimFileDbstorageDto tblEfimFileDbstorageDto) {
		this.tblEfimFileDbstorageDto = tblEfimFileDbstorageDto;
	}

	
}
