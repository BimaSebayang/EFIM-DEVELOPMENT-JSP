package id.co.roxas.efim.entity.owner.stream;

import java.io.Serializable;

public class ProcInformation implements Serializable{
	private static final long serialVersionUID = 7380590150901411708L;
	private String procId;
    private String procName;
    private Integer procSatatus;
    private String procNotes;
    private String createdDate;
	public String getProcId() {
		return procId;
	}
	public void setProcId(String procId) {
		this.procId = procId;
	}
	public String getProcName() {
		return procName;
	}
	public void setProcName(String procName) {
		this.procName = procName;
	}
	public Integer getProcSatatus() {
		return procSatatus;
	}
	public void setProcSatatus(Integer procSatatus) {
		this.procSatatus = procSatatus;
	}
	public String getProcNotes() {
		return procNotes;
	}
	public void setProcNotes(String procNotes) {
		this.procNotes = procNotes;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
   
}
