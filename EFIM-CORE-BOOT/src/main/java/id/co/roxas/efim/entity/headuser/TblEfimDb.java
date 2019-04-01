package id.co.roxas.efim.entity.headuser;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import id.co.roxas.efim.entity.headuser.pk.TblEfimDbPk;
import id.co.roxas.efim.entity.master.TblCode;


@Entity
@Table(name = "HEADUSER.TBL_EFIM_DB")
@IdClass(TblEfimDbPk.class)
public class TblEfimDb implements Serializable{
	private static final long serialVersionUID = 6824449861746780827L;

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
	private TblCode fileStatus;
	private TblCode projectCode;
	private TblCode fileType;
	private TblCode fileTypeInBin;
	

	@Id
	@Column(name = "FILE_ID_REF")
	public String getFileIdReff() {
		return fileIdReff;
	}
	public void setFileIdReff(String fileIdReff) {
		this.fileIdReff = fileIdReff;
	}
	
	@Column(name = "FILE_NAME")
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Column(name = "FILE_SIZE")
	public Double getFileSize() {
		return fileSize;
	}
	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}
	
	@Column(name = "FILE_STR_ID_REFF")
	public String getFileStrIdReff() {
		return fileStrIdReff;
	}
	public void setFileStrIdReff(String fileStrIdReff) {
		this.fileStrIdReff = fileStrIdReff;
	}
	
	@Column(name = "FILE_OWNER")
	public String getFileOwner() {
		return fileOwner;
	}
	public void setFileOwner(String fileOwner) {
		this.fileOwner = fileOwner;
	}
	
	@Column(name = "HIDDEN_FILE_CODE")
	public String getHiddenFileCode() {
		return hiddenFileCode;
	}
	public void setHiddenFileCode(String hiddenFileCode) {
		this.hiddenFileCode = hiddenFileCode;
	}
	
	@Column(name = "CREATED_DATE")
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "UPDATED_DATE")
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name = "UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FILE_STATUS", referencedColumnName="MST_CODE_TYPE")
	public TblCode getFileStatus() {
		return fileStatus;
	}
	public void setFileStatus(TblCode fileStatus) {
		this.fileStatus = fileStatus;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PROJECT_CODE", referencedColumnName="MST_CODE_TYPE")
	public TblCode getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(TblCode projectCode) {
		this.projectCode = projectCode;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FILE_TYPE", referencedColumnName="MST_CODE_TYPE")
	public TblCode getFileType() {
		return fileType;
	}
	public void setFileType(TblCode fileType) {
		this.fileType = fileType;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FILE_TYPE_IN_BIN", referencedColumnName="MST_CODE_TYPE")
	public TblCode getFileTypeInBin() {
		return fileTypeInBin;
	}
	public void setFileTypeInBin(TblCode fileTypeInBin) {
		this.fileTypeInBin = fileTypeInBin;
	}
	
	
	
	
	
	
}
