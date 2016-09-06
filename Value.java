package up.fiz.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="VALUE")
public class Value implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="VALUE_ID")
	private Long valueId;
	@Column(name ="VALUE")
	private String value;
	@Column(name ="VALUE_DATA")
	private String valueData;
	
	public String getValueData() {
		return valueData;
	}
	public void setValueData(String valueData) {
		this.valueData = valueData;
	}
	@Transient
	private List<ValueValueDetail> ValueValueIds;
	
	public Long getValueId() {
		return valueId;
	}
	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<ValueValueDetail> getValueValueIds() {
		return ValueValueIds;
	}
	public void setValueValueIds(List<ValueValueDetail> valueValueIds) {
		ValueValueIds = valueValueIds;
	}
	
	
}
