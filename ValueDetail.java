package up.fiz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VALUE_DETAIL")
public class ValueDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2339508991740260314L;
	@Id
	@Column(name ="VALUE_DETAIL_ID")
	private Long valueDetailId;
	@Column(name ="DATA")
	private String data;
	
	public Long getValueDetailId() {
		return valueDetailId;
	}
	public void setValueDetailId(Long valueDetailId) {
		this.valueDetailId = valueDetailId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
}
